package de.dirty.ddac.listener;

import de.dirty.ddac.CPlayer;
import de.dirty.ddac.PlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.logging.Logger;

/**
 * @author DasDirt
 * @project DasDirtsAntiCheat
 * @since 27.12.2018 18:32
 */
public class JoinListener implements Listener {

    Logger logger;

    public JoinListener(Logger logger) {
        this.logger = logger;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        CPlayer player = new CPlayer(e.getPlayer(), e.getPlayer().getName(), e.getPlayer().getUniqueId().toString(), e.getPlayer().getAddress().getAddress().getHostAddress(), logger);
        player.getPacketReader().inject();
        PlayerManager.addPlayer(player);
    }

}
