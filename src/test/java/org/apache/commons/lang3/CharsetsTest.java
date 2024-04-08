package org.apache.commons.lang3;

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

public class CharsetsTest {
    import static org.junit.jupiter.api.Assertions.assertEquals;
    
    import org.junit.jupiter.api.Test;
    
    class CharsetsTest {
    
        @Test
        void shouldReturnDefaultCharsetNameWhenCharsetNameIsNull() {
            // Test implementation here
        }
    
        @Test
        void shouldReturnGivenCharsetNameWhenCharsetNameIsNotNull() {
            // Test implementation here
        }
    
        @Test
        void shouldReturnUtf8WhenCharsetNameIsEmptyString() {
            // Test implementation here
        }
        
        @Test
        void shouldReturnGivenCharsetNameWhenCharsetNameIsValidCharsetName() {
            // Test implementation here
        }
        
        @Test
        void shouldThrowUnsupportedCharsetExceptionWhenCharsetNameIsInvalidCharsetName() {
            // Test implementation here
        }
    }
    @Test
    @DisplayName("Returns the given charset if not null")
    void returnsGivenCharsetIfNotNull() {
        Charset charset = Charset.forName("UTF-8");
        Charset result = Charsets.toCharset(charset);
        Assertions.assertEquals(charset, result);
    }
    
    @Test
    @DisplayName("Returns the default charset if given charset is null")
    void returnsDefaultCharsetIfGivenCharsetIsNull() {
        Charset defaultCharset = Charset.defaultCharset();
        Charset result = Charsets.toCharset(null);
        Assertions.assertEquals(defaultCharset, result);
    }
    
    @Test
    @DisplayName("Returns the given charset if not null")
    void returnsGivenCharsetIfNotNull() {
        String charsetName = "UTF-8";
        Charset charset = Charset.forName(charsetName);
        Charset result = Charsets.toCharset(charsetName);
        Assertions.assertEquals(charset, result);
    }
    
    @Test
    @DisplayName("Returns the default charset if given charset is null")
    void returnsDefaultCharsetIfGivenCharsetIsNull() {
        Charset defaultCharset = Charset.defaultCharset();
        Charset result = Charsets.toCharset(null);
        Assertions.assertEquals(defaultCharset, result);
    }
    
    @Test
    @DisplayName("Throws UnsupportedCharsetException if given charset name is invalid")
    void throwsUnsupportedCharsetExceptionForInvalidCharsetName() {
        String invalidCharsetName = "InvalidCharset";
        Assertions.assertThrows(UnsupportedCharsetException.class, () -> {
            Charsets.toCharset(invalidCharsetName);
        });
    }

}