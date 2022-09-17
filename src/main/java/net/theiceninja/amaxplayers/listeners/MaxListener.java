package net.theiceninja.amaxplayers.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MaxListener implements Listener {

    @EventHandler
    public void onServerListPing(ServerListPingEvent e) {
        e.setMaxPlayers(Bukkit.getMaxPlayers());
    }
}
