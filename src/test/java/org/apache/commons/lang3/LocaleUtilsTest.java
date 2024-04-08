package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class LocaleUtilsTest {
    import org.junit.jupiter.api.Test;
    
    class LocaleUtilsTest {
    
        @Test
        void testToLocaleWithNull() {
            Locale result = LocaleUtils.toLocale(null);
            Assertions.assertEquals(Locale.getDefault(), result);
        }
    
        @Test
        void testToLocaleWithEmptyString() {
            Locale result = LocaleUtils.toLocale("");
            Assertions.assertEquals(new Locale("", ""), result);
        }
    
        @Test
        void testToLocaleWithLanguageOnly() {
            Locale result = LocaleUtils.toLocale("en");
            Assertions.assertEquals(new Locale("en", ""), result);
        }
    
        @Test
        void testToLocaleWithLanguageAndCountryUsingUnderscore() {
            Locale result = LocaleUtils.toLocale("en_GB");
            Assertions.assertEquals(new Locale("en", "GB"), result);
        }
    
        @Test
        void testToLocaleWithLanguageAndCountryUsingDash() {
            Locale result = LocaleUtils.toLocale("en-GB");
            Assertions.assertEquals(new Locale("en", "GB"), result);
        }
    
        @Test
        void testToLocaleWithLanguageAndCountryAndVariant() {
            Locale result = LocaleUtils.toLocale("en_GB_xxx");
            Assertions.assertEquals(new Locale("en", "GB", "xxx"), result);
        }
    
        @Test
        void testToLocaleWithInvalidFormat() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                LocaleUtils.toLocale("invalid");
            });
        }
    
        @Test
        void testToLocaleWithScriptAndExtensions() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                LocaleUtils.toLocale("en-GB#script=Latn;region=US");
            });
        }
    
        @Test
        void testToLocaleWithLowercaseLanguage() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                LocaleUtils.toLocale("EN_GB");
            });
        }
    
        @Test
        void testToLocaleWithLowercaseCountry() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                LocaleUtils.toLocale("en_gb");
            });
        }
    
        @Test
        void testToLocaleWithInvalidLength() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                LocaleUtils.toLocale("en_");
            });
        }
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    
    import java.util.List;
    import java.util.Locale;
    
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class LocaleUtilsTestSuite {
    
        @Test
        void shouldReturnSameListAsLocaleGetAvailableLocales() {
            List<Locale> expected = List.of(Locale.getAvailableLocales());
            List<Locale> actual = localeUtils.availableLocaleList();
            assertEquals(expected, actual);
        }
    
        @Test
        void shouldReturnUnmodifiableList() {
            List<Locale> locales = localeUtils.availableLocaleList();
            assertThrows(UnsupportedOperationException.class, () -> locales.add(Locale.US));
        }
    
        @Test
        void shouldReturnFilteredList() {
            List<Locale> locales = localeUtils.availableLocaleList(l -> l.getLanguage().equals("en"));
            assertTrue(locales.stream().allMatch(l -> l.getLanguage().equals("en")));
        }
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    
    import java.util.*;
    
    import static org.junit.jupiter.api.Assertions.*;
    
    @TestInstance(Lifecycle.PER_CLASS)
    class LocaleUtilsTest {
        @Test
        void testAvailableLocaleSet() {
            Set<Locale> expectedLocales = new HashSet<>(Arrays.asList(Locale.getAvailableLocales()));
            Set<Locale> actualLocales = LocaleUtils.availableLocaleSet();
    
            assertEquals(expectedLocales.size(), actualLocales.size());
            assertTrue(expectedLocales.containsAll(actualLocales));
        }
    }
    @Test
    public void testCountriesByLanguage() {
        List<Locale> englishCountries = LocaleUtils.countriesByLanguage("en");
        assertEquals(234, englishCountries.size());
    }
    
    @Test
    public void testCountriesByLanguageWithNullLanguageCode() {
        List<Locale> countries = LocaleUtils.countriesByLanguage(null);
        assertEquals(0, countries.size());
    }
    
    @Test
    public void testCountriesByLanguageWithInvalidLanguageCode() {
        List<Locale> countries = LocaleUtils.countriesByLanguage("xyz");
        assertEquals(0, countries.size());
    }
    
    @Test
    public void testCountriesByLanguageWithUndeterminedLanguageCode() {
        List<Locale> countries = LocaleUtils.countriesByLanguage("und");
        assertEquals(0, countries.size());
    }
    
    @Test
    public void testCountriesByLanguageWithEmptyLanguageCode() {
        List<Locale> countries = LocaleUtils.countriesByLanguage("");
        assertEquals(0, countries.size());
    }
    @Test
    public void testLanguagesByCountry_NullCountryCode_ReturnsEmptyList() {
        List<Locale> result = LocaleUtils.languagesByCountry(null);
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testLanguagesByCountry_InvalidCountryCode_ReturnsEmptyList() {
        List<Locale> result = LocaleUtils.languagesByCountry("INVALID");
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testLanguagesByCountry_ValidCountryCode_ReturnsLanguages() {
        List<Locale> result = LocaleUtils.languagesByCountry("US");
        assertEquals(1, result.size());
        assertEquals(Locale.US, result.get(0));
    }
    
    @Test
    public void testLanguagesByCountry_CaseInsensitiveCountryCode_ReturnsLanguages() {
        List<Locale> result = LocaleUtils.languagesByCountry("us");
        assertEquals(1, result.size());
        assertEquals(Locale.US, result.get(0));
    }
    
    @Test
    public void testLanguagesByCountry_UndeterminedCountryCode_ReturnsEmptyList() {
        List<Locale> result = LocaleUtils.languagesByCountry("und");
        assertTrue(result.isEmpty());
    }
    void testLocaleLookupList() {
            Locale locale = new Locale("fr", "CA", "xxx");
            List<Locale> expected = List.of(
                    new Locale("fr", "CA", "xxx"),
                    new Locale("fr", "CA"),
                    new Locale("fr")
            );
            List<Locale> result = LocaleUtils.localeLookupList(locale);
            assertEquals(expected, result);
        }
    
        void testLocaleLookupListWithDefaultLocale() {
            Locale locale = new Locale("fr", "CA", "xxx");
            Locale defaultLocale = new Locale("en");
            List<Locale> expected = List.of(
                    new Locale("fr", "CA", "xxx"),
                    new Locale("fr", "CA"),
                    new Locale("fr"),
                    new Locale("en")
            );
            List<Locale> result = LocaleUtils.localeLookupList(locale, defaultLocale);
            assertEquals(expected, result);
        }
    @Test
    void testIsAvailableLocaleWithAvailableLocale() {
        Locale locale = Locale.US;
        assertTrue(LocaleUtils.isAvailableLocale(locale));
    }
    
    @Test
    void testIsAvailableLocaleWithUnavailableLocale() {
        Locale locale = new Locale("en", "ABC");
        assertFalse(LocaleUtils.isAvailableLocale(locale));
    }
    
    @Test
    void testIsAvailableLocaleWithNullLocale() {
        assertFalse(LocaleUtils.isAvailableLocale(null));
    }
    
    @Test
    void testIsAvailableLocaleWithUndeterminedLanguage() {
        Locale locale = new Locale("und");
        assertTrue(LocaleUtils.isAvailableLocale(locale));
    }
    
    @Test
    void testIsAvailableLocaleWithUndeterminedCountry() {
        Locale locale = new Locale("en", "und");
        assertTrue(LocaleUtils.isAvailableLocale(locale));
    }
    
    @Test
    void testIsAvailableLocaleWithEmptyLanguage() {
        Locale locale = new Locale("", "US");
        assertFalse(LocaleUtils.isAvailableLocale(locale));
    }
    
    @Test
    void testIsAvailableLocaleWithEmptyCountry() {
        Locale locale = new Locale("en", "");
        assertFalse(LocaleUtils.isAvailableLocale(locale));
    }
    
    @Test
    void testIsAvailableLocaleWithLanguageContainingInvalidCharacters() {
        Locale locale = new Locale("en!", "US");
        assertFalse(LocaleUtils.isAvailableLocale(locale));
    }
    
    @Test
    void testIsAvailableLocaleWithCountryContainingInvalidCharacters() {
        Locale locale = new Locale("en", "US!");
        assertFalse(LocaleUtils.isAvailableLocale(locale));
    }
    
    @Test
    void testIsAvailableLocaleWithLanguageAndCountryContainingInvalidCharacters() {
        Locale locale = new Locale("en!", "US!");
        assertFalse(LocaleUtils.isAvailableLocale(locale));
    }
    @Test
    @DisplayName("should return true for null locale")
    void shouldReturnTrueForNullLocale() {
        assertTrue(LocaleUtils.isLanguageUndetermined(null));
    }
    
    @Test
    @DisplayName("should return true for undetermined language locale")
    void shouldReturnTrueForUndeterminedLanguageLocale() {
        Locale locale = new Locale("und");
        assertTrue(LocaleUtils.isLanguageUndetermined(locale));
    }
    
    @Test
    @DisplayName("should return false for determined language locale")
    void shouldReturnFalseForDeterminedLanguageLocale() {
        Locale locale = new Locale("en");
        assertFalse(LocaleUtils.isLanguageUndetermined(locale));
    }
    
    @Test
    @DisplayName("should return false for well-formed language locale")
    void shouldReturnFalseForWellFormedLanguageLocale() {
        Locale locale = new Locale("en_US");
        assertFalse(LocaleUtils.isLanguageUndetermined(locale));
    }
    
    @Test
    @DisplayName("should return false for empty language locale")
    void shouldReturnFalseForEmptyLanguageLocale() {
        Locale locale = new Locale("");
        assertFalse(LocaleUtils.isLanguageUndetermined(locale));
    }
    
    @Test
    @DisplayName("should return false for malformed language locale")
    void shouldReturnFalseForMalformedLanguageLocale() {
        Locale locale = new Locale("a");
        assertFalse(LocaleUtils.isLanguageUndetermined(locale));
    }

}