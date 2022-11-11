package xyz.mlserver.lib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import xyz.mlserver.java.Log;

public class HFLConfigFile {

    private final String libName = "HighFunctionalityLib";
    private boolean enabled = false;

    private String host, database, user, password;
    private int port;

    /**
     * HighFunctionalityLibのデータ読み取りクラス
     */
    public HFLConfigFile() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin(libName);
        if (plugin == null) {
            Log.error(libName + "が存在しません。");
            return;
        }
        host = plugin.getConfig().getString("mysql.host", null);
        port = plugin.getConfig().getInt("mysql.port", -1);
        database = plugin.getConfig().getString("mysql.database", null);
        user = plugin.getConfig().getString("mysql.user", null);
        password = plugin.getConfig().getString("mysql.password", null);

        if (!(host != null && database != null && user != null && password != null) || !plugin.getConfig().getBoolean("mysql.enable", false)) return;
        enabled = true;
    }

    /**
     * HighFunctionalityLibが使えるかどうか
     * @return 使える場合 TRUE
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * HighFunctionalityLibのconfig.ymlからMySQL接続に関する情報を取得する
     * @return ポート番号
     */
    public int getPort() {
        return port;
    }

    /**
     * HighFunctionalityLibのconfig.ymlからMySQL接続に関する情報を取得する
     * @return データベース名
     */
    public String getDatabase() {
        return database;
    }

    /**
     * HighFunctionalityLibのconfig.ymlからMySQL接続に関する情報を取得する
     * @return アドレス
     */
    public String getHost() {
        return host;
    }

    /**
     * HighFunctionalityLibのconfig.ymlからMySQL接続に関する情報を取得する
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * HighFunctionalityLibのconfig.ymlからMySQL接続に関する情報を取得する
     * @return ユーザー名
     */
    public String getUser() {
        return user;
    }

    /**
     * データベース接続不可時などに実行すればいい
     */
    public void disable() {
        enabled = false;
    }
}
