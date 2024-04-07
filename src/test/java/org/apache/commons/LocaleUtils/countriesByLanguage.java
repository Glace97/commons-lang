import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Locale;

class countriesByLanguageTest {

    @Test
    void testCountriesByLanguage_NullLanguageCode_ReturnsEmptyList() {
        List<Locale> result = LocaleUtils.countriesByLanguage(null);
        assertEquals(0, result.size());
    }

    @Test
    void testCountriesByLanguage_InvalidLanguageCode_ReturnsEmptyList() {
        List<Locale> result = LocaleUtils.countriesByLanguage("xyz");
        assertEquals(0, result.size());
    }

    @Test
    void testCountriesByLanguage_ValidLanguageCode_ReturnsList() {
        List<Locale> result = LocaleUtils.countriesByLanguage("en");
        assertFalse(result.isEmpty());
    }

    @Test
    void testCountriesByLanguage_ValidLanguageCode_ReturnsCorrectList() {
        List<Locale> result = LocaleUtils.countriesByLanguage("en");
        assertTrue(result.contains(Locale.US));
        assertTrue(result.contains(Locale.UK));
        assertFalse(result.contains(Locale.CANADA));
    }
}