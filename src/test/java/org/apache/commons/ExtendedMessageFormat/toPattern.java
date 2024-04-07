
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class toPatternTest {

    private ExtendedMessageFormat extendedMessageFormat;
    private Map<String, FormatFactory> formatFactoryRegistry;

    @BeforeEach
    void setUp() {
        formatFactoryRegistry = new HashMap<>();
        formatFactoryRegistry.put("date", new DateFormatFactory());
        formatFactoryRegistry.put("number", new NumberFormatFactory());
        extendedMessageFormat = new ExtendedMessageFormat("", Locale.US, formatFactoryRegistry);
    }

    @Test
    @DisplayName("Test toPattern with valid pattern")
    void testToPatternValidPattern() {
        String pattern = "This is a {0} pattern";
        extendedMessageFormat.applyPattern(pattern);
        assertEquals(pattern, extendedMessageFormat.toPattern());
    }

    @Test
    @DisplayName("Test toPattern with null pattern")
    void testToPatternNullPattern() {
        assertThrows(NullPointerException.class, () -> extendedMessageFormat.applyPattern(null));
    }

    @Test
    @DisplayName("Test toPattern with empty pattern")
    void testToPatternEmptyPattern() {
        extendedMessageFormat.applyPattern("");
        assertEquals("", extendedMessageFormat.toPattern());
    }

    @Test
    @DisplayName("Test toPattern with pattern containing special characters")
    void testToPatternSpecialCharactersPattern() {
        String pattern = "This is a {0} pattern with {1} special {2} characters";
        extendedMessageFormat.applyPattern(pattern);
        assertEquals(pattern, extendedMessageFormat.toPattern());
    }

    @Test
    @DisplayName("Test toPattern with pattern containing quotes")
    void testToPatternQuotesPattern() {
        String pattern = "This is a {0} pattern with 'quotes'";
        extendedMessageFormat.applyPattern(pattern);
        assertEquals(pattern, extendedMessageFormat.toPattern());
    }

    @Test
    @DisplayName("Test toPattern with pattern containing nested format elements")
    void testToPatternNestedFormatElementsPattern() {
        String pattern = "This is a {0} pattern with {1, number, currency} nested {2, date} format elements";
        extendedMessageFormat.applyPattern(pattern);
        assertEquals(pattern, extendedMessageFormat.toPattern());
    }
}
