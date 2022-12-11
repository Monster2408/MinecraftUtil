package xyz.mlserver.mc.util.customhead;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import xyz.mlserver.mc.util.itemstack.CustomItem;

import java.lang.reflect.Field;
import java.util.UUID;

/**
 * <p>
 *     CustomHeadAPI of <a href="https://minecraft-heads.com/" target="_blank">Minecraft Heads</a>
 * </p>
 */
public class CustomHeadAPI {

    private static final String prefix = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";

    public static ItemStack getQuestionItem() {
        String id = getPrefix() + "MjcwNWZkOTRhMGM0MzE5MjdmYjRlNjM5YjBmY2ZiNDk3MTdlNDEyMjg1YTAyYjQzOWUwMTEyZGEyMmIyZTJlYyJ9fX0=";
        return new CustomItem(CustomHeadAPI.createSkull(id)).setDisplayName("???").build();
    }

    public static ItemStack getLeftItem() {
        String id = getPrefix() + "Nzc4ZWY4ZDEzYWU1M2FhNDMxNDNhMWZlNzU5YjVjNjIwNDEwNDZiMTc0NmI1MGZhNDUyZGYwZDUzNGM2YTNkIn19fQ==";
        return new CustomItem(CustomHeadAPI.createSkull(id)).setDisplayName("次").build();
    }

    public static ItemStack getRightItem() {
        String id = getPrefix() + "MmI0ZTM0ZDA0ZDNhNTY1ZjYxNjY4YzcwOTMwN2MzNTE5YTRmNzA2YTY5ZjBkZTIwZDJmMDNiZGJjMTdlOTIwNSJ9fX0=";
        return new CustomItem(CustomHeadAPI.createSkull(id)).setDisplayName("前").build();
    }

    public static ItemStack getTrophyItem() {
        String id = getPrefix() + "ZTM0YTU5MmE3OTM5N2E4ZGYzOTk3YzQzMDkxNjk0ZmMyZmI3NmM4ODNhNzZjY2U4OWYwMjI3ZTVjOWYxZGZlIn19fQ==";
        return CustomHeadAPI.createSkull(id);
    }

    /**
     *
     * @param url
     * @return
     */
    public static ItemStack createSkull(String url) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        if (url.isEmpty()) return head;
        if (!url.startsWith(getPrefix())) url = getPrefix() + url;

        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        profile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (IllegalArgumentException|NoSuchFieldException|SecurityException | IllegalAccessException error) {
            error.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

    public static String getPrefix() {
        return prefix;
    }
}