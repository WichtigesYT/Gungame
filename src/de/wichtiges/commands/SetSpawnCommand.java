package de.wichtiges.commands;

import de.wichtiges.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SetSpawnCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        final File ordner = new File("plugins//GunGame");
        final File file = new File("plugins//GunGame//spawn.yml");
        if (!ordner.exists()) {
            ordner.mkdir();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (IOException e2) {
                p.sendMessage("§cDie Datei konnte auf dem Pfad nicht erstellt werden! --> Frag Koppy");
            }
        }
        final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        final Location spawn = p.getLocation();
        final double x = spawn.getX();
        final double y = spawn.getY();
        final double z = spawn.getZ();
        final double yaw = spawn.getYaw();
        final double pitch = spawn.getPitch();
        final String worldname = spawn.getWorld().getName();
        cfg.set("X", (Object)x);
        cfg.set("Y", (Object)y);
        cfg.set("Z", (Object)z);
        cfg.set("Yaw", (Object)yaw);
        cfg.set("Pitch", (Object)pitch);
        cfg.set("WN", (Object)worldname);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        p.sendMessage(String.valueOf(Main.prefix) + "§7Du hast den §bSpawn §7f\u00fcr GunGame gesetzt");
        p.performCommand("setworldspawn");
        return true;
    }
}
