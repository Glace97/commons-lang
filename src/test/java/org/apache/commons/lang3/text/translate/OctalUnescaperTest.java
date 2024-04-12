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

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class OctalUnescaperTest {
        private OctalUnescaper octalUnescaper;
    
        @BeforeEach
        void setUp() {
            octalUnescaper = new OctalUnescaper();
        }

    //@Test
        void testTranslateSingleDigitOctal() throws IOException {
            Writer writer = new StringWriter();
            int result = octalUnescaper.translate("\\0", 0, writer);
            assertEquals(2, result);
            assertEquals(0, writer.toString());
        }

    //@Test
        void testTranslateDoubleDigitOctal() throws IOException {
            Writer writer = new StringWriter();
            int result = octalUnescaper.translate("\\77", 0, writer);
            assertEquals(3, result);
            assertEquals(63, writer.toString());
        }

    //@Test
        void testTranslateTripleDigitOctal() throws IOException {
            Writer writer = new StringWriter();
            int result = octalUnescaper.translate("\\377", 0, writer);
            assertEquals(4, result);
            assertEquals(255, writer.toString());
        }
    
        @Test
        void testTranslateInvalidOctal() throws IOException {
            Writer writer = new StringWriter();
            int result = octalUnescaper.translate("\\8", 0, writer);
            assertEquals(0, result);
            assertEquals("", writer.toString());
        }
    
        @Test
        void testTranslateInvalidEscapeSequence() throws IOException {
            Writer writer = new StringWriter();
            int result = octalUnescaper.translate("\\x", 0, writer);
            assertEquals(0, result);
            assertEquals("", writer.toString());
        }
    
        @Test
        void testTranslateNoBackslash() throws IOException {
            Writer writer = new StringWriter();
            int result = octalUnescaper.translate("0", 0, writer);
            assertEquals(0, result);
            assertEquals("", writer.toString());
        }
    
        @Test
        void testTranslateBackslashAtEnd() throws IOException {
            Writer writer = new StringWriter();
            int result = octalUnescaper.translate("abc\\", 3, writer);
            assertEquals(0, result);
            assertEquals("", writer.toString());
        }
    
        @Test
        void testTranslateBackslashAtStart() throws IOException {
            Writer writer = new StringWriter();
            int result = octalUnescaper.translate("\\abc", 0, writer);
            assertEquals(0, result);
            assertEquals("", writer.toString());
        }

}