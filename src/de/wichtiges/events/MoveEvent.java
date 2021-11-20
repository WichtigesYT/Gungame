package de.wichtiges.events;

import de.wichtiges.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.io.File;

public class MoveEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        World world = player.getWorld();

        if (!player.getWorld().getName().equalsIgnoreCase(world.getName())) {

            File file = new File("plugins//GunGame//spawn.yml");
            if (!file.exists()) {
                player.sendMessage(String.valueOf(Main.prefix) + "§cDer Spawn wurde noch nicht gesetzt!");
                player.setGameMode(GameMode.ADVENTURE);
            }
            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            Location spawn = player.getLocation();
            double x = cfg.getDouble("X");
            double y = cfg.getDouble("Y");
            double z = cfg.getDouble("Z");
            double yaw = cfg.getDouble("YAW");
            double pitch = cfg.getDouble("PITCH");
            String worldname = cfg.getString("WN");
            World welt = Bukkit.getWorld(worldname);
            spawn.setX(x);
            spawn.setY(y);
            spawn.setZ(z);
            spawn.setPitch((float)pitch);
            spawn.setPitch((float)yaw);
            spawn.setWorld(welt);
            player.teleport(spawn);

        }

    }

}
