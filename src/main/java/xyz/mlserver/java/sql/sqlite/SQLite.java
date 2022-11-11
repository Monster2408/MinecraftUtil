package xyz.mlserver.java.sql.sqlite;

public class SQLite {

    private final String fileName, path;

    public SQLite(String fileName, String path) {
        this.fileName = fileName;
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public String getPath() {
        return path;
    }

}
