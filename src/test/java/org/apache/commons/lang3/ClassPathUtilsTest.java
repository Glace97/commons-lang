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

public class ClassPathUtilsTest {
    @Test
    void testPackageToPath() {
        // Test with a valid package name
        String result = ClassPathUtils.packageToPath("com.example.package");
        assertEquals("com/example/package", result);

        // Test with an empty package name
        result = ClassPathUtils.packageToPath("");
        assertEquals("", result);

        // Test with a package name containing only dots
        result = ClassPathUtils.packageToPath("...");
        assertEquals("///", result);

        // Test with a null package name
        assertThrows(NullPointerException.class, () -> {
            ClassPathUtils.packageToPath(null);
        });
    }

    @Test
    @DisplayName("Should return the fully qualified path")
    void shouldReturnFullyQualifiedPath() {
        // Arrange
        Class<?> context = StringUtils.class;
        String resourceName = "StringUtils.properties";

        // Act
        String result = ClassPathUtils.toFullyQualifiedPath(context, resourceName);

        // Assert
        Assertions.assertEquals("org/apache/commons/lang3/StringUtils.properties", result);
    }

    @Test
    @DisplayName("Should throw NullPointerException when context is null")
    void shouldThrowNullPointerExceptionWhenContextIsNull() {
        // Arrange
        Class<?> context = null;
        String resourceName = "StringUtils.properties";

        // Act & Assert
        Assertions.assertThrows(NullPointerException.class, () -> {
            ClassPathUtils.toFullyQualifiedPath(context, resourceName);
        });
    }

    @Test
    @DisplayName("Should throw NullPointerException when resourceName is null")
    void shouldThrowNullPointerExceptionWhenResourceNameIsNull() {
        // Arrange
        Class<?> context = StringUtils.class;
        String resourceName = null;

        // Act & Assert
        Assertions.assertThrows(NullPointerException.class, () -> {
            ClassPathUtils.toFullyQualifiedPath(context, resourceName);
        });
    }

    @Test
    @DisplayName("Should return the fully qualified path")
    void shouldReturnFullyQualifiedPathWithPackage() {
        // Arrange
        Package context = StringUtils.class.getPackage();
        String resourceName = "StringUtils.properties";

        // Act
        String result = ClassPathUtils.toFullyQualifiedPath(context, resourceName);

        // Assert
        Assertions.assertEquals("org/apache/commons/lang3/StringUtils.properties", result);
    }

    @Test
    @DisplayName("Should throw NullPointerException when context is null")
    void shouldThrowNullPointerExceptionWhenContextIsNullWithPackage() {
        // Arrange
        Package context = null;
        String resourceName = "StringUtils.properties";

        // Act & Assert
        Assertions.assertThrows(NullPointerException.class, () -> {
            ClassPathUtils.toFullyQualifiedPath(context, resourceName);
        });
    }

    @Test
    @DisplayName("Should throw NullPointerException when resourceName is null")
    void shouldThrowNullPointerExceptionWhenResourceNameIsNullWithPackage() {
        // Arrange
        Package context = StringUtils.class.getPackage();
        String resourceName = null;

        // Act & Assert
        Assertions.assertThrows(NullPointerException.class, () -> {
            ClassPathUtils.toFullyQualifiedPath(context, resourceName);
        });
    }

    @Test
    void testToFullyQualifiedName_withClass() {
        String result = ClassPathUtils.toFullyQualifiedName(String.class, "test.txt");
        assertEquals("java.lang.test.txt", result);
    }

    @Test
    void testToFullyQualifiedName_withPackage() {
        Package pkg = String.class.getPackage();
        String result = ClassPathUtils.toFullyQualifiedName(pkg, "test.txt");
        assertEquals("java.lang.test.txt", result);
    }

    @Test
    void testToFullyQualifiedName_nullResourceName() {
        assertThrows(NullPointerException.class, () -> {
            ClassPathUtils.toFullyQualifiedName(String.class, null);
        });
    }

    @Test
    void testToFullyQualifiedName_emptyResourceName() {
        String result = ClassPathUtils.toFullyQualifiedName(String.class, "");
        assertEquals("java.lang.", result);
    }


    @Test
    @DisplayName("Should convert path to package name")
    void shouldConvertPathToPackageName() {
        String path = "com/example/myapp";
        String expectedPackageName = "com.example.myapp";

        String packageName = ClassPathUtils.pathToPackage(path);

        assertEquals(expectedPackageName, packageName);
    }

}