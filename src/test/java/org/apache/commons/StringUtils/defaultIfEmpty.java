import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class defaultIfEmptyTest {

    @Test
    void testDefaultIfEmpty_withEmptyString_returnsDefaultString() {
        String str = "";
        String defaultStr = "DEFAULT";
        String result = StringUtils.defaultIfEmpty(str, defaultStr);
        assertEquals(defaultStr, result);
    }
    
    @Test
    void testDefaultIfEmpty_withNullString_returnsDefaultString() {
        String str = null;
        String defaultStr = "DEFAULT";
        String result = StringUtils.defaultIfEmpty(str, defaultStr);
        assertEquals(defaultStr, result);
    }
    
    @Test
    void testDefaultIfEmpty_withNonEmptyString_returnsString() {
        String str = "STRING";
        String defaultStr = "DEFAULT";
        String result = StringUtils.defaultIfEmpty(str, defaultStr);
        assertEquals(str, result);
    }
    
    @Test
    void testDefaultIfEmpty_withEmptyDefaultString_returnsEmptyString() {
        String str = "STRING";
        String defaultStr = "";
        String result = StringUtils.defaultIfEmpty(str, defaultStr);
        assertEquals(str, result);
    }
    
    @Test
    void testDefaultIfEmpty_withNullDefaultString_returnsNull() {
        String str = "STRING";
        String defaultStr = null;
        String result = StringUtils.defaultIfEmpty(str, defaultStr);
        assertEquals(str, result);
    }
    
    @Test
    void testDefaultIfEmpty_withEmptyStringAndEmptyDefaultString_returnsEmptyString() {
        String str = "";
        String defaultStr = "";
        String result = StringUtils.defaultIfEmpty(str, defaultStr);
        assertEquals(defaultStr, result);
    }
    
    @Test
    void testDefaultIfEmpty_withNullStringAndNullDefaultString_returnsNull() {
        String str = null;
        String defaultStr = null;
        String result = StringUtils.defaultIfEmpty(str, defaultStr);
        assertEquals(defaultStr, result);
    }
    
    @Test
    void testDefaultIfEmpty_withEmptyStringAndNullDefaultString_returnsNull() {
        String str = "";
        String defaultStr = null;
        String result = StringUtils.defaultIfEmpty(str, defaultStr);
        assertEquals(defaultStr, result);
    }
    
    @Test
    void testDefaultIfEmpty_withNullStringAndEmptyDefaultString_returnsEmptyString() {
        String str = null;
        String defaultStr = "";
        String result = StringUtils.defaultIfEmpty(str, defaultStr);
        assertEquals(defaultStr, result);
    }
}