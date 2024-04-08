package org.apache.commons.lang3.builder;

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

public class IDKeyTest {
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;
    
    public class IDKeyTestSuite {
    
        @Test
        void testHashCode() {
            IDKey key1 = new IDKey("test");
            IDKey key2 = new IDKey("test");
    
            assertEquals(key1.hashCode(), key2.hashCode());
        }
    
        @Test
        void testHashCodeDifferentObjects() {
            IDKey key1 = new IDKey("test1");
            IDKey key2 = new IDKey("test2");
    
            assertNotEquals(key1.hashCode(), key2.hashCode());
        }
    
        @Test
        void testHashCodeNullObject() {
            IDKey key1 = new IDKey(null);
            IDKey key2 = new IDKey(null);
    
            assertEquals(key1.hashCode(), key2.hashCode());
        }
    
        @Test
        void testHashCodeLargeObject() {
            String largeString = generateLargeString();
            IDKey key1 = new IDKey(largeString);
            IDKey key2 = new IDKey(largeString);
    
            assertEquals(key1.hashCode(), key2.hashCode());
        }
    
        private String generateLargeString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 100000; i++) {
                sb.append("a");
            }
            return sb.toString();
        }
    }
    @Test
    @DisplayName("should return true when comparing two IDKeys with the same id and value")
    void testEqualsSameIdAndValue() {
        // Arrange
        Object value = new Object();
        IDKey key1 = new IDKey(value);
        IDKey key2 = new IDKey(value);
    
        // Act
        boolean result = key1.equals(key2);
    
        // Assert
        Assertions.assertTrue(result);
    }
    
    @Test
    @DisplayName("should return false when comparing two IDKeys with different ids")
    void testEqualsDifferentId() {
        // Arrange
        Object value = new Object();
        IDKey key1 = new IDKey(value);
        IDKey key2 = new IDKey(value);
        key2.id = 123;
    
        // Act
        boolean result = key1.equals(key2);
    
        // Assert
        Assertions.assertFalse(result);
    }
    
    @Test
    @DisplayName("should return false when comparing two IDKeys with different values")
    void testEqualsDifferentValue() {
        // Arrange
        IDKey key1 = new IDKey(new Object());
        IDKey key2 = new IDKey(new Object());
    
        // Act
        boolean result = key1.equals(key2);
    
        // Assert
        Assertions.assertFalse(result);
    }
    
    @Test
    @DisplayName("should return false when comparing an IDKey with a different type of object")
    void testEqualsDifferentObjectType() {
        // Arrange
        IDKey key = new IDKey(new Object());
        Object other = new Object();
    
        // Act
        boolean result = key.equals(other);
    
        // Assert
        Assertions.assertFalse(result);
    }
    
    @Test
    @DisplayName("should return true when comparing an IDKey with itself")
    void testEqualsSameObject() {
        // Arrange
        IDKey key = new IDKey(new Object());
    
        // Act
        boolean result = key.equals(key);
    
        // Assert
        Assertions.assertTrue(result);
    }
    
    @Test
    @DisplayName("should return true when comparing an IDKey with null")
    void testEqualsNull() {
        // Arrange
        IDKey key = new IDKey(new Object());
    
        // Act
        boolean result = key.equals(null);
    
        // Assert
        Assertions.assertFalse(result);
    }

}