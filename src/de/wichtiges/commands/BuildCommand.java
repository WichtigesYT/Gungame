package de.wichtiges.commands;

import de.wichtiges.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (p.hasPermission("gg.build")) {
            if (p.getGameMode() != GameMode.CREATIVE) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(String.valueOf(Main.prefix) + "§7Du wurdest in den §aBaumodus §7gesetzt.");
            }
            else if (p.getGameMode() == GameMode.CREATIVE) {
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(String.valueOf(Main.prefix) + "§7Du hast in den §cBaumodus §7verlassen.");
            }
        }
        return true;
    }
}
