package org.apache.commons.lang3.time;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatUtilsTest {

    @Test
    void testFormat_CalendarPattern() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.APRIL, 10, 14, 30, 0); // Set specific date and time
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String expected = "2024-04-10 14:30:00";
        assertEquals(expected, DateFormatUtils.format(calendar, pattern));
    }

    @Test
    void testFormat_CalendarPatternLocale() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.APRIL, 10, 14, 30, 0); // Set specific date and time
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String expected = "2024-04-10 14:30:00";
        assertEquals(expected, DateFormatUtils.format(calendar, pattern, Locale.US));
    }

    @Test
    void testFormat_CalendarPatternTimeZone() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(2024, Calendar.APRIL, 10, 14, 30, 0); // Set specific date and time
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String expected = "2024-04-10 14:30:00";
        assertEquals(expected, DateFormatUtils.format(calendar, pattern, TimeZone.getTimeZone("GMT")));
    }

    @Test
    void testFormat_DatePattern() {
        Date date = new Date(1735684200000L); // 2024-04-10 14:30:00
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String expected = "2024-04-10 14:30:00";
        assertEquals(expected, DateFormatUtils.format(date, pattern));
    }

    @Test
    void testFormat_DatePatternLocale() {
        Date date = new Date(1735684200000L); // 2024-04-10 14:30:00
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String expected = "2024-04-10 14:30:00";
        assertEquals(expected, DateFormatUtils.format(date, pattern, Locale.US));
    }

    @Test
    void testFormat_DatePatternTimeZone() {
        Date date = new Date(1735684200000L); // 2024-04-10 14:30:00
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String expected = "2024-04-10 14:30:00";
        assertEquals(expected, DateFormatUtils.format(date, pattern, TimeZone.getTimeZone("GMT")));
    }

    @Test
    void testFormat_LongPattern() {
        long millis = 1735684200000L; // 2024-04-10 14:30:00
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String expected = "2024-04-10 14:30:00";
        assertEquals(expected, DateFormatUtils.format(millis, pattern));
    }

    @Test
    void testFormat_LongPatternLocale() {
        long millis = 1735684200000L; // 2024-04-10 14:30:00
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String expected = "2024-04-10 14:30:00";
        assertEquals(expected, DateFormatUtils.format(millis, pattern, Locale.US));
    }

    @Test
    void testFormat_LongPatternTimeZone() {
        long millis = 1735684200000L; // 2024-04-10 14:30:00
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String expected = "2024-04-10 14:30:00";
        assertEquals(expected, DateFormatUtils.format(millis, pattern, TimeZone.getTimeZone("GMT")));
    }

    @Test
    void testFormatUTC_DatePattern() {
        Date date = new Date(1735684200000L); // 2024-04-10 14:30:00
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String expected = "2024-04-10 14:30:00";
        assertEquals(expected, DateFormatUtils.formatUTC(date, pattern));
    }

    @Test
    void testFormatUTC_DatePatternLocale() {
        Date date = new Date(1735684200000L); // 2024-04-10 14:30:00
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String expected = "2024-04-10 14:30:00";
        assertEquals(expected, DateFormatUtils.formatUTC(date, pattern, Locale.US));
    }

    @Test
    void testFormatUTC_LongPattern() {
        long millis = 1735684200000L; // 2024-04-10 14:30:00
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String expected = "2024-04-10 14:30:00";
        assertEquals(expected, DateFormatUtils.formatUTC(millis, pattern));
    }

    @Test
    void testFormatUTC_LongPatternLocale() {
        long millis = 1735684200000L; // 2024-04-10 14:30:00
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String expected = "2024-04-10 14:30:00";
        assertEquals(expected, DateFormatUtils.formatUTC(millis, pattern, Locale.US));
    }
}
