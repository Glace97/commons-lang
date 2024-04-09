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


import org.apache.commons.text.translate.NumericEntityEscaper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class UnicodeEscaperTest {
    @Test
    public void testTranslate_returnsFalseForCodePointBelowRange() throws IOException, IOException {
        Writer writer = new StringWriter();
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper();
        boolean result = unicodeEscaper.translate(0, writer);
        assertFalse(result);
        assertEquals("", writer.toString());
    }

    @Test
    public void testTranslate_returnsFalseForCodePointAboveRange() throws IOException {
        Writer writer = new StringWriter();
        NumericEntityEscaper unicodeEscaper = new NumericEntityEscaper();
        boolean result = unicodeEscaper.translate(1114112, writer);
        assertFalse(result);
        assertEquals("", writer.toString());
    }

    @Test
    public void testTranslate_returnsFalseForCodePointWithinRange() throws IOException {
        Writer writer = new StringWriter();
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper();
        boolean result = unicodeEscaper.translate(100, writer);
        assertFalse(result);
        assertEquals("", writer.toString());
    }

    @Test
    public void testTranslate_returnsTrueForCodePointAboveFFFF() throws IOException {
        Writer writer = new StringWriter();
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper();
        boolean result = unicodeEscaper.translate(1114113, writer);
        assertTrue(result);
        assertEquals("\\uD801\\uDC01", writer.toString());
    }

    @Test
    public void testTranslate_returnsTrueForCodePointWithinFFFF() throws IOException {
        Writer writer = new StringWriter();
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper();
        boolean result = unicodeEscaper.translate(65535, writer);
        assertTrue(result);
        assertEquals("\\uFFFF", writer.toString());
    }

    @Test
    void toUtf16Escape_shouldReturnCorrectHexadecimalString() {
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper();
        assertEquals("\\u0000", unicodeEscaper.toUtf16Escape(0));
        assertEquals("\\u0020", unicodeEscaper.toUtf16Escape(32));
        assertEquals("\\u00A9", unicodeEscaper.toUtf16Escape(169));
        assertEquals("\\uD83D\\uDE00", unicodeEscaper.toUtf16Escape(128512));
        assertEquals("\\uFFFF", unicodeEscaper.toUtf16Escape(65535));
    }

    @Test
    void toUtf16Escape_shouldReturnEmptyStringForCodePointsBelowLowerBound() {
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper();
        NumericEntityEscaper unicodeEscapxer = new NumericEntityEscaper();
        assertEquals("", unicodeEscaper.toUtf16Escape(-1));
        assertEquals("", unicodeEscaper.toUtf16Escape(-100));
        assertEquals("", unicodeEscaper.toUtf16Escape(Integer.MIN_VALUE));
    }

    @Test
    void toUtf16Escape_shouldReturnEmptyStringForCodePointsAboveUpperBound() {
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper();
        assertEquals("", unicodeEscaper.toUtf16Escape(65536));
        assertEquals("", unicodeEscaper.toUtf16Escape(100000));
        assertEquals("", unicodeEscaper.toUtf16Escape(Integer.MAX_VALUE));
    }

    @Test
    void toUtf16Escape_shouldReturnEmptyStringForCodePointsEqualToLowerBound() {
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper();
        assertEquals("", unicodeEscaper.toUtf16Escape(0));
    }

    @Test
    void toUtf16Escape_shouldReturnEmptyStringForCodePointsEqualToUpperBound() {
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper();
        assertEquals("", unicodeEscaper.toUtf16Escape(65535));
    }

    @Test
    void testConstructor() {
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper();
        assertNotNull(unicodeEscaper);
    }

    @Test
    void testBetween() {
        UnicodeEscaper betweenEscaper = UnicodeEscaper.between(65, 90);
        assertNotNull(betweenEscaper);
    }

    @Test
    void testBetweenBelowBoundary() {
        UnicodeEscaper belowBoundaryEscaper = UnicodeEscaper.between(0, 9);
        assertNotNull(belowBoundaryEscaper);
    }

    @Test
    void testBetweenAboveBoundary() {
        UnicodeEscaper aboveBoundaryEscaper = UnicodeEscaper.between(100, 200);
        assertNotNull(aboveBoundaryEscaper);
    }

    @Test
    void testBetweenOutsideBoundary() {
        UnicodeEscaper outsideBoundaryEscaper = UnicodeEscaper.between(50, 60);
        assertNotNull(outsideBoundaryEscaper);
    }

    @Test
    void testBetweenBoundaryInclusive() {
        UnicodeEscaper inclusiveBoundaryEscaper = UnicodeEscaper.between(20, 50);
        assertNotNull(inclusiveBoundaryEscaper);
    }

    @Test
    void testBetweenBoundaryExclusive() {
        UnicodeEscaper exclusiveBoundaryEscaper = UnicodeEscaper.between(20, 50);
        assertNotNull(exclusiveBoundaryEscaper);
    }

    @Test
    void testUnicodeEscaperConstructor2() {
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper();
        assertNotNull(unicodeEscaper);
    }

    @Test
    void testUnicodeEscaperConstructorWithRange2() {
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper(10, 20, true);
        assertNotNull(unicodeEscaper);
    }

    @Test
    void testUnicodeEscaperBelow() {
        UnicodeEscaper belowEscaper = UnicodeEscaper.below(10);
        assertNotNull(belowEscaper);
    }

    @Test
    void testUnicodeEscaperBelowOutsideOfRange() {
        UnicodeEscaper belowEscaper = UnicodeEscaper.below(10000);
        assertNotNull(belowEscaper);
    }


//    @Test
//    void testOutsideOf_lowerBoundary() {
//        UnicodeEscaper escaper = UnicodeEscaper.outsideOf(0, 127);
//        assertFalse(escaper.between);
//        assertEquals(0, escaper.below);
//        assertEquals(127, escaper.above);
////    }
//
//    @Test
//    void testOutsideOf_upperBoundary() {
//        UnicodeEscaper escaper = UnicodeEscaper.outsideOf(128, 255);
//        assertFalse(escaper.between);
//        assertEquals(128, escaper.below);
//        assertEquals(255, escaper.above);
//    }

//    @Test
//    void testOutsideOf_betweenTrue() {
//        UnicodeEscaper escaper = UnicodeEscaper.outsideOf(32, 126);
//        assertTrue(escaper.between);
//        assertEquals(32, escaper.below);
//        assertEquals(126, escaper.above);
//    }
//
//    @Test
//    void testOutsideOf_betweenFalse() {
//        UnicodeEscaper escaper = UnicodeEscaper.outsideOf(32, 126);
//        assertFalse(escaper.between);
//        assertEquals(32, escaper.below);
//        assertEquals(126, escaper.above);
//    }

    @Test
    public void testUnicodeEscaperConstructor() {
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper();
        assertNotNull(unicodeEscaper);
    }

//    @Test
//    public void testUnicodeEscaperConstructorWithRange() {
//        UnicodeEscaper unicodeEscaper = new UnicodeEscaper(32, 126, true);
//        assertNotNull(unicodeEscaper);
//        assertEquals(32, unicodeEscaper.below);
//        assertEquals(126, unicodeEscaper.above);
//        assertTrue(unicodeEscaper.between);
//    }
//
//    @Test
//    public void testUnicodeEscaperAbove() {
//        UnicodeEscaper unicodeEscaper = UnicodeEscaper.above(100);
//        assertNotNull(unicodeEscaper);
//        assertEquals(0, unicodeEscaper.below);
//        assertEquals(100, unicodeEscaper.above);
//        assertFalse(unicodeEscaper.between);
//    }

}