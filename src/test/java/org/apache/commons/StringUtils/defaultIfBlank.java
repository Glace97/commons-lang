import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Locale;

class defaultIfBlankTest {

    @Test
    void testDefaultIfBlank_NullString_ReturnsDefault() {
        String str = null;
        String defaultStr = "DEFAULT";
        String result = StringUtils.defaultIfBlank(str, defaultStr);
        assertEquals(defaultStr, result);
    }

    @Test
    void testDefaultIfBlank_EmptyString_ReturnsDefault() {
        String str = "";
        String defaultStr = "DEFAULT";
        String result = StringUtils.defaultIfBlank(str, defaultStr);
        assertEquals(defaultStr, result);
    }

    @Test
    void testDefaultIfBlank_WhitespaceString_ReturnsDefault() {
        String str = "   ";
        String defaultStr = "DEFAULT";
        String result = StringUtils.defaultIfBlank(str, defaultStr);
        assertEquals(defaultStr, result);
    }

    @Test
    void testDefaultIfBlank_NonBlankString_ReturnsString() {
        String str = "Hello";
        String defaultStr = "DEFAULT";
        String result = StringUtils.defaultIfBlank(str, defaultStr);
        assertEquals(str, result);
    }

    @Test
    void testDefaultIfBlank_EmptyDefaultString_ReturnsNull() {
        String str = "";
        String defaultStr = null;
        String result = StringUtils.defaultIfBlank(str, defaultStr);
        assertNull(result);
    }

    @Test
    void testDefaultIfBlank_NonBlankDefaultString_ReturnsString() {
        String str = "";
        String defaultStr = "DEFAULT";
        String result = StringUtils.defaultIfBlank(str, defaultStr);
        assertEquals(str, result);
    }
}