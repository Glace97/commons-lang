import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@TestInstance(Lifecycle.PER_CLASS)
class toStringTest {

    private FastDateFormat fastDateFormat;

    @BeforeEach
    void setUp() {
        fastDateFormat = new FastDateFormat("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
    }

    @Test
    void testToString() {
        String expected = "FastDateFormat[yyyy-MM-dd HH:mm:ss," + Locale.getDefault() + "," + TimeZone.getDefault().getID() + "]";
        String actual = fastDateFormat.toString();
        assertEquals(expected, actual);
    }
}