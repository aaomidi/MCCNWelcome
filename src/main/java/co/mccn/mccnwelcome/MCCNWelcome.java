package co.mccn.mccnwelcome;

import co.mccn.mccnwelcome.managers.Events;
import me.confuser.barapi.BarAPI;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class MCCNWelcome extends JavaPlugin {
    public BarAPI barAPI;

    @Override
    public final void onLoad() {
        if (!new File(this.getDataFolder(), "config.yml").exists()) {
            this.saveDefaultConfig();

        }
    }

    @Override
    public final void onEnable() {
        getServer().getPluginManager().registerEvents(new Events(this), this);
        Plugin plugin = getServer().getPluginManager().getPlugin("BarAPI");
        if (plugin == null) {
            getLogger().log(Level.SEVERE, "BarAPI not found, Disabling...");
            getServer().getPluginManager().disablePlugin(this);
        } else {
            barAPI = (BarAPI) plugin;
        }
    }

    @Override
    public final void onDisable() {


    }
}