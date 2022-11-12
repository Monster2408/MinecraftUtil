package xyz.mlserver.mc.util;

import org.bukkit.ChatColor;

public class Color {

    public static String replaceColorCode(String source) {
        if (source == null)
            return null;
        return ChatColor.translateAlternateColorCodes('&', source);
    }

    public static String deleteColorCode(String source) {
        if (source == null)
            return null;
        return ChatColor.stripColor(source);
    }

    public static ChatColor getNameToColor(String color) {
        if (color.length() == 2) {
            return getCodeToColor(color);
        }
        switch (color.toLowerCase()) {
            case "black":
                return ChatColor.BLACK;
            case "dark_blue":
                return ChatColor.DARK_BLUE;
            case "dark_green":
                return ChatColor.DARK_GREEN;
            case "aqua":
                return ChatColor.AQUA;
            case "dark_red":
                return ChatColor.DARK_RED;
            case "purple":
                return ChatColor.DARK_PURPLE;
            case "gold":
                return ChatColor.GOLD;
            case "gray":
                return ChatColor.GRAY;
            case "dark_gray":
                return ChatColor.DARK_GRAY;
            case "blue":
                return ChatColor.BLUE;
            case "green":
                return ChatColor.GREEN;
            case "dark_aqua":
                return ChatColor.DARK_AQUA;
            case "red":
                return ChatColor.RED;
            case "pink":
                return ChatColor.LIGHT_PURPLE;
            case "yellow":
                return ChatColor.YELLOW;
            case "white":
                return ChatColor.WHITE;
            default:
                return null;
        }
    }

    public static ChatColor getCodeToColor(String code) {
        if (code.length() == 2) {
            if (String.valueOf(code.charAt(0)).equalsIgnoreCase("&") || String.valueOf(code.charAt(0)).equalsIgnoreCase("§")) {
                code = String.valueOf(code.charAt(1));
            } else {
                return null;
            }
        }
        switch (code.toLowerCase()) {
            case "0":
                return ChatColor.BLACK;
            case "1":
                return ChatColor.DARK_BLUE;
            case "2":
                return ChatColor.DARK_GREEN;
            case "3":
                return ChatColor.DARK_AQUA;
            case "4":
                return ChatColor.DARK_RED;
            case "5":
                return ChatColor.DARK_PURPLE;
            case "6":
                return ChatColor.GOLD;
            case "7":
                return ChatColor.GRAY;
            case "8":
                return ChatColor.DARK_GRAY;
            case "9":
                return ChatColor.BLUE;
            case "a":
                return ChatColor.GREEN;
            case "b":
                return ChatColor.AQUA;
            case "c":
                return ChatColor.RED;
            case "d":
                return ChatColor.LIGHT_PURPLE;
            case "e":
                return ChatColor.YELLOW;
            case "f":
                return ChatColor.WHITE;
            default:
                return null;
        }
    }

}
