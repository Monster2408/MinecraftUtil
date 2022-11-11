package xyz.mlserver.mls.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class ChangeSponsorColor extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    private final UUID uuid;
    private final ChatColor color;

    public ChangeSponsorColor(UUID uuid, ChatColor color) {
        this.uuid  = uuid;
        this.color = color;
    }

    public UUID getUuid() {
        return uuid;
    }

    public ChatColor getColor() {
        return color;
    }

}
