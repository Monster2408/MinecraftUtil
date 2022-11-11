package xyz.mlserver.java.lang.honyaku;

import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class GoogleIME {

    private static final String GOOGLE_IME_URL =
            "https://www.google.com/transliterate?langpair=ja-Hira|ja&text=";

    public static String  convByGoogleIME(String org) {
        return conv(org);
    }

    // 変換の実行
    private static String conv(String org) {
        if ( org.length() == 0 ) {
            return "";
        }

        String[] list = org.split("§");
        String note = "";
        String First;
        char charFirst;
        boolean t = false;
        if (String.valueOf(org.charAt(0)).equalsIgnoreCase("§")) t = true;
        for (String text: list) {
            First = "";
            if (t && text.length() > 0) {
                charFirst = text.charAt(0);
                First = "§" + charFirst; // 一文字目を格納
                text = text.substring(1); // 一文字目を除去
            }
            HttpURLConnection urlconn = null;
            BufferedReader reader = null;
            if (text.length() != 0) {
                try {
                    String baseurl;
                    String encode = "UTF-8";
                    baseurl = GOOGLE_IME_URL + URLEncoder.encode(text, "UTF-8");

                    URL url = new URL(baseurl);

                    urlconn = (HttpURLConnection) url.openConnection();
                    urlconn.setRequestMethod("GET");
                    urlconn.setInstanceFollowRedirects(false);
                    urlconn.connect();

                    reader = new BufferedReader(
                            new InputStreamReader(urlconn.getInputStream(), encode));

                    String json = CharStreams.toString(reader);
                    String parsed = GoogleIME.parseJson(json);

                    note = note + First + parsed;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (urlconn != null) {
                        urlconn.disconnect();
                    }
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) { // do nothing.
                        }
                    }
                }
                note = note + First;
            } else {
                note = note + First;
            }
        }
        return note;
    }

    // デバッグ用エントリ
    /**
     * GoogleIMEの最初の変換候補を抽出して結合します
     *
     * @param json 変換元のJson形式の文字列
     * @return 変換後の文字列
     * @since 2.8.10
     */
    public static String parseJson(String json) {
        StringBuilder result = new StringBuilder();
        for (JsonElement response : new Gson().fromJson(json, JsonArray.class)) {
            result.append(response.getAsJsonArray().get(1).getAsJsonArray().get(0).getAsString());
        }
        return result.toString();
    }

}
