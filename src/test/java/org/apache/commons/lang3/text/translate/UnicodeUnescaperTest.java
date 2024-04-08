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

public class UnicodeUnescaperTest {
    @Test
    void testTranslate_whenValidInputWithUnicodeValue_shouldWriteCorrectCharacter() throws IOException {
        CharSequence input = "\\u0061";
        int index = 0;
    
        int translated = unescaper.translate(input, index, writer);
    
        assertEquals(6, translated);
        assertEquals("a", writer.toString());
    }
    
    @Test
    void testTranslate_whenValidInputWithUnicodeValueAndAdditionalUChars_shouldWriteCorrectCharacter() throws IOException {
        CharSequence input = "\\uuu0061";
        int index = 0;
    
        int translated = unescaper.translate(input, index, writer);
    
        assertEquals(7, translated);
        assertEquals("a", writer.toString());
    }
    
    @Test
    void testTranslate_whenValidInputWithUnicodeValueAndPlusChar_shouldWriteCorrectCharacter() throws IOException {
        CharSequence input = "\\u+0061";
        int index = 0;
    
        int translated = unescaper.translate(input, index, writer);
    
        assertEquals(7, translated);
        assertEquals("a", writer.toString());
    }
    
    @Test
    void testTranslate_whenValidInputWithInvalidUnicodeValue_shouldThrowException() {
        CharSequence input = "\\u00g1";
        int index = 0;
    
        assertThrows(IllegalArgumentException.class, () -> unescaper.translate(input, index, writer));
    }
    
    @Test
    void testTranslate_whenInputEndsWithoutEnoughHexDigits_shouldThrowException() {
        CharSequence input = "\\u006";
        int index = 0;
    
        assertThrows(IllegalArgumentException.class, () -> unescaper.translate(input, index, writer));
    }
    
    @Test
    void testTranslate_whenInputEndsWithoutEnoughHexDigitsDueToEndOfCharSequence_shouldThrowException() {
        CharSequence input = "\\u006";
        int index = 0;
    
        assertThrows(IllegalArgumentException.class, () -> unescaper.translate(input, index, writer));
    }
    
    @Test
    void testTranslate_whenInvalidInput_shouldReturnZero() throws IOException {
        CharSequence input = "abc";
        int index = 0;
    
        int translated = unescaper.translate(input, index, writer);
    
        assertEquals(0, translated);
        assertEquals("", writer.toString());
    }

}