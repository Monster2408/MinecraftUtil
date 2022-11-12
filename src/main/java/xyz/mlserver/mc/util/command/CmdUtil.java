package xyz.mlserver.mc.util.command;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CmdUtil {

    private final HashMap<String, String> commandUtilHash;
    private final HashMap<String, String> adminCommandUtilHash;
    private String format;
    private String header;

    private final String temp_heder = ChatColor.YELLOW + "-------- " + ChatColor.WHITE + "HELP: page" + "%NOW-PAGE%/%MAX-PAGE%" + ChatColor.YELLOW + " --------";
    private final String temp_format = ChatColor.GOLD + "%CMD%: " + ChatColor.WHITE + "%DESCRIPTION%";

    /**
     * 引数はヘルプコマンドの表示形式
     * @param format コマンド部分のフォーマット | null → <code>/cmd: コマンド説明</code>
     * @param header ヘッダ部分のフォーマット | null → <code>-------- HELP: page(1/3) --------</code>
     */
    public CmdUtil(String format, String header) {
        this.commandUtilHash = new HashMap<>();
        this.adminCommandUtilHash = new HashMap<>();
        if (format == null) format = temp_format;
        this.format = format;
        if (header == null) header = temp_heder;
        this.header = header;
    }

    /**
     * 引数はヘルプコマンドの表示形式
     * @param format コマンド部分のフォーマット | null → <code>/cmd: コマンド説明</code>
     */
    public CmdUtil(String format) {
        this(format, null);
    }

    /**
     * 引数はヘルプコマンドの表示形式
     */
    public CmdUtil() {
        this(null, null);
    }

    /**
     * コマンドの追加
     * @param cmd コマンドの使い方 | <code>/cmd create</code>
     * @param description コマンドの説明
     * @return {@link CmdUtil}
     */
    public CmdUtil add(String cmd, String description) {
        this.commandUtilHash.put(cmd, description);
        return this;
    }

    /**
     * 管理者専用のコマンドの追加。追加したコマンドはOPにしか閲覧不可。
     * @param cmd コマンドの使い方 | <code>/cmd create</code>
     * @param description コマンドの説明
     * @return {@link CmdUtil}
     */
    public CmdUtil addOP(String cmd, String description) {
        this.adminCommandUtilHash.put(cmd, description);
        return this;
    }

    /**
     * コマンドヘルプ表示形式を取得
     * @return {@link String}
     */
    public String getFormat() {
        return format;
    }

    /**
     * コマンドヘルプ表示形式を設定。Placeholderとして<code>%CMD%</code>(コマンド)と<code>%DESCRIPTION%</code>(コマンドの説明)が使用可能
     * @param format Placeholderとして<code>%CMD%</code>(コマンド)と<code>%DESCRIPTION%</code>(コマンドの説明)が使用可能
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * コマンドヘルプヘッダ部分の表示形式を取得。
     * @return {@link String}
     */
    public String getHeader() {
        return header;
    }

    /**
     * コマンドヘルプヘッダ部分の表示形式を設定。Placeholderとして<code>%NOW-PAGE%</code>(表示中のページ)と<code>%MAX-PAGE%</code>(コマンドヘルプ最大ページ)が使用可能
     * @param header Placeholderとして<code>%NOW-PAGE%</code>(表示中のページ)と<code>%MAX-PAGE%</code>(コマンドヘルプ最大ページ)が使用可能
     */
    public void setHeader(String header) {
        this.header = header;
    }

    private HashMap<String, String> getCommandUtilHash() {
        return commandUtilHash;
    }

    private HashMap<String, String> getAdminCommandUtilHash() {
        return adminCommandUtilHash;
    }

    /**
     * コマンドヘルプの送信
     * @param player 送信先({@link Player})
     * @param page 表示するページ、最大ページ以上であれば最大ページを表示
     * @param advanced テキストクリックでコマンドを補完する機能のON/OFF
     */
    public void send(Player player, int page, boolean advanced) {
        if (player.isOp()) {
            if (advanced) for (TextComponent textComponent : getAdminAdvanceHelpMsg(page)) player.spigot().sendMessage(textComponent);
            else for (String text : getAdminHelpMsg(page)) player.sendMessage(text);
        } else {
            if (advanced) for (TextComponent textComponent : getAdvanceHelpMsg(page)) player.spigot().sendMessage(textComponent);
            else for (String text : getHelpMsg(page)) player.sendMessage(text);
        }
    }

    /**
     * コマンドヘルプの送信
     * @param sender 送信先({@link CommandSender})
     * @param page 表示するページ、最大ページ以上であれば最大ページを表示
     */
    public void send(CommandSender sender, int page) {
        if (sender instanceof Player) send(((Player)sender), page, false);
        else for (String text : getAdminHelpMsg(page)) sender.sendMessage(text);
    }

    /**
     * コマンドヘルプの送信
     * @param player 送信先({@link Player})
     * @param page 表示するページ、最大ページ以上であれば最大ページを表示
     */
    public void send(Player player, int page) {
        send(player, page, false);
    }

    /**
     * コマンドヘルプの送信
     * @param sender 送信先({@link CommandSender})
     * @param page 表示するページ、最大ページ以上であれば最大ページを表示
     * @param advanced テキストクリックでコマンドを補完する機能のON/OFF
     */
    public void send(CommandSender sender, int page, boolean advanced) {
        if (sender instanceof Player) send(((Player)sender), page, advanced);
        else send(sender, page);
    }

    private List<String> getHelpMsg(int page) {
        List<String> list = new ArrayList<>();
        String text;
        HashMap<String, String> hash = this.getCommandUtilHash();
        for (String cmd : hash.keySet()) {
            text = format;
            text = text.replace("%CMD%", cmd);
            text = text.replace("%DESCRIPTION%", hash.get(cmd));
            list.add(text);
        }
        int max;
        int COMMAND_LINES = 7;
        List<String> _list = new ArrayList<>();
        if ((list.size() % COMMAND_LINES) > 0) {
            max = (list.size() / COMMAND_LINES) + 1;
        } else {
            max = (list.size() / COMMAND_LINES);
        }
        int ListI;
        if (max < page) {
            ListI = 0;
            page = 1;
        } else {
            ListI = page - 1;
        }
        ListI = ListI * COMMAND_LINES;
        text = header;
        text = text.replace("%NOW-PAGE%", String.valueOf(page));
        text = text.replace("%MAX-PAGE%", String.valueOf(max));
        _list.add(text);
        for (int n = 0; n < COMMAND_LINES; n++) {
            if (ListI >= list.size()) return _list;
            _list.add(list.get(ListI));
            ListI++;
        }
        return _list;
    }

    private List<String> getAdminHelpMsg(int page) {
        List<String> list = new ArrayList<>();
        String text;
        HashMap<String, String> hash = this.getCommandUtilHash();
        HashMap<String, String> adminHash = this.getAdminCommandUtilHash();
        for (String cmd : hash.keySet()) {
            text = format;
            text = text.replace("%CMD%", cmd);
            text = text.replace("%DESCRIPTION%", hash.get(cmd));
            list.add(text);
        }
        for (String cmd : adminHash.keySet()) {
            text = format;
            text = text.replace("%CMD%", cmd);
            text = text.replace("%DESCRIPTION%", adminHash.get(cmd));
            list.add(text);
        }
        int max;
        int COMMAND_LINES = 7;
        List<String> _list = new ArrayList<>();
        if ((list.size() % COMMAND_LINES) > 0) {
            max = (list.size() / COMMAND_LINES) + 1;
        } else {
            max = (list.size() / COMMAND_LINES);
        }
        int ListI;
        if (max < page) {
            ListI = 0;
            page = 1;
        } else {
            ListI = page - 1;
        }
        ListI = ListI * COMMAND_LINES;
        text = header;
        text = text.replace("%NOW-PAGE%", String.valueOf(page));
        text = text.replace("%MAX-PAGE%", String.valueOf(max));
        _list.add(text);
        for (int n = 0; n < COMMAND_LINES; n++) {
            if (ListI >= list.size()) return _list;
            _list.add(list.get(ListI));
            ListI++;
        }
        return _list;
    }

    private List<TextComponent> getAdvanceHelpMsg(int page) {
        List<TextComponent> list = new ArrayList<>();
        TextComponent component;
        String text;
        HashMap<String, String> hash = this.getCommandUtilHash();
        HashMap<String, String> adminHash = this.getAdminCommandUtilHash();
        for (String cmd : hash.keySet()) {
            text = format;
            text = text.replace("%CMD%", cmd);
            text = text.replace("%DESCRIPTION%", hash.get(cmd));
            component = new TextComponent(text);
            component.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, cmd));
            list.add(component);
        }
        int max;
        int COMMAND_LINES = 7;
        List<TextComponent> _list = new ArrayList<>();
        if ((list.size() % COMMAND_LINES) > 0) {
            max = (list.size() / COMMAND_LINES) + 1;
        } else {
            max = (list.size() / COMMAND_LINES);
        }
        int ListI;
        if (max < page) {
            ListI = 0;
            page = 1;
        } else {
            ListI = page - 1;
        }
        ListI = ListI * COMMAND_LINES;
        text = header;
        text = text.replace("%NOW-PAGE%", String.valueOf(page));
        text = text.replace("%MAX-PAGE%", String.valueOf(max));
        _list.add(new TextComponent(text));
        for (int n = 0; n < COMMAND_LINES; n++) {
            if (ListI >= list.size()) return _list;
            _list.add(list.get(ListI));
            ListI++;
        }
        return _list;
    }

    private List<TextComponent> getAdminAdvanceHelpMsg(int page) {
        List<TextComponent> list = new ArrayList<>();
        TextComponent component;
        String text;
        HashMap<String, String> hash = this.getCommandUtilHash();
        HashMap<String, String> adminHash = this.getAdminCommandUtilHash();
        for (String cmd : hash.keySet()) {
            text = format;
            text = text.replace("%CMD%", cmd);
            text = text.replace("%DESCRIPTION%", hash.get(cmd));
            component = new TextComponent(text);
            component.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, cmd));
            list.add(component);
        }
        for (String cmd : adminHash.keySet()) {
            text = format;
            text = text.replace("%CMD%", cmd);
            text = text.replace("%DESCRIPTION%", adminHash.get(cmd));
            component = new TextComponent(text);
            component.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, cmd));
            list.add(component);
        }
        int max;
        int COMMAND_LINES = 7;
        List<TextComponent> _list = new ArrayList<>();
        if ((list.size() % COMMAND_LINES) > 0) {
            max = (list.size() / COMMAND_LINES) + 1;
        } else {
            max = (list.size() / COMMAND_LINES);
        }
        int ListI;
        if (max < page) {
            ListI = 0;
            page = 1;
        } else {
            ListI = page - 1;
        }
        ListI = ListI * COMMAND_LINES;
        text = header;
        text = text.replace("%NOW-PAGE%", String.valueOf(page));
        text = text.replace("%MAX-PAGE%", String.valueOf(max));
        _list.add(new TextComponent(text));
        for (int n = 0; n < COMMAND_LINES; n++) {
            if (ListI >= list.size()) return _list;
            _list.add(list.get(ListI));
            ListI++;
        }
        return _list;
    }
}
