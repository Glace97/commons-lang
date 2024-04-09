package org.apache.commons.lang3.text.translate;

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

public class JavaUnicodeEscaperTest {
    @Test
    @DisplayName("should return \\uXXXX\\uXXXX format for valid code point")
    void shouldReturnUtf16EscapeString() {
        JavaUnicodeEscaper escaper = new JavaUnicodeEscaper(0, Integer.MAX_VALUE, true);
        int codePoint = 65; // 'A'
        String expected = "\\u0041\\u0000";

        String result = escaper.toUtf16Escape(codePoint);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("should return \\uXXXX\\uXXXX format for surrogate pair")
    void shouldReturnUtf16EscapeStringForSurrogatePair() {
        JavaUnicodeEscaper escaper = new JavaUnicodeEscaper(0, Integer.MAX_VALUE, true);
        int codePoint = 128525; // 😄
        String expected = "\\uD83D\\uDE04";

        String result = escaper.toUtf16Escape(codePoint);

        Assertions.assertEquals(expected, result);
    }

//    @Test
//    @DisplayName("should create JavaUnicodeEscaper object with correct values")
//    void shouldCreateJavaUnicodeEscaperObject() {
//        int below = 0;
//        int above = 100;
//        boolean between = true;
//
//        JavaUnicodeEscaper escaper = new JavaUnicodeEscaper(below, above, between);
//
//        Assertions.assertEquals(below, escaper.getBelow());
//        Assertions.assertEquals(above, escaper.getAbove());
//        Assertions.assertEquals(between, escaper.isBetween());
//    }

    @Test
    @DisplayName("should handle lowest code point boundary correctly")
    void shouldHandleLowestCodePointBoundary() {
        JavaUnicodeEscaper escaper = new JavaUnicodeEscaper(0, Integer.MAX_VALUE, true);
        int codePoint = 0;
        String expected = "\\u0000\\u0000";

        String result = escaper.toUtf16Escape(codePoint);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("should handle highest code point boundary correctly")
    void shouldHandleHighestCodePointBoundary() {
        JavaUnicodeEscaper escaper = new JavaUnicodeEscaper(0, Integer.MAX_VALUE, true);
        int codePoint = Integer.MAX_VALUE;
        String expected = "\\uDFFF\\uFFFF";

        String result = escaper.toUtf16Escape(codePoint);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("should handle code points outside the specified range")
    void shouldHandleCodePointsOutsideRange() {
        JavaUnicodeEscaper escaper = new JavaUnicodeEscaper(65, 90, true);
        int codePoint = 97; // 'a'
        String expected = "\\u0061\\u0000";

        String result = escaper.toUtf16Escape(codePoint);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("should handle code points between the specified range")
    void shouldHandleCodePointsBetweenRange() {
        JavaUnicodeEscaper escaper = new JavaUnicodeEscaper(65, 90, true);
        int codePoint = 80; // 'P'
        String expected = "\\u0050\\u0000";

        String result = escaper.toUtf16Escape(codePoint);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("should escape surrogate pair correctly")
    void shouldEscapeSurrogatePair() {
        JavaUnicodeEscaper escaper = new JavaUnicodeEscaper(0, Integer.MAX_VALUE, true);
        int codePoint = 128525; // 😄
        String expected = "\\uD83D\\uDE04";

        String result = escaper.toUtf16Escape(codePoint);

        Assertions.assertEquals(expected, result);
    }


    @Test
    void testBetweenConstructor() {
        JavaUnicodeEscaper escaper = new JavaUnicodeEscaper(65, 90, true);
        assertNotNull(escaper);
    }

//    @Test
//    void testBetweenEscape1(int codePoint) {
//        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.between(65, 90);
//        String result = escaper.escape(Character.toString((char) codePoint));
//        assertEquals("\\u" + Integer.toHexString(codePoint), result);
//    }
//
//    @Test
//    void testBetweenBoundaryEscape() {
//        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.between(65, 90);
//        String result = escaper.escape(Character.toString((char) 65));
//        assertEquals("\\u0041", result);
//        result = escaper.escape(Character.toString((char) 90));
//        assertEquals("\\u005A", result);
//    }
//
//    @Test
//    void testBetweenNoEscape(int codePoint) {
//        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.between(65, 90);
//        String result = escaper.escape(Character.toString((char) codePoint));
//        assertEquals(Character.toString((char) codePoint), result);
//    }

    @Test
    public void testJavaUnicodeEscaperConstructor() {
        // Test for below boundary
        JavaUnicodeEscaper escaper1 = new JavaUnicodeEscaper(0, 10, false);
        assertNotNull(escaper1);

        // Test for above boundary
        JavaUnicodeEscaper escaper2 = new JavaUnicodeEscaper(0, 10, true);
        assertNotNull(escaper2);
    }

    @Test
    public void testJavaUnicodeEscaperBelow() {
        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.below(10);
        assertNotNull(escaper);
    }

    // Your Java code here
//    @Test
//    @DisplayName("should escape characters outside the specified range")
//    void shouldEscapeCharactersOutsideRange() {
//        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.outsideOf(65, 90);
//        assertEquals("\\u0041", escaper.escape("A"));
//        assertEquals("B", escaper.escape("B"));
//        assertEquals("\\u005A", escaper.escape("Z"));
//        assertEquals("a", escaper.escape("a"));
//        assertEquals("\\u007A", escaper.escape("z"));
//    }
//
//    @Test
//    @DisplayName("should not escape characters within the specified range")
//    void shouldNotEscapeCharactersWithinRange() {
//        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.outsideOf(65, 90);
//        assertEquals("A", escaper.escape("A"));
//        assertEquals("B", escaper.escape("B"));
//        assertEquals("Z", escaper.escape("Z"));
//    }
//
//    @Test
//    @DisplayName("should escape characters above the specified range")
//    void shouldEscapeCharactersAboveRange() {
//        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.outsideOf(65, 90);
//        assertEquals("\\u00C0", escaper.escape("À"));
//        assertEquals("\\u0100", escaper.escape("Ā"));
//        assertEquals("\\u1E00", escaper.escape("Ḁ"));
//        assertEquals("\\uFFFD", escaper.escape("�"));
//    }
//
//    @Test
//    @DisplayName("should escape characters below the specified range")
//    void shouldEscapeCharactersBelowRange() {
//        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.outsideOf(65, 90);
//        assertEquals("\\u0000", escaper.escape("\0"));
//        assertEquals("\\u001F", escaper.escape("\u001F"));
//        assertEquals("\\u0020", escaper.escape(" "));
//        assertEquals("\\u0061", escaper.escape("a"));
//    }

    @Test
    @DisplayName("Constructs JavaUnicodeEscaper instance with valid input")
    void testConstructorWithValidInput() {
        JavaUnicodeEscaper escaper = new JavaUnicodeEscaper(0, 10, true);
        assertNotNull(escaper);
    }

    @Test
    @DisplayName("Constructs JavaUnicodeEscaper instance with below and above values reversed")
    void testConstructorWithReversedValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            new JavaUnicodeEscaper(10, 0, true);
        });
    }

    @Test
    @DisplayName("Returns JavaUnicodeEscaper instance above the specified code point")
    void testAboveMethod() {
        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.above(100);
        assertNotNull(escaper);
    }

    // Add more tests to cover different edge cases and scenarios

}