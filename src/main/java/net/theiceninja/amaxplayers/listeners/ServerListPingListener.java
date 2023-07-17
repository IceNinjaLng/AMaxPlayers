package net.theiceninja.amaxplayers.listeners;

import net.theiceninja.amaxplayers.MaxPlayersPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public final class ServerListPingListener implements Listener {

    private final MaxPlayersPlugin plugin;

    public ServerListPingListener(MaxPlayersPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onServerListPing(ServerListPingEvent event) {
        event.setMaxPlayers(plugin.getServer().getMaxPlayers());
    }
}
