package net.theiceninja.amaxplayers.commands;

import net.theiceninja.amaxplayers.MaxPlayersPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public final class SetMaxCommand implements CommandExecutor {

    private final MaxPlayersPlugin plugin;

    public SetMaxCommand(MaxPlayersPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!sender.hasPermission("maxplayers.admin")) {
            sender.sendMessage(plugin.getStringFromConfig("messages.no-permission"));
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(plugin.getStringFromConfig("messages.setmax-usage"));
            return true;
        }

        try {
            plugin.getServer().setMaxPlayers(Integer.parseInt(args[0]));
            plugin.getConfig().set("num", Integer.parseInt(args[0]));
            plugin.saveConfig();

            sender.sendMessage(plugin.getStringFromConfig("messages.num-done")
                    .replaceAll("%num%", String.valueOf(Integer.parseInt(args[0]))));
        } catch (Exception ex) {
            if (args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                plugin.getServer().setMaxPlayers(plugin.getConfig().getInt("num"));

                sender.sendMessage(plugin.getStringFromConfig("messages.config-reload"));
            } else
                sender.sendMessage(plugin.getStringFromConfig("messages.no-num"));
        }

        return true;
    }
}
