package de.wichtiges.events;

import de.wichtiges.Main;
import de.wichtiges.ScoreApi;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class QuitEvent implements Listener
{
    private Main main;

    public QuitEvent(Main main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)main);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        e.setQuitMessage((String)null);
        ScoreApi.setScoreboard(p);
    }
}
