package xyz.mlserver.mc.util.itemstack;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;

public class CustomItem {

    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public CustomItem(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
    }

    public CustomItem(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = itemStack.getItemMeta();
    }

    public CustomItem(Material material, int id) {
        this.itemStack = new ItemStack(material, 1, (short) id);
        this.itemMeta = itemStack.getItemMeta();
    }

    public CustomItem(Material material, DyeColor dyeColor) { this(material, dyeColor.getWoolData()); }

    public CustomItem setDisplayName(String displayName) {
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
        return this;
    }

    public CustomItem setAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public CustomItem setDurability(short durability) {
        this.itemStack.setDurability(durability);
        return this;
    }

    public CustomItem addEnchantment(Enchantment enchantment, int level) {
        this.itemMeta.addEnchant(enchantment, level, false);
        return this;
    }

    public CustomItem addEnchantments(HashMap<Enchantment, Integer> hash) {
        for (Enchantment enchantment : hash.keySet()) {
            this.itemMeta.addEnchant(enchantment, hash.get(enchantment), false);
        }
        return this;
    }

    public CustomItem clearEnchantments() {
        for (Enchantment enchantment : this.itemMeta.getEnchants().keySet()) {
            this.itemMeta.removeEnchant(enchantment);
        }
        return this;
    }

    public CustomItem removeEnchantment(Enchantment enchantment) {
        if (this.itemMeta.getEnchants().containsKey(enchantment)) this.itemMeta.removeEnchant(enchantment);
        return this;
    }

    public CustomItem setLore(String... lines) {
        this.itemMeta.setLore(Arrays.asList(lines));
        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
