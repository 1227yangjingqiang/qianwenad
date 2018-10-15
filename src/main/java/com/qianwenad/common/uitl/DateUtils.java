package com.qianwenad.common.uitl;

import com.vip.vjtools.vjkit.time.DateUtil;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils extends DateUtil {

    private static final ThreadLocal<SimpleDateFormat> dateFormatHolder = new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected SimpleDateFormat initialValue() {

            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

    };

    private static final ThreadLocal<SimpleDateFormat> dateFormatForTAndZHolder = new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected SimpleDateFormat initialValue() {

            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        }

    };

    private static final ThreadLocal<SimpleDateFormat> dateFormatForConsiseDateHolder = new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected SimpleDateFormat initialValue() {

            return new SimpleDateFormat("yyyyMMdd");
        }

    };

    private static final ThreadLocal<SimpleDateFormat> dateFormatForPageHolder = new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected SimpleDateFormat initialValue() {

            return new SimpleDateFormat("yyyy-MM-dd");
        }

    };

    private static final ThreadLocal<SimpleDateFormat> dateFormatForFileNameHolder = new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected SimpleDateFormat initialValue() {

            return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        }

    };

    private static final ThreadLocal<SimpleDateFormat> dateFormatForShortHolder = new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected SimpleDateFormat initialValue() {

            return new SimpleDateFormat("yyyy-MM-dd HH:mm");
        }

    };

    private static final ThreadLocal<SimpleDateFormat> dateFormatForYyyyMMddHHmmssNumber = new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected SimpleDateFormat initialValue() {

            return new SimpleDateFormat("yyyyMMddHHmmss");
        }

    };

    private static final ThreadLocal<SimpleDateFormat> dateFormatForEuropeHolder = new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected SimpleDateFormat initialValue() {

            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+00:00");
        }

    };

    private static final ThreadLocal<SimpleDateFormat> dateFormatForCnMonthHolder = new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected SimpleDateFormat initialValue() {

            return new SimpleDateFormat("yyyy年MM月");
        }

    };

	/**
	 * 产生形如"2018年06月"的
	 * @param date 时间
	 * @return 毫秒数
	 */
	public static String format2CnMonth(Date date) {
		SimpleDateFormat dateFormat = dateFormatForCnMonthHolder.get();
		Assert.isTrue(dateFormat != null);
		return dateFormat.format(date);
	}

	/**
	 * 产生形如YYYYMMddHHmmss的整数
	 * @param date 时间
	 * @return 毫秒数
	 */
	public static long formatToYyyyMMddHHmmssNumber(Date date) {
		SimpleDateFormat dateFormat = dateFormatForYyyyMMddHHmmssNumber.get();
		Assert.isTrue(dateFormat != null);
		String strDate = dateFormat.format(date);
		return Long.parseLong(strDate);
	}

	public static String formatYyyyMMdd(Date date) {
		SimpleDateFormat dateFormat = dateFormatForConsiseDateHolder.get();
		Assert.isTrue(dateFormat != null);
		return dateFormat.format(date);
	}

    /**
     * @param datetime 字符串的实际格式
     * @return 对应的秒数
     */
    public static long parseDateTimeStrToSecond(String datetime) {
        SimpleDateFormat dateFormat = dateFormatHolder.get();
        Assert.isTrue(dateFormat != null);
        try {
            Date date = dateFormat.parse(datetime);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal.getTimeInMillis() / 1000;
        } catch (Throwable ex) {
            throw new IllegalStateException(datetime + "为不合法的日期格式!", ex);
        }
    }

    public static String format(Date date) {
        SimpleDateFormat dateFormat = dateFormatHolder.get();
        Assert.isTrue(dateFormat != null);
        return dateFormat.format(date);
    }

    public static String formatyyyyMMdd(Date date) {
        SimpleDateFormat dateFormat = dateFormatForConsiseDateHolder.get();
        Assert.isTrue(dateFormat != null);
        return dateFormat.format(date);
    }

    public static String formatYyyyMMddHHmmss(Date date) {
        SimpleDateFormat dateFormat = dateFormatForYyyyMMddHHmmssNumber.get();
        Assert.isTrue(dateFormat != null);
        return dateFormat.format(date);
    }

    public static String formatForPage(long time) {
        SimpleDateFormat dateFormatForPage = dateFormatForPageHolder.get();
        Assert.isTrue(dateFormatForPage != null);
        return dateFormatForPage.format(new Date(time));
    }

    public static String formatFromMillis2Default(long time) {
        SimpleDateFormat dateFormat = dateFormatHolder.get();
        Assert.isTrue(dateFormat != null);
        return dateFormat.format(new Date(time));
    }

    public static String formatForFileName(Date date) {
        SimpleDateFormat dateFormat = dateFormatForFileNameHolder.get();
        Assert.isTrue(dateFormat != null);
        return dateFormat.format(date);
    }

    public static String formatForShortDate(Date date) {
        SimpleDateFormat dateFormat = dateFormatForShortHolder.get();
        Assert.isTrue(dateFormat != null);
        return dateFormat.format(date);
    }

    public static String getCurrentTime() {
        return format(new Date());
    }

    /**
     * @param strDate 形如yyyy-MM-dd HH:mm:ss的日期字符串
     * @return 返回对应的日期
     */
    public static Date parse(String strDate) {
        SimpleDateFormat dateFormat = dateFormatHolder.get();
        Assert.isTrue(dateFormat != null);
        try {
            return dateFormat.parse(strDate);
        } catch (Throwable ex) {
            throw new IllegalStateException(strDate + "为不合法的日期格式!", ex);
        }
    }

    /**
     * @param strDate 形如yyyy-MM-dd的日期字符串
     * @return 返回对应的日期
     */
    public static Date parseyyyyMMdd(String strDate) {
        SimpleDateFormat dateFormat = dateFormatForPageHolder.get();
        Assert.isTrue(dateFormat != null);
        try {
            return dateFormat.parse(strDate);
        } catch (Throwable ex) {
            throw new IllegalStateException(strDate + "为不合法的日期格式!", ex);
        }
    }

    /**
     * @param strDate 形如yyyyMMdd的日期字符串
     */
    public static Date parseDate(String strDate) {
        SimpleDateFormat dateFormat = dateFormatForConsiseDateHolder.get();
        Assert.isTrue(dateFormat != null);
        try {
            return dateFormat.parse(strDate);
        } catch (Throwable ex) {
            throw new IllegalStateException(strDate + "为不合法的日期格式!", ex);
        }
    }

    public static Date parseyyyyMMddHHmmssStr(String dateStr) {
        SimpleDateFormat dateFormat = dateFormatForYyyyMMddHHmmssNumber.get();
        Assert.isTrue(dateFormat != null);
        try {
            return dateFormat.parse(dateStr);
        } catch (Throwable ex) {
            throw new IllegalStateException(dateStr + "为不合法的日期格式!", ex);
        }
    }

    public static String toSecond(long milliseconds) {
        long secondPart = milliseconds / 1000;
        long millisecondsPart = milliseconds % 1000;

        return "[" + secondPart + "]s [" + millisecondsPart + "]ms";
    }

    public static String getShortDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String getEuropeDatetimeStr(Date date) {
        SimpleDateFormat dateFormat = dateFormatForEuropeHolder.get();
        return dateFormat.format(date);
    }

    /**
     * 获得一个月之前的短日期
     *
     * @param date 日期
     * @return 一个月之前的短日期 YYYY-MM-DD
     */
    public static String getShortDateMonthAgo(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return getShortDate(cal.getTime());
    }

    /**
     * 获得一天之前的短日期
     *
     * @param date 日期
     * @return YYYY-MM-DD
     */
    public static String getShortDateOneDayAgo(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return getShortDate(cal.getTime());
    }

    /**
     * 获得一周之前的短日期
     *
     * @param date 日期
     * @return YYYY-MM-DD
     */
    public static String getShortDateOneWeekAgo(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.WEEK_OF_YEAR, -1);
        return getShortDate(cal.getTime());
    }

    /**
     * 获得指定小时之前的短日期
     *
     * @param date   日期
     * @param offset 小时数
     * @return YYYY-MM-DD
     */
    public static String getShortDateHourOffset(Date date, int offset) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, offset);
        return getShortDate(cal.getTime());
    }

    /**
     * 获得指定天数之前的日期  单位:天 ; 返回日期格式
     *
     * @param date   日期
     * @param before 天数
     * @return 指定天数之前的日期
     */
    public static Date getTimeBeforeByDayWithDate(Date date, int before) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (before <= 0) {
            return cal.getTime();
        }
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - before);
        return cal.getTime();
    }

    /**
     * 获得指定天数之前的日期的秒数格式  单位:天
     *
     * @param date   日期
     * @param before 天数
     * @return 秒
     */
    public static Long getTimeBeforeByDay(Date date, int before) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (before <= 0) {
            return cal.getTimeInMillis() / 1000;
        }
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - before);
        return cal.getTimeInMillis() / 1000;
    }

    /**
     * 获得指定日期之后N天的日期
     *
     * @param date  日期
     * @param after 天数
     * @return date之后after天的毫秒数
     */
    public static Long getMillisAfterByDay(Date date, int after) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (after <= 0) {
            return cal.getTimeInMillis();
        }
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + after);
        return cal.getTimeInMillis();
    }

    /**
     * 获得指定时间之前的日期  单位:天
     *
     * @param date   日期
     * @param before 天数
     * @return 指定时间之前的日期字符串, 格式yyyy-MM-dd HH:mm:ss
     */
    public static String getTimeBeforeByDayWithFormat(Date date, int before) {
        SimpleDateFormat dateFormat = dateFormatHolder.get();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (before <= 0) {
            return dateFormat.format(date);
        }
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - before);
        Date datetime = cal.getTime();

        return dateFormat.format(datetime);
    }

    /**
     * 获得指定时间之前的日期  单位:分
     *
     * @param date   日期
     * @param before 分钟数
     * @return 指定分钟数之前的秒数
     */
    public static Long getTimeBeforeByMinute(Date date, int before) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (before <= 0) {
            return cal.getTimeInMillis() / 1000;
        }
        cal.add(Calendar.MINUTE, -before);
        return cal.getTimeInMillis() / 1000;
    }

    /**
     * @param strDate 形如yyyy-MM-ddTHH:mm:ssZ的日期
     * @return
     */
    public static Date parse4TandZ(String strDate) {
        SimpleDateFormat dateFormat = dateFormatForTAndZHolder.get();
        Assert.isTrue(dateFormat != null);
        try {
            return dateFormat.parse(strDate);
        } catch (Throwable ex) {
            throw new IllegalStateException(strDate + "为不合法的日期格式!", ex);
        }
    }

    /**
     * 形如yyyy-MM-ddTHH:mm:ssZ的日期字符串
     *
     * @param date 日期
     * @return 形如yyyy-MM-ddTHH:mm:ssZ的日期字符串
     */
    public static String parse4TandZString(Date date) {
        SimpleDateFormat dateFormat = dateFormatForTAndZHolder.get();
        Assert.isTrue(dateFormat != null);
        try {
            return dateFormat.format(date);
        } catch (Throwable ex) {
            throw new IllegalStateException(date + "为不合法的日期格式!", ex);
        }
    }

    /**
     * 本月最开始时间
     *
     * @return
     */
    public static Date getMonthTimeBegin() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 本月最后结束时间
     *
     * @return
     */
    public static Date getMonthTimeEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return cal.getTime();
    }

    /**
     * 本月最开始时间
     *
     * @return
     */
    public static Date getLastMonthTimeBegin() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) - 1, cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 本月最后结束时间
     *
     * @return
     */
    public static Date getLastMonthTimeEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) - 1, cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 24);
        return cal.getTime();
    }

    /**
     * 获取当月月份
     *
     * @return
     */
    public static String getMonth() {
        Calendar cal = Calendar.getInstance();
        return "" + (cal.get(Calendar.MONTH) + 1);
    }

    /**
     * 获取上月月份
     *
     * @return
     */
    public static String getLastMonth() {
        Calendar cal = Calendar.getInstance();
        return "" + cal.get(Calendar.MONTH);
    }

    /**
     * 获取两个时间之间的间隔天数
     */
    public static long calculateDateSpan(String from, String to) throws ParseException {
        SimpleDateFormat dateFormat = dateFormatForConsiseDateHolder.get();
        long fromDate = dateFormat.parse(from).getTime();
        long toDate = dateFormat.parse(to).getTime();
        long span = toDate - fromDate;

        return span / (1000 * 60 * 60 * 24);
    }

    /**
     * 取过去的n个月的起始时间
     *
     * @param months: -2 ：两个月前的时间  2:两个月之后的时间
     * @return
     */
    public static Date beforeMonths(int months) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, months);
        return c.getTime();

    }

}
