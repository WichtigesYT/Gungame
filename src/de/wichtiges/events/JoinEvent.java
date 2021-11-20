package de.wichtiges.events;

import de.wichtiges.Main;
import de.wichtiges.ScoreApi;
import de.wichtiges.StartInv;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class JoinEvent implements Listener
{
    private Main main;

    public JoinEvent(Main main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)main);
    }



    @EventHandler(
            priority = EventPriority.HIGHEST
    )
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        ScoreApi.setScoreboard(p);
        this.setLevel(p.getName(), 1);
        new StartInv(e.getPlayer()).setInventory();
        e.setJoinMessage((String)null);
        p.setGameMode(GameMode.ADVENTURE);
        File file = new File("plugins//GunGame//spawn.yml");
        if (!file.exists()) {
            p.sendMessage(String.valueOf(Main.prefix) + "§cDer Spawn wurde noch nicht gesetzt!");
            p.setGameMode(GameMode.ADVENTURE);
        }
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        Location spawn = p.getLocation();
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
        p.teleport(spawn);

    }

    @EventHandler
    public void onJoine(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPlayedBefore()) {
            this.addTode(p.getName(), 1);
        }
    }

    public void setKills(String name, int amount) {
        File file = new File("plugins/Koppyconomy", "kills.yml");
        FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        cfg.set(String.valueOf(name) + ".kills", (Object)amount);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTode(String name, int amount) {
        File file = new File("plugins/Koppyconomy", "tode.yml");
        FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
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

    public void setLevel(String name, int amount) {
        File file = new File("plugins/Koppyconomy", "level.yml");
        FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        cfg.set(String.valueOf(name) + ".level", (Object)amount);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
