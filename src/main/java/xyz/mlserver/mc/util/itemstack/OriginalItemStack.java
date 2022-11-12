package xyz.mlserver.mc.util.itemstack;

import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.comphenix.protocol.wrappers.WrappedSignedProperty;
import com.cryptomorin.xseries.XMaterial;
import dev.dbassett.skullcreator.SkullCreator;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class OriginalItemStack {

    public static ItemStack createItem(Material material, int size, String name, List<String> lore) {
        ItemStack item = new ItemStack(material, size);
        ItemMeta meta = item.getItemMeta();
        if (name != null) meta.setDisplayName(name);
        if (lore != null) meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createItem(Material material, int size, String name) {
        ItemStack item = new ItemStack(material, size);
        ItemMeta meta = item.getItemMeta();
        if (name != null) meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createItem(Material material, int size, String name, short dyeColor) {
        ItemStack item = new ItemStack(material, size, dyeColor);
        ItemMeta meta = item.getItemMeta();
        if (name != null) meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createSkull(int size, String name, String value, String signature) {
        ItemStack head = new ItemStack(Objects.requireNonNull(XMaterial.PLAYER_HEAD.parseMaterial()), size, (short) 3);
        if (value.isEmpty() || signature.isEmpty())
            return head;

        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        headMeta.setDisplayName(name);

        WrappedGameProfile profile = new WrappedGameProfile(UUID.randomUUID(), name);
        profile.getProperties().put("textures", new WrappedSignedProperty("textures", value, signature));

        try {
            Field profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);

        } catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException error) {
            error.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

    public static ItemStack createSkull(int size, String name, String url) {
        ItemStack item = SkullCreator.createSkull();
        if (url.isEmpty()) return item;
        item = SkullCreator.itemFromUrl(url);
        ItemMeta meta = item.getItemMeta();
        if (!name.isEmpty()) meta.setDisplayName(name);
        item.setItemMeta(meta);
        item.setAmount(size);
        return item;
    }

    public static ItemStack addBookEnchantment(ItemStack item, Enchantment enchantment, int level){
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
        meta.addStoredEnchant(enchantment, level, true);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack addBookEnchantment(ItemStack item, List<Enchantment> enchantments, int level){
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();
        for (Enchantment enchantment : enchantments) meta.addStoredEnchant(enchantment, level, true);
        item.setItemMeta(meta);
        return item;
    }

}
