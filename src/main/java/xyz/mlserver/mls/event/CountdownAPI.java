package xyz.mlserver.mls.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * カウントダウン時の共通関数を集めたClass
 */
public class CountdownAPI {

    /**
     * カウントダウン(3s)の関数
     */
    public static void displayCountdown3() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendTitle(ChatColor.DARK_GREEN + "❸", ChatColor.GRAY + "開始まで・・・", 10, 10, 10);
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
        }
    }

    /**
     * カウントダウン(2s)の関数
     */
    public static void displayCountdown2() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendTitle(ChatColor.GOLD + "❷", ChatColor.GRAY + "開始まで・・・", 10, 10, 10);
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
        }
    }

    /**
     * カウントダウン(1s)の関数
     */
    public static void displayCountdown1() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendTitle(ChatColor.DARK_RED + "❶", ChatColor.GRAY + "開始まで・・・", 10, 10, 10);
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
        }
    }

}
