package xyz.mlserver.mls;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public enum MLSMember {
    GINGER_ALE10("Ginger_Ale10", UUID.fromString("95593263-edef-4f07-a6bb-efd7a05e2652"), "ぎんあれ"),
    MONSTER2408("Monster2408", UUID.fromString("1c2b6991-e8ce-4e5d-b4d8-ec3f0cdc5f8e"), "もんすたぁ"),
    KAIJI_("kaiji_", UUID.fromString("bf72eed1-c522-49c4-ace3-975eb806471b"), "かいじ"),
    ;
    private final String id;
    private final UUID uuid;
    private final String name;

    /**
     * 撮影メンバー
     * @param id String MCID
     * @param uuid {@link UUID} UUID
     * @param name String 名前
     */
    MLSMember(String id, UUID uuid, String name) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
    }

    /**
     * 撮影メンバーの名前
     * @return String 名前
     */
    public String getName() {
        return name;
    }

    /**
     * 撮影メンバーのMCID
     * @return String MCID
     */
    public String getId() {
        return id;
    }

    /**
     * 撮影メンバーのUUID
     * @return {@link UUID} UUID

     */
    public UUID getUuid() {
        return uuid;
    }

    private static HashMap<String, Boolean> cameraCheck;

    public static HashMap<String, Boolean> getCameraCheck() {
        if (cameraCheck == null) cameraCheck = new HashMap<>();
        return cameraCheck;
    }

    public static void setupCameraCheck() {
        cameraCheck = new HashMap<>();
    }

    public static void add(Player player) {
        if (cameraCheck == null) setupCameraCheck();
        cameraCheck.put(player.getUniqueId().toString(), false);
    }

    public static void remove(Player player) {
        if (cameraCheck == null) setupCameraCheck();
        cameraCheck.remove(player.getUniqueId().toString());
    }
}
