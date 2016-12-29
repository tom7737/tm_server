package com.bjgt.ms.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class PureUtil {
    public static void debug(final Object msg) {
        System.out.println(msg);
    }

    public static String getDateFormatStr(final String formart) {
        return new SimpleDateFormat(formart).format(new java.util.Date());
    }

    public static String getCurrentTimeStr() {
        return getDateFormatStr("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 产生n个数的不重复的数字列�?
         *
     * @param list
     * @param num
     * @return
     */
    private static List<Integer> getRandomList(final int count) {
        List<Integer> list = new ArrayList<Integer>(count);
        java.util.Random random = new java.util.Random(70);
        int idx = 0;

        while (idx < count) {
            int num = (random.nextInt(count));

            if (list.contains(num)) {
                list.add(new Integer(num));
                idx++;
            }
        }

        return list;
    }

    public static boolean timeEquals() {
        Date date = new Date();
        DateFormat df = DateFormat.getDateTimeInstance();

        try {
            date.compareTo(df.parse("2004-12-24 16:00:00"));

            return true;
        } catch (java.text.ParseException e) {
            System.out.print(e.getMessage());

            return false;
        }
    }

    /**
     * 以时间为基础创建ID
     *
     * @param name
     * @return
     */
    public static synchronized String getIdByTime(final String name, final String ext) {
        return name + "-" + getCurrDate() + "-" + getCurrTime() + getRandomNumber() + "." + ext;
    }

    /**
     * 取得字符串格式的当前日期
     *
     * @return
     */
    public static String getCurrDate() {
        Date date = new Date();
        Format formatter = new SimpleDateFormat("yyyy.MM.dd");

        return formatter.format(date);
    }

    /**
     * 取得字符串格式的当前时间
     *
     * @return
     */
    public static String getCurrTime() {
        Date date = new Date();
        Format formatter = new SimpleDateFormat(".HH.mm.ss");

        return formatter.format(date);
    }

    public static String getRandomNumber() {
        Random random = new Random();
        String retval = String.valueOf(random.nextInt(100));

        return retval;
    }

    /**
     * 得到给定日期
     *
     * @param date
     *            给定日期
     * @param pattern
     *            给定日期格式
     * @return Date 给定日期
     */
    public static Date getDate(final String date, final String format) {
        if ((date == null) || date.isEmpty() || (format == null) || format.isEmpty()) {
            return null;
        }

        SimpleDateFormat formatter = new SimpleDateFormat(format);

        try {
            return formatter.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 得到异常的详细信�?
             * @param e
     * @return
     */
    public static String getStackMsg(final Exception e) {
        StringBuffer sb = new StringBuffer();
        StackTraceElement stackArray[] = e.getStackTrace();

        for (int i = 0; i < stackArray.length; i++) {
            StackTraceElement element = stackArray[i];

            sb.append(element.toString() + "\n");
        }

        return sb.toString();
    }
}
