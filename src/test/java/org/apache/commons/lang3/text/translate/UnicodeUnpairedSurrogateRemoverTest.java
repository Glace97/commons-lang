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

public class UnicodeUnpairedSurrogateRemoverTest {
    @Test
    @DisplayName("Test translate with valid surrogate pair")
    void testValidSurrogatePair() throws IOException {
        // Arrange
        int codePoint = 0xD83D;
    
        // Act
        boolean translated = remover.translate(codePoint, writer);
    
        // Assert
        assertTrue(translated);
        assertEquals("", writer.toString());
    }
    
    @Test
    @DisplayName("Test translate with invalid surrogate pair")
    void testInvalidSurrogatePair() throws IOException {
        // Arrange
        int codePoint = 0xD83D;
    
        // Act
        boolean translated = remover.translate(codePoint, writer);
    
        // Assert
        assertTrue(translated);
        assertEquals("", writer.toString());
    }
    
    @Test
    @DisplayName("Test translate with valid non-surrogate code point")
    void testValidNonSurrogateCodePoint() throws IOException {
        // Arrange
        int codePoint = 'A';
    
        // Act
        boolean translated = remover.translate(codePoint, writer);
    
        // Assert
        assertFalse(translated);
        assertEquals("A", writer.toString());
    }
    
    @Test
    @DisplayName("Test translate with invalid non-surrogate code point")
    void testInvalidNonSurrogateCodePoint() throws IOException {
        // Arrange
        int codePoint = Character.MAX_CODE_POINT + 1;
    
        // Act
        boolean translated = remover.translate(codePoint, writer);
    
        // Assert
        assertFalse(translated);
        assertEquals(Character.toString(codePoint), writer.toString());
    }

}