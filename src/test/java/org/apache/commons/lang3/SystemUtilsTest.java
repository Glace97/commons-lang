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

import java.io.File;

public class SystemUtilsTest {
    @Test
    void testIsOSVersionMatchWithMatchingVersion() {
        assertTrue(SystemUtils.isOSVersionMatch("10.0", "10"));
    }

    @Test
    void testIsOSVersionMatchWithNonMatchingVersion() {
        assertFalse(SystemUtils.isOSVersionMatch("10.0", "11"));
    }

    @Test
    void testIsOSVersionMatchWithEmptyVersion() {
        assertFalse(SystemUtils.isOSVersionMatch("", "10"));
    }

    @Test
    void testIsOSVersionMatchWithNullVersion() {
        assertFalse(SystemUtils.isOSVersionMatch(null, "10"));
    }

    @Test
    void testIsOSVersionMatchWithMatchingVersionPrefixWithDot() {
        assertTrue(SystemUtils.isOSVersionMatch("10.0", "10."));
    }

    @Test
    void testIsOSVersionMatchWithNonMatchingVersionPrefixWithDot() {
        assertFalse(SystemUtils.isOSVersionMatch("10.0", "11."));
    }

    @Test
    void testIsOSVersionMatchWithMatchingVersionPrefixWithMultipleDots() {
        assertTrue(SystemUtils.isOSVersionMatch("10.0.1", "10.0"));
    }

    @Test
    void testIsOSVersionMatchWithNonMatchingVersionPrefixWithMultipleDots() {
        assertFalse(SystemUtils.isOSVersionMatch("10.0.1", "10.1"));
    }

    @Test
    void testIsOSNameMatch() {
        // Test for Windows
        assertTrue(SystemUtils.isOSNameMatch("Windows 10", "Windows"));
        assertTrue(SystemUtils.isOSNameMatch("Windows 7", "Windows"));
        assertTrue(SystemUtils.isOSNameMatch("Windows XP", "Windows"));
        assertFalse(SystemUtils.isOSNameMatch("Mac OS X", "Windows"));
        assertFalse(SystemUtils.isOSNameMatch("Linux", "Windows"));

        // Test for Mac OS X
        assertTrue(SystemUtils.isOSNameMatch("Mac OS X 10.15", "Mac OS X"));
        assertTrue(SystemUtils.isOSNameMatch("Mac OS X 10.14", "Mac OS X"));
        assertTrue(SystemUtils.isOSNameMatch("Mac OS X 10.13", "Mac OS X"));
        assertFalse(SystemUtils.isOSNameMatch("Windows 10", "Mac OS X"));
        assertFalse(SystemUtils.isOSNameMatch("Linux", "Mac OS X"));

        // Test for Linux
        assertTrue(SystemUtils.isOSNameMatch("Linux", "Linux"));
        assertTrue(SystemUtils.isOSNameMatch("Linux Mint", "Linux"));
        //assertTrue(SystemUtils.isOSNameMatch("Ubuntu", "Linux"));
        assertFalse(SystemUtils.isOSNameMatch("Windows 10", "Linux"));
        assertFalse(SystemUtils.isOSNameMatch("Mac OS X", "Linux"));
    }

    @Test
    void testGetUserDir() {
        assertNotNull(SystemUtils.getUserDir());
    }

    @Test
    void testFileSeparator() {
        assertNotNull(SystemUtils.FILE_SEPARATOR);
    }

    @Test
    void testPathSeparator() {
        assertNotNull(SystemUtils.PATH_SEPARATOR);
    }

    @Test
    void testLineSeparator() {
        assertNotNull(SystemUtils.LINE_SEPARATOR);
    }

    @Test
    void testJavaVersion() {
        assertNotNull(SystemUtils.JAVA_VERSION);
    }

    @Test
    void testJavaHome() {
        assertNotNull(SystemUtils.JAVA_HOME);
    }

    @Test
    void testJavaIoTmpdir() {
        assertNotNull(SystemUtils.JAVA_IO_TMPDIR);
    }

    @Test
    void testUserName() {
        assertNotNull(SystemUtils.USER_NAME);
    }

    @Test
    void testUserHome() {
        assertNotNull(SystemUtils.USER_HOME);
    }

    @Test
    void testUserDir() {
        assertNotNull(SystemUtils.USER_DIR);
    }

    @Test
    void testOsName() {
        assertNotNull(SystemUtils.OS_NAME);
    }

    @Test
    void testOsArch() {
        assertNotNull(SystemUtils.OS_ARCH);
    }

    @Test
    void testOsVersion() {
        assertNotNull(SystemUtils.OS_VERSION);
    }

    @Test
    void testIsJava1_1() {
        assertFalse(SystemUtils.IS_JAVA_1_1);
    }

    @Test
    void testGetJavaIoTmpDir() {
        File tempDir = SystemUtils.getJavaIoTmpDir();
        assertNotNull(tempDir);
        assertTrue(tempDir.exists());
        assertTrue(tempDir.isDirectory());
    }

    @Test
    void testGetJavaHome() {
        File javaHome = SystemUtils.getJavaHome();
        assertNotNull(javaHome);
        assertTrue(javaHome.exists());
        assertTrue(javaHome.isDirectory());
    }

    @Test
    public void testGetUserName() {
        String userName = SystemUtils.getUserName();
        assertNotNull(userName);
        assertFalse(userName.isEmpty());
    }

    @Test
    public void testGetUserNameWithDefaultValue() {
        String userName = SystemUtils.getUserName("defaultUser");
        assertNotNull(userName);
        assertFalse(userName.isEmpty());
    }

    @Test
    public void testGetUserNameWithNullDefaultValue() {
        String userName = SystemUtils.getUserName(null);
        assertNotNull(userName);
        assertFalse(userName.isEmpty());
    }

    @Test
    public void testGetUserNameWithEmptyDefaultValue() {
        String userName = SystemUtils.getUserName("");
        assertNotNull(userName);
        assertFalse(userName.isEmpty());
    }

    @Test
    void testIsJavaVersionMatch() {
        assertTrue(SystemUtils.isJavaVersionMatch("1.8.0_301", "1.8"));
        assertTrue(SystemUtils.isJavaVersionMatch("1.8.0_301", "1.8.0"));
        assertTrue(SystemUtils.isJavaVersionMatch("1.8.0_301", "1.8.0_301"));
        assertFalse(SystemUtils.isJavaVersionMatch("1.8.0_301", "1.9"));
        assertFalse(SystemUtils.isJavaVersionMatch(null, "1.8"));
    }

    @Test
    void testIsJavaVersionMatch_NullVersion() {
        assertFalse(SystemUtils.isJavaVersionMatch(null, "1.8"));
    }

    @Test
    void testIsJavaVersionMatch_MatchingVersion() {
        assertTrue(SystemUtils.isJavaVersionMatch("1.8.0_301", "1.8"));
    }

    @Test
    void testIsJavaVersionMatch_NonMatchingVersion() {
        assertFalse(SystemUtils.isJavaVersionMatch("1.8.0_301", "1.9"));
    }

    @Test
    void testIsJavaVersionMatch_EmptyPrefix() {
        assertTrue(SystemUtils.isJavaVersionMatch("1.8.0_301", ""));
    }

    @Test
    void testIsJavaVersionMatch_PrefixTooLong() {
        assertFalse(SystemUtils.isJavaVersionMatch("1.8.0_301", "1.8.0_3011"));
    }

    @Test
    void testIsOSMatch() {
        // Test matching OS name and version
        assertTrue(SystemUtils.isOSMatch("Windows 10", "10.0", "Windows", "10"));
        assertTrue(SystemUtils.isOSMatch("Mac OS X 10.15", "10.15", "Mac OS X", "10.15"));
        assertTrue(SystemUtils.isOSMatch("Linux", "4.15.0-65-generic", "Linux", "4.15"));

        // Test mismatching OS name and version
        assertFalse(SystemUtils.isOSMatch("Windows 7", "6.1", "Windows", "10"));
        assertFalse(SystemUtils.isOSMatch("Mac OS X 10.12", "10.12", "Mac OS X", "10.13"));
        assertFalse(SystemUtils.isOSMatch("Linux", "4.15.0-65-generic", "Windows", "10"));
    }

    @Test
    @DisplayName("should return true when actual version is equal to required version")
    void shouldReturnTrueWhenActualVersionIsEqualToRequiredVersion() {
        assertTrue(SystemUtils.isJavaVersionAtLeast(JavaVersion.get("1.8")));
    }

    @Test
    @DisplayName("should return true when actual version is greater than required version")
    void shouldReturnTrueWhenActualVersionIsGreaterThanRequiredVersion() {
        assertTrue(SystemUtils.isJavaVersionAtLeast(JavaVersion.get("1.9")));
    }

}