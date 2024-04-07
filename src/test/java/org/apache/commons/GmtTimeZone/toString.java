import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toStringTest {

    @Test
    void testToStringPositiveOffset() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 5, 30);
        String expected = "[GmtTimeZone id=\"+05:30\",offset=19800000]";
        assertEquals(expected, gmtTimeZone.toString());
    }

    @Test
    void testToStringNegativeOffset() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 2, 0);
        String expected = "[GmtTimeZone id=\"-02:00\",offset=-7200000]";
        assertEquals(expected, gmtTimeZone.toString());
    }

    @Test
    void testToStringZeroOffset() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 0, 0);
        String expected = "[GmtTimeZone id=\"+00:00\",offset=0]";
        assertEquals(expected, gmtTimeZone.toString());
    }

    @Test
    void testToStringOutOfRangeHours() {
        assertThrows(IllegalArgumentException.class, () -> new GmtTimeZone(false, 25, 0));
    }

    @Test
    void testToStringOutOfRangeMinutes() {
        assertThrows(IllegalArgumentException.class, () -> new GmtTimeZone(false, 10, 60));
    }

    @Test
    void testToStringSerialization() {
        GmtTimeZone gmtTimeZone = new GmtTimeZone(false, 3, 15);
        String expected = "[GmtTimeZone id=\"+03:15\",offset=11700000]";
        assertEquals(expected, gmtTimeZone.toString());

        // Verify serialization matches toString result
        assertEquals(expected, Objects.requireNonNullElse(gmtTimeZone.toString(), ""));
    }
}