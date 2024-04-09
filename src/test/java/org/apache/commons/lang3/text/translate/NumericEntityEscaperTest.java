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


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class NumericEntityEscaperTest {
//    @Test
//    void translate_shouldReturnFalse_whenCodePointBelowRange() throws IOException {
//        Writer writer = new StringWriter();
//        assertFalse(escaper.translate(0, writer));
//        assertEquals("&#0;", writer.toString());
//    }
//
//    @Test
//    void translate_shouldReturnFalse_whenCodePointAboveRange() throws IOException {
//        Writer writer = new StringWriter();
//        assertFalse(escaper.translate(Integer.MAX_VALUE, writer));
//        assertEquals("&#" + Integer.MAX_VALUE + ";", writer.toString());
//    }
//
//    @Test
//    void translate_shouldReturnFalse_whenCodePointWithinRangeAndBetweenIsFalse() throws IOException {
//        NumericEntityEscaper escaper = new NumericEntityEscaper(10, 20, false);
//        Writer writer = new StringWriter();
//        assertFalse(escaper.translate(15, writer));
//        assertEquals("&#15;", writer.toString());
//    }
//
//    @Test
//    void translate_shouldReturnFalse_whenCodePointOutsideRangeAndBetweenIsFalse() throws IOException {
//        NumericEntityEscaper escaper = new NumericEntityEscaper(10, 20, false);
//        Writer writer = new StringWriter();
//        assertFalse(escaper.translate(5, writer));
//        assertEquals("&#5;", writer.toString());
//    }
//
//    @Test
//    void translate_shouldReturnTrue_whenCodePointWithinRangeAndBetweenIsTrue() throws IOException {
//        NumericEntityEscaper escaper = new NumericEntityEscaper(10, 20, true);
//        Writer writer = new StringWriter();
//        assertTrue(escaper.translate(15, writer));
//        assertEquals("&#15;", writer.toString());
//    }
//
//    @Test
//    void translate_shouldReturnTrue_whenCodePointOutsideRangeAndBetweenIsTrue() throws IOException {
//        NumericEntityEscaper escaper = new NumericEntityEscaper(10, 20, true);
//        Writer writer = new StringWriter();
//        assertTrue(escaper.translate(5, writer));
//        assertEquals("&#5;", writer.toString());
//    }
    @Test
    void testNumericEntityEscaperConstructor1() {
        NumericEntityEscaper numericEntityEscaper = new NumericEntityEscaper();
        assertNotNull(numericEntityEscaper);
    }
    
//    @Test
//    void testNumericEntityEscaperRangeConstructor2() {
//        NumericEntityEscaper numericEntityEscaper = new NumericEntityEscaper(0, 127, true);
//        assertNotNull(numericEntityEscaper);
//    }
    
    @Test
    void testNumericEntityEscaperBetweenMethod() {
        NumericEntityEscaper numericEntityEscaper = NumericEntityEscaper.between(0, 127);
        assertNotNull(numericEntityEscaper);
    }
    
//    @Test
//    void testNumericEntityEscaperBelowBoundary() {
//        NumericEntityEscaper numericEntityEscaper = new NumericEntityEscaper(0, 127, true);
//        assertFalse(numericEntityEscaper.between);
//    }
//
//    @Test
//    void testNumericEntityEscaperAboveBoundary() {
//        NumericEntityEscaper numericEntityEscaper = new NumericEntityEscaper(0, 127, true);
//        assertFalse(numericEntityEscaper.between);
//    }
////
//    @Test
//    void testNumericEntityEscaperInsideBoundary() {
//        numericEntityEscaper = new NumericEntityEscaper(0, 127, true);
//        assertTrue(numericEntityEscaper.between);
//    }
////
//    @Test
//    void testNumericEntityEscaperOutsideBoundary() {
//        numericEntityEscaper = new NumericEntityEscaper(0, 127, false);
//        assertFalse(numericEntityEscaper.between);
//    }

    @Test
    public void testNumericEntityEscaperConstructor() {
        NumericEntityEscaper escaper = new NumericEntityEscaper();
        assertNotNull(escaper);
    }

//    @Test
//    public void testNumericEntityEscaperRangeConstructor() {
//        NumericEntityEscaper escaper = new NumericEntityEscaper(10, 20, true);
//        assertNotNull(escaper);
//    }

    @Test
    public void testNumericEntityEscaperBelowMethod() {
        NumericEntityEscaper escaper = NumericEntityEscaper.below(10);
        assertNotNull(escaper);
    }
//    @Test
//    void testInsideRange() {
//        NumericEntityEscaper escaper = NumericEntityEscaper.outsideOf(10, 20);
//        for (int i = 11; i <= 19; i++) {
//            assertEquals(false, escaper.between);
//            assertEquals(i, escaper.below);
//            assertEquals(i, escaper.above);
//        }
////    }
//
//    @Test
//    void testOutsideRange() {
//        NumericEntityEscaper escaper = NumericEntityEscaper.outsideOf(10, 20);
//        for (int i = 1; i <= 30; i++) {
//            if (i >= 10 && i <= 20) {
//                assertEquals(false, escaper.between);
//                assertEquals(i, escaper.below);
//                assertEquals(i, escaper.above);
//            } else {
//                assertEquals(true, escaper.between);
//                assertEquals(0, escaper.below);
//                assertEquals(Integer.MAX_VALUE, escaper.above);
//            }
//        }
//    }
//    @Test
//    @DisplayName("NumericEntityEscaper() - Test with default values")
//    void testNumericEntityEscaperWithDefaultValues() {
//        NumericEntityEscaper escaper = new NumericEntityEscaper();
//        assertEquals(0, escaper.below);
//        assertEquals(Integer.MAX_VALUE, escaper.above);
//        assertTrue(escaper.between);
//    }
////
//    @Test
//    @DisplayName("NumericEntityEscaper(int below, int above, boolean between) - Test with specific values")
//    void testNumericEntityEscaperWithSpecificValues() {
//        NumericEntityEscaper escaper = new NumericEntityEscaper(10, 20, false);
//        assertEquals(10, escaper.below);
//        assertEquals(20, escaper.above);
//        assertFalse(escaper.between);
//    }
//
//    @Test
//    @DisplayName("above(int codePoint) - Test with code point above specified value")
//    void testAboveWithCodePointAboveSpecifiedValue() {
//        NumericEntityEscaper escaper = NumericEntityEscaper.above(100);
//        assertEquals(0, escaper.below);
//        assertEquals(100, escaper.above);
//        assertFalse(escaper.between);
//    }
//
//    @Test
//    @DisplayName("above(int codePoint) - Test with code point below specified value")
//    void testAboveWithCodePointBelowSpecifiedValue() {
//        NumericEntityEscaper escaper = NumericEntityEscaper.above(10);
//        assertEquals(0, escaper.below);
//        assertEquals(10, escaper.above);
//        assertFalse(escaper.between);
//    }

}