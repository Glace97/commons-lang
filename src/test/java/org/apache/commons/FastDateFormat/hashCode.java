import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hashCodeTest {

    @Test
    void testHashCode() {
        FastDateFormat format1 = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateFormat format2 = new FastDateFormat("dd MMM yyyy", TimeZone.getTimeZone("GMT"), Locale.US);
        FastDateFormat format3 = new FastDateFormat("HH:mm:ss", TimeZone.getTimeZone("GMT"), Locale.US);
        
        assertEquals(format1.hashCode(), format1.hashCode());
        assertEquals(format2.hashCode(), format2.hashCode());
        assertEquals(format3.hashCode(), format3.hashCode());
        
        assertNotEquals(format1.hashCode(), format2.hashCode());
        assertNotEquals(format1.hashCode(), format3.hashCode());
        assertNotEquals(format2.hashCode(), format3.hashCode());
    }
}