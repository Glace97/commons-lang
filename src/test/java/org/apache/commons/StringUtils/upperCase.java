import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Locale;

class upperCaseTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testUpperCase_NullInput_ReturnNull() {
        String result = stringUtils.upperCase(null);
        assertEquals(null, result);
    }

    @Test
    void testUpperCase_EmptyString_ReturnEmptyString() {
        String result = stringUtils.upperCase("");
        assertEquals("", result);
    }

    @Test
    void testUpperCase_AllLowerCase_ReturnAllUpperCase() {
        String result = stringUtils.upperCase("abc");
        assertEquals("ABC", result);
    }

    @Test
    void testUpperCase_AllUpperCase_ReturnSameString() {
        String result = stringUtils.upperCase("ABC");
        assertEquals("ABC", result);
    }

    @Test
    void testUpperCase_MixedCase_ReturnAllUpperCase() {
        String result = stringUtils.upperCase("aBc");
        assertEquals("ABC", result);
    }

    @Test
    void testUpperCase_NullInputWithLocale_ReturnNull() {
        String result = stringUtils.upperCase(null, Locale.ENGLISH);
        assertEquals(null, result);
    }

    @Test
    void testUpperCase_EmptyStringWithLocale_ReturnEmptyString() {
        String result = stringUtils.upperCase("", Locale.ENGLISH);
        assertEquals("", result);
    }

    @Test
    void testUpperCase_AllLowerCaseWithLocale_ReturnAllUpperCase() {
        String result = stringUtils.upperCase("abc", Locale.ENGLISH);
        assertEquals("ABC", result);
    }

    @Test
    void testUpperCase_AllUpperCaseWithLocale_ReturnSameString() {
        String result = stringUtils.upperCase("ABC", Locale.ENGLISH);
        assertEquals("ABC", result);
    }

    @Test
    void testUpperCase_MixedCaseWithLocale_ReturnAllUpperCase() {
        String result = stringUtils.upperCase("aBc", Locale.ENGLISH);
        assertEquals("ABC", result);
    }
}