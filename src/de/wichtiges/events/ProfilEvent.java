package de.wichtiges.events;

import de.wichtiges.Main;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfilEvent implements Listener
{
    public Inventory profil;
    private Main main;

    public ProfilEvent(final Main main) {
        this.profil = null;
        this.main = main;
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)main);
    }

    @EventHandler
    public void onFeather(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getItem() != null && e.getItem().getType() == Material.CHEST) {
            final ItemStack istack7 = new ItemStack(Material.GOLD_NUGGET);
            final ItemMeta istackMeta7 = istack7.getItemMeta();
            istackMeta7.setDisplayName("§6Level:");
            istack7.setItemMeta(istackMeta7);
            final ArrayList<String> lore7 = new ArrayList<String>();
            lore7.add("§7\u27a5  Level " + this.getLevel(p.getName()));
            istackMeta7.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            istackMeta7.setLore((List)lore7);
            istackMeta7.addEnchant(Enchantment.KNOCKBACK, 4, true);
            istack7.setItemMeta(istackMeta7);
            final ItemStack istack8 = new ItemStack(Material.BARRIER);
            final ItemMeta istackMeta8 = istack8.getItemMeta();
            istackMeta8.setDisplayName("§cStats Reset");
            istack8.setItemMeta(istackMeta8);
            final ArrayList<String> lore8 = new ArrayList<String>();
            lore8.add("§7\u27a5  Deine Stats §cRESETTEN");
            istackMeta8.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            istackMeta8.setLore((List)lore8);
            istackMeta8.addEnchant(Enchantment.KNOCKBACK, 4, true);
            istack8.setItemMeta(istackMeta8);
            final ItemStack istack9 = new ItemStack(Material.NETHER_STAR);
            final ItemMeta istackMeta9 = istack9.getItemMeta();
            istackMeta9.setDisplayName("§6Spawn");
            istack9.setItemMeta(istackMeta9);
            final ArrayList<String> lore9 = new ArrayList<String>();
            lore9.add("§5\u27a5 Zum Spawn");
            istackMeta9.setLore((List)lore9);
            istack9.setItemMeta(istackMeta9);
            final ItemStack istack10 = new ItemStack(Material.COMPASS);
            final ItemMeta istackMeta10 = istack10.getItemMeta();
            istackMeta10.setDisplayName("§6Stats:");
            istack10.setItemMeta(istackMeta10);
            final ArrayList<String> lore10 = new ArrayList<String>();
            lore10.add("§7\u27a5 Kills: §e" + getKills(p.getName()) + " Kills");
            lore10.add("§7\u27a5 Tode:  §e" + getTode(p.getName()) + " Tode");
            lore10.add("§7\u27a5 KD: §e" + (float)((int)(getKills(p.getName()) / (float)getTode(p.getName()) * 100.0f) / 100.0) + " Kills/Tode");
            istackMeta10.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            istackMeta10.setLore((List)lore10);
            istackMeta10.addEnchant(Enchantment.KNOCKBACK, 4, true);
            istack10.setItemMeta(istackMeta10);
            final ItemStack istack11 = new ItemStack(Material.STAINED_GLASS_PANE);
            final ItemMeta meta = istack11.getItemMeta();
            meta.setDisplayName(" ");
            istack11.setItemMeta(meta);
            (this.profil = Bukkit.createInventory((InventoryHolder)null, 27, "§3Profil")).setItem(0, istack11);
            this.profil.setItem(1, istack11);
            this.profil.setItem(2, istack11);
            this.profil.setItem(3, istack11);
            this.profil.setItem(4, istack11);
            this.profil.setItem(5, istack11);
            this.profil.setItem(6, istack11);
            this.profil.setItem(7, istack11);
            this.profil.setItem(8, istack11);
            this.profil.setItem(9, istack11);
            this.profil.setItem(11, istack11);
            this.profil.setItem(13, istack11);
            this.profil.setItem(15, istack11);
            this.profil.setItem(17, istack11);
            this.profil.setItem(18, istack11);
            this.profil.setItem(19, istack11);
            this.profil.setItem(20, istack11);
            this.profil.setItem(21, istack11);
            this.profil.setItem(22, istack11);
            this.profil.setItem(23, istack11);
            this.profil.setItem(24, istack11);
            this.profil.setItem(25, istack11);
            this.profil.setItem(26, istack11);
            this.profil.setItem(10, istack9);
            this.profil.setItem(12, istack10);
            this.profil.setItem(14, istack7);
            this.profil.setItem(16, istack8);
            e.getPlayer().openInventory(this.profil);
        }
    }

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        if (e.getClickedInventory() != null && e.getClickedInventory().getName().equalsIgnoreCase("§3Profil")) {
            final Player p = (Player)e.getWhoClicked();
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().getType() != Material.AIR) {
                final Material material = e.getCurrentItem().getType();
                if (material == Material.NETHER_STAR) {
                    p.closeInventory();
                    p.updateInventory();
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 3.0f, 1.0f);
                    p.sendMessage(String.valueOf(Main.prefix) + "§7Du wirst in §a3 Sekunden §7an den §bSpawn §7 teleportiert!");
                    Bukkit.getScheduler().runTaskLater((Plugin)this.main, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            final File file = new File("plugins//GunGame//spawn.yml");
                            if (!file.exists()) {
                                p.sendMessage(String.valueOf(Main.prefix) + "§cDer Spawn wurde noch nicht gesetzt!");
                            }
                            final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                            final Location spawn = p.getLocation();
                            final double x = cfg.getDouble("X");
                            final double y = cfg.getDouble("Y");
                            final double z = cfg.getDouble("Z");
                            final double yaw = cfg.getDouble("YAW");
                            final double pitch = cfg.getDouble("PITCH");
                            final String worldname = cfg.getString("WN");
                            final World welt = Bukkit.getWorld(worldname);
                            spawn.setX(x);
                            spawn.setY(y);
                            spawn.setZ(z);
                            spawn.setPitch((float)pitch);
                            spawn.setPitch((float)yaw);
                            spawn.setWorld(welt);
                            p.teleport(spawn);
                            p.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest an den §bSpawn §7teleportiert!");
                        }
                    }, 60L);
                }
                else if (material == Material.BARRIER) {
                    p.sendMessage(String.valueOf(Main.prefix) + "§7Deine §bStats §7wurden §cRESETTET§7!");
                    this.setKills(p.getName(), 0);
                    this.setTode(p.getName(), 1);
                    p.closeInventory();
                    p.updateInventory();
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 3.0f, 1.0f);
                }
            }
        }
    }

    public void setLevel(final String name, final int amount) {
        final File file = new File("plugins/Koppyconomy", "level.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        cfg.set(String.valueOf(name) + ".level", (Object)amount);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getLevel(final String name) {
        final File file = new File("plugins/Koppyconomy", "level.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int level = cfg.getInt(String.valueOf(name) + ".level");
        return level;
    }

    public static Integer getMoney(final String name) {
        final File file = new File("plugins/Koppyconomy", "money.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int money = cfg.getInt(String.valueOf(name) + ".money");
        return money;
    }

    public static Integer getKills(final String name) {
        final File file = new File("plugins/Koppyconomy", "kills.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
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

    public static Integer getTode(final String name) {
        final File file = new File("plugins/Koppyconomy", "tode.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int tode = cfg.getInt(String.valueOf(name) + ".tode");
        return tode;
    }

    public void addTode(final String name, final int amount) {
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

    public static Integer getTode(final Player name) {
        final File file = new File("plugins/Koppyconomy", "tode.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int tode = cfg.getInt(name + ".tode");
        return tode;
    }

    public void setTode(final String name, final int amount) {
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
