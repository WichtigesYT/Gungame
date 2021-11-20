package de.wichtiges.commands;

import de.wichtiges.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class TodeCommand implements CommandExecutor
{
    private static String prefix;

    static {
        TodeCommand.prefix = "§8[§2Tode§8] §r";
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (args.length == 0) {
            p.sendMessage(String.valueOf(TodeCommand.prefix) + " §7Deine Tode: §e" + this.getTode(p.getName()) + " Tode");
        }
        else if (args.length == 2) {
            p.sendMessage("§3§lTode-Befehle:");
            p.sendMessage("§7Tode ansehen: §e/kills");
        }
        else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("help")) {
                p.sendMessage("§3§lTode-Befehle:");
                p.sendMessage("§7Tode ansehen: §e/kills");
            }
            else if (p.hasPermission("gg.see.others")) {
                final Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    p.sendMessage(String.valueOf(TodeCommand.prefix) + " §b" + target.getName() + "'s §7Tode: §e" + this.getTode(target.getName()) + " Tode");
                }
                else {
                    p.sendMessage(String.valueOf(Main.prefix) + "§cDer Spieler ist nicht online!");
                }
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + "§cDazu hast du keine Rechte!");
            }
        }
        return true;
    }

    public Integer getTode(final String name) {
        final File file = new File("plugins/Koppyconomy", "tode.yml");
        final FileConfiguration cfg = (FileConfiguration) YamlConfiguration.loadConfiguration(file);
        final int tode = cfg.getInt(String.valueOf(name) + ".tode");
        return tode;
    }

    public void addTode(final String name, final int amount) {
        final File file = new File("plugins/Koppyconomy", "tode.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        int tode = cfg.getInt(String.valueOf(name) + ".tode");
        tode += amount;
        cfg.set(String.valueOf(name) + ".tode", (Object)tode);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getTode(final Player name) {
        final File file = new File("plugins/Koppyconomy", "tode.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int tode = cfg.getInt(name + ".tode");
        return tode;
    }

    public void setTode(final String name, final int amount) {
        final File file = new File("plugins/Koppyconomy", "tode.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        cfg.set(String.valueOf(name) + ".tode", (Object)amount);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
