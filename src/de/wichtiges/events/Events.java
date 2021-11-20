package de.wichtiges.events;

import de.wichtiges.*;
import de.wichtiges.level.*;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class Events implements Listener
{
    private Main main;

    public Events(final Main main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)main);
    }



    @EventHandler
    public void onFood(final FoodLevelChangeEvent e) {
        e.setCancelled(true);
        e.setFoodLevel(0);
    }

    @EventHandler
    public void onMove(final PlayerMoveEvent event) {
        final Player p = event.getPlayer();
        final Material m = p.getLocation().getBlock().getType();
        if ((m.equals((Object)Material.STATIONARY_WATER) || m.equals((Object)Material.WATER)) && p.getGameMode() != GameMode.CREATIVE) {
            final File file = new File("plugins//GunGame//spawn.yml");
            if (!file.exists()) {
                p.sendMessage(String.valueOf(Main.prefix) + "§cDer Spawn wurde noch nicht gesetzt!");
            }
            final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            final Location spawn = p.getLocation();
            final double x = cfg.getDouble("X");
            final double y = cfg.getDouble("Y");
            final double z = cfg.getDouble("Z");
            final double yaw = cfg.getDouble("Yaw");
            final double pitch = cfg.getDouble("Pitch");
            final String worldname = cfg.getString("WN");
            final World welt = Bukkit.getWorld(worldname);
            spawn.setX(x);
            spawn.setY(y);
            spawn.setZ(z);
            spawn.setPitch((float)pitch);
            spawn.setPitch((float)yaw);
            spawn.setWorld(welt);
            p.teleport(spawn);
            p.setHealth(0.0);
        }
    }

    @EventHandler
    public void onWeatherChange(final WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDrop(final InventoryDragEvent e) {
        if (e.getWhoClicked().getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickup(final PlayerPickupItemEvent e) {
        if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        if (e.getEntity() instanceof Player && !(e.getEntity() instanceof Player)) {
            final Player p = e.getEntity();
            p.closeInventory();
            this.Respawn(e.getEntity(), 1);
            Bukkit.getScheduler().runTaskLater((Plugin)this.main, (Runnable)new Runnable() {
                @Override
                public void run() {
                    if (Events.this.getLevel(p.getName()) == 0 || Events.this.getLevel(p.getName()) == 1) {
                        new StartInv(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 2) {
                        new InvLV2(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 3) {
                        new InvLV3(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 4) {
                        new InvLV4(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 5) {
                        new InvLV5(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 6) {
                        new InvLV6(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 7) {
                        new InvLV7(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 8) {
                        new InvLV8(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 9) {
                        new InvLV9(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 10) {
                        new InvLV10(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 11) {
                        new InvLV11(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 12) {
                        new InvLV12(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 13) {
                        new InvLV13(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 14) {
                        new InvLV14(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 15) {
                        new InvLV15(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 16) {
                        new InvLV16(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 17) {
                        new InvLV17(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 18) {
                        new InvLV18(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 19) {
                        new InvLV19(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 20) {
                        new InvLV20(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 21) {
                        new InvLV21(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 22) {
                        new InvLV22(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 23) {
                        new InvLV23(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 24) {
                        new InvLV24(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 25) {
                        new InvLV25(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 26) {
                        new InvLV26(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 27) {
                        new InvLV27(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 28) {
                        new InvLV28(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 29) {
                        new InvLV29(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 30) {
                        new InvLV30(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 31) {
                        new InvLV31(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 32) {
                        new InvLV32(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 33) {
                        new InvLV33(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 34) {
                        new InvLV34(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 35) {
                        new InvLV35(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 36) {
                        new InvLV36(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 37) {
                        new InvLV37(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 38) {
                        new InvLV38(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 39) {
                        new InvLV39(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 40) {
                        new InvLV40(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 41) {
                        new InvLV41(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 42) {
                        new InvLV42(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 43) {
                        new InvLV43(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 44) {
                        new InvLV44(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 45) {
                        new InvLV45(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 46) {
                        new InvLV46(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 47) {
                        new InvLV47(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 48) {
                        new InvLV48(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 49) {
                        new InvLV49(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 50) {
                        new InvLV50(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 51) {
                        new InvLV51(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 52) {
                        new InvLV52(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 53) {
                        new InvLV53(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 54) {
                        new InvLV54(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 55) {
                        new InvLV55(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 56) {
                        new InvLV56(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 57) {
                        new InvLV57(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 58) {
                        new InvLV58(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 59) {
                        new InvLV59(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 60) {
                        new InvLV60(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 61){
                        new InvLV61(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 61){
                        new InvLV61(p).setInventory();
                    }
                    else if (Events.this.getLevel(p.getName()) == 62){
                        new InvLV62(p).setInventory();
                    }
                }
            }, 20L);
        }
    }

    @EventHandler
    public void onJoine(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        p.setMaxHealth(20.0);
        p.setHealth(20.0);
    }

    @EventHandler
    public void onBlockPlace(final BlockPlaceEvent e) {
        if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreak(final BlockBreakEvent e) {
        if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onGamemodeChange(final PlayerGameModeChangeEvent e) {
        e.getPlayer().getInventory().clear();
        e.getPlayer().getInventory().setArmorContents((ItemStack[])null);
        e.getPlayer().updateInventory();
        if (e.getNewGameMode() != GameMode.CREATIVE) {
            new StartInv(e.getPlayer()).setInventory();
        }
    }

    @EventHandler
    public void onDrop(final PlayerDropItemEvent e) {
        final Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE) {
            e.setCancelled(false);
        }
        else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamen(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        final Player p2 = p.getKiller();
        p.playSound(p.getLocation(), Sound.BAT_DEATH, 4.0f, 1.0f);
        e.getDrops().clear();
        this.Respawn(p, 0);
        p2.getInventory().clear();
        this.addTode(p.getName(), 1);
        if (this.getLevel(p.getName()) == 0 || this.getLevel(p.getName()) == 1 || this.getLevel(p.getName()) == 2) {
            this.setLevel(p.getName(), 1);
        }
        else if (this.getLevel(p.getName()) < 10) {
            this.removeLevel(p.getName(), 1);
        }
        else if (this.getLevel(p.getName()) < 20) {
            this.removeLevel(p.getName(), 2);
        }
        else if (this.getLevel(p.getName()) < 30) {
            this.removeLevel(p.getName(), 4);
        }
        else if (this.getLevel(p.getName()) < 40) {
            this.removeLevel(p.getName(), 6);
        }
        else if (this.getLevel(p.getName()) < 50) {
            this.removeLevel(p.getName(), 10);
        }
        else if (this.getLevel(p.getName()) < 100) {
            this.removeLevel(p.getName(), 15);
        }
        else {
            this.removeLevel(p.getName(), 20);
        }
        if (p2 != null) {
            this.addLevel(p2.getName(), 1);
            this.addKills(p2.getName(), 1);
            p2.setHealth(20.0);
            p2.playSound(p2.getLocation(), Sound.NOTE_PLING, 1.0f, 6.0f);
            p2.sendMessage(String.valueOf(Main.prefix) + "§7Du bist nun §6Level " + this.getLevel(p2.getName()) + " §7.");
            p2.sendMessage(String.valueOf(Main.prefix) + "§7Du hat den Spieler §b" + p.getName() + " §7get\u00f6tet.");
            if (this.getLevel(p2.getName()) == 0 || this.getLevel(p2.getName()) == 1) {
                new StartInv(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 2) {
                new InvLV2(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 3) {
                new InvLV3(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 4) {
                new InvLV4(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 5) {
                new InvLV5(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 6) {
                new InvLV6(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 7) {
                new InvLV7(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 8) {
                new InvLV8(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 9) {
                new InvLV9(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 10) {
                new InvLV10(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 11) {
                new InvLV11(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 12) {
                new InvLV12(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 13) {
                new InvLV13(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 14) {
                new InvLV14(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 15) {
                new InvLV15(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 16) {
                new InvLV16(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 17) {
                new InvLV17(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 18) {
                new InvLV18(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 19) {
                new InvLV19(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 20) {
                new InvLV20(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 21) {
                new InvLV21(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 22) {
                new InvLV22(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 23) {
                new InvLV23(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 24) {
                new InvLV24(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 25) {
                new InvLV25(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 26) {
                new InvLV26(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 27) {
                new InvLV27(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 28) {
                new InvLV28(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 29) {
                new InvLV29(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 30) {
                new InvLV30(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 31) {
                new InvLV31(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 32) {
                new InvLV32(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 33) {
                new InvLV33(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 34) {
                new InvLV34(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 35) {
                new InvLV35(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 36) {
                new InvLV36(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 37) {
                new InvLV37(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 38) {
                new InvLV38(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 39) {
                new InvLV39(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 40) {
                new InvLV40(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 41) {
                new InvLV41(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 42) {
                new InvLV42(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 43) {
                new InvLV43(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 44) {
                new InvLV44(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 45) {
                new InvLV45(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 46) {
                new InvLV46(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 47) {
                new InvLV47(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 48) {
                new InvLV48(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 49) {
                new InvLV49(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 50) {
                new InvLV50(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 51) {
                new InvLV51(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 52) {
                new InvLV52(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 53) {
                new InvLV53(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 54) {
                new InvLV54(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 55) {
                new InvLV55(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 56) {
                new InvLV56(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 57) {
                new InvLV57(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 58) {
                new InvLV58(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 59) {
                new InvLV59(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 60) {
                new InvLV60(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 61) {
                new InvLV61(p2).setInventory();
            }
            else if (this.getLevel(p2.getName()) == 62) {
                new InvLV62(p2).setInventory();
            }
            p.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest von dem Spieler §b" + p2.getName() + " §7get\u00f6tet!");
        }
        else {
            p.sendMessage(String.valueOf(Main.prefix) + "§7Du bist §cGestorben!");
        }
    }

    public void Respawn(final Player p, final int Time) {
        Bukkit.getScheduler().runTaskLater((Plugin)this.main, (Runnable)new Runnable() {
            @Override
            public void run() {
                p.spigot().respawn();
            }
        }, (long)Time);
    }

    @EventHandler
    public void onRespawn(final PlayerRespawnEvent e) {
        final Player p = e.getPlayer();
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
                if (Events.this.getLevel(p.getName()) == 0 || Events.this.getLevel(p.getName()) == 1) {
                    new StartInv(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 2) {
                    new InvLV2(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 3) {
                    new InvLV3(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 4) {
                    new InvLV4(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 5) {
                    new InvLV5(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 6) {
                    new InvLV6(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 7) {
                    new InvLV7(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 8) {
                    new InvLV8(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 9) {
                    new InvLV9(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 10) {
                    new InvLV10(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 11) {
                    new InvLV11(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 12) {
                    new InvLV12(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 13) {
                    new InvLV13(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 14) {
                    new InvLV14(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 15) {
                    new InvLV15(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 16) {
                    new InvLV16(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 17) {
                    new InvLV17(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 18) {
                    new InvLV18(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 19) {
                    new InvLV19(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 20) {
                    new InvLV20(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 21) {
                    new InvLV21(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 22) {
                    new InvLV22(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 23) {
                    new InvLV23(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 24) {
                    new InvLV24(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 25) {
                    new InvLV25(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 26) {
                    new InvLV26(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 27) {
                    new InvLV27(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 28) {
                    new InvLV28(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 29) {
                    new InvLV29(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 30) {
                    new InvLV30(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 31) {
                    new InvLV31(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 32) {
                    new InvLV32(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 33) {
                    new InvLV33(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 34) {
                    new InvLV34(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 35) {
                    new InvLV35(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 36) {
                    new InvLV36(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 37) {
                    new InvLV37(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 38) {
                    new InvLV38(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 39) {
                    new InvLV39(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 40) {
                    new InvLV40(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 41) {
                    new InvLV41(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 42) {
                    new InvLV42(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 43) {
                    new InvLV43(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 44) {
                    new InvLV44(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 45) {
                    new InvLV45(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 46) {
                    new InvLV46(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 47) {
                    new InvLV47(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 48) {
                    new InvLV48(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 49) {
                    new InvLV49(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 50) {
                    new InvLV50(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 51) {
                    new InvLV51(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 52) {
                    new InvLV52(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 53) {
                    new InvLV53(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 54) {
                    new InvLV54(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 55) {
                    new InvLV55(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 56) {
                    new InvLV56(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 57) {
                    new InvLV57(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 58) {
                    new InvLV58(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 59) {
                    new InvLV59(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 60) {
                    new InvLV60(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 61){
                    new InvLV61(p).setInventory();
                }
                else if (Events.this.getLevel(p.getName()) == 62){
                    new InvLV62(p).setInventory();
                }
                else {
                    new InvLV62(p).setInventory();
                }
            }
        }, 10L);
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent event){

        if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {

            event.setCancelled(true);

        }

    }

    public void addMoney(final String name, final int amount) {
        final File file = new File("plugins/Koppyconomy", "money.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        int money = cfg.getInt(String.valueOf(name) + ".money");
        money += amount;
        cfg.set(String.valueOf(name) + ".money", (Object)money);
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

    public void addLevel(final String name, final int amount) {
        final File file = new File("plugins/Koppyconomy", "level.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        int level = cfg.getInt(String.valueOf(name) + ".level");
        level += amount;
        cfg.set(String.valueOf(name) + ".level", (Object)level);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer getLevel(final Player name) {
        final File file = new File("plugins/Koppyconomy", "level.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int level = cfg.getInt(name + ".level");
        return level;
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

    public Integer getKills(final String name) {
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

    public Integer getTode(final String name) {
        final File file = new File("plugins/Koppyconomy", "tode.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final int tode = cfg.getInt(String.valueOf(name) + ".tode");
        return tode;
    }

    public void removeKills(final String name, final int amount) {
        final File file = new File("plugins/Koppyconomy", "kills.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        int kills = cfg.getInt(String.valueOf(name) + ".kills");
        kills -= amount;
        cfg.set(String.valueOf(name) + ".kills", (Object)kills);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeLevel(final String name, final int amount) {
        final File file = new File("plugins/Koppyconomy", "level.yml");
        final FileConfiguration cfg = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        int level = cfg.getInt(String.valueOf(name) + ".level");
        level -= amount;
        cfg.set(String.valueOf(name) + ".level", (Object)level);
        try {
            cfg.save(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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

    public Integer getTode(final Player name) {
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
