package xyz.mlserver.java;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtil {

    private final Date date = new Date();
    private final SimpleDateFormat timestampFormat;
    private final SimpleDateFormat dateFormat;

    public TimeUtil() {
        this(null, null, null);
    }

    public TimeUtil(String TimestampFormat, String DateFormat, String Timezone) {
        if (TimestampFormat == null) TimestampFormat = "EEE, d. MMM yyyy HH:mm:ss z";
        if (DateFormat == null) DateFormat = "yyyy-MM-dd";
        if (Timezone == null) Timezone = "default";
        timestampFormat = new SimpleDateFormat(TimestampFormat);
        dateFormat = new SimpleDateFormat(DateFormat);

        TimeZone zone = Timezone.equalsIgnoreCase("default") ? TimeZone.getDefault() : TimeZone.getTimeZone(Timezone);
        timestampFormat.setTimeZone(zone);
        dateFormat.setTimeZone(zone);
    }

    public String format(String format) {
        return format(new SimpleDateFormat(format));
    }
    public String format(SimpleDateFormat format) {
        date.setTime(System.currentTimeMillis());
        return format.format(date);
    }

    public String date() {
        return format(dateFormat);
    }
    public String timeStamp() {
        return format(timestampFormat);
    }

}
