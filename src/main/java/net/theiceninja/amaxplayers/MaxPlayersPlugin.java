package net.theiceninja.amaxplayers;

import net.theiceninja.amaxplayers.commands.SetMaxCommand;
import net.theiceninja.amaxplayers.listeners.MaxListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MaxPlayersPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();

        getCommand("amaxplayers").setExecutor(new SetMaxCommand(this));
        getServer().getPluginManager().registerEvents(new MaxListener(this), this);

        getServer().setMaxPlayers(getConfig().getInt("num"));
    }
}
