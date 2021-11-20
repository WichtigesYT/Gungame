package de.wichtiges.events;

import de.wichtiges.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class NoHitAreaEvent implements Listener
{
    private Main main;

    public NoHitAreaEvent(final Main main) {
        this.main = main;
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)main);
    }

    public NoHitAreaEvent() {

    }

    @EventHandler
    public void ond(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player p2 = (Player)e.getDamager();
            final File file1 = new File("plugins//GunGame//region.yml");
            file1.exists();
            final YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
            final Location locA = p.getLocation();
            final double x = cfg1.getDouble("X");
            final double y = cfg1.getDouble("Y");
            final double z = cfg1.getDouble("Z");
            locA.setX(x);
            locA.setY(y);
            locA.setZ(z);
            final Location locB = p.getLocation();
            final double x2 = cfg1.getDouble("X1");
            final double y2 = cfg1.getDouble("Y1");
            final double z2 = cfg1.getDouble("Z1");
            locB.setX(x2);
            locB.setY(y2);
            locB.setZ(z2);
            final Location loc = p.getLocation();
            final Double maxX = (locA.getX() > locB.getX()) ? locA.getX() : locB.getX();
            final Double minX = (locA.getX() < locB.getX()) ? locA.getX() : locB.getX();
            final Double maxY = (locA.getY() > locB.getY()) ? locA.getY() : locB.getY();
            final Double minY = (locA.getY() < locB.getY()) ? locA.getY() : locB.getY();
            final Double maxZ = (locA.getZ() > locB.getZ()) ? locA.getZ() : locB.getZ();
            final Double minZ = (locA.getZ() < locB.getZ()) ? locA.getZ() : locB.getZ();
            if (loc.getX() <= maxX && loc.getX() >= minX) {
                if (loc.getY() <= maxY && loc.getY() >= minY && loc.getZ() <= maxZ && loc.getZ() >= minZ) {
                    if (p2.getGameMode() != GameMode.CREATIVE) {
                        e.setCancelled(true);
                        p2.sendMessage(String.valueOf(Main.prefix) + "§cDu darfst hier niemanden schlagen!");
                    }
                    else {
                        e.setCancelled(false);
                    }
                }
            }
            else {
                e.setCancelled(false);
            }
        }
    }

    @EventHandler
    public void onds(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final File file1 = new File("plugins//GunGame//region.yml");
            file1.exists();
            final YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
            final Location locA = p.getLocation();
            final double x = cfg1.getDouble("X");
            final double y = cfg1.getDouble("Y");
            final double z = cfg1.getDouble("Z");
            locA.setX(x);
            locA.setY(y);
            locA.setZ(z);
            final Location locB = p.getLocation();
            final double x2 = cfg1.getDouble("X1");
            final double y2 = cfg1.getDouble("Y1");
            final double z2 = cfg1.getDouble("Z1");
            locB.setX(x2);
            locB.setY(y2);
            locB.setZ(z2);
            final Location loc = p.getLocation();
            final Double maxX = (locA.getX() > locB.getX()) ? locA.getX() : locB.getX();
            final Double minX = (locA.getX() < locB.getX()) ? locA.getX() : locB.getX();
            final Double maxY = (locA.getY() > locB.getY()) ? locA.getY() : locB.getY();
            final Double minY = (locA.getY() < locB.getY()) ? locA.getY() : locB.getY();
            final Double maxZ = (locA.getZ() > locB.getZ()) ? locA.getZ() : locB.getZ();
            final Double minZ = (locA.getZ() < locB.getZ()) ? locA.getZ() : locB.getZ();
            if (loc.getX() <= maxX && loc.getX() >= minX) {
                if (loc.getY() <= maxY && loc.getY() >= minY && loc.getZ() <= maxZ && loc.getZ() >= minZ) {
                    e.setCancelled(true);
                }
            }
            else {
                e.setCancelled(false);
            }
        }
    }

    @EventHandler
    public void ondamen(final EntityShootBowEvent e) {
        final Player p = (Player)e.getEntity();
        final File file1 = new File("plugins//GunGame//region.yml");
        file1.exists();
        final YamlConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
        final Location locA = p.getLocation();
        final double x = cfg1.getDouble("X");
        final double y = cfg1.getDouble("Y");
        final double z = cfg1.getDouble("Z");
        locA.setX(x);
        locA.setY(y);
        locA.setZ(z);
        final Location locB = p.getLocation();
        final double x2 = cfg1.getDouble("X1");
        final double y2 = cfg1.getDouble("Y1");
        final double z2 = cfg1.getDouble("Z1");
        locB.setX(x2);
        locB.setY(y2);
        locB.setZ(z2);
        final Location loc = p.getLocation();
        if (this.isIn(loc, locA, locB)) {
            e.setCancelled(true);
        }
        else {
            e.setCancelled(false);
        }
    }

    private boolean isIn(final Location loc, final Location locA, final Location locB) {
        final Double maxX = (locA.getX() > locB.getX()) ? locA.getX() : locB.getX();
        final Double minX = (locA.getX() < locB.getX()) ? locA.getX() : locB.getX();
        final Double maxY = (locA.getY() > locB.getY()) ? locA.getY() : locB.getY();
        final Double minY = (locA.getY() < locB.getY()) ? locA.getY() : locB.getY();
        final Double maxZ = (locA.getZ() > locB.getZ()) ? locA.getZ() : locB.getZ();
        final Double minZ = (locA.getZ() < locB.getZ()) ? locA.getZ() : locB.getZ();
        return loc.getX() <= maxX && loc.getX() >= minX && loc.getY() <= maxY && loc.getY() >= minY && loc.getZ() <= maxZ && loc.getZ() >= minZ;
    }
}
