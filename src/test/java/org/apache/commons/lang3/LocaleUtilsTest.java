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

import java.util.*;

import org.junit.jupiter.api.*;

public class LocaleUtilsTest {

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

    @Test
    void testAvailableLocaleSet() {
        Set<Locale> expectedLocales = new HashSet<>(Arrays.asList(Locale.getAvailableLocales()));
        Set<Locale> actualLocales = LocaleUtils.availableLocaleSet();

        assertEquals(expectedLocales.size(), actualLocales.size());
        assertTrue(expectedLocales.containsAll(actualLocales));
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
    public void testLanguagesByCountry_UndeterminedCountryCode_ReturnsEmptyList() {
        List<Locale> result = LocaleUtils.languagesByCountry("und");
        assertTrue(result.isEmpty());
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
    void testIsAvailableLocaleWithEmptyLanguage() {
        Locale locale = new Locale("", "US");
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

}