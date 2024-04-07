import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetStrategyTest {
    private FastDateParser fastDateParser;

    @BeforeEach
    void setUp() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.US;
        
        fastDateParser = new FastDateParser(pattern, timeZone, locale);
    }

    @Test
    void testGetStrategy_Year() {
        Strategy strategy = fastDateParser.getStrategy(Calendar.YEAR);
        
        assertNotNull(strategy);
        assertEquals(NumberStrategy.class, strategy.getClass());
    }

    @Test
    void testGetStrategy_Month() {
        Strategy strategy = fastDateParser.getStrategy(Calendar.MONTH);
        
        assertNotNull(strategy);
        assertEquals(NumberStrategy.class, strategy.getClass());
    }

    @Test
    void testGetStrategy_DayOfMonth() {
        Strategy strategy = fastDateParser.getStrategy(Calendar.DAY_OF_MONTH);
        
        assertNotNull(strategy);
        assertEquals(NumberStrategy.class, strategy.getClass());
    }

    @Test
    void testGetStrategy_HourOfDay() {
        Strategy strategy = fastDateParser.getStrategy(Calendar.HOUR_OF_DAY);
        
        assertNotNull(strategy);
        assertEquals(NumberStrategy.class, strategy.getClass());
    }

    @Test
    void testGetStrategy_Minute() {
        Strategy strategy = fastDateParser.getStrategy(Calendar.MINUTE);
        
        assertNotNull(strategy);
        assertEquals(NumberStrategy.class, strategy.getClass());
    }

    @Test
    void testGetStrategy_Second() {
        Strategy strategy = fastDateParser.getStrategy(Calendar.SECOND);
        
        assertNotNull(strategy);
        assertEquals(NumberStrategy.class, strategy.getClass());
    }

    @Test
    void testGetStrategy_Millisecond() {
        Strategy strategy = fastDateParser.getStrategy(Calendar.MILLISECOND);
        
        assertNotNull(strategy);
        assertEquals(NumberStrategy.class, strategy.getClass());
    }

    @Test
    void testGetStrategy_TimeZone() {
        Strategy strategy = fastDateParser.getStrategy(Calendar.ZONE_OFFSET);
        
        assertNotNull(strategy);
        assertEquals(TimeZoneStrategy.class, strategy.getClass());
    }
}