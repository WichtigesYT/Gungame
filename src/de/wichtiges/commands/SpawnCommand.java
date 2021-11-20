package de.wichtiges.commands;

import de.wichtiges.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.io.File;

public class SpawnCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        final File file = new File("plugins//GunGame//spawn.yml");
        if (!file.exists()) {
            p.sendMessage(String.valueOf(Main.prefix) + "§cDer Spawn wurde noch nicht gesetzt!");
            return true;
        }
        final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        final Location spawn = p.getLocation();
        final double x = cfg.getDouble("X");
        final double y = cfg.getDouble("Y");
        final double z = cfg.getDouble("Z");
        final double yaw = cfg.getDouble("YAW");
        final double pitch = cfg.getDouble("PITCH");
        final String worldname = cfg.getString("WN");
        final World welt = Bukkit.getWorld(worldname);
        spawn.setX(x);
        spawn.setY(y);
        spawn.setZ(z);
        spawn.setPitch((float)pitch);
        spawn.setPitch((float)yaw);
        spawn.setWorld(welt);
        p.teleport(spawn);
        p.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest an den §bSpawn §7teleportiert!");
        return true;
    }

    @EventHandler
    public void onRespawn(final PlayerRespawnEvent e) {
        final Player p = e.getPlayer();
        final File file = new File("plugins//GunGame//spawn.yml");
        if (!file.exists()) {
            p.sendMessage(String.valueOf(Main.prefix) + "§cDer Spawn wurde noch nicht gesetzt!");
        }
        final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        final Location spawn = p.getLocation();
        final double x = cfg.getDouble("X");
        final double y = cfg.getDouble("Y");
        final double z = cfg.getDouble("Z");
        final double yaw = cfg.getDouble("Yaw");
        final double pitch = cfg.getDouble("Pitch");
        final String worldname = cfg.getString("WN");
        final World welt = Bukkit.getWorld(worldname);
        spawn.setX(x);
        spawn.setY(y);
        spawn.setZ(z);
        spawn.setPitch((float)pitch);
        spawn.setPitch((float)yaw);
        spawn.setWorld(welt);
        p.teleport(spawn);
        p.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest an den §bSpawn §7teleportiert!");
    }
}
