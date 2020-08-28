package com.flt.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author flt
 * description:
 * path: myblog-com.flt.util-DateUtils
 * date: 2020/8/4 13:53
 */
public class DateUtils {
    private static final SimpleDateFormat FORMAT;

    static {
        FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    }

    public static LocalDate DateConverLocalDate(Date date) {
        String datePattern = FORMAT.format(date);
        LocalDate localDate = LocalDate.parse(datePattern);
        return localDate;
    }

}
