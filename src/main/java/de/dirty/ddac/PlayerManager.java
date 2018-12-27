package de.dirty.ddac;

import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * @author DasDirt
 * @project DasDirtsAntiCheat
 * @since 27.12.2018 16:29
 */
public class PlayerManager {
    private static ArrayList<CPlayer> cPlayerData = new ArrayList<>();

    public static CPlayer getDataFromPlayer(Player player) {
        for (CPlayer cPlayer : cPlayerData) {
            if (cPlayer.getPlayer() == player) {
                return cPlayer;
            }
        }
        return null;
    }

    public static void handlePacket(Player player, Packet<?> packet) {
        getDataFromPlayer(player).handlePacket(packet);
    }

    public static void addPlayer(CPlayer player) {
        cPlayerData.add(player);
    }

    public static void removePlayer(Player player) {
        CPlayer cPlayer = getDataFromPlayer(player);
        if (cPlayer != null){
            cPlayer.getPacketReader().unInject();
            cPlayerData.remove(cPlayer);
        }
    }

}
