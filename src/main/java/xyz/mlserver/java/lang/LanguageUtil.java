package xyz.mlserver.java.lang;

import com.cryptomorin.xseries.XMaterial;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import dev.dbassett.skullcreator.SkullCreator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.mlserver.mc.util.itemstack.OriginalItemStack;
import xyz.mlserver.mc.util.skull.SkullVar;

public class LanguageUtil {
    private static Table<String, Language, String> languageTable;

    private final String key;

    private static final LanguageUtil LANGUAGE_PREFIX = LanguageUtil.register("LANGUAGE_PREFIX").jp("[言語] ").eng("[LANGUAGES] ");

    public static LanguageUtil getPrefix() {
        return LANGUAGE_PREFIX;
    }


    public LanguageUtil(String key) {
        if (languageTable == null) languageTable = HashBasedTable.create();
        this.key = key;
    }

    public static LanguageUtil register(String key) {
        return new LanguageUtil(key);
    }

    public LanguageUtil eng(String eng) {
        languageTable.put(key, Language.ENGLISH, eng);
        return this;
    }

    public LanguageUtil jp(String jp) {
        languageTable.put(key, Language.JAPANESE, jp);
        return this;
    }

    public String get(Language lang) { return languageTable.get(key, lang); }

    public String replace(String replaceOld, String replaceNew, Language language) {
        String text = languageTable.get(key, language);
        if (text == null) return null;
        text = text.replace(replaceOld, replaceNew);
        return text;
    }

    public static void open(Player player) {
        Inventory gui = Bukkit.createInventory(null , 9, "Options...");

        ItemStack noClick, japaneseIcon,englishIcon;
        ItemMeta meta;

        noClick = OriginalItemStack.createItem(XMaterial.GREEN_STAINED_GLASS_PANE.parseMaterial(), 1, " ");
        japaneseIcon = SkullCreator.itemFromUrl(SkullVar.JAPAN_URL);
        meta = japaneseIcon.getItemMeta();
        meta.setDisplayName(Language.JAPANESE.getName());
        japaneseIcon.setItemMeta(meta);

        englishIcon = SkullCreator.itemFromUrl(SkullVar.US_URL);
        meta = englishIcon.getItemMeta();
        meta.setDisplayName(Language.ENGLISH.getName());
        englishIcon.setItemMeta(meta);

        for (int i = 0; i < 9; i++) {
            gui.setItem(i, noClick);
            if (i == 3) gui.setItem(i, japaneseIcon);
            if (i == 5) gui.setItem(i, englishIcon);
        }

        player.openInventory(gui);
    }

}

