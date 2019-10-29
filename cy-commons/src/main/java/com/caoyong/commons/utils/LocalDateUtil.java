package com.caoyong.commons.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * 基于java8的LocalDateTime日期工具类
 *
 * @author caoyong
 * @version 1.0.0
 * @since 2019-07-25 13:33:04
 **/
public class LocalDateUtil {
    /**
     * 日期格式yyyy-MM-dd
     */
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 日期时间格式yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期时间格式器yyyy-MM-dd HH:mm:ss
     */
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 日期格式器yyyy-MM-dd
     */
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 指定格式获取新增天数日期
     *
     * @param timeFormat 格式
     * @param plusDays   新增天数
     * @return 结果
     */
    public static String getPlusDaysByFormat(String timeFormat, Integer plusDays) {
        return LocalDateTime.now().plusDays(plusDays).format(DateTimeFormatter.ofPattern(timeFormat));
    }

    /**
     * Date转LocalDateTime
     *
     * @param date Date对象
     * @return LocalDateTime结果
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为Date
     *
     * @param dateTime LocalDateTime对象
     * @return Date对象
     */
    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 格式化时间-默认yyyy-MM-dd HH:mm:ss格式
     *
     * @param dateTime LocalDateTime对象
     * @return 结果
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        return formatDateTime(dateTime, DATE_TIME_PATTERN);
    }

    /**
     * 按pattern格式化时间-默认yyyy-MM-dd HH:mm:ss格式
     *
     * @param dateTime LocalDateTime对象
     * @param pattern  要格式化的字符串
     * @return 结果
     */
    public static String formatDateTime(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) {
            return null;
        }
        if (pattern == null || pattern.isEmpty()) {
            pattern = DATE_TIME_PATTERN;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

    /**
     * 获取今天的00:00:00
     *
     * @return 结果
     */
    public static String getDayStart() {
        return getDayStart(LocalDateTime.now());
    }

    /**
     * 获取今天的23:59:59
     *
     * @return 结果
     */
    public static String getDayEnd() {
        return getDayEnd(LocalDateTime.now());
    }

    /**
     * 获取某天的00:00:00
     *
     * @param dateTime LocalDateTime对象
     * @return 结果
     */
    public static String getDayStart(LocalDateTime dateTime) {
        return formatDateTime(dateTime.with(LocalTime.MIN));
    }

    /**
     * 获取某天的23:59:59
     *
     * @param dateTime LocalDateTime对象
     * @return 结果
     */
    public static String getDayEnd(LocalDateTime dateTime) {
        return formatDateTime(dateTime.with(LocalTime.MAX));
    }

    /**
     * 获取本月第一天的00:00:00
     *
     * @return 结果
     */
    public static String getFirstDayOfMonth() {
        return getFirstDayOfMonth(LocalDateTime.now());
    }

    /**
     * 获取本月最后一天的23:59:59
     *
     * @return 结果
     */
    public static String getLastDayOfMonth() {
        return getLastDayOfMonth(LocalDateTime.now());
    }

    /**
     * 获取某月第一天的00:00:00
     *
     * @param dateTime LocalDateTime对象
     * @return 结果
     */
    public static String getFirstDayOfMonth(LocalDateTime dateTime) {
        return formatDateTime(dateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN));
    }

    /**
     * 获取某月最后一天的23:59:59
     *
     * @param dateTime LocalDateTime对象
     * @return 结果
     */
    public static String getLastDayOfMonth(LocalDateTime dateTime) {
        return formatDateTime(dateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX));
    }

    /**
     * 返回当前的日期
     *
     * @return 当前日期
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 返回当前日期时间
     *
     * @return 当前日期时间
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 返回当前日期字符串yyyy-MM-dd
     *
     * @return 日期yyyy-MM-dd
     */
    public static String getCurrentDateStr() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * 返回当前日期时间字符串
     *
     * @return 日期时间字符串
     */
    public static String getCurrentDateTimeStr() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    /**
     * @param dateStr 日期
     * @param pattern 格式
     * @return 结果
     */
    public static LocalDate parseLocalDate(String dateStr, String pattern) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * @param dateTimeStr 日期时间
     * @param pattern     格式
     * @return LocalDateTime对象
     */
    public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 日期相隔天数
     *
     * @param startDateInclusive 开始
     * @param endDateExclusive   结束
     * @return 结果
     */
    public static long periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        //另一实现：ChronoUnit.DAYS.between(startDateInclusive, endDateExclusive);
        return endDateExclusive.toEpochDay() - startDateInclusive.toEpochDay();
    }

    /**
     * 日期相隔天数
     *
     * @param startDate 开始
     * @param endDate   结束
     * @return 结果
     */
    public static long periodDays(String startDate, String endDate) {
        return periodDays(parseLocalDate(startDate, DATE_PATTERN), parseLocalDate(endDate, DATE_PATTERN));
    }

    /**
     * 日期相隔今天天数(正数：距离未来多少天 负数：距离以前多少天)
     *
     * @param date 日期
     * @return 结果
     */
    public static long periodTodayDays(String date) {
        return periodDays(LocalDate.now(), parseLocalDate(date, DATE_PATTERN));
    }

    /**
     * 日期相隔小时
     *
     * @param startInclusive 开始
     * @param endExclusive   结束
     * @return 结果
     */
    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toHours();
    }

    /**
     * 日期相隔分钟
     *
     * @param startInclusive 开始
     * @param endExclusive   结束
     * @return 结果
     */
    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    /**
     * 日期相隔毫秒数
     *
     * @param startInclusive 开始
     * @param endExclusive   结束
     * @return 结果
     */
    public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMillis();
    }

    /**
     * 是否当天
     *
     * @param date 是否是今天
     * @return 结果
     */
    public static boolean isToday(LocalDate date) {
        return getCurrentLocalDate().equals(date);
    }

    /**
     * 获取本月的第一天
     *
     * @return 本月的第一天
     */
    public static String getFirstDayOfThisMonth() {
        return getCurrentLocalDate().with(TemporalAdjusters.firstDayOfMonth()).format(DATE_FORMATTER);
    }

    /**
     * 获取本月的最后一天
     *
     * @return 本月的最后一天
     */
    public static String getLastDayOfThisMonth() {
        return getCurrentLocalDate().with(TemporalAdjusters.lastDayOfMonth()).format(DATE_FORMATTER);
    }

    /**
     * 获取指定日期的第一个周一
     *
     * @return 结果
     */
    public static String getFirstMonday(String date) {
        return LocalDate.parse(date).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY))
                .format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期的后两周
     *
     * @return 后两周
     */
    public static String getCurDateAfterTwoWeek() {
        return getCurrentLocalDate().plus(2, ChronoUnit.WEEKS).format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期的6个月后的日期
     *
     * @return 6个月后日期
     */
    public static String getCurDateAfterSixMonth() {
        return getCurrentLocalDate().plus(6, ChronoUnit.MONTHS).format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期的5年后的日期
     *
     * @return 5年后的日期
     */
    public static String getCurDateAfterFiveYear() {
        return getCurrentLocalDate().plus(5, ChronoUnit.YEARS).format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期的20年后的日期
     *
     * @return 20年后日期
     */
    public static String getCurDateAfterTwentyYear() {
        return getCurrentLocalDate().plus(2, ChronoUnit.DECADES).format(DATE_FORMATTER);
    }

}
