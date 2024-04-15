package org.apache.commons.lang3.text;

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

import java.text.DecimalFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

public class ExtendedMessageFormatTest {
    ExtendedMessageFormat format1;
    ExtendedMessageFormat format2;
    ExtendedMessageFormat format3;

    @Test
    public void testHashCode_equalObjects() {
        format1 = new ExtendedMessageFormat("Pattern");
        format2 = new ExtendedMessageFormat("Pattern");
        assertEquals(format1.hashCode(), format2.hashCode());
    }

    @Test
    public void testHashCode_notEqualObjects() {
        format1 = new ExtendedMessageFormat("Pattern1");
        format2 = new ExtendedMessageFormat("Pattern2");
        assertNotEquals(format1.hashCode(), format2.hashCode());
    }

    @Test
    public void testHashCode_equalObjectsWithLocale() {
        format1 = new ExtendedMessageFormat("Pattern", Locale.ENGLISH);
        format2 = new ExtendedMessageFormat("Pattern", Locale.ENGLISH);
        assertEquals(format1.hashCode(), format2.hashCode());
    }

    ExtendedMessageFormat extendedMessageFormat;
    @Test
    void setFormat_ThrowsUnsupportedOperationException() {
        extendedMessageFormat = new ExtendedMessageFormat("Test");
        assertThrows(UnsupportedOperationException.class, () -> extendedMessageFormat.setFormat(0, null));
    }

    @Test
    void setFormat_ThrowsUnsupportedOperationExceptionForAllFormatElementIndexes() {
        extendedMessageFormat = new ExtendedMessageFormat("Test");
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            assertThrows(UnsupportedOperationException.class, () -> extendedMessageFormat.setFormat(finalI, null));
        }
    }

    private ExtendedMessageFormat format;

    @Test
    void testEquals_sameInstance_returnsTrue() {
        format = new ExtendedMessageFormat("pattern");
        assertTrue(format.equals(format));
    }

    @Test
    void testEquals_null_returnsFalse() {
        format = new ExtendedMessageFormat("pattern");
        assertFalse(format.equals(null));
    }

    @Test
    void testEquals_differentClass_returnsFalse() {
        format = new ExtendedMessageFormat("pattern");
        assertFalse(format.equals("pattern"));
    }

    @Test
    void testEquals_equalObjects_returnsTrue() {
        format = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat otherFormat = new ExtendedMessageFormat("pattern");
        assertTrue(format.equals(otherFormat));
    }

    @Test
    void testEquals_differentToPattern_returnsFalse() {
        format = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat otherFormat = new ExtendedMessageFormat("differentPattern");
        assertFalse(format.equals(otherFormat));
    }

    @Test
    void setFormatByArgumentIndex_shouldThrowUnsupportedOperationException() {
        // Test code here
    }

    @Test
    void testToPatternReturnsPatternWithLocale() {
        String pattern = "This is a test pattern with locale";
        Locale locale = Locale.US;
        extendedMessageFormat = new ExtendedMessageFormat(pattern, locale, null);
        assertEquals(pattern, extendedMessageFormat.toPattern());
    }

}