package de.dirty.ddac.listener;

import de.dirty.ddac.PlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author DasDirt
 * @project DasDirtsAntiCheat
 * @since 27.12.2018 18:51
 */
public class QuitListener implements Listener {

    @EventHandler
    public void on(PlayerQuitEvent e){
        PlayerManager.removePlayer(e.getPlayer());
    }

}
