package de.wichtiges.commands;

import de.wichtiges.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (p.hasPermission("gg.gm")) {
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Main.prefix) + "§cVerwende: §7/gamemode 0 | 1 | 2 | 3  <Spieler>");
            }
            else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("0")) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aSURVIVAL §7gesetzt.");
                }
                else if (args[0].equalsIgnoreCase("1")) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aCREATIVE §7gesetzt.");
                }
                else if (args[0].equalsIgnoreCase("2")) {
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aADVENTURE §7gesetzt.");
                }
                else if (args[0].equalsIgnoreCase("3")) {
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aSPECTATOR §7gesetzt.");
                }
                else if (args[0].equalsIgnoreCase("creative")) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aCREATIVE §7gesetzt.");
                }
                else if (args[0].equalsIgnoreCase("adventure")) {
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aADVENTURE §7gesetzt.");
                }
                else if (args[0].equalsIgnoreCase("spectator")) {
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aSPECTATOR §7gesetzt.");
                }
                else if (args[0].equalsIgnoreCase("survival")) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aSPECTATOR §7gesetzt.");
                }
                else {
                    p.sendMessage(String.valueOf(Main.prefix) + "§cVerwende: §7/gamemode 0 | 1 | 2 | 3  <Spieler>");
                }
            }
            else if (args.length == 2) {
                final Player target = Bukkit.getPlayer(args[1]);
                if (target != null) {
                    if (args[0].equalsIgnoreCase("0")) {
                        target.setGameMode(GameMode.SURVIVAL);
                        target.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aSURVIVAL §7gesetzt.");
                        p.sendMessage(String.valueOf(Main.prefix) + "§7Der Spieler§b " + target.getName() + " §7wurde in den §aSURVIVAL §7gesetzt.");
                    }
                    else if (args[0].equalsIgnoreCase("1")) {
                        target.setGameMode(GameMode.CREATIVE);
                        target.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aCREATIVE §7gesetzt.");
                        p.sendMessage(String.valueOf(Main.prefix) + "§7Der Spieler§b " + target.getName() + " §7wurde in den §aCREATIVE §7gesetzt.");
                    }
                    else if (args[0].equalsIgnoreCase("2")) {
                        target.setGameMode(GameMode.ADVENTURE);
                        target.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aADVENTURE §7gesetzt.");
                        p.sendMessage(String.valueOf(Main.prefix) + "§7Der Spieler§b " + target.getName() + " §7wurde in den §aADVENTURE §7gesetzt.");
                    }
                    else if (args[0].equalsIgnoreCase("3")) {
                        target.setGameMode(GameMode.SPECTATOR);
                        target.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aSPECTATOR §7gesetzt.");
                        p.sendMessage(String.valueOf(Main.prefix) + "§7Der Spieler§b " + target.getName() + " §7wurde in den §aSPECTATOR §7gesetzt.");
                    }
                    else if (args[0].equalsIgnoreCase("creative")) {
                        target.setGameMode(GameMode.CREATIVE);
                        target.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aCREATIVE §7gesetzt.");
                        p.sendMessage(String.valueOf(Main.prefix) + "§7Der Spieler§b " + target.getName() + " §7wurde in den §aCREATIVE §7gesetzt.");
                    }
                    else if (args[0].equalsIgnoreCase("adventure")) {
                        target.setGameMode(GameMode.ADVENTURE);
                        target.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aADVENTURE §7gesetzt.");
                        p.sendMessage(String.valueOf(Main.prefix) + "§7Der Spieler§b " + target.getName() + " §7wurde in den §aADVENTURE §7gesetzt.");
                    }
                    else if (args[0].equalsIgnoreCase("spectator")) {
                        target.setGameMode(GameMode.SPECTATOR);
                        target.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aSPECTATOR §7gesetzt.");
                        p.sendMessage(String.valueOf(Main.prefix) + "§7Der Spieler§b " + target.getName() + " §7wurde in den §aSPECTATOR §7gesetzt.");
                    }
                    else if (args[0].equalsIgnoreCase("survival")) {
                        target.setGameMode(GameMode.SURVIVAL);
                        target.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den Gamemode §aSPECTATOR §7gesetzt.");
                        p.sendMessage(String.valueOf(Main.prefix) + "§7Der Spieler§b " + target.getName() + " §7wurde in den §aSPECTATOR §7gesetzt.");
                    }
                    else {
                        p.sendMessage(String.valueOf(Main.prefix) + "§cVerwende: §7/gamemode 0 | 1 | 2 | 3  <Spieler>");
                    }
                }
                else {
                    p.sendMessage(String.valueOf(Main.prefix) + "§7Der Spieler§c" + target.getName() + " §7ist nicht online!");
                }
            }
            else {
                p.sendMessage(String.valueOf(Main.prefix) + "§cVerwende: §7/gamemode 0 | 1 | 2 | 3  <Spieler>");
            }
        }
        else {
            p.sendMessage(String.valueOf(Main.prefix) + "§cDu hast keine Rechte auf diesen Command!");
        }
        return true;
    }
}
