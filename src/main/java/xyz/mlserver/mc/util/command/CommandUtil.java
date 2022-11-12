package xyz.mlserver.mc.util.command;

import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

/**
 * ヘルプコマンドを作るためのｸﾗｽ
 * @deprecated 新規ｸﾗｽが誕生しました。V2.0で削除予定
 */
public class CommandUtil {

    private static final int COMMAND_LINES = 7;

    private static List<String> getHelps(List<String> list, int page) {
        int max;
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
        _list.add("-------- HELP(" + page + "/" + max + ") --------");
        for (int n = 0; n < COMMAND_LINES; n++) {
            if (ListI >= list.size()) return _list;
            _list.add(list.get(ListI));
            ListI++;
        }
        return _list;
    }

    public static void sendHelp(CommandSender sender, List<String> list, int page) {
        for (String text : getHelps(list, page)) {
            sender.sendMessage(text);
        }
    }

}