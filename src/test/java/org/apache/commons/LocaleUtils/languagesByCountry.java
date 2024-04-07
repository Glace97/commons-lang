import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Locale;

class languagesByCountryTest {

    private static LocaleUtils localeUtils;

    @BeforeAll
    static void setUp() {
        localeUtils = new LocaleUtils();
    }

    @Test
    @DisplayName("Test languagesByCountry with null countryCode")
    void testLanguagesByCountryWithNullCountryCode() {
        List<Locale> result = localeUtils.languagesByCountry(null);
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("Test languagesByCountry with empty countryCode")
    void testLanguagesByCountryWithEmptyCountryCode() {
        List<Locale> result = localeUtils.languagesByCountry("");
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("Test languagesByCountry with valid countryCode")
    void testLanguagesByCountryWithValidCountryCode() {
        List<Locale> result = localeUtils.languagesByCountry("US");
        assertTrue(result.contains(Locale.ENGLISH));
        assertTrue(result.contains(Locale.SPANISH));
    }
}