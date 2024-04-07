import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getTimeZoneTest {

    private FastDateFormat fastDateFormat;

    @BeforeAll
    public void setup() {
        fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
    }

    @Test
    public void testGetTimeZone() {
        TimeZone timeZone = fastDateFormat.getTimeZone();
        assertNotNull(timeZone);
        assertEquals("GMT", timeZone.getID());
    }
}