package de.wichtiges.level;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class InvLV32 {
    Player p;

    public InvLV32(final Player p) {
        this.p = p;
    }

    public void setInventory() {
        final ItemStack istack10 = new ItemStack(Material.STONE_SWORD);
        final ItemMeta istackMeta10 = istack10.getItemMeta();
        istackMeta10.setDisplayName("§6Oh Yeah!");
        istackMeta10.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        istack10.setItemMeta(istackMeta10);
        istack10.setItemMeta(istackMeta10);
        final ItemStack istack11 = new ItemStack(Material.STICK);
        final ItemMeta istackMeta11 = istack11.getItemMeta();
        istackMeta11.setDisplayName("§7Knocki-100");
        istack11.setItemMeta(istackMeta11);
        final ArrayList<String> lore13 = new ArrayList<String>();
        istackMeta11.addEnchant(Enchantment.KNOCKBACK, 100, true);
        istack11.setItemMeta(istackMeta11);
        final ItemStack istack12 = new ItemStack(Material.STICK);
        final ItemMeta istackMeta12 = istack12.getItemMeta();
        istackMeta12.setDisplayName("§7Knocki-1000");
        istack12.setItemMeta(istackMeta12);
        final ArrayList<String> lore14 = new ArrayList<String>();
        istackMeta12.addEnchant(Enchantment.KNOCKBACK, 1000, true);
        istack12.setItemMeta(istackMeta11);
        final ItemStack istack13 = new ItemStack(Material.CHEST);
        final ItemMeta istackMeta13 = istack13.getItemMeta();
        istackMeta13.setDisplayName("§1\u27a5 Profil");
        istack13.setItemMeta(istackMeta13);
        final ItemStack istack14 = new ItemStack(Material.FEATHER);
        final ItemMeta istackMeta14 = istack14.getItemMeta();
        istackMeta14.setDisplayName("§6\u27a5 Spectator");
        istack14.setItemMeta(istackMeta14);
        final ItemStack istack15 = new ItemStack(Material.TNT);
        final ItemMeta istackMeta15 = istack15.getItemMeta();
        istackMeta15.setDisplayName("§2\u27a5 BauModus");
        istack15.setItemMeta(istackMeta15);
        final ItemStack istack16 = new ItemStack(Material.CHAINMAIL_HELMET);
        final ItemMeta istackMeta16 = istack16.getItemMeta();
        istackMeta16.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
        istack16.setItemMeta(istackMeta16);
        final ItemStack istack17 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        final ItemMeta istackMeta17 = istack17.getItemMeta();
        istackMeta17.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
        istack17.setItemMeta(istackMeta17);
        final ItemStack istack18 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        final ItemMeta istackMeta18 = istack18.getItemMeta();
        istackMeta18.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
        istack18.setItemMeta(istackMeta18);
        final ItemStack istack19 = new ItemStack(Material.CHAINMAIL_BOOTS);
        final ItemMeta istackMeta19 = istack19.getItemMeta();
        istackMeta19.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, true);
        istack19.setItemMeta(istackMeta19);
        this.p.getInventory().clear();
        this.p.getInventory().setArmorContents((ItemStack[])null);
        this.p.getInventory().setBoots(istack19);
        this.p.getInventory().setLeggings(istack18);
        this.p.getInventory().setChestplate(istack17);
        this.p.getInventory().setHelmet(istack16);
        this.p.getInventory().setItem(0, istack10);
        this.p.getInventory().setItem(8, istack13);
        this.p.updateInventory();
    }
}
