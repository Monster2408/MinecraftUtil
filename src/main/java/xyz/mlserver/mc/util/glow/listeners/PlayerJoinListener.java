package xyz.mlserver.mc.util.glow.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;
import xyz.mlserver.mc.util.glow.GlowAPI;

public class PlayerJoinListener implements Listener {

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    @SuppressWarnings("unused")
    public void onPlayerJoin(@NotNull PlayerJoinEvent event) {
        GlowAPI.initTeams(event.getPlayer());
    }

}