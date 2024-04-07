import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

class applyRulesTest {
    
    private FastDateFormat fastDateFormat;
    private Calendar calendar;
    
    @BeforeEach
    void setUp() {
        fastDateFormat = new FastDateFormat("dd-MM-yyyy", TimeZone.getDefault(), Locale.getDefault());
        calendar = Calendar.getInstance();
    }
    
    @Test
    void testApplyRules_FormatCalendar_ReturnsStringBuffer() {
        StringBuffer buf = new StringBuffer();
        StringBuffer result = fastDateFormat.applyRules(calendar, buf);
        
        assertNotNull(result);
        assertEquals(buf, result);
    }
    
    @Test
    void testApplyRules_FormatCalendar_ReturnsSameStringBuffer() {
        StringBuffer buf = new StringBuffer();
        StringBuffer result = fastDateFormat.applyRules(calendar, buf);
        
        assertSame(buf, result);
    }
    
    @Test
    void testApplyRules_FormatCalendar_ReturnsNonEmptyStringBuffer() {
        StringBuffer buf = new StringBuffer();
        StringBuffer result = fastDateFormat.applyRules(calendar, buf);
        
        assertTrue(result.length() > 0);
    }
    
    @Test
    void testApplyRules_FormatCalendar_ReturnsExpectedStringBuffer() {
        StringBuffer buf = new StringBuffer();
        StringBuffer result = fastDateFormat.applyRules(calendar, buf);
        
        String expected = calendar.get(Calendar.DAY_OF_MONTH) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.YEAR);
        assertEquals(expected, result.toString());
    }
    
    @Test
    void testApplyRules_FormatCalendar_FormatTwice_ReturnsSameStringBuffer() {
        StringBuffer buf1 = new StringBuffer();
        StringBuffer result1 = fastDateFormat.applyRules(calendar, buf1);
        
        StringBuffer buf2 = new StringBuffer();
        StringBuffer result2 = fastDateFormat.applyRules(calendar, buf2);
        
        assertSame(result1, result2);
    }
}