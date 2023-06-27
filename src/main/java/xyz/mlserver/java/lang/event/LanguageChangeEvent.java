package xyz.mlserver.java.lang.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import xyz.mlserver.java.lang.Language;

import java.util.UUID;

/**
 * Language Change Event
 * @since 1.0.7
 */
public class LanguageChangeEvent extends Event {

    /**
     * HandlerList
     */
    private static final HandlerList handlers = new HandlerList();

    /**
     * Player's UUID(String)
     */
    private final String uuid;

    /**
     * Language
     */
    private final Language beforeLanguage;

    private final Language afterLanguage;

    /**
     * Constructor
     * @param uuid Player's UUID(String)
     * @param beforeLanguage Before Language
     * @param afterLanguage After Language
     */
    public LanguageChangeEvent(String uuid, Language beforeLanguage, Language afterLanguage) {
        this.uuid = uuid;
        this.beforeLanguage = beforeLanguage;
        this.afterLanguage = afterLanguage;
    }

    /**
     * Constructor
     * @param player Player
     * @param beforeLanguage Before Language
     * @param afterLanguage After Language
     */
    public LanguageChangeEvent(Player player, Language beforeLanguage, Language afterLanguage) {
        this(player.getUniqueId().toString(), beforeLanguage, afterLanguage);
    }

    /**
     * Constructor
     * @param uuid Player's UUID(UUID)
     * @param beforeLanguage Before Language
     * @param afterLanguage After Language
     */
    public LanguageChangeEvent(UUID uuid, Language beforeLanguage, Language afterLanguage) {
        this(uuid.toString(), beforeLanguage, afterLanguage);
    }

    /**
     * Get Player's UUID(String)
     * @return Player's UUID(String)
     */
    public String getUniqueId() {
        return uuid;
    }

    /**
     * Get Player's Language Before Change
     * @return Player's Language Before Change
     */
    public Language getBeforeLanguage() {
        return beforeLanguage;
    }

    /**
     * Get Player's Language After Change
     * @return Player's Language After Change
     */
    public Language getAfterLanguage() {
        return afterLanguage;
    }

    /**
     * Get HandlerList
     * @return HandlerList
     */
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Get HandlerList
     * @return HandlerList
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
