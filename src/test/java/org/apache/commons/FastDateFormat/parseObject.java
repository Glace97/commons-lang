import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class parseObjectTest {

    @Test
    void testParseObject() {
        FastDateFormat format = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        
        // Test valid date format
        String validDate = "2021-01-01";
        ParsePosition validPos = new ParsePosition(0);
        Object validResult = format.parseObject(validDate, validPos);
        assertNotNull(validResult);
        assertEquals(0, validPos.getErrorIndex());
        assertEquals(validDate.length(), validPos.getIndex());
        
        // Test invalid date format
        String invalidDate = "2021-13-01";
        ParsePosition invalidPos = new ParsePosition(0);
        Object invalidResult = format.parseObject(invalidDate, invalidPos);
        assertNull(invalidResult);
        assertEquals(5, invalidPos.getErrorIndex());
        
        // Test empty string
        String emptyDate = "";
        ParsePosition emptyPos = new ParsePosition(0);
        Object emptyResult = format.parseObject(emptyDate, emptyPos);
        assertNull(emptyResult);
        assertEquals(0, emptyPos.getErrorIndex());
        assertEquals(0, emptyPos.getIndex());
        
        // Test null string
        String nullDate = null;
        ParsePosition nullPos = new ParsePosition(0);
        Object nullResult = format.parseObject(nullDate, nullPos);
        assertNull(nullResult);
        assertEquals(0, nullPos.getErrorIndex());
        assertEquals(0, nullPos.getIndex());
    }

}