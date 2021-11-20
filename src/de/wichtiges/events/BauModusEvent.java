package de.wichtiges.events;

import de.wichtiges.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class BauModusEvent implements Listener
{
    private Main main;

    public BauModusEvent(final Main main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)main);
    }

    @EventHandler
    public void onFeather(final InventoryClickEvent e) {
        if (e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.TNT) {
            final ItemStack istack12 = new ItemStack(Material.TNT);
            final ItemMeta istackMeta12 = istack12.getItemMeta();
            istackMeta12.setDisplayName("§2\u27a5 BauModus");
            istack12.setItemMeta(istackMeta12);
            if (e.getWhoClicked().getGameMode() != GameMode.CREATIVE) {
                e.getWhoClicked().setGameMode(GameMode.CREATIVE);
                e.getWhoClicked().getInventory().clear();
                e.getWhoClicked().sendMessage(String.valueOf(Main.prefix) + "§7Der §aBauModus §7wurde aktiviert!");
                e.getWhoClicked().getInventory().setItem(9, istack12);
            }
            else if (e.getWhoClicked().getGameMode() == GameMode.CREATIVE) {
                e.getWhoClicked().setGameMode(GameMode.ADVENTURE);
                e.getWhoClicked().getInventory().setItem(22, istack12);
                e.getWhoClicked().sendMessage(String.valueOf(Main.prefix) + "§7Du hast den §cBauModus §7verlassen!");
            }
        }
    }
}
