package de.wichtiges.events;

import de.wichtiges.ScoreApi;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {
    public ChatEvent() {
    }

    @EventHandler
    public static void onChat(AsyncPlayerChatEvent e) {
        e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
        String msg = e.getMessage();
        Player p = e.getPlayer();
        e.setFormat(p.getDisplayName() + "§eLevel: " + ScoreApi.getLevel(p.getName()) + " §8>>> §7" + msg);
    }
}
