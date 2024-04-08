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

public class JavaVersionTest {
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertNull;
    
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;
    
    class JavaVersionTest {
    
        private JavaVersion javaVersion;
    
        @Test
        @DisplayName("Test getJavaVersion with known version")
        void testGetJavaVersionKnownVersion() {
            javaVersion = JavaVersion.getJavaVersion("1.8");
            assertEquals(JavaVersion.VERSION_1_8, javaVersion);
        }
    
        @Test
        @DisplayName("Test getJavaVersion with unknown version")
        void testGetJavaVersionUnknownVersion() {
            javaVersion = JavaVersion.getJavaVersion("9.0");
            assertNull(javaVersion);
        }
    }
    import org.junit.jupiter.api.Test;
    
    @Test
    void testAtMost_SameVersion() {
        JavaVersion version = new JavaVersion(1, 0);
        Assertions.assertTrue(version.atMost(JAVA_1_0));
    }
    
    @Test
    void testAtMost_GreaterVersion() {
        JavaVersion version = new JavaVersion(1, 4);
        Assertions.assertTrue(version.atMost(JAVA_5_0));
    }
    
    @Test
    void testAtMost_LowerVersion() {
        JavaVersion version = new JavaVersion(8, 0);
        Assertions.assertFalse(version.atMost(JAVA_1_4));
    }
    
    @Test
    void testAtMost_EqualVersion() {
        JavaVersion version = new JavaVersion(11, 0);
        Assertions.assertTrue(version.atMost(JAVA_11_0));
    }
    
    @Test
    void testAtMost_NullVersion() {
        JavaVersion version = new JavaVersion(1, 0);
        Assertions.assertThrows(NullPointerException.class, () -> version.atMost(null));
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
    void testGetWithUnknownVersion() {
        JavaVersion version = JavaVersion.get("22");
        Assertions.assertNull(version);
    }
    
    @Test
    void testGetWithDecimalVersion() {
        JavaVersion version1 = JavaVersion.get("1.9");
        Assertions.assertEquals(JavaVersion.JAVA_RECENT, version1);
    
        JavaVersion version2 = JavaVersion.get("10.5");
        Assertions.assertEquals(JavaVersion.JAVA_RECENT, version2);
    }
    
    @Test
    void testGetWithInvalidVersion() {
        JavaVersion version = JavaVersion.get("abc");
        Assertions.assertNull(version);
    }
    @Test
    void testAtLeast_SameVersion_ReturnsTrue() {
        JavaVersion requiredVersion = new JavaVersion();
        Assertions.assertTrue(javaVersion.atLeast(requiredVersion));
    }
    
    @Test
    void testAtLeast_LowerVersion_ReturnsFalse() {
        JavaVersion requiredVersion = new JavaVersion();
        requiredVersion.setValue(1);
        Assertions.assertFalse(javaVersion.atLeast(requiredVersion));
    }
    
    @Test
    void testAtLeast_HigherVersion_ReturnsTrue() {
        JavaVersion requiredVersion = new JavaVersion();
        requiredVersion.setValue(2);
        Assertions.assertTrue(javaVersion.atLeast(requiredVersion));
    }
    
    @Test
    void testAtLeast_NullVersion_ThrowsNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            javaVersion.atLeast(null);
        });
    }
    @Test
    @DisplayName("Test toString with null name")
    void testToStringWithNullName() {
        javaVersion.name = null;
        Assertions.assertEquals("", javaVersion.toString());
    }
    
    @Test
    @DisplayName("Test toString with empty name")
    void testToStringWithEmptyName() {
        javaVersion.name = "";
        Assertions.assertEquals("", javaVersion.toString());
    }
    
    @Test
    @DisplayName("Test toString with valid name")
    void testToStringWithValidName() {
        javaVersion.name = "1.5";
        Assertions.assertEquals("1.5", javaVersion.toString());
    }

}