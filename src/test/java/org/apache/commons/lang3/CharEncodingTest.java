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

public class CharEncodingTest {
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    import static org.junit.jupiter.api.Assertions.*;
    
    @TestInstance(Lifecycle.PER_CLASS)
    class CharEncodingTestSuite {
    
        @Test
        void testIsSupportedWithValidCharset() {
            assertTrue(CharEncoding.isSupported("ISO-8859-1"));
            assertTrue(CharEncoding.isSupported("US-ASCII"));
            assertTrue(CharEncoding.isSupported("UTF-16"));
            assertTrue(CharEncoding.isSupported("UTF-16BE"));
            assertTrue(CharEncoding.isSupported("UTF-16LE"));
            assertTrue(CharEncoding.isSupported("UTF-8"));
        }
    
        @Test
        void testIsSupportedWithInvalidCharset() {
            assertFalse(CharEncoding.isSupported("InvalidCharset"));
        }
    
        @Test
        void testIsSupportedWithNullCharset() {
            assertFalse(CharEncoding.isSupported(null));
        }
    }

}