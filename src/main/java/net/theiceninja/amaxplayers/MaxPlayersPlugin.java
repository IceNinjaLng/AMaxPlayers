package net.theiceninja.amaxplayers;

import net.theiceninja.amaxplayers.commands.SetMaxCommand;
import net.theiceninja.amaxplayers.listeners.ServerListPingListener;
import net.theiceninja.amaxplayers.utils.ColorUtil;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class MaxPlayersPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();

        getCommand("amaxplayers").setExecutor(new SetMaxCommand(this));
        getServer().getPluginManager().registerEvents(new ServerListPingListener(this), this);

        getServer().setMaxPlayers(getConfig().getInt("num"));
    }

    public String getStringFromConfig(@NotNull String path) {
        if (!getConfig().isSet(path)) return "Can't find this path";

        String string = getConfig().getString(path);
        if (string == null) {
            return "Can't find this message";
        }

        return ColorUtil.color(string);
    }
}
