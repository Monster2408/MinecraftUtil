package xyz.mlserver.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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


    /**
     * JsonAPIのURLからString型でデータを取得する
     * @param urlString Json APIのURL
     * @return Json APIのレスポンス
     */
    public static String getResult(String urlString){
        StringBuilder result = new StringBuilder();
        try{
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tmp = "";
            while ((tmp = in.readLine()) != null) {
                result.append(tmp);
            }
            in.close();
            con.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

}
