package xyz.mlserver.java.lang;

public enum Language {
    ENGLISH("ENGLISH", "english"),
    JAPANESE("日本語", "japanese") {
        @Override
        public String toString() {
            return name().toUpperCase();
        }
    };
    private final String name;
    private String id;
    Language(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public String getId() { return id; }

    public static Language fromId(String id) {
        for (Language language : Language.values()) {
            if (language.getId().equalsIgnoreCase(id)) return language;
        }
        return null;
    }
}