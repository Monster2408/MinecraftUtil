package xyz.mlserver.java.sql.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import xyz.mlserver.java.sql.mysql.MySQL;
import xyz.mlserver.java.sql.sqlite.SQLite;

import java.io.File;
import java.io.IOException;

public class AdvanceDataBase {

    private final HikariConfig config = new HikariConfig();

    public AdvanceDataBase(MySQL mysql, SQLite sqLite) throws ClassNotFoundException {
        if (mysql == null) {
            String path = sqLite.getPath();
            final File dataFolder = new File(path);
            if (!dataFolder.exists()) dataFolder.mkdirs();

            final File databaseFile = new File(dataFolder, sqLite.getFileName());
            if (!databaseFile.exists()) {
                try { databaseFile.createNewFile(); }
                catch (IOException e) { e.printStackTrace(); }
            }

            String driverClassName = "org.sqlite.JDBC";
            Class.forName(driverClassName);
            config.setDriverClassName(driverClassName);
            config.setJdbcUrl("jdbc:sqlite:" + path + sqLite.getFileName());
        } else {
            String sql_url = "jdbc:mysql://" + mysql.getHost() + ":" + mysql.getPort() + "/" + mysql.getDatabase() + "?" + mysql.getProperties();
            if (mysql.getPort() == -1) sql_url = "jdbc:mysql://" + mysql.getHost() + "/" + mysql.getDatabase() + "?" + mysql.getProperties();
            Class.forName("com.mysql.jdbc.Driver");
            config.setJdbcUrl(sql_url);
            config.setUsername(mysql.getUsername());
            config.setPassword(mysql.getPassword());
            config.setConnectionTimeout(250);
        }
    }

    public HikariDataSource generateDataSource() {
        return new HikariDataSource(config);
    }
}
