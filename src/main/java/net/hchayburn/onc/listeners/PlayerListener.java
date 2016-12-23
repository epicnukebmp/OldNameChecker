package net.hchayburn.onc.listeners;

import net.hchayburn.onc.ONC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    private ONC onc;

    public PlayerListener(ONC onc) {
        this.onc = onc;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String UUID = event.getPlayer().getUniqueId().toString();

        if (!event.getPlayer().hasPermission("oldnamechecker.bypass")) {
            onc.fetchNameHistory(UUID);
            // TODO: Something here. Likely will broadcast a message to all staff alerting that the user has previous name history.
        }
    }
}
