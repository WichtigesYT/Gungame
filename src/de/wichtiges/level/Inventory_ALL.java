package de.wichtiges.level;

import de.wichtiges.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class Inventory_ALL implements Listener
{
    private Main main;

    public Inventory_ALL(final Main main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)main);
    }

    @EventHandler
    public void onJoin1(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        final ItemStack istack12 = new ItemStack(Material.TNT);
        final ItemMeta istackMeta12 = istack12.getItemMeta();
        istackMeta12.setDisplayName("§2\u27a5 BauModus");
        istack12.setItemMeta(istackMeta12);
        if (p.hasPermission("gg.build")) {
            p.getInventory().setItem(22, istack12);
        }
    }

    @EventHandler
    public void onInventoryClickEvent(final InventoryClickEvent e) {
        final ItemStack istack12 = new ItemStack(Material.TNT);
        final ItemMeta istackMeta12 = istack12.getItemMeta();
        istackMeta12.setDisplayName("§2\u27a5 BauModus");
        istack12.setItemMeta(istackMeta12);
        final ItemStack istack13 = new ItemStack(Material.CHEST);
        final ItemMeta istackMeta13 = istack13.getItemMeta();
        istackMeta13.setDisplayName("§1\u27a5 Profil");
        istack13.setItemMeta(istackMeta13);
        if (e.getCurrentItem().equals((Object)istack12) || e.getCurrentItem().equals((Object)istack13)) {
            e.setCancelled(true);
        }
    }
}
