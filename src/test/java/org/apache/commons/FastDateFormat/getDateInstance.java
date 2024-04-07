import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getDateInstanceTest {

    @Test
    void testGetDateInstanceWithStyle() {
        FastDateFormat dateFormat = FastDateFormat.getDateInstance(FastDateFormat.FULL);
        assertNotNull(dateFormat);
    }

    @Test
    void testGetDateInstanceWithStyleAndLocale() {
        FastDateFormat dateFormat = FastDateFormat.getDateInstance(FastDateFormat.LONG, Locale.US);
        assertNotNull(dateFormat);
    }

    @Test
    void testGetDateInstanceWithStyleAndTimeZone() {
        FastDateFormat dateFormat = FastDateFormat.getDateInstance(FastDateFormat.MEDIUM, TimeZone.getTimeZone("GMT"));
        assertNotNull(dateFormat);
    }

    @Test
    void testGetDateInstanceWithStyleTimeZoneAndLocale() {
        FastDateFormat dateFormat = FastDateFormat.getDateInstance(FastDateFormat.SHORT, TimeZone.getTimeZone("GMT+5:30"), Locale.US);
        assertNotNull(dateFormat);
    }
}