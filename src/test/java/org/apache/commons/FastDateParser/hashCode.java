import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class hashCodeTest {
    
    @Test
    public void testHashCode() {
        FastDateParser parser1 = new FastDateParser("dd/MM/yyyy", TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        FastDateParser parser2 = new FastDateParser("dd/MM/yyyy", TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        
        assertEquals(parser1.hashCode(), parser2.hashCode());
    }
    
    @Test
    public void testHashCode_DifferentPattern() {
        FastDateParser parser1 = new FastDateParser("dd/MM/yyyy", TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        FastDateParser parser2 = new FastDateParser("MM/dd/yyyy", TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        
        assertNotEquals(parser1.hashCode(), parser2.hashCode());
    }
    
    @Test
    public void testHashCode_DifferentTimeZone() {
        FastDateParser parser1 = new FastDateParser("dd/MM/yyyy", TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        FastDateParser parser2 = new FastDateParser("dd/MM/yyyy", TimeZone.getTimeZone("UTC"), Locale.ENGLISH);
        
        assertNotEquals(parser1.hashCode(), parser2.hashCode());
    }
    
    @Test
    public void testHashCode_DifferentLocale() {
        FastDateParser parser1 = new FastDateParser("dd/MM/yyyy", TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
        FastDateParser parser2 = new FastDateParser("dd/MM/yyyy", TimeZone.getTimeZone("GMT"), Locale.FRENCH);
        
        assertNotEquals(parser1.hashCode(), parser2.hashCode());
    }
}