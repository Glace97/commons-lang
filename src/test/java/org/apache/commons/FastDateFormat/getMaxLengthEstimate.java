import static org.junit.jupiter.api.Assertions.assertEquals;

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

class getMaxLengthEstimateTest {

    private FastDateFormat fastDateFormat;

    @BeforeEach
    void setUp() {
        fastDateFormat = new FastDateFormat("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
    }

    @Test
    void testGetMaxLengthEstimate() {
        int expectedMaxLength = 19; // Length of "yyyy-MM-dd HH:mm:ss"
        int actualMaxLength = fastDateFormat.getMaxLengthEstimate();
        
        assertEquals(expectedMaxLength, actualMaxLength);
    }
}