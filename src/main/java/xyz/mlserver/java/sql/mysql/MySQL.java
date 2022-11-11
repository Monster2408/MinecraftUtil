package xyz.mlserver.java.sql.mysql;

import org.bukkit.plugin.Plugin;

public class MySQL {

    private final String host, database, username, password, properties;
    private final int port;

    private static final String temp_properties = "useSSL=false&useLegacyDatetimeCode=false&autoReconnect=true&serverTimezone=JST";

    public MySQL(String host, int port, String database, String username, String password, String properties) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
        this.properties = properties;
    }

    public MySQL(String host, String database, String username, String password, String properties) {
        this(host, -1, database, username, password, properties);
    }

    public MySQL(String host, int port, String database, String username, String password) {
        this(host, port, database, username, password, temp_properties);
    }

    public MySQL(String host, String database, String username, String password) {
        this(host, -1, database, username, password, temp_properties);
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getProperties() {
        return properties;
    }

    public static String getHostFromHFL(Plugin plugin) {
        return plugin.getConfig().getString("mysql.host");
    }

    public static int getPortFromHFL(Plugin plugin) {
        return plugin.getConfig().getInt("mysql.port");
    }

    public static String getDataBaseFromHFL(Plugin plugin) {
        return plugin.getConfig().getString("mysql.database");
    }

    public static String getUsernameFromHFL(Plugin plugin) {
        return plugin.getConfig().getString("mysql.username");
    }

    public static String getPasswordFromHFL(Plugin plugin) {
        return plugin.getConfig().getString("mysql.password");
    }

}
