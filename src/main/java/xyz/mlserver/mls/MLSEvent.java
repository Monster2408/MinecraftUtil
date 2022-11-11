package xyz.mlserver.mls;

public enum MLSEvent {
    AOONI6_23("aooni6_23", "aoonidata", "青鬼ゲーム6.23"),
    AOONI3_0("aooni3_0", "aooni3_0data", "青鬼ゲーム3.0"),
    AOONISCHOOL("aoonischool", "aoonischooldata", "青鬼スクール"),
    ONLINE("online", "onlinedata", "青鬼ONLINE in MC"),
    Hueoni("hueoni", "hodata", "増え鬼ごっこ"),
    Takaoni("takaoni", "takadata", "高鬼ごっこ"),
    DBD("dbd", "dbddata", "DeadByDaylight")
            {
        public String toString() {
            return this.name();
        }
    };

    private final String name;
    private final String database;
    private final String display;

    MLSEvent(String name, String database, String display) {
        this.name = name;
        this.database = database;
        this.display = display;
    }

    public String getName() { return this.name; }

    public String getDatabase() { return this.database; }

    public String getDisplay() { return this.display; }

}

