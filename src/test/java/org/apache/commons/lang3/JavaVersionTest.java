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


import org.junit.jupiter.api.*;

public class JavaVersionTest {


    private JavaVersion javaVersion;


    @Test
    @DisplayName("Test getJavaVersion with unknown version")
    void testGetJavaVersionUnknownVersion() {
        javaVersion = JavaVersion.getJavaVersion("9.0");
        assertNull(javaVersion);
    }

    @Test
    void testGetWithNullVersion() {
        JavaVersion version = JavaVersion.get(null);
        Assertions.assertNull(version);
    }
    
    @Test
    void testGetWithValidVersions() {
        JavaVersion version1 = JavaVersion.get("1.2");
        Assertions.assertEquals(JavaVersion.JAVA_1_2, version1);
    
        JavaVersion version2 = JavaVersion.get("9");
        Assertions.assertEquals(JavaVersion.JAVA_9, version2);
    
        JavaVersion version3 = JavaVersion.get("15");
        Assertions.assertEquals(JavaVersion.JAVA_15, version3);
    }


    
    @Test
    void testGetWithDecimalVersion() {
        JavaVersion version1 = JavaVersion.get("1.9");
        Assertions.assertEquals(JavaVersion.JAVA_RECENT, version1);
    
        JavaVersion version2 = JavaVersion.get("10.5");
        Assertions.assertEquals(JavaVersion.JAVA_RECENT, version2);
    }

    @Test
    void testAtLeast_NullVersion_ThrowsNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            javaVersion.atLeast(null);
        });
    }

    @Test
    public void testAtLeast() {
        assertTrue(JavaVersion.JAVA_1_5.atLeast(JavaVersion.JAVA_1_5));
        assertTrue(JavaVersion.JAVA_1_5.atLeast(JavaVersion.JAVA_1_4));
        assertFalse(JavaVersion.JAVA_1_4.atLeast(JavaVersion.JAVA_1_5));
        // Add similar assertions for other versions
    }

    @Test
    public void testAtMost() {
        assertTrue(JavaVersion.JAVA_1_5.atMost(JavaVersion.JAVA_1_5));
        assertTrue(JavaVersion.JAVA_1_4.atMost(JavaVersion.JAVA_1_5));
        assertFalse(JavaVersion.JAVA_1_5.atMost(JavaVersion.JAVA_1_4));
        // Add similar assertions for other versions
    }

    @Test
    public void testToString() {
        assertEquals("1.5", JavaVersion.JAVA_1_5.toString());
        assertEquals("1.4", JavaVersion.JAVA_1_4.toString());
        // Add similar assertions for other versions
    }


    @Test
    public void testMaxVersion() {
        // Test with java.specification.version set
        // Test without java.specification.version set
    }

}