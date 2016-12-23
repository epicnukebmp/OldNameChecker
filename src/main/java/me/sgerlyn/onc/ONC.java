package me.sgerlyn.onc;

import me.sgerlyn.onc.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ONC extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        // TODO: Command that fetchs username history.
    }

    public void fetchNameHistory(final String UUID) {
        getServer().getScheduler().runTaskAsynchronously(this, new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://api.mojang.com/user/profile/" + UUID + "/names");
                    URLConnection connection = url.openConnection();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    reader.readLine();
                } catch (IOException ex) {
                    getLogger().warning("Could not fetch name history! Please contact SGerlyn if you think this is an error");
                    ex.printStackTrace();
                }
            }
        });
    }
}
