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

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

public class ClassLoaderUtilsTest {


    private ClassLoaderUtils classLoaderUtils;

    @Test
    void testGetThreadURLs_ReturnsEmptyArray_WhenClassLoaderIsNull() {
        URL[] urls = classLoaderUtils.getThreadURLs();
        assertNotNull(urls);
        assertEquals(0, urls.length);
    }

    @Test
    void testGetThreadURLs_ReturnsSameURLArrayInstance_WhenClassLoaderHasURLs() throws MalformedURLException {
        ClassLoader classLoader = new URLClassLoader(new URL[]{new URL("https://example.com")});
        URL[] urls1 = classLoaderUtils.getThreadURLs();
        URL[] urls2 = classLoaderUtils.getThreadURLs();
        assertSame(urls1, urls2);
    }

    @Test
    void testGetSystemURLs_WithChildClassLoader_ShouldReturnParentURLs() {
        URLClassLoader parentClassLoader = new URLClassLoader(new URL[0]);
        URLClassLoader childClassLoader = new URLClassLoader(new URL[0], parentClassLoader);

        URL[] expectedURLs = parentClassLoader.getURLs();

        URL[] actualURLs = classLoaderUtils.getSystemURLs();

        assertArrayEquals(expectedURLs, actualURLs);
    }

    @Test
    void testGetSystemURLs_WithMultipleClassLoaders_ShouldReturnCombinedURLs() {
        URLClassLoader classLoader1 = new URLClassLoader(new URL[0]);
        URLClassLoader classLoader2 = new URLClassLoader(new URL[0]);
        URLClassLoader classLoader3 = new URLClassLoader(new URL[0]);

        URL[] expectedURLs = Arrays.stream(new URLClassLoader[]{classLoader1, classLoader2, classLoader3})
                .map(URLClassLoader::getURLs)
                .flatMap(Arrays::stream)
                .toArray(URL[]::new);

        URL[] actualURLs = classLoaderUtils.getSystemURLs();

        assertArrayEquals(expectedURLs, actualURLs);
    }

    @Test
    void testToString_WithClassLoader_ReturnsString() {
        ClassLoader classLoader = new ClassLoader() {
        };
        String expectedResult = classLoader.toString();

        String result = ClassLoaderUtils.toString(classLoader);

        assertEquals(expectedResult, result);
    }

    @Test
    void testToString_WithURLClassLoader_ReturnsFormattedString() throws MalformedURLException {
        URL[] urls = new URL[]{new URL("http://example.com")};
        URLClassLoader classLoader = new URLClassLoader(urls);
        String expectedResult = classLoader + Arrays.toString(urls);

        String result = ClassLoaderUtils.toString(classLoader);

        assertEquals(expectedResult, result);
    }

    @Test
    void testToString_WithNullClassLoader_ReturnsNullString() {
        ClassLoader classLoader = null;
        String expectedResult = "null";

        String result = ClassLoaderUtils.toString(classLoader);

        assertEquals(expectedResult, result);
    }


}