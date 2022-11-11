package xyz.mlserver.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.URL;

public class CountryUtil {

    public static String getCountryByIP(InetSocketAddress ip) throws Exception {
        URL url = new URL("http://ip-api.com/json/" + ip.getHostName());
        BufferedReader stream = new BufferedReader(new InputStreamReader(
                url.openStream()));
        StringBuilder entirePage = new StringBuilder();
        String inputLine;
        while ((inputLine = stream.readLine()) != null)
            entirePage.append(inputLine);
        stream.close();
        if(!(entirePage.toString().contains("\"country\":\"")))
            return null;
        return entirePage.toString().split("\"country\":\"")[1].split("\",")[0];
    }

    public static String getCountryByIP(String ip) throws Exception {
        URL url = new URL("http://ip-api.com/json/" + ip);
        BufferedReader stream = new BufferedReader(new InputStreamReader(
                url.openStream()));
        StringBuilder entirePage = new StringBuilder();
        String inputLine;
        while ((inputLine = stream.readLine()) != null)
            entirePage.append(inputLine);
        stream.close();
        if(!(entirePage.toString().contains("\"country\":\"")))
            return null;
        return entirePage.toString().split("\"country\":\"")[1].split("\",")[0];
    }

}
