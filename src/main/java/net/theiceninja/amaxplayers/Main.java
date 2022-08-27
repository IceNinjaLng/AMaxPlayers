package net.theiceninja.amaxplayers;

import net.theiceninja.amaxplayers.commands.SetMaxCommand;
import net.theiceninja.amaxplayers.listeners.MaxListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("amaxplayers").setExecutor(new SetMaxCommand(this));
        getServer().getPluginManager().registerEvents(new MaxListener(), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
    }
}
