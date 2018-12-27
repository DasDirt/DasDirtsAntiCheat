package de.dirty.ddac;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.logging.Logger;


/**
 * @author DasDirt
 * @project DasDirtsAntiCheat
 * @since 27.12.2018 16:03
 */
public class PlayerPacketReader {

    private Player player;
    private Channel channel;
    Logger logger;

    public PlayerPacketReader(Player player, Logger logger) {
        this.player = player;
        this.logger = logger;
    }

    public void inject() {
        logger.info("Applying injection into the Players(" + player.getPlayer().getName() + ") channel");
        channel = ((CraftPlayer) player).getHandle().playerConnection.networkManager.channel;
        channel.pipeline().addAfter("decoder", "Injector", new MessageToMessageDecoder<Packet<?>>() {
            @Override
            protected void decode(ChannelHandlerContext channelHandlerContext, Packet<?> packet, List<Object> list) throws Exception {
                list.add(packet);
                PlayerManager.handlePacket(player, packet);
            }
        });
    }

    public void unInject() {
        logger.info("Release injection into the Players(" + player.getName() + ") channel");
        if (channel != null && channel.pipeline().get("Injector") != null) {
            channel.pipeline().remove("Injector");
        }
    }
}
