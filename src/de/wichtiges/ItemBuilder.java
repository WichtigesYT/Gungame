package de.wichtiges;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemBuilder {
    private ItemStack itemStack;
    private ItemMeta itemMeta;
    private SkullMeta skullMeta;

    public ItemBuilder(final Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder(final ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder setMaterial(final Material material) {
        this.itemStack.setType(material);
        return this;
    }

    public ItemBuilder setSubid(final byte subid) {
        this.itemStack.getData().setData(subid);
        return this;
    }

    public ItemBuilder setAmount(final int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder setName(final String name) {
        this.itemMeta.setDisplayName(name);
        return this;
    }

    public ItemBuilder setDurability(final short durability) {
        this.itemStack.setDurability(durability);
        return this;
    }

    public ItemBuilder setEnchantments(final Map<Enchantment, Integer> enchantments) {
        enchantments.forEach((enchantment, level) -> this.itemStack.addEnchantment(enchantment, (int)level));
        return this;
    }

    public ItemBuilder addEnchantment(final Enchantment enchantment, final Integer level) {
        this.itemStack.addEnchantment(enchantment, (int)level);
        return this;
    }

    public ItemBuilder clearEnchantments() {
        this.itemStack.getEnchantments().keySet().forEach(enchantment -> this.itemStack.removeEnchantment(enchantment));
        return this;
    }

    public ItemBuilder removeEnchantment(final Enchantment enchantment) {
        this.itemStack.removeEnchantment(enchantment);
        return this;
    }

    public ItemBuilder setLore(final List<String> lore) {
        this.itemMeta.setLore((List)lore);
        return this;
    }

    public ItemBuilder addLore(final String lore) {
        final List<String> loreList = (List<String>)this.itemMeta.getLore();
        loreList.add(lore);
        this.itemMeta.setLore((List)loreList);
        return this;
    }

    public ItemBuilder clearLore() {
        this.itemMeta.setLore((List)new ArrayList());
        return this;
    }

    public ItemBuilder removeLore(final String lore) {
        this.itemMeta.getLore().remove(lore);
        return this;
    }

    public ItemBuilder setSkullOwner(final String owner) {
        this.itemStack.setItemMeta(this.itemMeta);
        (this.skullMeta = (SkullMeta)this.itemStack.getItemMeta()).setOwner(owner);
        return this;
    }

    public ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }

    public ItemStack buildSkull() {
        this.itemStack.setItemMeta((ItemMeta)this.skullMeta);
        this.itemStack.getData().setData((byte)3);
        return this.itemStack;
    }
}
