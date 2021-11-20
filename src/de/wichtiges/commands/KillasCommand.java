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

public class KillasCommand implements CommandExecutor
{
    private static String prefix;

    static {
        KillasCommand.prefix = "§8[§2Kills§8] §r";
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (args.length == 0) {
            p.sendMessage(String.valueOf(KillasCommand.prefix) + " §7Deine Kills: §e" + this.getKills(p.getName()) + " Kills");
        }
        else if (args.length == 2) {
            p.sendMessage("§3§lKill-Befehle:");
            p.sendMessage("§7Kills ansehen: §e/kills");
        }
        else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("help")) {
                p.sendMessage("§3§lKill-Befehle:");
                p.sendMessage("§7Kills ansehen: §e/kills");
            }
            else if (p.hasPermission("gg.see.others")) {
                final Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    p.sendMessage(String.valueOf(KillasCommand.prefix) + " §b" + target.getName() + "'s §7Kills: §e" + this.getKills(target.getName()) + " Kills");
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
}
