package de.wichtiges.commands;

import de.wichtiges.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class StatsResettCommand implements CommandExecutor
{
    private static String prefix;

    static {
        StatsResettCommand.prefix = "§8§l\u279c §r";
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (args.length == 0) {
            p.sendMessage(String.valueOf(Main.prefix) + "Deine Stats wurden §cRESETTET§7!");
            this.setKills(p.getName(), 0);
            this.setTode(p.getName(), 1);
        }
        else if (args.length == 1) {
            if (p.hasPermission("gg.admin")) {
                final String t = args[0];
                this.setKills(t, 0);
                this.setTode(t, 1);
                p.sendMessage(String.valueOf(Main.prefix) + "§7Die Stats von dem Spieler §b" + t + " §7wurden §cRESETTET§7!");
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + "§cDazu hast du keine Rechte!");
            }
        }
        return true;
    }

    public void setLevel(final String name, final int amount) {
        final File file = new File("plugins/Koppyconomy", "level.yml");
        final FileConfiguration cfg = (FileConfiguration) YamlConfiguration.loadConfiguration(file);
        cfg.set(String.valueOf(name) + ".level", (Object)amount);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getLevel(final String name) {
        final File file = new File("plugins/Koppyconomy", "level.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int level = cfg.getInt(String.valueOf(name) + ".level");
        return level;
    }

    public static Integer getMoney(final String name) {
        final File file = new File("plugins/Koppyconomy", "money.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int money = cfg.getInt(String.valueOf(name) + ".money");
        return money;
    }

    public static Integer getKills(final String name) {
        final File file = new File("plugins/Koppyconomy", "kills.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
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

    public static Integer getTode(final String name) {
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

    public static Integer getTode(final Player name) {
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
