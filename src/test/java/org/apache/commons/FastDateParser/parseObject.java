import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class parseObjectTest {

    private FastDateParser parser;

    @BeforeEach
    public void setup() {
        parser = new FastDateParser("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
    }

    @Test
    public void testParseObject_ValidInput_ReturnsDate() throws ParseException {
        String source = "2021-05-20 10:30:00";
        Object result = parser.parseObject(source);
        assertNotNull(result);
        assertTrue(result instanceof Date);
    }

    @Test
    public void testParseObject_InvalidInput_ThrowsParseException() {
        String source = "2021-05-20";
        assertThrows(ParseException.class, () -> {
            parser.parseObject(source);
        });
    }

    @Test
    public void testParseObject_NullInput_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            parser.parseObject(null);
        });
    }

    // Add more test cases to cover edge cases and achieve high coverage

}