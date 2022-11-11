package xyz.mlserver.mls.sponsor;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xyz.mlserver.java.sql.DataBase;
import xyz.mlserver.mc.util.Color;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SponsorColor {

    private final DataBase dataBase;

    public SponsorColor(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    /**
     * プレイヤーの登録色を登録する
     * @param uuid 指定したプレイヤーのUUID({@link String})
     * @param color 登録する{@link ChatColor}
     */
    public void set(String uuid, ChatColor color) {
        createTable();

        String sql = "insert into sponsor_color (uuid, color) "
                + "VALUES (?, ?) "
                + "ON DUPLICATE KEY UPDATE "
                + "uuid=?, "
                + "color=?;";
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.setString(1, uuid);
            prestat.setString(2, color.toString());
            prestat.setString(3, uuid);
            prestat.setString(4, color.toString());
            prestat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * プレイヤーの登録色を登録する
     * @param uuid 指定したプレイヤーのUUID({@link UUID})
     * @param color 登録する{@link ChatColor}
     */
    public void set(UUID uuid, ChatColor color) { set(uuid.toString(), color);}    /**
     * プレイヤーの登録色を登録する
     * @param player 指定したプレイヤー({@link Player})
     * @param color 登録する{@link ChatColor}
     */

    public void set(Player player, ChatColor color) { set(player.getUniqueId().toString(), color);}

    /**
     * プレイヤーの登録色を取得する
     * @deprecated 直観的でないため非推奨
     * @param uuid 指定したプレイヤーのUUID({@link String})
     * @param defaultColor データベースに記録がなかった場合に指定した{@link ChatColor}が返ってくる
     * @return プレイヤーの登録 {@link ChatColor}
     */
    public ChatColor load(String uuid, ChatColor defaultColor) {
        createTable();

        String sql = "select * from sponsor_color where uuid=?;";
        ChatColor color;
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.setString(1, uuid);
            ResultSet rs = prestat.executeQuery();
            try {
                if(rs.next()) {
                    rs.beforeFirst();
                    rs.next();
                    // Log.debug(rs.getString("color"));
                    color = Color.getNameToColor(rs.getString("color"));
                } else {
                    color = defaultColor;
                }
            } catch (Exception e) {
                color = defaultColor;
            }
        } catch (SQLException e) {
            color = defaultColor;
        }
        return color;
    }

    /**
     * プレイヤーの登録色を取得する
     * @deprecated 直観的でないため非推奨
     * @param uuid 指定したプレイヤーのUUID({@link UUID})
     * @param defaultColor データベースに記録がなかった場合に指定した{@link ChatColor}が返ってくる
     * @return プレイヤーの登録 {@link ChatColor}
     */
    public ChatColor load(UUID uuid, ChatColor defaultColor) { return load(uuid.toString(), defaultColor); }
    /**
     * プレイヤーの登録色を取得する
     * @deprecated 直観的でないため非推奨
     * @param uuid 指定したプレイヤーのUUID({@link String})
     * @return プレイヤーの登録 {@link ChatColor}
     */
    public ChatColor load(String uuid) { return load(uuid, null); }
    /**
     * プレイヤーの登録色を取得する
     * @deprecated 直観的でないため非推奨
     * @param uuid 指定したプレイヤーのUUID({@link UUID})
     * @return プレイヤーの登録 {@link ChatColor}
     */
    public ChatColor load(UUID uuid) { return load(uuid.toString(), null); }

    /**
     * プレイヤーの登録色を取得する
     * @param uuid 指定したプレイヤーのUUID({@link String})
     * @param defaultColor データベースに記録がなかった場合に指定した{@link ChatColor}が返ってくる
     * @return プレイヤーの登録 {@link ChatColor}
     */
    public ChatColor get(String uuid, ChatColor defaultColor) {
        createTable();

        String sql = "select * from sponsor_color where uuid=?;";
        ChatColor color;
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.setString(1, uuid);
            ResultSet rs = prestat.executeQuery();
            try {
                if(rs.next()) {
                    rs.beforeFirst();
                    rs.next();
                    color = Color.getNameToColor(rs.getString("color"));
                } else {
                    color = defaultColor;
                }
            } catch (Exception e) {
                color = defaultColor;
            }
        } catch (SQLException e) {
            color = defaultColor;
        }
        return color;
    }
    /**
     * プレイヤーの登録色を取得する
     * @param uuid 指定したプレイヤーのUUID({@link UUID})
     * @param defaultColor データベースに記録がなかった場合に指定した{@link ChatColor}が返ってくる
     * @return プレイヤーの登録 {@link ChatColor}
     */
    public ChatColor get(UUID uuid, ChatColor defaultColor) { return get(uuid.toString(), defaultColor); }
    /**
     * プレイヤーの登録色を取得する
     * @param uuid 指定したプレイヤーのUUID({@link String})
     * @return プレイヤーの登録 {@link ChatColor}
     */
    public ChatColor get(String uuid) { return get(uuid, null); }
    /**
     * プレイヤーの登録色を取得する
     * @param uuid 指定したプレイヤーのUUID({@link UUID})
     * @return プレイヤーの登録 {@link ChatColor}
     */
    public ChatColor get(UUID uuid) { return get(uuid.toString(), null); }

    private void createTable() {
        String sql = "create table if not exists sponsor_color (" +
                "uuid varchar(36) NOT NULL PRIMARY KEY," +
                "color varchar(100)" +
                ");";
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
