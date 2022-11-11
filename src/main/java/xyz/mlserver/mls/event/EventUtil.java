package xyz.mlserver.mls.event;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import xyz.mlserver.java.sql.DataBase;
import xyz.mlserver.mls.MLSEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class EventUtil {

    private static Table<MLSEvent, String, Integer> winDataTable;
    private static Table<MLSEvent, String, Integer> gameDataTable;
    private static Table<MLSEvent, String, Date> winDataTableLastUpdate;
    private static Table<MLSEvent, String, Date> gameDataTableLastUpdate;

    public static int getWin(DataBase dataBase, MLSEvent event, String uuid) {
        if (winDataTableLastUpdate == null) winDataTableLastUpdate = HashBasedTable.create();
        if (winDataTable == null) winDataTable = HashBasedTable.create();
        if (winDataTableLastUpdate.get(event, uuid) != null && winDataTable.get(event, uuid) != null) {
            Date lastUpdate = winDataTableLastUpdate.get(event, uuid);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.MINUTE, -1);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(lastUpdate);
            if(calendar1.after(calendar)){ // 前回のロードが現在から5分前よりも未来なら
                return winDataTable.get(event, uuid);
            }
        }

        Date now = new Date();

        String sql = "select * from " + event.getDatabase() + " where uuid=?";
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.setString(1, uuid);
            ResultSet result = prestat.executeQuery();
            if (result.next()) {
                int num = result.getInt(3);
                winDataTable.put(event, uuid, num);
                winDataTableLastUpdate.put(event, uuid, now);
                return num;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        winDataTableLastUpdate.put(event, uuid, now);
        winDataTable.put(event, uuid, 0);
        return 0;
    }

    public static int getWin(DataBase dataBase, MLSEvent event, UUID uuid) {
        return getWin(dataBase, event, uuid.toString());
    }

    public static int getGame(DataBase dataBase, MLSEvent event, String uuid) {
        if (gameDataTableLastUpdate == null) gameDataTableLastUpdate = HashBasedTable.create();
        if (gameDataTable == null) gameDataTable = HashBasedTable.create();
        if (gameDataTableLastUpdate.get(event, uuid) != null && gameDataTable.get(event, uuid) != null) {
            Date lastUpdate = gameDataTableLastUpdate.get(event, uuid);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.MINUTE, -1);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(lastUpdate);
            if(calendar1.after(calendar)){ // 前回のロードが現在から5分前よりも未来なら
                return gameDataTable.get(event, uuid);
            }
        }

        Date now = new Date();

        String sql = "select * from " + event.getDatabase() + " where uuid=?";
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            prestat.setString(1, uuid);
            ResultSet result = prestat.executeQuery();
            if (result.next()) {
                int num = result.getInt(2);
                gameDataTable.put(event, uuid, num);
                gameDataTableLastUpdate.put(event, uuid, now);
                return num;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        gameDataTableLastUpdate.put(event, uuid, now);
        gameDataTable.put(event, uuid, 0);
        return 0;
    }

    public static int getGame(DataBase dataBase, MLSEvent event, UUID uuid) {
        return getGame(dataBase, event, uuid.toString());
    }

    public static List<String> getRanking(DataBase dataBase, MLSEvent event) {
        String table_name = event.getDatabase();
        List<String> list = new ArrayList<>();
        int i = 0;
        String sql = "SELECT * FROM " + table_name + " order by win desc;";
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            ResultSet result = prestat.executeQuery();
            while(result.next()) {
                if (i >= 9) break;
                list.add(result.getString(1));
                i++;
            }
        } catch (Exception ignored) { }
        return list;
    }

    public static HashMap<Integer, String> getRankingWithRanking(DataBase dataBase, MLSEvent event) {
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

    public static HashMap<String, Integer> getRankingData(DataBase dataBase, MLSEvent event) {
        String table_name = event.getDatabase();
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        String sql = "SELECT * FROM " + table_name + " order by win desc;";
        try(Connection con = dataBase.getDataSource().getConnection();
            PreparedStatement prestat = con.prepareStatement(sql)) {
            ResultSet result = prestat.executeQuery();
            while(result.next()) {
                if (i >= 20) break;
                map.put(result.getString(1), result.getInt(3));
                i++;
            }
        } catch (Exception ignored) { }
        return map;
    }

}
