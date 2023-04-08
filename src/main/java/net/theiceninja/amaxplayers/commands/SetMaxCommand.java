package net.theiceninja.amaxplayers.commands;

import net.theiceninja.amaxplayers.MaxPlayersPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class SetMaxCommand implements CommandExecutor {

    private final MaxPlayersPlugin plugin;

    public SetMaxCommand(MaxPlayersPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) {
            executeMaxCommand(sender, args);
            return true;
        }

        if (!player.hasPermission("maxplayers.setmax")) {
            player.sendMessage(color(plugin.getConfig().getString("messages.no-permission")));
            return true;
        }

        executeMaxCommand(sender, args);

        return true;
    }

    private String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    private void executeMaxCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(color(plugin.getConfig().getString("messages.setmax-usage")));
        } else {
            try {
                int num = Integer.parseInt(args[0]);

                plugin.getServer().setMaxPlayers(num);
                plugin.getConfig().set("num", num);
                plugin.saveConfig();

                sender.sendMessage(color(plugin.getConfig().getString("messages.num-done")).replaceAll("%num%", String.valueOf(num)));
            } catch (Exception e) {
                if (args[0].equalsIgnoreCase("reload")) {
                    plugin.reloadConfig();
                    plugin.getServer().setMaxPlayers(plugin.getConfig().getInt("num"));

                    sender.sendMessage(color(plugin.getConfig().getString("messages.config-reload")));
                } else {
                    sender.sendMessage(color(plugin.getConfig().getString("messages.no-num")));
                }
            }
        }
    }
}
