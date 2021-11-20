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

public class SetPosCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (args.length == 0) {
            p.sendMessage(String.valueOf(Main.prefix) + "§cVerwende: /setpos 1/2");
        }
        else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("1")) {
                final File ordner = new File("plugins//GunGame");
                final File file1 = new File("plugins//GunGame//region.yml");
                if (!ordner.exists()) {
                    ordner.mkdir();
                }
                if (!file1.exists()) {
                    try {
                        file1.createNewFile();
                    }
                    catch (IOException e2) {
                        p.sendMessage("§cDie Datei konnte auf dem Pfad nicht erstellt werden! --> Frag Koppy");
                    }
                }
                final YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
                final Location locA = p.getLocation();
                final double x = locA.getX();
                final double y = locA.getY();
                final double z = locA.getZ();
                cfg1.set("X", (Object)x);
                cfg1.set("Y", (Object)y);
                cfg1.set("Z", (Object)z);
                try {
                    cfg1.save(file1);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                p.sendMessage(String.valueOf(Main.prefix) + "§7Du hast den §a1.ten Punkt §7f\u00fcr GunGame gesetzt");
                return true;
            }
            if (args[0].equalsIgnoreCase("2")) {
                final File ordner = new File("plugins//GunGame");
                final File file1 = new File("plugins//GunGame//region.yml");
                if (!ordner.exists()) {
                    ordner.mkdir();
                }
                if (!file1.exists()) {
                    try {
                        file1.createNewFile();
                    }
                    catch (IOException e2) {
                        p.sendMessage("§cDie Datei konnte auf dem Pfad nicht erstellt werden! --> Frag Koppy");
                    }
                }
                final YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
                final Location locB = p.getLocation();
                final double x2 = locB.getX();
                final double y2 = locB.getY();
                final double z2 = locB.getZ();
                cfg1.set("X1", (Object)x2);
                cfg1.set("Y1", (Object)y2);
                cfg1.set("Z1", (Object)z2);
                try {
                    cfg1.save(file1);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                p.sendMessage(String.valueOf(Main.prefix) + "§7Du hast den §a2.ten Punkt §7f\u00fcr GunGame gesetzt");
                return true;
            }
        }
        else {
            p.sendMessage(String.valueOf(Main.prefix) + "§cVerwende: /setpos 1/2");
        }
        return true;
    }
}
