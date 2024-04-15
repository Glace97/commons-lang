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
    public void testTranslate_returnsTrueForCodePointWithinFFFF() throws IOException {
        Writer writer = new StringWriter();
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper();
        boolean result = unicodeEscaper.translate(65535, writer);
        assertTrue(result);
        assertEquals("\\uFFFF", writer.toString());
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

    @Test
    public void testUnicodeEscaperConstructor() {
        UnicodeEscaper unicodeEscaper = new UnicodeEscaper();
        assertNotNull(unicodeEscaper);
    }

}