package de.wichtiges;

import de.wichtiges.commands.*;
import de.wichtiges.events.*;
import de.wichtiges.level.Inventory_ALL;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    public static String prefix;
    public static Main instance;

    static {
        Main.prefix = "§6GunGame §8\u2503 §r";
    }

    public void onEnable() {
        System.out.println("Das GunGame Plugin wurde geladen!");

        (Main.instance = this).registerCommands();
        new NoHitAreaEvent(this);
        new JoinEvent(this);
        new QuitEvent(this);
        new BauModusEvent(this);
        new Inventory_ALL(this);
        new Events(this);
        new ProfilEvent(this);
        new MoveEvent();
        ScoreApi.startScheduler();
    }

    public void onDisable() {
        System.out.println("Das GunGame Plugin wurde deaktiviert!");
        Main.instance = null;
    }

    public void registerCommands() {
        this.getCommand("setspawn").setExecutor((CommandExecutor)new SetSpawnCommand());
        this.getCommand("spawn").setExecutor((CommandExecutor)new SpawnCommand());
        this.getCommand("setpos").setExecutor((CommandExecutor)new SetPosCommand());
        this.getCommand("gamemode").setExecutor((CommandExecutor)new GameModeCommand());
        this.getCommand("build").setExecutor((CommandExecutor)new BuildCommand());
        this.getCommand("kills").setExecutor((CommandExecutor)new KillasCommand());
        this.getCommand("tode").setExecutor((CommandExecutor)new TodeCommand());
        this.getCommand("kd").setExecutor((CommandExecutor)new DKCommand());
        this.getCommand("stats").setExecutor((CommandExecutor)new StatsCommand());
        this.getCommand("statsresett").setExecutor((CommandExecutor)new StatsResettCommand());
    }
}