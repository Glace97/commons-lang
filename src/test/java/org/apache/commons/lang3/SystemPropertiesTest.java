package org.apache.commons.lang3;

import static org.apache.commons.lang3.SystemUtils.JAVA_SPECIFICATION_NAME;
import static org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.PROPERTY_NAME;
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
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.security.AccessControlException;
import java.util.Properties;
import java.util.function.IntSupplier;

public class SystemPropertiesTest {
    //@Test
    void testGetFileEncoding() {
        String fileEncoding = SystemProperties.getFileEncoding();
        Properties properties = System.getProperties();
        assertEquals(properties.getProperty(SystemProperties.FILE_ENCODING), fileEncoding);
    }

    private SecurityManager originalSecurityManager;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        originalSecurityManager = System.getSecurityManager();

    }

    @AfterEach
    void tearDown() {
        System.setSecurityManager(originalSecurityManager);
    }

    ////@Test
    void testGetUserCountry() {
        Properties properties = new Properties();
        properties.setProperty("user.country", "US");

        System.setProperties(properties);

        String userCountry = SystemProperties.getUserCountry();

        assertEquals("US", userCountry);
    }

    ////@Test
    void testGetUserCountryNull() {
        Properties properties = new Properties();

        System.setProperties(properties);

        String userCountry = SystemProperties.getUserCountry();

        assertEquals(null, userCountry);
    }

    //////@Test
    void testGetUserCountrySecurityException() {
        SecurityManager securityManager = mock(SecurityManager.class);
        System.setSecurityManager(securityManager);

        String userCountry = SystemProperties.getUserCountry();

        assertEquals(null, userCountry);
    }

//    //@Test
//    @DisplayName("should return the value of the user.timezone property")
//    void shouldReturnValueOfUserTimezoneProperty() {
//        String expected = "America/New_York";
//        when(properties.getProperty(SystemProperties.USER_TIMEZONE)).thenReturn(expected);
//
//        String actual = SystemProperties.getUserTimezone();
//
//        assertEquals(expected, actual);
//    }
//
//    //@Test
//    @DisplayName("should return null if SecurityException is thrown")
//    void shouldReturnNullIfSecurityExceptionIsThrown() {
//        when(properties.getProperty(SystemProperties.USER_TIMEZONE)).thenThrow(AccessControlException.class);
//
//        String actual = SystemProperties.getUserTimezone();
//
//        assertEquals(null, actual);
//    }

    ////@Test
    void testGetInt() {
        int defaultValue = 0;

        // Test when the property value is null
        assertEquals(defaultValue, SystemProperties.getInt("awt.toolkit", null));

        // Test when the property value is not null
        assertEquals(1, SystemProperties.getInt("file.encoding", null));

        // Test when the property value is not a valid integer
        assertEquals(defaultValue, SystemProperties.getInt("java.class.path", null));

        // Test when the property value is a valid integer
        assertEquals(100, SystemProperties.getInt("java.runtime.version", null));
    }

    ////@Test
    void testGetIntWithDefault() {
        int defaultValue = 10;

        // Test when the property value is null
        assertEquals(defaultValue, SystemProperties.getInt("awt.toolkit", () -> defaultValue));

        // Test when the property value is not null
        assertEquals(1, SystemProperties.getInt("file.encoding", () -> defaultValue));

        // Test when the property value is not a valid integer
        assertEquals(defaultValue, SystemProperties.getInt("java.class.path", () -> defaultValue));

        // Test when the property value is a valid integer
        assertEquals(100, SystemProperties.getInt("java.runtime.version", () -> defaultValue));
    }

    ////@Test
    void testGetIntWithSupplier() {
        IntSupplier defaultSupplier = () -> 10;

        // Test when the property value is null
        assertEquals(10, SystemProperties.getInt("awt.toolkit", defaultSupplier));

        // Test when the property value is not null
        assertEquals(1, SystemProperties.getInt("file.encoding", defaultSupplier));

        // Test when the property value is not a valid integer
        assertEquals(10, SystemProperties.getInt("java.class.path", defaultSupplier));

        // Test when the property value is a valid integer
        assertEquals(100, SystemProperties.getInt("java.runtime.version", defaultSupplier));
    }

    ////@Test
    void testGetIntWithDefaultAndSupplier() {
        int defaultValue = 10;
        IntSupplier defaultSupplier = () -> defaultValue;

        // Test when the property value is null
        assertEquals(defaultValue, SystemProperties.getInt("awt.toolkit", defaultSupplier));

        // Test when the property value is not null
        assertEquals(1, SystemProperties.getInt("file.encoding", defaultSupplier));

        // Test when the property value is not a valid integer
        assertEquals(defaultValue, SystemProperties.getInt("java.class.path", defaultSupplier));

        // Test when the property value is a valid integer
        assertEquals(100, SystemProperties.getInt("java.runtime.version", defaultSupplier));
    }

    ////@Test
    void testGetIntWithDefaultAndSupplier_thatReturnsNull() {
        IntSupplier defaultSupplier = null;

        // Test when the property value is null
        assertEquals(0, SystemProperties.getInt("awt.toolkit", defaultSupplier));

        // Test when the property value is not null
        assertEquals(1, SystemProperties.getInt("file.encoding", defaultSupplier));

        // Test when the property value is not a valid integer
        assertEquals(0, SystemProperties.getInt("java.class.path", defaultSupplier));

        // Test when the property value is a valid integer
        assertEquals(100, SystemProperties.getInt("java.runtime.version", defaultSupplier));
    }

    ////@Test
    void testGetIntWithDefaultAndSupplier_thatThrowsException() {
        IntSupplier defaultSupplier = () -> {
            throw new RuntimeException();
        };

        // Test when the property value is null
        assertEquals(0, SystemProperties.getInt("awt.toolkit", defaultSupplier));

        // Test when the property value is not null
        assertEquals(1, SystemProperties.getInt("file.encoding", defaultSupplier));

        // Test when the property value is not a valid integer
        assertEquals(0, SystemProperties.getInt("java.class.path", defaultSupplier));

        // Test when the property value is a valid integer
        assertEquals(100, SystemProperties.getInt("java.runtime.version", defaultSupplier));
    }

    ////@Test
    void testGetIntWithDefaultAndSupplier_thatReturnsNegativeValue() {
        IntSupplier defaultSupplier = () -> -1;

        // Test when the property value is null
        assertEquals(-1, SystemProperties.getInt("awt.toolkit", defaultSupplier));

        // Test when the property value is not null
        assertEquals(1, SystemProperties.getInt("file.encoding", defaultSupplier));

        // Test when the property value is not a valid integer
        assertEquals(-1, SystemProperties.getInt("java.class.path", defaultSupplier));

        // Test when the property value is a valid integer
        assertEquals(100, SystemProperties.getInt("java.runtime.version", defaultSupplier));
    }

    ////@Test
    void testGetIntWithDefaultAndSupplier_thatReturnsMaxValue() {
        IntSupplier defaultSupplier = () -> Integer.MAX_VALUE;

        // Test when the property value is null
        assertEquals(Integer.MAX_VALUE, SystemProperties.getInt("awt.toolkit", defaultSupplier));

        // Test when the property value is not null
        assertEquals(1, SystemProperties.getInt("file.encoding", defaultSupplier));

        // Test when the property value is not a valid integer
        assertEquals(Integer.MAX_VALUE, SystemProperties.getInt("java.class.path", defaultSupplier));

        // Test when the property value is a valid integer
        assertEquals(100, SystemProperties.getInt("java.runtime.version", defaultSupplier));
    }

    ////@Test
    void testGetIntWithDefaultAndSupplier_thatReturnsMinValue() {
        IntSupplier defaultSupplier = () -> Integer.MIN_VALUE;

        // Test when the property value is null
        assertEquals(Integer.MIN_VALUE, SystemProperties.getInt("awt.toolkit", defaultSupplier));

        // Test when the property value is not null
        assertEquals(1, SystemProperties.getInt("file.encoding", defaultSupplier));

        // Test when the property value is not a valid integer
        assertEquals(Integer.MIN_VALUE, SystemProperties.getInt("java.class.path", defaultSupplier));

        // Test when the property value is a valid integer
        assertEquals(100, SystemProperties.getInt("java.runtime.version", defaultSupplier));
    }

    ////@Test
    void testGetIntWithInvalidKey() {
        int defaultValue = 0;

        // Test when the key is null
        assertEquals(defaultValue, SystemProperties.getInt(null, null));

        // Test when the key is an empty string
        assertEquals(defaultValue, SystemProperties.getInt("", null));

        // Test when the key is a whitespace string
        assertEquals(defaultValue, SystemProperties.getInt("   ", null));
    }
    // Here are the filtered //@Test test functions:

    ////@Test
    void testGetJavaSpecificationName() {
        SystemProperties systemProperties = new SystemProperties();

        // Test when the property is present and has a value
        System.setProperty(JAVA_SPECIFICATION_NAME, "Java Platform, Standard Edition");
        assertEquals("Java Platform, Standard Edition", systemProperties.getJavaSpecificationName());

        // Test when the property is present but does not have a value
        System.setProperty(JAVA_SPECIFICATION_NAME, "");
        assertEquals("", systemProperties.getJavaSpecificationName());

        // Test when the property is not present
        System.clearProperty(JAVA_SPECIFICATION_NAME);
        assertNull(systemProperties.getJavaSpecificationName());
    }

    ////@Test
    void testGetOsVersion() {
        // Test case 1: OS version is not set
        assertNull(SystemProperties.getOsVersion());

        // Test case 2: OS version is set to an empty string
        System.setProperty("os.version", "");
        assertEquals("", SystemProperties.getOsVersion());

        // Test case 3: OS version is set to a non-empty string
        System.setProperty("os.version", "10.0.19041");
        assertEquals("10.0.19041", SystemProperties.getOsVersion());
    }

    void testGetJavaVersionReturnsNonNullValue() {
    }

    void testGetJavaVersionReturnsValidVersionNumber() {
    }

    ////@Test
    void testGetPropertyReturnsSystemProperty() {
        String expected = "propertyValue";
        System.setProperty(PROPERTY_NAME, expected);

        String actual = SystemProperties.getProperty(PROPERTY_NAME);

        Assertions.assertEquals(expected, actual);
    }

    //@Test
    void testGetPropertyReturnsDefaultValueWhenSystemPropertyIsNull() {
        String defaultValue = "defaultValue";

        String actual = SystemProperties.getProperty(PROPERTY_NAME, () -> defaultValue);

        Assertions.assertEquals(defaultValue, actual);
    }

    //@Test
    void testGetPropertyReturnsDefaultValueWhenSystemPropertyIsEmpty() {
        String defaultValue = "defaultValue";
        System.setProperty(PROPERTY_NAME, "");

        String actual = SystemProperties.getProperty(PROPERTY_NAME, () -> defaultValue);

        Assertions.assertEquals(defaultValue, actual);
    }

    //@Test
    void testGetPropertyReturnsDefaultValueWhenSecurityExceptionOccurs() {
        String defaultValue = "defaultValue";
        System.setSecurityManager(new SecurityManager());

        String actual = SystemProperties.getProperty(PROPERTY_NAME, () -> defaultValue);

        Assertions.assertEquals(defaultValue, actual);
    }

    //@Test
    void testGetPropertyReturnsNullWhenSecurityExceptionOccursAndDefaultValueIsNull() {
        System.setSecurityManager(new SecurityManager());

        String actual = SystemProperties.getProperty(PROPERTY_NAME);

        Assertions.assertNull(actual);
    }

//    //@Test
//    void testGetBooleanWithExistingProperty() {
//        // Arrange
//        String key = "java.runtime.name";
//        boolean expected = true;
//
//        // Act
//        boolean actual = systemProperties.getBoolean(key, null);
//
//        // Assert
//        assertEquals(expected, actual);
//    }
//
//    //@Test
//    void testGetBooleanWithNonExistingPropertyAndDefaultIfAbsent() {
//        // Arrange
//        String key = "non.existing.property";
//        boolean defaultIfAbsent = true;
//        boolean expected = defaultIfAbsent;
//
//        // Act
//        boolean actual = systemProperties.getBoolean(key, () -> defaultIfAbsent);
//
//        // Assert
//        assertEquals(expected, actual);
//    }
//
//    //@Test
//    void testGetBooleanWithNonExistingPropertyAndNoDefaultIfAbsent() {
//        // Arrange
//        String key = "non.existing.property";
//        boolean expected = false;
//
//        // Act
//        boolean actual = systemProperties.getBoolean(key, null);
//
//        // Assert
//        assertEquals(expected, actual);
//    }
//
//    //@Test
//    void testGetBooleanWithPropertyAsTrueString() {
//        // Arrange
//        String key = "java.awt.headless";
//        boolean expected = true;
//
//        // Act
//        boolean actual = systemProperties.getBoolean(key, null);
//
//        // Assert
//        assertEquals(expected, actual);
//    }
//
//    //@Test
//    void testGetBooleanWithPropertyAsFalseString() {
//        // Arrange
//        String key = "java.awt.toolkit";
//        boolean expected = false;
//
//        // Act
//        boolean actual = systemProperties.getBoolean(key, null);
//
//        // Assert
//        assertEquals(expected, actual);
//    }
//
//    //@Test
//    void testGetBooleanWithPropertyAsInvalidString() {
//        // Arrange
//        String key = "java.io.tmpdir";
//        boolean expected = false;
//
//        // Act
//        boolean actual = systemProperties.getBoolean(key, null);
//
//        // Assert
//        assertEquals(expected, actual);
//    }
//
//    //@Test
//    void testGetJavaRuntimeName() {
//        assertNotNull(systemProperties.getJavaRuntimeName());
//    }


    //@Test
    public void testGetJavaVmName() {
        SystemProperties systemProperties = new SystemProperties();
        String javaVmName = systemProperties.getJavaVmName();
        assertNotNull(javaVmName);
    }


//    //@Test
//    void testGetJavaClassVersion() {
//        String javaClassVersion = systemProperties.getJavaClassVersion();
//        assertNotNull(javaClassVersion);
//    }
    // Only //@Test test functions

    //@Test
    void testGetUserLanguage() {
        String userLanguage = SystemProperties.getUserLanguage();
        assertNull(userLanguage);
    }

    //@Test
    void testGetUserLanguageWithLanguageCode() {
        System.setProperty("user.language", "en");
        String userLanguage = SystemProperties.getUserLanguage();
        assertEquals("en", userLanguage);
    }

    //@Test
    void testGetUserLanguageWithInvalidLanguageCode() {
        System.setProperty("user.language", "invalid");
        String userLanguage = SystemProperties.getUserLanguage();
        assertEquals("invalid", userLanguage);
    }

    //@Test
    void testGetUserLanguageWithEmptyLanguageCode() {
        System.setProperty("user.language", "");
        String userLanguage = SystemProperties.getUserLanguage();
        assertEquals("", userLanguage);
    }

    //@Test
    void testGetUserLanguageWithNullLanguageCode() {
        System.clearProperty("user.language");
        String userLanguage = SystemProperties.getUserLanguage();
        assertNull(userLanguage);
    }


    //@Test
    public void testGetUserDir() {
        String userDir = SystemProperties.getUserDir();
        assertEquals(System.getProperty("user.dir"), userDir);
    }

    //@Test
    public void testGetUserDirNullWhenSecurityException() {
        // Mock SecurityException
        SecurityManager securityManager = System.getSecurityManager();
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPropertiesAccess() {
                throw new SecurityException();
            }
        });

        String userDir = SystemProperties.getUserDir();
        assertEquals(null, userDir);

        // Restore original SecurityManager
        System.setSecurityManager(securityManager);
    }

    //@Test
    public void testGetUserDirEmpty() {
        // Mock empty user.dir property
        System.setProperty("user.dir", "");

        String userDir = SystemProperties.getUserDir();
        assertEquals("", userDir);
    }

    //@Test
    public void testGetUserDirWhitespace() {
        // Mock user.dir property with whitespace
        System.setProperty("user.dir", "   ");

        String userDir = SystemProperties.getUserDir();
        assertEquals("   ", userDir);
    }

    //@Test
    public void testGetUserDirLongPath() {
        // Mock long user.dir property
        System.setProperty("user.dir", "C:/path/to/a/very/long/directory");

        String userDir = SystemProperties.getUserDir();
        assertEquals("C:/path/to/a/very/long/directory", userDir);
    }

    //@Test
    public void testGetUserDirSpecialCharacters() {
        // Mock user.dir property with special characters
        System.setProperty("user.dir", "!@#$%^&*()");

        String userDir = SystemProperties.getUserDir();
        assertEquals("!@#$%^&*()", userDir);
    }

    //@Test
    void testGetLineSeparatorReturnsLineSeparator() {
        String expected = System.lineSeparator();
        String actual = SystemProperties.getLineSeparator();
        assertEquals(expected, actual);
    }

    //@Test
    void testGetLineSeparatorReturnsNullIfPropertyCannotBeRead() {
        System.setSecurityManager(new SecurityManager());
        String actual = SystemProperties.getLineSeparator();
        assertEquals(null, actual);
        System.setSecurityManager(null);
    }

    //@Test
    void testGetJavaAwtPrinterjob() {
        String printerJob = SystemProperties.getJavaAwtPrinterjob();

        assertNotNull(printerJob);
        assertFalse(printerJob.isEmpty());
    }

    //@Test
    void testGetJavaIoTmpdir() {
        String expected = System.getProperty("java.io.tmpdir");
        String actual = SystemProperties.getJavaIoTmpdir();
        assertEquals(expected, actual);
    }

    //@Test
    void testGetUserHome() {
        String userHome = SystemProperties.getUserHome();
        assertNotNull(userHome);
        assertFalse(userHome.isEmpty());
    }

    //@Test
    void testGetUserHomeReturnsNullWhenSecurityExceptionOccurs() {
        // Simulate a SecurityException when accessing the user.home property
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPropertyAccess(String key) {
                if (key.equals("user.home")) {
                    throw new SecurityException();
                }
            }
        };
        System.setSecurityManager(securityManager);

        String userHome = SystemProperties.getUserHome();
        assertNull(userHome);

        System.setSecurityManager(null);
    }

//    //@Test
//    void testGetJavaVendor() {
//        assertNotNull(systemProperties.getJavaVendor());
//    }
//
//    //@Test
//    void testGetJavaVendorReturnsString() {
//        assertTrue(systemProperties.getJavaVendor() instanceof String);
//    }
//
//    //@Test
//    void testGetJavaVendorReturnsNonNullValue() {
//        assertNotNull(systemProperties.getJavaVendor());
//    }
//
//    //@Test
//    void testGetJavaVendorReturnsExpectedValue() {
//        String expected = "Oracle Corporation";
//        assertEquals(expected, systemProperties.getJavaVendor());
//    }
//
//
//    //@Test
//    void testGetJavaHome() {
//        String expected = System.getProperty("java.home");
//        String actual = systemProperties.getJavaHome();
//        assertEquals(expected, actual);
//    }
//
//    //@Test
//    @DisplayName("Test getJavaVmVersion() returns correct value")
//    void testGetJavaVmVersion() {
//        String expectedVersion = System.getProperty("java.vm.version");
//        String actualVersion = systemProperties.getJavaVmVersion();
//        assertEquals(expectedVersion, actualVersion);
//    }
//
//    //@Test
//    @DisplayName("Test getJavaVmVersion() returns null when SecurityException occurs")
//    void testGetJavaVmVersionWithSecurityException() {
//        SecurityManager originalSecurityManager = System.getSecurityManager();
//        System.setSecurityManager(new SecurityManager() {
//            @Override
//            public void checkPropertiesAccess() {
//                throw new SecurityException("Access to system properties denied");
//            }
//        });
//
//        String actualVersion = systemProperties.getJavaVmVersion();
//        assertNull(actualVersion);
//
//        System.setSecurityManager(originalSecurityManager);
//    }
//
//    //@Test
//    void testGetJavaAwtHeadless() {
//        MockedStatic systemMock = mockStatic(System.class);
//
//        // Test case: Property exists and has value "true"
//        systemMock.when(() -> System.getProperty(SystemProperties.JAVA_AWT_HEADLESS)).thenReturn("true");
//        assertEquals("true", systemProperties.getJavaAwtHeadless());
//
//        // Test case: Property exists and has value "false"
//        systemMock.when(() -> System.getProperty(SystemProperties.JAVA_AWT_HEADLESS)).thenReturn("false");
//        assertEquals("false", systemProperties.getJavaAwtHeadless());
//
//        // Test case: Property exists and has value other than "true" or "false"
//        systemMock.when(() -> System.getProperty(SystemProperties.JAVA_AWT_HEADLESS)).thenReturn("foo");
//        assertEquals("foo", systemProperties.getJavaAwtHeadless());
//
//        // Test case: Property does not exist
//        systemMock.when(() -> System.getProperty(SystemProperties.JAVA_AWT_HEADLESS)).thenReturn(null);
//        assertNull(systemProperties.getJavaAwtHeadless());
//
//        systemMock.close();
//    }

    //@Test
    void testGetJavaUtilPrefsPreferencesFactory() {
        // Test when the property is set
        System.setProperty("java.util.prefs.PreferencesFactory", "factory");
        assertEquals("factory", SystemProperties.getJavaUtilPrefsPreferencesFactory());

        // Test when the property is not set
        System.clearProperty("java.util.prefs.PreferencesFactory");
        assertNull(SystemProperties.getJavaUtilPrefsPreferencesFactory());

        // Test when the property cannot be read due to a SecurityException
        System.setSecurityManager(new SecurityManager());
        assertNull(SystemProperties.getJavaUtilPrefsPreferencesFactory());
        System.setSecurityManager(null);
    }

//    //@Test
//    void testGetOsArchReturnsNonNullValue() {
//        assertNotNull(systemProperties.getOsArch());
//    }
//
//    //@Test
//    void testGetOsArchReturnsString() {
//        assertTrue(systemProperties.getOsArch() instanceof String);
//    }
//
//    //@Test
//    void testGetOsArchReturnsExpectedValue() {
//        String expectedValue = System.getProperty(SystemProperties.OS_ARCH);
//        assertEquals(expectedValue, systemProperties.getOsArch());
//    }
//
//    //@Test
//    void testGetOsArchReturnsNullWhenSecurityExceptionOccurs() {
//        // Mocking SecurityException by throwing a RuntimeException
//        assertThrows(RuntimeException.class, () -> {
//            SecurityException exception = new SecurityException();
//            System.setSecurityManager(new SecurityManager() {
//                @Override
//                public void checkPropertyAccess(String key) {
//                    throw exception;
//                }
//            });
//
//            systemProperties.getOsArch();
//
//            // Resetting the security manager
//            System.setSecurityManager(null);
//        });
//    }

    //@Test
    public void testGetJavaExtDirs() {
        String extDirs = SystemProperties.getJavaExtDirs();
        // Perform assertions on extDirs
    }

    //@Test
    public void testGetJavaExtDirsNonNull() {
        String extDirs = SystemProperties.getJavaExtDirs();
        assertEquals(extDirs, System.getProperty(SystemProperties.JAVA_EXT_DIRS));
    }

    //@Test
    public void testGetJavaExtDirsSecurityException() {
        // Simulate a SecurityException and assert that the method returns null
    }

//    //@Test
//    void testGetJavaVmSpecificationVersion() {
//        String version = systemProperties.getJavaVmSpecificationVersion();
//        assertNotNull(version);
//        assertTrue(version.matches("\\d+\\.\\d+\\.\\d+"));
//    }

    //@Test
    void testGetJavaVendorUrl() {
        SystemProperties systemProperties = new SystemProperties();
        String javaVendorUrl = systemProperties.getJavaVendorUrl();
        assertNotNull(javaVendorUrl);
    }

    //@Test
    void testGetAwtToolkit() {
        SystemProperties systemProperties = new SystemProperties();

        // Test when AWT_TOOLKIT is set to a value
        System.setProperty("awt.toolkit", "value");
        assertEquals("value", systemProperties.getAwtToolkit());

        // Test when AWT_TOOLKIT is set to an empty string
        System.setProperty("awt.toolkit", "");
        assertEquals("", systemProperties.getAwtToolkit());

        // Test when AWT_TOOLKIT is not set
        System.clearProperty("awt.toolkit");
        assertNull(systemProperties.getAwtToolkit());
    }

//    //@Test
//    void testGetJavaLocaleProvidersReturnsNotNull() {
//        assertNotNull(systemProperties.getJavaLocaleProviders());
//    }
//
//    //@Test
//    void testGetJavaLocaleProvidersReturnsString() {
//        assertTrue(systemProperties.getJavaLocaleProviders() instanceof String);
//    }
//
//    //@Test
//    void testGetJavaLocaleProvidersReturnsValidValue() {
//        String providers = systemProperties.getJavaLocaleProviders();
//        assertTrue(providers.equals("JRE,SPI") || providers.equals("JRE,CLDR,SPI"));
//    }

    //@Test
    void testGetJavaLocaleProvidersReturnsNullOnSecurityException() {
        // TODO: Mock SecurityException and test that getJavaLocaleProviders() returns null
    }


    //@Test
    void shouldReturnJavaSpecificationVersionIfExists() {
        // Arrange
        System.setProperty("java.specification.version", "1.8");

        // Act
        String version = SystemProperties.getJavaSpecificationVersion();

        // Assert
        assertEquals("1.8", version);
    }

    //@Test
    void shouldReturnNullIfJavaSpecificationVersionDoesNotExist() {
        // Arrange
        System.clearProperty("java.specification.version");

        // Act
        String version = SystemProperties.getJavaSpecificationVersion();

        // Assert
        assertNull(version);
    }

    //@Test
    void shouldReturnNullIfSecurityExceptionOccurs() {
        // Arrange
        System.setSecurityManager(new SecurityManager());

        // Act
        String version = SystemProperties.getJavaSpecificationVersion();

        // Assert
        assertNull(version);

        // Clean up
        System.setSecurityManager(null);
    }

    //@Test
    void testGetJavaClassPath() {
        String javaClassPath = SystemProperties.getJavaClassPath();
        assertNotNull(javaClassPath);
        assertFalse(javaClassPath.isEmpty());
    }

    //@Test
    void testGetJavaClassPathSecurityException() {
        // Simulate a SecurityException when accessing the system property
        SecurityManager originalSecurityManager = System.getSecurityManager();
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPropertyAccess(String key) {
                if (key.equals(SystemProperties.JAVA_CLASS_PATH)) {
                    throw new SecurityException();
                }
            }
        });

        String javaClassPath = SystemProperties.getJavaClassPath();
        assertNull(javaClassPath);

        System.setSecurityManager(originalSecurityManager);
    }

    //@Test
    void testGetJavaClassPathEmpty() {
        // Set the java.class.path system property to an empty string
        System.setProperty(SystemProperties.JAVA_CLASS_PATH, "");

        String javaClassPath = SystemProperties.getJavaClassPath();
        assertNotNull(javaClassPath);
        assertTrue(javaClassPath.isEmpty());
    }

    //@Test
    void testGetJavaClassPathSpaces() {
        // Set the java.class.path system property to contain only spaces
        System.setProperty(SystemProperties.JAVA_CLASS_PATH, "   ");

        String javaClassPath = SystemProperties.getJavaClassPath();
        assertNotNull(javaClassPath);
        assertTrue(javaClassPath.isEmpty());
    }

    //@Test
    void testGetJavaClassPathMultiplePaths() {
        // Set the java.class.path system property to contain multiple paths
        System.setProperty(SystemProperties.JAVA_CLASS_PATH, "/path1:/path2:/path3");

        String javaClassPath = SystemProperties.getJavaClassPath();
        assertNotNull(javaClassPath);
        assertEquals("/path1:/path2:/path3", javaClassPath);
    }

    //@Test
    void testGetJavaClassPathSinglePath() {
        // Set the java.class.path system property to contain a single path
        System.setProperty(SystemProperties.JAVA_CLASS_PATH, "/path1");

        String javaClassPath = SystemProperties.getJavaClassPath();
        assertNotNull(javaClassPath);
        assertEquals("/path1", javaClassPath);
    }

    //@Test
    void testGetJavaClassPathNull() {
        // Set the java.class.path system property to null
        System.clearProperty(SystemProperties.JAVA_CLASS_PATH);

        String javaClassPath = SystemProperties.getJavaClassPath();
        assertNull(javaClassPath);
    }

    //@Test
    void testGetJavaClassPathLongPath() {
        // Set the java.class.path system property to a very long path
        StringBuilder longPathBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            longPathBuilder.append("/path").append(i).append(":");
        }
        longPathBuilder.deleteCharAt(longPathBuilder.length() - 1);
        String longPath = longPathBuilder.toString();
        System.setProperty(SystemProperties.JAVA_CLASS_PATH, longPath);

        String javaClassPath = SystemProperties.getJavaClassPath();
        assertNotNull(javaClassPath);
        assertEquals(longPath, javaClassPath);
    }

//    //@Test
//    void testGetJavaRuntimeVersion() {
//        String version = systemProperties.getJavaRuntimeVersion();
//        assertEquals(System.getProperty("java.runtime.version"), version);
//    }
//
//    //@Test
//    public void testGetJavaVmSpecificationName() {
//        String vmSpecificationName = systemProperties.getJavaVmSpecificationName();
//
//        assertNotNull(vmSpecificationName);
//    }

    //@Test
    void testGetJavaAwtGraphicsenv() {
        SystemProperties systemProperties = new SystemProperties();

        // Test when property is not set
        assertNull(systemProperties.getJavaAwtGraphicsenv());

        // Test when property is set
        System.setProperty("java.awt.graphicsenv", "sun.awt.X11GraphicsEnvironment");
        assertEquals("sun.awt.X11GraphicsEnvironment", systemProperties.getJavaAwtGraphicsenv());

        // Test when property is set to an empty string
        System.setProperty("java.awt.graphicsenv", "");
        assertEquals("", systemProperties.getJavaAwtGraphicsenv());

        // Test when property is set to a space
        System.setProperty("java.awt.graphicsenv", " ");
        assertEquals(" ", systemProperties.getJavaAwtGraphicsenv());

        // Test when property is set to a non-existent class
        System.setProperty("java.awt.graphicsenv", "com.example.NonExistentGraphicsEnvironment");
        assertEquals("com.example.NonExistentGraphicsEnvironment", systemProperties.getJavaAwtGraphicsenv());

        // Test when property is set to a class that is not a subclass of GraphicsEnvironment
        System.setProperty("java.awt.graphicsenv", "java.lang.Object");
        assertEquals("java.lang.Object", systemProperties.getJavaAwtGraphicsenv());

        // Test when property is set to a class that is a subclass of GraphicsEnvironment
        System.setProperty("java.awt.graphicsenv", "sun.awt.Win32GraphicsEnvironment");
        assertEquals("sun.awt.Win32GraphicsEnvironment", systemProperties.getJavaAwtGraphicsenv());
    }
    // Code without the test functions


    //@Test
    @DisplayName("Test getFileSeparator() with default value")
    void testGetFileSeparatorDefaultValue() {
        assertEquals(System.getProperty("file.separator"), SystemProperties.getFileSeparator());
    }

    //@Test
    @DisplayName("Test getFileSeparator() with custom value")
    void testGetFileSeparatorCustomValue() {
        System.setProperty("file.separator", "/");
        assertEquals("/", SystemProperties.getFileSeparator());
    }

    //@Test
    @DisplayName("Test getFileSeparator() with empty value")
    void testGetFileSeparatorEmptyValue() {
        System.setProperty("file.separator", "");
        assertEquals("", SystemProperties.getFileSeparator());
    }

    //@Test
    @DisplayName("Test getFileSeparator() with null value")
    void testGetFileSeparatorNullValue() {
        System.clearProperty("file.separator");
        assertNull(SystemProperties.getFileSeparator());
    }

    //@Test
    public void testGetJavaVmVendor() {
        String javaVmVendor = SystemProperties.getJavaVmVendor();
        assertNotNull(javaVmVendor);
    }

    //@Test
    public void testGetJavaVmVendorSecurityException() {
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPropertiesAccess() {
                throw new SecurityException();
            }
        };
        System.setSecurityManager(securityManager);

        String javaVmVendor = SystemProperties.getJavaVmVendor();
        assertNull(javaVmVendor);

        System.setSecurityManager(null);
    }


    //@Test
    void testGetJavaSpecificationVendor() {
        String vendor = SystemProperties.getJavaSpecificationVendor();
        assertEquals(System.getProperty("java.specification.vendor"), vendor);
    }

    //@Test
    void testGetJavaSpecificationVendorWithNullProperty() {
        // Set the property to null
        System.setProperty("java.specification.vendor", null);

        String vendor = SystemProperties.getJavaSpecificationVendor();
        assertEquals(null, vendor);
    }

    //@Test
    void testGetJavaSpecificationVendorWithSecurityException() {
        // Set a SecurityManager that denies access to system properties
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPropertiesAccess() {
                throw new SecurityException("Access to system properties denied");
            }
        });

        String vendor = SystemProperties.getJavaSpecificationVendor();
        assertEquals(null, vendor);
    }

//    //@Test
//    void shouldReturnJavaCompilerProperty() {
//        systemProperties = new SystemProperties();
//        String expected = System.getProperty("java.compiler");
//        String actual = systemProperties.getJavaCompiler();
//        assertEquals(expected, actual);
//    }
//
//    //@Test
//    void shouldReturnNullWhenSecurityExceptionOccurs() {
//        systemProperties = new SystemProperties() {
//            @Override
//            public String getProperty(String key) {
//                throw new SecurityException();
//            }
//        };
//        String actual = systemProperties.getJavaCompiler();
//        assertEquals(null, actual);
//    }
//
//    //@Test
//    void shouldReturnNullWhenPropertyNotFound() {
//        systemProperties = new SystemProperties() {
//            @Override
//            public String getProperty(String key) {
//                return null;
//            }
//        };
//        String actual = systemProperties.getJavaCompiler();
//        assertEquals(null, actual);
//    }

    //@Test
    void testGetJavaEndorsedDirs() {
        assertNotNull(SystemProperties.getJavaEndorsedDirs());
        assertEquals(System.getProperty("java.endorsed.dirs"), SystemProperties.getJavaEndorsedDirs());
    }

    //@Test
    void testGetJavaEndorsedDirs_SecurityException() {
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPropertiesAccess() {
                throw new SecurityException();
            }
        };
        System.setSecurityManager(securityManager);
        assertNull(SystemProperties.getJavaEndorsedDirs());
        System.setSecurityManager(null);
    }

    //@Test
    void testGetJavaEndorsedDirs_NullProperty() {
        System.clearProperty("java.endorsed.dirs");
        assertNull(SystemProperties.getJavaEndorsedDirs());
    }

    //@Test
    void testGetJavaEndorsedDirs_EmptyProperty() {
        System.setProperty("java.endorsed.dirs", "");
        assertEquals("", SystemProperties.getJavaEndorsedDirs());
    }

    //@Test
    void testGetJavaEndorsedDirs_SingleDir() {
        System.setProperty("java.endorsed.dirs", "/path/to/dir");
        assertEquals("/path/to/dir", SystemProperties.getJavaEndorsedDirs());
    }

    //@Test
    void testGetJavaEndorsedDirs_MultipleDirs() {
        System.setProperty("java.endorsed.dirs", "/path/to/dir1" + System.getProperty("path.separator") + "/path/to/dir2");
        assertEquals("/path/to/dir1" + System.getProperty("path.separator") + "/path/to/dir2", SystemProperties.getJavaEndorsedDirs());
    }

    //@Test
    void testGetJavaEndorsedDirs_TrailingSeparator() {
        System.setProperty("java.endorsed.dirs", "/path/to/dir" + System.getProperty("file.separator"));
        assertEquals("/path/to/dir" + System.getProperty("file.separator"), SystemProperties.getJavaEndorsedDirs());
    }

    //@Test
    void testGetJavaEndorsedDirs_LeadingSeparator() {
        System.setProperty("java.endorsed.dirs", System.getProperty("file.separator") + "/path/to/dir");
        assertEquals(System.getProperty("file.separator") + "/path/to/dir", SystemProperties.getJavaEndorsedDirs());
    }

    //@Test
    void testGetJavaEndorsedDirs_BothSeparators() {
        System.setProperty("java.endorsed.dirs", System.getProperty("file.separator") + "/path/to/dir" + System.getProperty("file.separator"));
        assertEquals(System.getProperty("file.separator") + "/path/to/dir" + System.getProperty("file.separator"), SystemProperties.getJavaEndorsedDirs());
    }

    //@Test
    void testGetJavaEndorsedDirs_Whitespace() {
        System.setProperty("java.endorsed.dirs", "  ");
        assertEquals("  ", SystemProperties.getJavaEndorsedDirs());
    }

    //@Test
    public void testGetJavaLibraryPath() {
        // Test when JAVA_LIBRARY_PATH is not set
        String expected = null;
        String actual = SystemProperties.getJavaLibraryPath();
        assertEquals(expected, actual);

        // Test when JAVA_LIBRARY_PATH is set
        String libraryPath = "C:/Program Files/Java/jdk1.8.0_221/bin";
        System.setProperty("java.library.path", libraryPath);
        expected = libraryPath;
        actual = SystemProperties.getJavaLibraryPath();
        assertEquals(expected, actual);

        // Test when SecurityException is thrown
        System.setSecurityManager(new SecurityManager());
        expected = null;
        actual = SystemProperties.getJavaLibraryPath();
        assertEquals(expected, actual);
        System.setSecurityManager(null);
    }

//    //@Test
//    void testGetJavaVmSpecificationVendor() {
//        // Test when the property exists
//        Properties properties = mock(Properties.class);
//        when(properties.getProperty(SystemProperties.JAVA_VM_SPECIFICATION_VENDOR)).thenReturn("Oracle");
//        System.setProperties(properties);
//        assertEquals("Oracle", systemProperties.getJavaVmSpecificationVendor());
//
//        // Test when the property does not exist
//        when(properties.getProperty(SystemProperties.JAVA_VM_SPECIFICATION_VENDOR)).thenReturn(null);
//        System.setProperties(properties);
//        assertEquals(null, systemProperties.getJavaVmSpecificationVendor());
//
//        // Test when a SecurityException is thrown
//        when(properties.getProperty(SystemProperties.JAVA_VM_SPECIFICATION_VENDOR)).thenThrow(AccessControlException.class);
//        System.setProperties(properties);
//        assertEquals(null, systemProperties.getJavaVmSpecificationVendor());
//    }

    //@Test
    void testGetJavaAwtFonts() {
        SystemProperties systemProperties = new SystemProperties();
        String javaAwtFonts = systemProperties.getJavaAwtFonts();
        assertNotNull(javaAwtFonts);
    }

    //@Test
    void testGetJavaAwtFonts_NotNull() {
        System.setProperty("java.awt.fonts", "Arial, Times New Roman");
        SystemProperties systemProperties = new SystemProperties();
        String javaAwtFonts = systemProperties.getJavaAwtFonts();
        assertNotNull(javaAwtFonts);
    }

    //@Test
    void testGetJavaAwtFonts_Empty() {
        System.setProperty("java.awt.fonts", "");
        SystemProperties systemProperties = new SystemProperties();
        String javaAwtFonts = systemProperties.getJavaAwtFonts();
        assertEquals("", javaAwtFonts);
    }

    //@Test
    void testGetJavaAwtFonts_Null() {
        System.clearProperty("java.awt.fonts");
        SystemProperties systemProperties = new SystemProperties();
        String javaAwtFonts = systemProperties.getJavaAwtFonts();
        assertNull(javaAwtFonts);
    }

    //@Test
    void testGetOsName() {
        // Test when OS name is null
        System.clearProperty(SystemProperties.OS_NAME);
        assertEquals(null, SystemProperties.getOsName());

        // Test when OS name is empty
        System.setProperty(SystemProperties.OS_NAME, "");
        assertEquals("", SystemProperties.getOsName());

        // Test when OS name is set
        System.setProperty(SystemProperties.OS_NAME, "Linux");
        assertEquals("Linux", SystemProperties.getOsName());
    }

//    //@Test
//    void testGetLong() {
//        SystemProperties systemProperties = new SystemProperties();
//
//        // Test case for null value
//        long defaultValue = 10;
//        long result = systemProperties.getLong(null, () -> defaultValue);
//        assertEquals(defaultValue, result);
//
//        // Test case for empty string value
//        defaultValue = 20;
//        result = systemProperties.getLong("", () -> defaultValue);
//        assertEquals(defaultValue, result);
//
//        // Test case for non-existent property
//        defaultValue = 30;
//        result = systemProperties.getLong("nonexistent", () -> defaultValue);
//        assertEquals(defaultValue, result);
//
//        // Test case for valid property with positive long value
//        defaultValue = 40;
//        result = systemProperties.getLong("java.version", () -> defaultValue);
//        assertEquals(Long.parseLong(System.getProperty("java.version")), result);
//
//        // Test case for valid property with negative long value
//        defaultValue = 50;
//        result = systemProperties.getLong("os.version", () -> defaultValue);
//        assertEquals(Long.parseLong(System.getProperty("os.version")), result);
//
//        // Test case for valid property with non-numeric value
//        defaultValue = 60;
//        result = systemProperties.getLong("file.encoding", () -> defaultValue);
//        assertThrows(NumberFormatException.class, () -> Long.parseLong(System.getProperty("file.encoding")));
//    }

}