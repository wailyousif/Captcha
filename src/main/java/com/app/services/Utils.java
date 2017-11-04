package com.app.services;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by wailm.yousif on 3/5/17.
 */
//Test
public class Utils
{
    public static final String emptyString = "";
    public static DateFormat df = new SimpleDateFormat("dd/MON/yyyy");

    public static boolean isBrowser(HttpServletRequest request)
    {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.contains("MSIE") || userAgent.contains("Firefox") || userAgent.contains("Chrome") ||
                userAgent.contains("Opera") || userAgent.contains("Safari"))
        {
            return true;
        }
        return false;
    }

    public static String getHttpDate()
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(calendar.getTime());
    }
}
