package de.dirty.ddac.check;

import de.dirty.Main;
import de.dirty.ddac.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @author DasDirt
 * @project DasDirtsAntiCheat
 * @since 27.12.2018 20:33
 */
public class RotationCheck {

    public RotationCheck() {

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    Location loc = all.getLocation();
                    System.out.println("Yaw: " + loc.getYaw() + " Pitch: " + loc.getPitch());
                    float pitch = loc.getPitch(), yaw = loc.getYaw();
                    if (pitch > 90) {
                        PlayerManager.getDataFromPlayer(all).crashPlayer();
                    }
                    if (pitch < -90) {
                        PlayerManager.getDataFromPlayer(all).crashPlayer();
                    }
                }
            }
        }.runTaskTimer(Main.getPlugin(Main.class), 0L, 1L);
    }

}
