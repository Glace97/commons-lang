import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getPatternTest {

    @Test
    void testGetPattern() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());

        String pattern = parser.getPattern();

        assertEquals("yyyy-MM-dd HH:mm:ss", pattern);
    }
}