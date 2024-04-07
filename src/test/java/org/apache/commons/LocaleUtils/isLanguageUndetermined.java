import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isLanguageUndeterminedTest {

    @Test
    void testLanguageUndetermined_NullLocale_ReturnsTrue() {
        assertTrue(LocaleUtils.isLanguageUndetermined(null));
    }

    @Test
    void testLanguageUndetermined_UndeterminedLanguage_ReturnsTrue() {
        Locale undeterminedLocale = new Locale("und");
        assertTrue(LocaleUtils.isLanguageUndetermined(undeterminedLocale));
    }

    @Test
    void testLanguageUndetermined_EmptyLanguage_ReturnsTrue() {
        Locale emptyLanguageLocale = new Locale("");
        assertTrue(LocaleUtils.isLanguageUndetermined(emptyLanguageLocale));
    }

    @Test
    void testLanguageUndetermined_NotWellFormedLanguage_ReturnsTrue() {
        Locale notWellFormedLocale = new Locale("a");
        assertTrue(LocaleUtils.isLanguageUndetermined(notWellFormedLocale));
    }

    @Test
    void testLanguageUndetermined_WellFormedLanguage_ReturnsFalse() {
        Locale wellFormedLocale = new Locale("en");
        assertFalse(LocaleUtils.isLanguageUndetermined(wellFormedLocale));
    }

    @Test
    void testLanguageUndetermined_LanguageWithCountry_ReturnsFalse() {
        Locale languageWithCountryLocale = new Locale("en", "US");
        assertFalse(LocaleUtils.isLanguageUndetermined(languageWithCountryLocale));
    }
}