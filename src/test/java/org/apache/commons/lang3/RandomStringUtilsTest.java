package org.apache.commons.lang3;

import static org.apache.commons.lang3.CharUtils.isAscii;
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


import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RandomStringUtilsTest {
    @Test
    void testRandomNumeric_WithNegativeCount_ShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            RandomStringUtils.randomNumeric(-1);
        });
    }
    
    @Test
    void testRandomNumeric_WithZeroCount_ShouldReturnEmptyString() {
        String result = RandomStringUtils.randomNumeric(0);
        assertEquals("", result);
    }
    
    @Test
    void testRandomNumeric_WithPositiveCount_ShouldReturnStringWithCorrectLength() {
        int count = 10;
        String result = RandomStringUtils.randomNumeric(count);
        assertEquals(count, result.length());
    }
    
    @Test
    void testRandomNumeric_WithMinLengthEqualToMaxLength_ShouldReturnStringWithCorrectLength() {
        int length = 5;
        String result = RandomStringUtils.randomNumeric(length, length + 1);
        assertEquals(length, result.length());
    }
    
    @Test
    void testRandomNumeric_WithMinLengthGreaterThanMaxLength_ShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            RandomStringUtils.randomNumeric(10, 5);
        });
    }
    
    @Test
    void testRandomNumeric_WithMinLengthEqualToMaxLengthPlusOne_ShouldReturnStringWithCorrectLength() {
        int minLength = 5;
        int maxLength = 6;
        String result = RandomStringUtils.randomNumeric(minLength, maxLength);
        assertTrue(result.length() >= minLength && result.length() < maxLength);
    }
//    @Test
//    void testRandomAsciiWithCount() {
//        String randomString = RandomStringUtils.randomAscii(5);
//        assertNotNull(randomString);
//        assertEquals(5, randomString.length());
//        assertTrue(isAscii(randomString));
//    }
//
//    @Test
//    void testRandomAsciiWithMinMax() {
//        String randomString = RandomStringUtils.randomAscii(3, 8);
//        assertNotNull(randomString);
//        assertTrue(randomString.length() >= 3 && randomString.length() < 8);
//        assertTrue(isAscii(randomString));
//    }
    
    @Test
    void testRandomAsciiWithNegativeCount() {
        assertThrows(IllegalArgumentException.class, () -> {
            RandomStringUtils.randomAscii(-5);
        });
    }
    
    @Test
    void testRandomAsciiWithMinGreaterThanMax() {
        assertThrows(IllegalArgumentException.class, () -> {
            RandomStringUtils.randomAscii(8, 3);
        });
    }
//    @Test
//    void testRandomAlphabeticWithNegativeCount() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            randomStringUtils.randomAlphabetic(-1);
//        });
//    }
//
//    @Test
//    void testRandomAlphabeticWithCountZero() {
//        String randomString = randomStringUtils.randomAlphabetic(0);
//        assertEquals("", randomString);
//    }
//
//    @Test
//    void testRandomAlphabeticWithCountOne() {
//        String randomString = randomStringUtils.randomAlphabetic(1);
//        assertTrue(Character.isLetter(randomString.charAt(0)));
//    }
////
//    @Test
//    void testRandomAlphabeticWithCountTen() {
//        String randomString = randomStringUtils.randomAlphabetic(10);
//        assertEquals(10, randomString.length());
//        assertTrue(randomString.matches("[a-zA-Z]+"));
//    }
//
//    @Test
//    void testRandomAlphabeticWithNegativeMinLengthAndPositiveMaxLength() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            randomStringUtils.randomAlphabetic(-1, 10);
//        });
//    }
//
//    @Test
//    void testRandomAlphabeticWithMinLengthZeroAndMaxLengthOne() {
//        String randomString = randomStringUtils.randomAlphabetic(0, 1);
//        assertTrue(randomString.length() >= 0 && randomString.length() < 1);
//        assertTrue(randomString.matches("[a-zA-Z]*"));
//    }
//
//    @Test
//    void testRandomAlphabeticWithMinLengthOneAndMaxLengthOne() {
//        String randomString = randomStringUtils.randomAlphabetic(1, 1);
//        assertEquals(1, randomString.length());
//        assertTrue(Character.isLetter(randomString.charAt(0)));
//    }
//
//    @Test
//    void testRandomAlphabeticWithMinLengthTenAndMaxLengthTwenty() {
//        String randomString = randomStringUtils.randomAlphabetic(10, 20);
//        assertTrue(randomString.length() >= 10 && randomString.length() < 20);
//        assertTrue(randomString.matches("[a-zA-Z]+"));
//    }
//
//    @Test
//    void testRandomAlphabeticWithMinLengthAndMaxLengthEqual() {
//        String randomString = randomStringUtils.randomAlphabetic(5, 5);
//        assertEquals(5, randomString.length());
//        assertTrue(randomString.matches("[a-zA-Z]+"));
//    }
//
//    @Test
//    void testRandomAlphabeticWithMinLengthGreaterThanMaxLength() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            randomStringUtils.randomAlphabetic(10, 5);
//        });
//    }
////
//    @Test
//    void testRandomAlphabeticUniqueness() {
//        HashSet<String> randomStrings = new HashSet<>();
//        for (int i = 0; i < 100; i++) {
//            String randomString = randomStringUtils.randomAlphabetic(10);
//            assertTrue(randomStrings.add(randomString));
//        }
//    }
    @Test
    @DisplayName("Test randomAlphanumeric with positive count")
    void testRandomAlphanumericPositiveCount() {
        String randomString = RandomStringUtils.randomAlphanumeric(10);
        assertNotNull(randomString);
        assertEquals(10, randomString.length());
        assertTrue(randomString.matches("[a-zA-Z0-9]+"));
    }
    
    @Test
    @DisplayName("Test randomAlphanumeric with negative count")
    void testRandomAlphanumericNegativeCount() {
        assertThrows(IllegalArgumentException.class, () -> {
            RandomStringUtils.randomAlphanumeric(-10);
        });
    }
    
    @Test
    @DisplayName("Test randomAlphanumeric with inclusive minimum and exclusive maximum length")
    void testRandomAlphanumericMinMax() {
        String randomString = RandomStringUtils.randomAlphanumeric(5, 10);
        assertNotNull(randomString);
        assertTrue(randomString.length() >= 5 && randomString.length() < 10);
        assertTrue(randomString.matches("[a-zA-Z0-9]+"));
    }
    @Test
    void testRandomWithCount() {
        String randomString = RandomStringUtils.random(10);
        Assertions.assertEquals(10, randomString.length());
    }
    
    @Test
    void testRandomWithCountAndLetters() {
        String randomString = RandomStringUtils.random(10, true, false);
        Assertions.assertEquals(10, randomString.length());
        Assertions.assertTrue(randomString.matches("[a-zA-Z]+"));
    }
    
    @Test
    void testRandomWithCountAndNumbers() {
        String randomString = RandomStringUtils.random(10, false, true);
        Assertions.assertEquals(10, randomString.length());
        Assertions.assertTrue(randomString.matches("[0-9]+"));
    }
    
    @Test
    void testRandomWithCountAndLettersAndNumbers() {
        String randomString = RandomStringUtils.random(10, true, true);
        Assertions.assertEquals(10, randomString.length());
        Assertions.assertTrue(randomString.matches("[a-zA-Z0-9]+"));
    }
    
    @Test
    void testRandomWithCountAndCharsArray() {
        char[] chars = {'a', 'b', 'c'};
        String randomString = RandomStringUtils.random(10, chars);
        Assertions.assertEquals(10, randomString.length());
        Set<Character> charSet = new HashSet<>(Arrays.asList('a', 'b', 'c'));
        for (char c : randomString.toCharArray()) {
            Assertions.assertTrue(charSet.contains(c));
        }
    }
    
    @Test
    void testRandomWithCountAndStartAndEnd() {
        String randomString = RandomStringUtils.random(10, 65, 90, true, false);
        Assertions.assertEquals(10, randomString.length());
        Assertions.assertTrue(randomString.matches("[A-Z]+"));
    }
    
    @Test
    void testRandomWithCountAndStartAndEndAndLettersAndNumbers() {
        String randomString = RandomStringUtils.random(10, 33, 126, true, true);
        Assertions.assertEquals(10, randomString.length());
        Assertions.assertTrue(randomString.matches("[\\p{Print}]+"));
    }
    
    @Test
    void testRandomWithCountAndStartAndEndAndCharsArray() {
        char[] chars = {'a', 'b', 'c'};
        String randomString = RandomStringUtils.random(10, 0, 2, false, false, chars);
        Assertions.assertEquals(10, randomString.length());
        Set<Character> charSet = new HashSet<>(Arrays.asList('a', 'b', 'c'));
        for (char c : randomString.toCharArray()) {
            Assertions.assertTrue(charSet.contains(c));
        }
    }
    
    @Test
    void testRandomWithCountAndStartAndEndAndLettersAndNumbersAndCharsArray() {
        char[] chars = {'a', 'b', 'c'};
        String randomString = RandomStringUtils.random(10, 0, 2, true, true, chars);
        Assertions.assertEquals(10, randomString.length());
        Set<Character> charSet = new HashSet<>(Arrays.asList('a', 'b', 'c'));
        for (char c : randomString.toCharArray()) {
            Assertions.assertTrue(charSet.contains(c) || Character.isDigit(c));
        }
    }
    
    @Test
    void testRandomWithCountAndCharsString() {
        String randomString = RandomStringUtils.random(10, "abc");
        Assertions.assertEquals(10, randomString.length());
        Set<Character> charSet = new HashSet<>(Arrays.asList('a', 'b', 'c'));
        for (char c : randomString.toCharArray()) {
            Assertions.assertTrue(charSet.contains(c));
        }
    }
    
    @Test
    void testRandomWithInvalidCount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            RandomStringUtils.random(-1);
        });
    }
    
    @Test
    void testRandomWithInvalidCharsArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            char[] chars = {};
            RandomStringUtils.random(10, chars);
        });
    }
    
    @Test
    void testRandomWithInvalidStartAndEnd() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            RandomStringUtils.random(10, 90, 65, true, false);
        });
    }
    
    @Test
    void testRandomWithInvalidCharsArrayAndStartAndEnd() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            char[] chars = {};
            RandomStringUtils.random(10, 0, 2, false, false, chars);
        });
    }
    
    @Test
    void testRandomWithInvalidCharsString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            RandomStringUtils.random(10, "");
        });
    }
    @Test
    void testRandomGraph_withPositiveCount() {
        int count = 5;
        String randomString = RandomStringUtils.randomGraph(count);
        Assertions.assertEquals(count, randomString.length());
        Assertions.assertTrue(randomString.matches("[\\p{Graph}]+"));
    }
    
    @Test
    void testRandomGraph_withNegativeCount() {
        int count = -5;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            RandomStringUtils.randomGraph(count);
        });
    }
    
    @Test
    void testRandomGraph_withMinLengthAndMaxLength() {
        int minLength = 1;
        int maxLength = 10;
        String randomString = RandomStringUtils.randomGraph(minLength, maxLength);
        int length = randomString.length();
        Assertions.assertTrue(length >= minLength && length < maxLength);
        Assertions.assertTrue(randomString.matches("[\\p{Graph}]+"));
    }
    @Test
    void testRandomPrintWithPositiveCount() {
        int count = 10;
        String randomString = RandomStringUtils.randomPrint(count);
        Assertions.assertEquals(count, randomString.length());
    }
    
    @Test
    void testRandomPrintWithNegativeCount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            RandomStringUtils.randomPrint(-1);
        });
    }
    
    @Test
    void testRandomPrintWithMinLengthInclusiveAndMaxLengthExclusive() {
        int minLength = 5;
        int maxLength = 10;
        String randomString = RandomStringUtils.randomPrint(minLength, maxLength);
        Assertions.assertTrue(randomString.length() >= minLength && randomString.length() < maxLength);
    }

}