import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(Lifecycle.PER_CLASS)
class isAvailableLocaleTest {

    @Test
    void testAvailableLocale() {
        Locale locale = Locale.US;
        assertTrue(LocaleUtils.isAvailableLocale(locale));
    }

    @Test
    void testUnavailableLocale() {
        Locale locale = new Locale("xyz", "XYZ");
        assertFalse(LocaleUtils.isAvailableLocale(locale));
    }

    @Test
    void testUndeterminedLocale() {
        Locale locale = new Locale("und");
        assertTrue(LocaleUtils.isAvailableLocale(locale));
    }

    @Test
    void testLocaleWithUnderscore() {
        Locale locale = new Locale("en", "US");
        assertTrue(LocaleUtils.isAvailableLocale(locale));
    }

    @Test
    void testLocaleWithDash() {
        Locale locale = new Locale("en", "US", "POSIX");
        assertTrue(LocaleUtils.isAvailableLocale(locale));
    }

    @Test
    void testLocaleWithInvalidLanguage() {
        Locale locale = new Locale("abc", "US");
        assertFalse(LocaleUtils.isAvailableLocale(locale));
    }

    @Test
    void testLocaleWithInvalidCountry() {
        Locale locale = new Locale("en", "XYZ");
        assertFalse(LocaleUtils.isAvailableLocale(locale));
    }
}