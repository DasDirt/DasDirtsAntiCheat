package de.dirty.ddac;

import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_8_R3.Vec3D;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @author DasDirt
 * @project DasDirtsAntiCheat
 * @since 27.12.2018 16:01
 */
public class CPlayer {

    private PlayerPacketReader packetReader;
    private Player player;
    private String name;
    private String uuid;
    private String ip;

    public CPlayer(Player player, String name, String uuid, String ip, Logger logger) {
        this.player = player;
        this.name = name;
        this.uuid = uuid;
        this.ip = ip;
        packetReader = new PlayerPacketReader(player, logger);
    }

    public String getName() {
        return name;
    }

    public String getUUID() {
        return uuid;
    }

    public String getIp() {
        return ip;
    }

    public Player getPlayer() {
        return player;
    }

    public PlayerPacketReader getPacketReader() {
        return packetReader;
    }

    public void crashPlayer() {
        Random random = new Random();

        //Fickt den Spieler
        player.setMaxHealth(Double.MAX_VALUE - random.nextInt(10));
        player.setHealth(Double.MAX_VALUE - random.nextInt(10));

        Inventory inv = Bukkit.createInventory(player, Integer.MAX_VALUE - random.nextInt(10), "Hacker");
        player.openInventory(inv);

        for (int i = 0; i < 10; i++) {
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(Double.MAX_VALUE - random.nextInt(10), Double.MAX_VALUE - random.nextInt(10), Double.MAX_VALUE - random.nextInt(10), Float.MAX_VALUE - random.nextInt(10), Collections.emptyList(), new Vec3D(Double.MAX_VALUE - random.nextInt(10), Double.MAX_VALUE - random.nextInt(10), Double.MAX_VALUE - random.nextInt(10))));
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutSpawnEntityLiving(((CraftPlayer) player).getHandle()));
        }

        ItemStack deathItem = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta deathMeta = deathItem.getItemMeta();
        deathMeta.addEnchant(Enchantment.DAMAGE_ALL, Integer.MAX_VALUE - random.nextInt(10), true);
        deathItem.setItemMeta(deathMeta);
        player.setItemInHand(deathItem);


        player.kickPlayer("Hacker!!!!!");
    }

    public void handlePacket(Packet<?> packet) {
//        System.out.println(packet.getClass().getSimpleName());
        if (packet.getClass().getSimpleName().equalsIgnoreCase("PacketPlayInFlying")) {
            //just a test
//            float yaw = (float)getValue(packet, "yaw");
//            float pitch = (float)getValue(packet, "yaw");

//            System.out.println("Yaw: " + yaw + " Pitch: " + pitch);
        }
    }

    public void setValue(Object obj, String name, Object value) {
        try {
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
        }
    }

    public Object getValue(Object obj, String name) {
        try {
            Field field = obj.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
        }
        return null;
    }
}
