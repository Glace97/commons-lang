import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.Locale;

class lowerCaseTest {

    private static StringUtils stringUtils;

    @BeforeAll
    static void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("Testing lowerCase method")
    class LowerCaseTests {

        @Test
        @DisplayName("Lower case conversion of null String should return null")
        void testLowerCaseNullString() {
            assertEquals(null, stringUtils.lowerCase(null));
        }

        @Test
        @DisplayName("Lower case conversion of empty String should return empty String")
        void testLowerCaseEmptyString() {
            assertEquals("", stringUtils.lowerCase(""));
        }

        @Test
        @DisplayName("Lower case conversion of lowercase String should return the same String")
        void testLowerCaseLowercaseString() {
            assertEquals("abc", stringUtils.lowerCase("abc"));
        }

        @Test
        @DisplayName("Lower case conversion of uppercase String should return lowercase String")
        void testLowerCaseUppercaseString() {
            assertEquals("abc", stringUtils.lowerCase("ABC"));
        }

        @Test
        @DisplayName("Lower case conversion of mixed case String should return lowercase String")
        void testLowerCaseMixedCaseString() {
            assertEquals("abc", stringUtils.lowerCase("AbC"));
        }

        @Test
        @DisplayName("Lower case conversion of String with special characters should return lowercase String")
        void testLowerCaseStringWithSpecialCharacters() {
            assertEquals("abc", stringUtils.lowerCase("A!B@C#"));
        }

        @Test
        @DisplayName("Lower case conversion of String with Unicode characters should return lowercase String")
        void testLowerCaseStringWithUnicodeCharacters() {
            assertEquals("μάθημα", stringUtils.lowerCase("ΜΆΘΗΜΑ"));
        }

        @Test
        @DisplayName("Lower case conversion of String with specific locale should return lowercase String")
        void testLowerCaseStringWithLocale() {
            String str = "Äpfel";
            Locale locale = Locale.GERMAN;
            assertEquals("äpfel", stringUtils.lowerCase(str, locale));
        }
    }
}