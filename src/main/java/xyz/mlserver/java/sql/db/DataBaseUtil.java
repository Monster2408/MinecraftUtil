package xyz.mlserver.java.sql.db;

import org.bukkit.plugin.Plugin;
import xyz.mlserver.java.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

public class DataBaseUtil {
    private final Plugin plugin;

    public DataBaseUtil(Plugin plugin) {
        this.plugin = plugin;
    }

    public void debugException(Exception exc) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exc.printStackTrace(pw);
        Log.toFile(sw.toString(), getPlugin());
        Log.debug(sw.toString());
    }

    /**
     * Debug.
     *
     * @param ex the ex
     */
    public void debugSqlException(SQLException ex) {
        Log.debug("§7An error has occurred with the database, the error code is: '" + ex.getErrorCode() + "'");
        Log.debug("§7The state of the sql is: " + ex.getSQLState());
        Log.debug("§7Error message: " + ex.getMessage());
        debugException(ex);
    }

    public Plugin getPlugin() {
        return plugin;
    }
}