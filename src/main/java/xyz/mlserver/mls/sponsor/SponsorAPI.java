package xyz.mlserver.mls.sponsor;

import org.bukkit.entity.Player;

public class SponsorAPI {

    /**
     * 支援者プランTier1のプレイヤーが与えられるパーミッションの文字列を取得
     * @return 支援者プランTier1パーミッション文字列
     */
    public static String getTierOnePermission() { return "sponsor.tier1"; }

    /**
     * 支援者プランTier2のプレイヤーが与えられるパーミッションの文字列を取得
     * @return 支援者プランTier2パーミッション文字列
     */
    public static String getTierTwoPermission() { return "sponsor.tier2"; }

    /**
     * 支援者プランTier3のプレイヤーが与えられるパーミッションの文字列を取得
     * @return 支援者プランTier3パーミッション文字列
     */
    public static String getTierThreePermission() { return "sponsor.tier3"; }

    /**
     * 指定したプレイヤーが支援者かどうかを取得
     * @param player プレイヤーを指定する
     * @return 指定したプレイヤーが支援者かどうか
     */
    public static boolean isSponsor(Player player) {
        return (isTierOne(player) || isTierTwo(player) || isTierThree(player));
    }

    /**
     * 指定したプレイヤーが支援者プランTier1に加入しているかどうかを取得
     * @param player プレイヤーを指定
     * @return 指定したプレイヤーが支援者プランTier1に加入しているかどうか
     */
    public static boolean isTierOne(Player player) { return player.hasPermission(getTierOnePermission()); }

    /**
     * 指定したプレイヤーが支援者プランTier2に加入しているかどうかを取得
     * @param player プレイヤーを指定
     * @return 指定したプレイヤーが支援者プランTier2に加入しているかどうか
     */
    public static boolean isTierTwo(Player player) { return player.hasPermission(getTierTwoPermission()); }

    /**
     * 指定したプレイヤーが支援者プランTier3に加入しているかどうかを取得
     * @param player プレイヤーを指定
     * @return 指定したプレイヤーが支援者プランTier3に加入しているかどうか
     */
    public static boolean isTierThree(Player player) { return player.hasPermission(getTierThreePermission()); }

}
