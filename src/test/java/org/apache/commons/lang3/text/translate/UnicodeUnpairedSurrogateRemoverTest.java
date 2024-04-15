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

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
public class UnicodeUnpairedSurrogateRemoverTest {
    private UnicodeUnpairedSurrogateRemover remover;

    @BeforeEach
    void setUp() {
        remover = new UnicodeUnpairedSurrogateRemover();
    }

    @Test
    @DisplayName("Translate should return true for surrogate characters")
    void testTranslateSurrogateCharacters() throws IOException {
        // Surrogate characters range from \uD800 to \uDFFF
        for (int i = Character.MIN_SURROGATE; i <= Character.MAX_SURROGATE; i++) {
            Writer writer = new StringWriter();
            assertTrue(remover.translate(i, writer));
            assertEquals("", writer.toString());
        }
    }

    @Test
    @DisplayName("Translate should return false for non-surrogate characters")
    void testTranslateNonSurrogateCharacters() throws IOException {
        // Test some non-surrogate characters
        assertFalse(remover.translate('A', new StringWriter()));
        assertFalse(remover.translate('Z', new StringWriter()));
        assertFalse(remover.translate('1', new StringWriter()));
        assertFalse(remover.translate('$', new StringWriter()));
    }


    @Test
    @DisplayName("Translate should not write anything to Writer for surrogate characters")
    void testTranslateOutputForSurrogateCharacters() throws IOException {
        StringWriter writer = new StringWriter();
        assertTrue(remover.translate(Character.MIN_SURROGATE, writer));
        assertTrue(remover.translate(Character.MAX_SURROGATE, writer));
        assertEquals("", writer.toString());
    }

    @Test
    @DisplayName("Translate should not write anything to Writer for non-surrogate characters")
    void testTranslateOutputForNonSurrogateCharacters() throws IOException {
        StringWriter writer = new StringWriter();
        assertFalse(remover.translate('A', writer));
        assertFalse(remover.translate('$', writer));
        assertEquals("", writer.toString());
    }

}