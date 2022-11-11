package xyz.mlserver.java;

import org.json.JSONObject;

public class JsonUtil {

    /**
     * JSONオブジェクトを生成する
     * <pre>
     * Discordでよく使う最低限のJSONオブジェクトを生成します。
     * </pre>
     * @param content   : メッセージ
     * @param username ： 送信者名
     * @param avatarUrl : 送信者画像URL
     **/
    public static String setJsonObj(String content, String username, String avatarUrl){
        //JSONオブジェクトを生成する
        JSONObject json = new JSONObject();

        json.append("content",content);

        if( username != null && username.length() > 0 ){
            //送信者名が有効な場合
            json.append("username", username);
        }

        if( avatarUrl != null && avatarUrl.length() > 0  ){
            //送信者画像URLが有効な場合
            json.append("avatar_url", avatarUrl);
        }

        //シリアライズ
        return json.toString();
    }


}
