package co.mccn.mccnwelcome.managers;

import co.mccn.mccnwelcome.MCCNWelcome;
import me.confuser.barapi.BarAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {
    private final MCCNWelcome _plugin;

    public Events(MCCNWelcome plugin) {
        _plugin = plugin;
    }
      @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String configMessage=_plugin.getConfig().getString("WelcomeMessage");
        String message= ChatColor.translateAlternateColorCodes('&', configMessage);
        String finalMessage=message.replace("%p",player.getName());
        int time=_plugin.getConfig().getInt("MessageTimer");
        _plugin.barAPI.setMessage(player,finalMessage,time);
    }
}
