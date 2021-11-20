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

public class DKCommand implements CommandExecutor
{
    private static String prefix;

    static {
        DKCommand.prefix = "§8[§3KD§8] §r";
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (args.length == 0) {
            if (this.getTode(p.getName()) == 0) {
                p.sendMessage(String.valueOf(DKCommand.prefix) + "§cDu musst min. einmal sterben!");
            }
            else {
                p.sendMessage(String.valueOf(DKCommand.prefix) + " §7Deine KD: §e" + (float)((int)(this.getKills(p.getName()) / (float)this.getTode(p.getName()) * 100.0f) / 100.0) + " Kills/Tode");
            }
        }
        else if (args.length == 2) {
            p.sendMessage("§3§lKD-Befehle:");
            p.sendMessage("§7KD ansehen: §e/kills");
        }
        else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("help")) {
                p.sendMessage("§3§lKD-Befehle:");
                p.sendMessage("§7KD ansehen: §e/kills");
            }
            else if (p.hasPermission("gg.see.others")) {
                final Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (this.getTode(target.getName()) == 0) {
                        p.sendMessage(String.valueOf(DKCommand.prefix) + "§cDer Spieler §b" + target.getName() + " §chat noch keine Tode!");
                    }
                    else {
                        p.sendMessage(String.valueOf(DKCommand.prefix) + " §b" + target.getName() + "'s §7KD: §e" + (float)((int)(this.getKills(target.getName()) / (float)this.getTode(target.getName()) * 100.0f) / 100.0) + " Kills/Tode");
                    }
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

    public Integer getKills(final String name) {
        final File file = new File("plugins/Koppyconomy", "kills.yml");
        final FileConfiguration cfg = (FileConfiguration) YamlConfiguration.loadConfiguration(file);
        final int kills = cfg.getInt(String.valueOf(name) + ".kills");
        return kills;
    }

    public void addKills(final String name, final int amount) {
        final File file = new File("plugins/Koppyconomy", "kills.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        int kills = cfg.getInt(String.valueOf(name) + ".kills");
        kills += amount;
        cfg.set(String.valueOf(name) + ".kills", (Object)kills);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getKills(final Player name) {
        final File file = new File("plugins/Koppyconomy", "kills.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int kills = cfg.getInt(name + ".kills");
        return kills;
    }

    public void setKills(final String name, final int amount) {
        final File file = new File("plugins/Koppyconomy", "kills.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        cfg.set(String.valueOf(name) + ".kills", (Object)amount);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getTode(final String name) {
        final File file = new File("plugins/Koppyconomy", "tode.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
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
