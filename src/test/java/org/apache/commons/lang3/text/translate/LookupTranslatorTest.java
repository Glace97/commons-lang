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


import com.sun.java.accessibility.util.Translator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class LookupTranslatorTest {
//    Translator translator;
//
//    @BeforeEach
//    void setUp(){
//        translator = new Translator();
//    }
//
//    @Test
//    @DisplayName("Should return 0 when input is empty")
//    void testTranslateWithEmptyInput() throws IOException {
//        Writer writer = new StringWriter();
//        int result = translator.translate("", 0, writer);
//        assertEquals(0, result);
//        assertEquals("", writer.toString());
//    }
//
//    @Test
//    @DisplayName("Should return 0 when translation does not exist for input")
//    void testTranslateWithNoTranslation() throws IOException {
//        Writer writer = new StringWriter();
//        int result = translator.translate("xyz", 0, writer);
//        assertEquals(0, result);
//        assertEquals("", writer.toString());
//    }
//
//    @Test
//    @DisplayName("Should return correct translation length and write translation to output")
//    void testTranslateWithTranslation() throws IOException {
//        Writer writer = new StringWriter();
//        int result = translator.translate("abcdef", 0, writer);
//        assertEquals(2, result);
//        assertEquals("13", writer.toString());
//    }
//
//    @Test
//    @DisplayName("Should handle maximum match correctly")
//    void testTranslateWithMaxMatch() throws IOException {
//        Writer writer = new StringWriter();
//        int result = translator.translate("abcdef", 2, writer);
//        assertEquals(4, result);
//        assertEquals("3", writer.toString());
//    }
//
//    @Test
//    @DisplayName("Should handle input length larger than translation length")
//    void testTranslateWithLongInput() throws IOException {
//        Writer writer = new StringWriter();
//        int result = translator.translate("abcdefgh", 0, writer);
//        assertEquals(2, result);
//        assertEquals("13", writer.toString());
//    }
//
//    @Test
//    @DisplayName("Should handle input length smaller than translation length")
//    void testTranslateWithShortInput() throws IOException {
//        Writer writer = new StringWriter();
//        int result = translator.translate("ab", 0, writer);
//        assertEquals(0, result);
//        assertEquals("", writer.toString());
//    }
//
//    @Test
//    @DisplayName("Should handle input length equal to translation length")
//    void testTranslateWithEqualLengthInput() throws IOException {
//        Writer writer = new StringWriter();
//        int result = translator.translate("cd", 0, writer);
//        assertEquals(2, result);
//        assertEquals("2", writer.toString());
//    }
//
//    @Test
//    @DisplayName("Should handle multiple translations in input")
//    void testTranslateWithMultipleTranslations() throws IOException {
//        Writer writer = new StringWriter();
//        int result = translator.translate("abcedfabef", 0, writer);
//        assertEquals(6, result);
//        assertEquals("13d13", writer.toString());
//    }

}