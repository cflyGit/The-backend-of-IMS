package com.bupt.ims.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Json2TimeStamp {
    public static Date transfer(String date) throws ParseException {
        if (date == null || date.equals("null") || date.equals("")) {
            return null;
        }
        Date dt = new Date(Long.parseLong(date));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return sdf.parse(sdf.format(dt));
    }
}
