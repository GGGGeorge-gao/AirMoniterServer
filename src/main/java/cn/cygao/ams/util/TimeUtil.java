package cn.cygao.ams.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期时间工具类
 *
 * @author STEA_YY、cygao
 */
public class TimeUtil {
    /**
     * 完全遵循ISO8601规范的时间格式
     */
    private static final DateTimeFormatter ISO8601_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    /**
     * 精确到秒的时间格式
     */
    private static final DateTimeFormatter STANDARD_DATE_TO_SECOND_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * 精确到日的时间格式
     */
    private static final DateTimeFormatter STANDARD_DATE_TO_DAY_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /**
     * 纯数字的时间格式
     */
    private static final DateTimeFormatter PURE_DIGITAL_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    /**
     * 转换成纯数字的时间格式
     *
     * @param date 日期类
     * @return 格式化字符串
     */
    public static String getPureDigitalTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).format(PURE_DIGITAL_FORMATTER);
    }

    /**
     * 传入日期类生成格式化的时间字符串(精确到秒)
     *
     * @param date 日期类
     * @return 格式化的时间字符串
     */
    public static String getFormattedTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).format(STANDARD_DATE_TO_SECOND_FORMATTER);
    }

    /**
     * 传入日期类生成格式化的日期字符串(精确到日)
     *
     * @param date 日期类
     * @return 格式化的日期字符串
     */
    public static String getFormattedDate(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).format(STANDARD_DATE_TO_DAY_FORMATTER);
    }

    public static String getISO8601Timestamp(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).format(ISO8601_DATE_FORMATTER);
    }

    public static String getISO8601Timestamp(Long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault()).format(ISO8601_DATE_FORMATTER);
    }

    /**
     * 传入日期字符串生成日期类
     *
     * @param dateStr 日期字符串
     * @return 日期类
     * @throws ParseException 日期转化异常
     */
    public static Date tranStringToDate(String dateStr) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(dateStr);
    }

    public static Date now() {
        return new Date();
    }
}
