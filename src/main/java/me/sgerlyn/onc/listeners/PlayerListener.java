package me.sgerlyn.onc.listeners;

import me.sgerlyn.onc.ONC;
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
