package xyz.mlserver.mls.event;

import org.bukkit.entity.Player;
import xyz.mlserver.java.sql.DataBase;
import xyz.mlserver.mls.MLSEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class EventSQL {

    private final DataBase dataBase;
    private final String table_name;

    /**
     * イベントクラス({@link MLSEvent})に登録されていない場合などに利用
     * @param table_name イベントのテーブル名を指定
     * @param dataBase データベース{@link DataBase}を指定
     * @deprecated 全てが綺麗に動作するかがわからないため非推奨
     */
    public EventSQL(String table_name, DataBase dataBase) {
        this.table_name = table_name;
        this.dataBase = dataBase;
    }

    /**
     * イベントクラス({@link MLSEvent})から利用
     * @param event イベントを指定
     * @param dataBase データベース{@link DataBase}を指定
     */
    public EventSQL(MLSEvent event, DataBase dataBase) { this(event.getDatabase(), dataBase); }

    /**
     * 企画の勝利数をUUID({@link String})より取得
     * @param uuid UUID({@link String})を指定
     * @return 企画の勝利数を取得
     */
    public int getWin(String uuid) {
        if (table_name == null) return -1;

        createTable();
        int num;
        String sql = "select * from " + table_name + " where uuid=?";
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.setString(1, uuid);
            ResultSet result = prestat.executeQuery();
            if (result.next()) {
                num = result.getInt(3);
            } else {
                num = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            num = 0;
        }
        return num;
    }

    /**
     * 企画の勝利数をUUID({@link UUID})より取得
     * @param uuid UUID({@link UUID})を指定
     * @return 企画の勝利数を取得
     */
    public int getWin(UUID uuid) {
        return getWin(uuid.toString());
    }
    /**
     * 企画の勝利数をplayer({@link Player})より取得
     * @param player player({@link Player})を指定
     * @return 企画の勝利数を取得
     */
    public int getWin(Player player) {
        return getWin(player.getUniqueId());
    }

    /**
     * 指定した企画の勝利数をUUID({@link String})より取得
     * @param event 企画({@link MLSEvent})を指定
     * @param uuid UUID({@link String})を指定
     * @return 企画の勝利数を取得
     */
    public int getWin(MLSEvent event, String uuid) {
        createTable(event);

        int num;
        String sql = "select * from " + event.getDatabase() + " where uuid=?";
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.setString(1, uuid);
            ResultSet result = prestat.executeQuery();
            if (result.next()) {
                num = result.getInt(3);
            } else {
                num = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            num = 0;
        }
        return num;
    }

    /**
     * 指定した企画の勝利数をUUID({@link UUID})より取得
     * @param event 企画({@link MLSEvent})を指定
     * @param uuid UUID({@link UUID})を指定
     * @return 企画の勝利数を取得
     */
    public int getWin(MLSEvent event, UUID uuid) {
        return getWin(event, uuid.toString());
    }

    /**
     * 指定した企画の勝利数をplayer({@link Player})より取得
     * @param event 企画({@link MLSEvent})を指定
     * @param player プレイヤー({@link Player})を指定
     * @return 企画の勝利数を取得
     */
    public int getWin(MLSEvent event, Player player) {
        return getWin(event, player.getUniqueId());
    }

    /**
     * UUID({@link String})を元に企画の勝利数を指定数増やす
     * @param uuid　UUID({@link String})を指定
     * @param i 増やす勝利数を指定
     */
    public void addWin(String uuid, int i) {
        if (table_name == null) return ;

        int game = getGame(uuid);
        int win = getWin(uuid) + i;

        String sql = "insert into " + table_name + " (uuid, game, win) "
                + "VALUES (?, ?, ?) "
                +"ON DUPLICATE KEY UPDATE "
                +"uuid=?, "
                +"game=?, "
                +"win=?;";
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.setString(1, uuid);
            prestat.setInt(2, game);
            prestat.setInt(3, win);
            prestat.setString(4, uuid);
            prestat.setInt(5, game);
            prestat.setInt(6, win);
            prestat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * UUID({@link UUID})を元に企画の勝利数を指定数増やす
     * @param uuid UUID({@link UUID})を指定
     * @param i 増やす勝利数を指定
     */
    public void addWin(UUID uuid, int i) { addWin(uuid.toString(), i); }

    /**
     * プレイヤー({@link Player})を元に企画の勝利数を指定数増やす
     * @param player プレイヤー({@link Player})を指定
     * @param i 増やす勝利数を指定
     */
    public void addWin(Player player, int i) { addWin(player.getUniqueId(), i); }

    /**
     * UUID({@link String})を元に企画の勝利数を1増やす
     * @param uuid UUID({@link String})を指定
     */
    public void addWin(String uuid) { addWin(uuid, 1); }

    /**
     * UUID({@link UUID})を元に企画の勝利数を1増やす
     * @param uuid UUID({@link UUID})を指定
     */
    public void addWin(UUID uuid) { addWin(uuid.toString()); }

    /**
     * プレイヤー({@link Player})を元に企画の勝利数を1増やす
     * @param player プレイヤー({@link Player})を指定
     */
    public void addWin(Player player) { addWin(player.getUniqueId()); }

    /**
     * 企画の参加数をUUID({@link String})より取得
     * @param uuid UUID({@link String})を指定
     * @return 企画の参加数を取得
     */
    public int getGame(String uuid) {
        if (table_name == null) return -1;
        createTable();

        int num;
        String sql = "select * from " + table_name + " where uuid=?";
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.setString(1, uuid);
            ResultSet result = prestat.executeQuery();
            if (result.next()) {
                num = result.getInt(2);
            } else {
                num = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            num = 0;
        }
        return num;
    }

    /**
     * 企画の参加数をUUID({@link UUID})より取得
     * @param uuid UUID({@link UUID})を指定
     * @return 企画の参加数を取得
     */
    public int getGame(UUID uuid) {
        return getGame(uuid.toString());
    }
    /**
     * 企画の参加数をplayer({@link Player})より取得
     * @param player player({@link Player})を指定
     * @return 企画の参加数を取得
     */
    public int getGame(Player player) {
        return getGame(player.getUniqueId());
    }

    /**
     * 指定した企画の参加数をUUID({@link String})より取得
     * @param event 企画({@link MLSEvent})を指定
     * @param uuid UUID({@link String})を指定
     * @return 企画の参加数を取得
     */
    public int getGame(MLSEvent event, String uuid) {
        createTable(event);

        int num;
        String sql = "select * from " + event.getDatabase() + " where uuid=?";
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.setString(1, uuid);
            ResultSet result = prestat.executeQuery();
            if (result.next()) {
                num = result.getInt(3);
            } else {
                num = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            num = 0;
        }
        return num;
    }

    /**
     * 指定した企画の参加数をUUID({@link UUID})より取得
     * @param event 企画({@link MLSEvent})を指定
     * @param uuid UUID({@link UUID})を指定
     * @return 企画の参加数を取得
     */
    public int getGame(MLSEvent event, UUID uuid) {
        return getGame(event, uuid.toString());
    }
    /**
     * 指定した企画の参加数をplayer({@link Player})より取得
     * @param event 企画({@link MLSEvent})を指定
     * @param player プレイヤー({@link Player})を指定
     * @return 企画の参加数を取得
     */
    public int getGame(MLSEvent event, Player player) {
        return getGame(event, player.getUniqueId());
    }

    /**
     * UUID({@link String})を元に企画の参加数を指定数増やす
     * @param uuid UUID({@link String})を指定
     * @param i 増やす勝利数を指定
     */
    public void addGame(String uuid, int i) {
        if (table_name == null) return ;

        int game = getGame(uuid) + i;
        int win = getWin(uuid);

        String sql = "insert into " + table_name + " (uuid, game, win) "
                + "VALUES (?, ?, ?) "
                +"ON DUPLICATE KEY UPDATE "
                +"uuid=?, "
                +"game=?, "
                +"win=?;";
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.setString(1, uuid);
            prestat.setInt(2, game);
            prestat.setInt(3, win);
            prestat.setString(4, uuid);
            prestat.setInt(5, game);
            prestat.setInt(6, win);
            prestat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * UUID({@link UUID})を元に企画の参加数を指定数増やす
     * @param uuid UUID({@link UUID})を指定
     * @param i 増やす勝利数を指定
     */
    public void addGame(UUID uuid, int i) { addGame(uuid.toString(), i); }

    /**
     * プレイヤー({@link Player})を元に企画の参加数を指定数増やす
     * @param player プレイヤー({@link Player})を指定
     * @param i 増やす勝利数を指定
     */
    public void addGame(Player player, int i) { addGame(player.getUniqueId(), i); }

    /**
     * UUID({@link String})を元に企画の参加数を1増やす
     * @param uuid UUID({@link String})を指定
     */
    public void addGame(String uuid) { addGame(uuid, 1); }

    /**
     * UUID({@link UUID})を元に企画の参加数を1増やす
     * @param uuid UUID({@link UUID})を指定
     */
    public void addGame(UUID uuid) { addGame(uuid.toString()); }

    /**
     * プレイヤー({@link Player})を元に企画の参加数を1増やす
     * @param player プレイヤー({@link Player})を指定
     */
    public void addGame(Player player) { addGame(player.getUniqueId()); }

    /**
     * 指定した企画の現在のランキングを取得する
     * @param event 企画({@link MLSEvent})を指定
     * @return ランキングリスト({@link Player})を順位, UUID({@link String})の形式で取得
     */
    public HashMap<Integer, String> getRanking(MLSEvent event) {
        createTable(event);

        String table_name = event.getDatabase();
        HashMap<Integer, String> map = new HashMap<>();
        int i = 1;
        String sql = "SELECT * FROM " + table_name + " order by win desc;";
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            ResultSet result = prestat.executeQuery();
            while(result.next()) {
                if (i >= 10) break;
                map.put(i, result.getString(1));
                i++;
            }
        } catch (Exception ignored) { }
        return map;
    }

    private void createTable() {
        String sql = "create table if not exists " + table_name + " (" +
                "uuid varchar(36) NOT NULL PRIMARY KEY," +
                "game int(10) default '0' not null," +
                "win int(10) default '0' not null" +
                ");"
                ;
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable(MLSEvent event) {
        String sql = "create table if not exists " + event.getDatabase() + " (" +
                "uuid varchar(36) NOT NULL PRIMARY KEY," +
                "game int(10) default '0' not null," +
                "win int(10) default '0' not null" +
                ");"
                ;
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
