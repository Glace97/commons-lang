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

public class NumericEntityUnescaperTest {
    @Test
    @DisplayName("should return 0 when input does not start with '&#'")
    void testTranslateMethodWhenInputDoesNotStartWithNumericEntity() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "abc";
        int index = 0;
        
        // Act
        int result = unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("should return 0 when input length is less than 3")
    void testTranslateMethodWhenInputLengthIsLessThan3() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#";
        int index = 0;
        
        // Act
        int result = unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("should return 0 when input starts with '&#' but next character is not a digit")
    void testTranslateMethodWhenInputStartsWithNumericEntityButNextCharacterIsNotDigit() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#x";
        int index = 0;
        
        // Act
        int result = unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("should return 0 when input starts with '&#' and next character is a digit but there is no semicolon at the end")
    void testTranslateMethodWhenInputStartsWithNumericEntityAndNextCharacterIsDigitButNoSemicolonAtEnd() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#123";
        int index = 0;
        
        // Act
        int result = unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("should return 0 when input starts with '&#' and next character is a digit but semicolon is required")
    void testTranslateMethodWhenInputStartsWithNumericEntityAndNextCharacterIsDigitButSemicolonIsRequired() throws IOException {
        // Arrange
        NumericEntityUnescaper unescaper = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonRequired);
        StringWriter writer = new StringWriter();
        String input = "&#123;";
        int index = 0;
        
        // Act
        int result = unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("should throw IllegalArgumentException when input starts with '&#' and next character is a digit but semicolon is missing and errorIfNoSemiColon option is set")
    void testTranslateMethodWhenInputStartsWithNumericEntityAndNextCharacterIsDigitButSemicolonIsMissingAndErrorOptionIsSet() {
        // Arrange
        NumericEntityUnescaper unescaper = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.errorIfNoSemiColon);
        StringWriter writer = new StringWriter();
        String input = "&#123";
        int index = 0;
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> unescaper.translate(input, index, writer));
    }
    
    @Test
    @DisplayName("should return 0 when input starts with '&#' and next character is a digit but semicolon is missing and errorIfNoSemiColon option is not set")
    void testTranslateMethodWhenInputStartsWithNumericEntityAndNextCharacterIsDigitButSemicolonIsMissingAndErrorOptionIsNotSet() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#123";
        int index = 0;
        
        // Act
        int result = unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("should return 0 when input starts with '&#x' but there is no character code after it")
    void testTranslateMethodWhenInputStartsWithHexNumericEntityButNoCharacterCode() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#x;";
        int index = 0;
        
        // Act
        int result = unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("should return 0 when input starts with '&#x' and character code is not a valid hexadecimal number")
    void testTranslateMethodWhenInputStartsWithHexNumericEntityAndCharacterCodeIsInvalid() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#xinvalid;";
        int index = 0;
        
        // Act
        int result = unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("should return 0 when input starts with '&#x' and character code is a valid hexadecimal number but semicolon is missing")
    void testTranslateMethodWhenInputStartsWithHexNumericEntityAndCharacterCodeIsValidButSemicolonIsMissing() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#x123";
        int index = 0;
        
        // Act
        int result = unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("should return correct number of characters written when input starts with '&#x' and character code is a valid hexadecimal number and semicolon is present")
    void testTranslateMethodWhenInputStartsWithHexNumericEntityAndCharacterCodeIsValidAndSemicolonIsPresent() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#x123;";
        int index = 0;
        
        // Act
        int result = unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals(6, result);
    }
    
    @Test
    @DisplayName("should return 0 when input starts with '&#' and character code is not a valid decimal number")
    void testTranslateMethodWhenInputStartsWithDecimalNumericEntityAndCharacterCodeIsInvalid() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#invalid;";
        int index = 0;
        
        // Act
        int result = unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("should return 0 when input starts with '&#' and character code is a valid decimal number but semicolon is missing")
    void testTranslateMethodWhenInputStartsWithDecimalNumericEntityAndCharacterCodeIsValidButSemicolonIsMissing() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#123";
        int index = 0;
        
        // Act
        int result = unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("should return correct number of characters written when input starts with '&#' and character code is a valid decimal number and semicolon is present")
    void testTranslateMethodWhenInputStartsWithDecimalNumericEntityAndCharacterCodeIsValidAndSemicolonIsPresent() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#123;";
        int index = 0;
        
        // Act
        int result = unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals(5, result);
    }
    
    @Test
    @DisplayName("should write correct character when input starts with '&#x' and character code is a valid hexadecimal number and semicolon is present")
    void testTranslateMethodWhenInputStartsWithHexNumericEntityAndCharacterCodeIsValidAndSemicolonIsPresentAndCharacterIsWithinBMP() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#x61;";
        int index = 0;
        
        // Act
        unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals("a", writer.toString());
    }
    
    @Test
    @DisplayName("should write correct characters when input starts with '&#x' and character code is a valid hexadecimal number and semicolon is present and character is beyond BMP")
    void testTranslateMethodWhenInputStartsWithHexNumericEntityAndCharacterCodeIsValidAndSemicolonIsPresentAndCharacterIsBeyondBMP() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#x1F600;";
        int index = 0;
        
        // Act
        unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals("\uD83D\uDE00", writer.toString());
    }
    
    @Test
    @DisplayName("should write correct characters when input starts with '&#' and character code is a valid decimal number and semicolon is present and character is within BMP")
    void testTranslateMethodWhenInputStartsWithDecimalNumericEntityAndCharacterCodeIsValidAndSemicolonIsPresentAndCharacterIsWithinBMP() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#97;";
        int index = 0;
        
        // Act
        unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals("a", writer.toString());
    }
    
    @Test
    @DisplayName("should write correct characters when input starts with '&#' and character code is a valid decimal number and semicolon is present and character is beyond BMP")
    void testTranslateMethodWhenInputStartsWithDecimalNumericEntityAndCharacterCodeIsValidAndSemicolonIsPresentAndCharacterIsBeyondBMP() throws IOException {
        // Arrange
        StringWriter writer = new StringWriter();
        String input = "&#128512;";
        int index = 0;
        
        // Act
        unescaper.translate(input, index, writer);
        
        // Assert
        assertEquals("\uD83D\uDE00", writer.toString());
    }
    @Test
    void testIsSet_SemiColonRequired() {
        unescaper = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonRequired);
        assertTrue(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonRequired));
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonOptional));
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.errorIfNoSemiColon));
    }
    
    @Test
    void testIsSet_SemiColonOptional() {
        unescaper = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonOptional);
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonRequired));
        assertTrue(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonOptional));
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.errorIfNoSemiColon));
    }
    
    @Test
    void testIsSet_ErrorIfNoSemiColon() {
        unescaper = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.errorIfNoSemiColon);
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonRequired));
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonOptional));
        assertTrue(unescaper.isSet(NumericEntityUnescaper.OPTION.errorIfNoSemiColon));
    }
    
    @Test
    void testIsSet_NoOptions() {
        unescaper = new NumericEntityUnescaper();
        assertTrue(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonRequired));
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonOptional));
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.errorIfNoSemiColon));
    }
    
    @Test
    void testIsSet_NullOption() {
        unescaper = new NumericEntityUnescaper(null);
        assertTrue(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonRequired));
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.semiColonOptional));
        assertFalse(unescaper.isSet(NumericEntityUnescaper.OPTION.errorIfNoSemiColon));
    }

}