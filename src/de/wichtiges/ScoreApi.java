package de.wichtiges;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.io.IOException;

public class ScoreApi {
    public static void setScoreboard(Player p) {
        final Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = sb.getObjective("aaa");
        if (obj == null) {
            obj = sb.registerNewObjective("aaa", "bbb");
        }
        obj.setDisplayName("§e§lJepCraft.de");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.getScore("§a ").setScore(11);
        obj.getScore("§7\u27a5 Rang:").setScore(10);

        if (p.getName().equalsIgnoreCase("WichtigesYT") || p.getName().equalsIgnoreCase("Joshi_7")) {
            obj.getScore("§4Leitung").setScore(9);
        } else if (p.getName().equalsIgnoreCase("Gremgom")){
            obj.getScore("§4CoLeitung").setScore(9);
        } else if (p.hasPermission("group.admin")) {
            obj.getScore("§4Administrator").setScore(9);
        } else if (p.hasPermission("group.srdeveloper")) {
            obj.getScore("§bSrDeveloper").setScore(9);
        } else if (p.hasPermission("group.developer")) {
            obj.getScore("§bDeveloper").setScore(9);
        } else if (p.hasPermission("group.event")){
            obj.getScore("§3Event").setScore(9);
        } else if (p.hasPermission("group.moderator")) {
            obj.getScore("§cModerator").setScore(9);
        } else if (p.hasPermission("group.supporter")) {
            obj.getScore("§eSupporter").setScore(9);
        } else if (p.hasPermission("group.helfer")) {
            obj.getScore("§dHelfer").setScore(9);
        } else if (p.hasPermission("group.srbuilder")) {
            obj.getScore("§aSrBuilder").setScore(9);
        } else if (p.hasPermission("group.builder")) {
            obj.getScore("§aBuilder").setScore(9);
        } else if (p.hasPermission("group.testbuilder")) {
            obj.getScore("§aTestBuilder").setScore(9);
        } else if (p.hasPermission("group.freund")) {
            obj.getScore("§2Freund").setScore(9);
        } else if (p.hasPermission("group.youtuber")){
            obj.getScore("§5YouTuber").setScore(9);
        } else if (p.hasPermission("group.ultra")){
            obj.getScore("§3Ultra").setScore(9);
        } else if (p.hasPermission("group.premium")){
            obj.getScore("§6Premium").setScore(9);
        } else {
            obj.getScore("§7Spieler").setScore(9);
        }

        obj.getScore("§b ").setScore(8);
        obj.getScore("§7\u2718 Online: ").setScore(7);
        obj.getScore(updateTeam(sb, "Coins", "§f" + Bukkit.getOnlinePlayers().size() + "§7/§f" + Bukkit.getMaxPlayers(), "§4", ChatColor.RED)).setScore(6);
        obj.getScore("§c ").setScore(5);
        obj.getScore("§7\u27a5 Level:").setScore(4);
        obj.getScore(updateTeam(sb, "Coins1", "§6" + getLevel(p.getName()), " §7", ChatColor.AQUA)).setScore(3);
        obj.getScore("§e ").setScore(2);
        obj.getScore("§7\u2718 Kills / Tode").setScore(1);
        obj.getScore(updateTeam(sb, "Coins2", "§7" + (float)((int)(getKills(p.getName()) / (float)getTode(p.getName()) * 100.0f) / 100.0), " §3K/D", ChatColor.BLACK)).setScore(0);

        p.setScoreboard(sb);
    }

    public static void updateScoreboard(Player p) {
        if (p.getScoreboard() == null) {
            setScoreboard(p);
        }
        Scoreboard sb = p.getScoreboard();
        Objective obj = sb.getObjective("aaa");
        obj.getScore(updateTeam(sb, "Coins", "§f" + Bukkit.getOnlinePlayers().size() + "§7/§f" + Bukkit.getMaxPlayers(), "§4", ChatColor.RED)).setScore(6);
        obj.getScore(updateTeam(sb, "Coins1", "§6" + getLevel(p.getName()), " §7", ChatColor.AQUA)).setScore(3);
        obj.getScore(updateTeam(sb, "Coins2", "§7" + (float) ((int) (getKills(p.getName()) / (float) getTode(p.getName()) * 100.0f) / 100.0), " §3K/D", ChatColor.BLACK)).setScore(0);


    }

    public static Team getTeam(Scoreboard sb, String Team, String prefix, String suffix) {
        Team team = sb.getTeam(Team);
        if (team == null) {
            team = sb.registerNewTeam(Team);
        }
        team.setPrefix(prefix);
        team.setSuffix(suffix);
        team.setAllowFriendlyFire(true);
        return team;
    }

    public static String updateTeam(Scoreboard sb, String Team, String prefix, String suffix, ChatColor entry) {
        Team team = sb.getTeam(Team);
        if (team == null) {
            team = sb.registerNewTeam(Team);
        }
        team.setPrefix(prefix);
        team.setSuffix(suffix);
        team.addEntry(entry.toString());
        return entry.toString();
    }

    public static void startScheduler() {
        new BukkitRunnable() {
            public void run() {
                for (Player on : Bukkit.getOnlinePlayers()) {

                    ScoreApi.updateScoreboard(on);

                }
            }
        }.runTaskTimer((Plugin)Main.instance, 20L, 20L);
    }

    public static Integer getLevel(String name) {
        final File file = new File("plugins/Koppyconomy", "level.yml");
        final FileConfiguration cfg = (FileConfiguration) YamlConfiguration.loadConfiguration(file);
        final int level = cfg.getInt(String.valueOf(name) + ".level");
        return level;
    }

    public static Integer getMoney(String name) {
        final File file = new File("plugins/Koppyconomy", "money.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int money = cfg.getInt(String.valueOf(name) + ".money");
        return money;
    }

    public static Integer getKills(String name) {
        final File file = new File("plugins/Koppyconomy", "kills.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int kills = cfg.getInt(String.valueOf(name) + ".kills");
        return kills;
    }

    public void addKills(String name, int amount) {
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

    public Integer getKills(Player name) {
        final File file = new File("plugins/Koppyconomy", "kills.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int kills = cfg.getInt(name + ".kills");
        return kills;
    }

    public void setKills(String name, int amount) {
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

    public static Integer getTode(String name) {
        final File file = new File("plugins/Koppyconomy", "tode.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int tode = cfg.getInt(String.valueOf(name) + ".tode");
        return tode;
    }

    public void addTode(String name, int amount) {
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

    public static Integer getTode(Player name) {
        final File file = new File("plugins/Koppyconomy", "tode.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int tode = cfg.getInt(name + ".tode");
        return tode;
    }

    public void setTode(String name, int amount) {
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
