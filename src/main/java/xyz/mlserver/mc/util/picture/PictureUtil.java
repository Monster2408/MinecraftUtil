package xyz.mlserver.mc.util.picture;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.mlserver.java.Log;
import xyz.mlserver.mc.util.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class PictureUtil {

    private JavaPlugin plugin;

    public PictureUtil(JavaPlugin plugin) { new PictureUtil(plugin); }

    public PictureUtil(JavaPlugin plugin, boolean textCenter) {
        this.plugin = plugin;
    }

    private URL newURL(String player_uuid) {
        String url = "https://minepic.org/avatar/8/%uuid%".replace("%uuid%" , player_uuid);

        try {
            return new URL(url);
        } catch (Exception e) {
            Log.warning("Could not read url from file.");
            return null;
        }
    }

    private BufferedImage getImage(Player player) {
        URL head_image = newURL(player.getUniqueId().toString());

        // URL Formatted correctly.
        if (head_image != null) {
            try {
                //User-Agent is needed for HTTP requests
                HttpURLConnection connection = (HttpURLConnection) head_image.openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
                return ImageIO.read(connection.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
                Log.warning("error_retrieving_avatar");
            }
        }
        return null;
    }

    public ImageMessage createPictureMessage(Player player, List<String> messages, boolean textCenter) {
        BufferedImage image = getImage(player);

        if (image == null) return null;

        return getMessage(messages, image, textCenter);
    }

    public ImageMessage createPictureMessage(Player player, List<String> messages) {
        return createPictureMessage(player, messages, false);
    }

    public ImageMessage createPictureMessage(Player player, boolean textCenter) {
        return createPictureMessage(player, null, textCenter);
    }

    public ImageMessage createPictureMessage(Player player) {
        return createPictureMessage(player, null, false);
    }

    private char getChar() {
        return ImageChar.BLOCK.getChar();
    }

    public ImageMessage getMessage(List<String> messages, BufferedImage image, boolean textCenter) {
        int imageDimensions = 8, count = 0;
        ImageMessage imageMessage = new ImageMessage(image, imageDimensions, getChar());
        String[] msg = new String[imageDimensions];
        if (messages != null) {
            for (String message : messages) {
                if (count > msg.length) break;
                msg[count++] = Color.replaceColorCode(message);
            }
        }

        while (count < imageDimensions) {
            msg[count++] = "";
        }

        if (textCenter)
            return imageMessage.appendCenteredText(msg);

        return imageMessage.appendText(msg);
    }

    public ImageMessage getMessage(List<String> messages, BufferedImage image) {
        return getMessage(messages, image, false);
    }

    public void sendOutPictureMessage(ImageMessage picture_message) {
        for (Player online_player : plugin.getServer().getOnlinePlayers()) {
            picture_message.sendToPlayer(online_player);
        }
    }


    public void clearChat(Player player) {
        for (int i = 0; i < 20; i++) {
            player.sendMessage("");
        }
    }


}
