import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toStringTest {

    private FastDateParser parser;

    @BeforeEach
    void setUp() {
        parser = new FastDateParser("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("GMT"), Locale.ENGLISH);
    }

    @Test
    void testToString() {
        String expected = "FastDateParser[yyyy-MM-dd HH:mm:ss, en, GMT]";
        String actual = parser.toString();
        assertEquals(expected, actual);
    }
}