package xyz.mlserver.java.lang;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.mlserver.java.lang.event.LanguageChangeEvent;
import xyz.mlserver.java.sql.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class LanguageSQL {

    private final DataBase dataBase;

    /**
     * 言語システムのホニャララ
     * @param dataBase 言語データを格納するデータベース
     */
    public LanguageSQL(DataBase dataBase) {
        this.dataBase = dataBase;
        createTable();
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    /**
     * Playerを元に設定言語を取得する
     * @param player 取得元の{@link Player}
     * @return {@link Language}
     */
    public Language getLanguage(Player player) { return getLanguage(player.getUniqueId()); }

    public Language getLanguage(UUID uuid) { return getLanguage(uuid.toString()); }

    public Language getLanguage(String uuid) {
        if (getDataBase() == null) return Language.ENGLISH;
        String sql = "SELECT * FROM languages where uuid=?;";
        Language language;
        try(Connection con = getDataBase().getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.setString(1, uuid);
            ResultSet result = prestat.executeQuery();
            if (result.next()) language = Language.fromId(result.getString(2));
            else {
                setLanguage(uuid, Language.ENGLISH);
                language = Language.ENGLISH;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            language = Language.ENGLISH;
        }
        return language;
    }

    public void setLanguage(Player player, Language language) { this.setLanguage(player.getUniqueId(), language); }

    public void setLanguage(UUID uuid, Language language) { this.setLanguage(uuid.toString(), language); }

    public void setLanguage(String uuid, Language language) {
        if (getDataBase() == null) return;
        Language beforeLanguage = getLanguage(uuid);
        String sql = "insert into languages (uuid, lang) "
                + "VALUES (?, ?) "
                +"ON DUPLICATE KEY UPDATE "
                +"uuid=?, "
                +"lang=?;";
        try(Connection con = getDataBase().getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.setString(1, uuid);
            prestat.setString(2, language.getId());
            prestat.setString(3, uuid);
            prestat.setString(4, language.getId());
            prestat.executeUpdate();
            Bukkit.getPluginManager().callEvent(new LanguageChangeEvent(uuid, beforeLanguage, language));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable() {
        if (getDataBase() == null) return;
        String sql = "create table if not exists languages (" +
                "uuid varchar(36) NOT NULL PRIMARY KEY," +
                "lang varchar(100) default '" + Language.JAPANESE.getId() + "' not null" +
                ");"
                ;
        try(Connection con = getDataBase().getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
