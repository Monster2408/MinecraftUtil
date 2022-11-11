package xyz.mlserver.java.math;

import java.util.Random;

public class Chance {

    private static boolean isPer(int per, int max) {
        if (per < 0) return false;
        if (per >= 100) return true;
        Random random = new Random();
        int next = random.nextInt(max);
        return per >= next;
    }

    public static boolean isPer(double per) {
        int max = getPrecision(per);
        String[] list = String.valueOf(per).split("\\.");
        String text = list[0] + list[1];
        int num = Integer.parseInt(text);
        max = max * 100;
        max -= 1; // per = 0.1 => 999 | 0.01 => 9999
        return isPer(num, max);
    }

    public static boolean isPer(int per) {
        return isPer(per, 99);
    }

    public static int getPrecision(double val) {
        String str = String.valueOf(val);
        str = str.split("\\.")[1];
        return str.length();
    }



}
