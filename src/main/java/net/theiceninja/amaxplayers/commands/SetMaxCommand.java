package net.theiceninja.amaxplayers.commands;

import net.theiceninja.amaxplayers.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetMaxCommand implements CommandExecutor {

    Main plugin;

    public SetMaxCommand(Main plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            if (args.length == 0){
                sender.sendMessage(color("&cYou need to follow the usage: /maxplayers <number>"));
                return true;
            }else{
                try {
                    int num = Integer.parseInt(args[0]);
                    Bukkit.setMaxPlayers(num);
                    sender.sendMessage(color("&cThe number of the players who can join the server is now &e" + num));
                }catch (Exception e) {
                    sender.sendMessage(color("&cThis is not a number so please follow the usage\n&eYou need to follow the usage: /maxplayers <number>"));
                }
            }
            return true;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("maxplayers.setmax")){
            p.sendMessage(color(plugin.getConfig().getString("no-permission")));
            return true;
        }
        if (args.length == 0){
            p.sendMessage(color(plugin.getConfig().getString("setmax-usage")));
            return true;
        }else{
            try {
                int num = Integer.parseInt(args[0]);
                Bukkit.setMaxPlayers(num);
                p.sendMessage(color(plugin.getConfig().getString("num-done")).replaceAll("%num%", String.valueOf(num)));
            }catch (Exception e) {
                p.sendMessage(color(plugin.getConfig().getString("no-num")));
            }
        }

        return true;
    }
    private String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
