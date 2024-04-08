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

public class ClassLoaderUtilsTest {
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;
    
    class ClassLoaderUtilsTestSuite {
    
        private ClassLoaderUtils classLoaderUtils;
    
        @Test
        void testGetThreadURLs_ReturnsEmptyArray_WhenClassLoaderIsNull() {
            URL[] urls = classLoaderUtils.getThreadURLs();
            assertNotNull(urls);
            assertEquals(0, urls.length);
        }
    
        @Test
        void testGetThreadURLs_ReturnsEmptyArray_WhenClassLoaderHasNoURLs() {
            ClassLoader classLoader = new URLClassLoader(null);
            URL[] urls = classLoaderUtils.getThreadURLs();
            assertNotNull(urls);
            assertEquals(0, urls.length);
        }
    
        @Test
        void testGetThreadURLs_ReturnsURLArray_WhenClassLoaderHasURLs() {
            URL[] givenURLs = new URL[] { new URL("https://example.com") };
            ClassLoader classLoader = new URLClassLoader(givenURLs);
            URL[] urls = classLoaderUtils.getThreadURLs();
            assertNotNull(urls);
            assertArrayEquals(givenURLs, urls);
        }
    
        @Test
        void testGetThreadURLs_ReturnsSameURLArrayInstance_WhenClassLoaderHasURLs() {
            ClassLoader classLoader = new URLClassLoader(new URL[] { new URL("https://example.com") });
            URL[] urls1 = classLoaderUtils.getThreadURLs();
            URL[] urls2 = classLoaderUtils.getThreadURLs();
            assertSame(urls1, urls2);
        }
    }
    @Test
    void testGetSystemURLs_WithSystemClassLoader_ShouldReturnURLs() {
        URL[] expectedURLs = ClassLoader.getSystemClassLoader().getURLs();
    
        URL[] actualURLs = classLoaderUtils.getSystemURLs();
    
        assertArrayEquals(expectedURLs, actualURLs);
    }
    
    @Test
    void testGetSystemURLs_WithCustomClassLoader_ShouldReturnEmptyArray() {
        URLClassLoader customClassLoader = new URLClassLoader(new URL[0]);
    
        URL[] actualURLs = classLoaderUtils.getSystemURLs();
    
        assertArrayEquals(classLoaderUtils.EMPTY_URL_ARRAY, actualURLs);
    }
    
    @Test
    void testGetSystemURLs_WithNullClassLoader_ShouldReturnEmptyArray() {
        URL[] actualURLs = classLoaderUtils.getSystemURLs();
    
        assertArrayEquals(classLoaderUtils.EMPTY_URL_ARRAY, actualURLs);
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
        ClassLoader classLoader = new ClassLoader() {};
        String expectedResult = classLoader.toString();
    
        String result = ClassLoaderUtils.toString(classLoader);
    
        assertEquals(expectedResult, result);
    }
    
    @Test
    void testToString_WithURLClassLoader_ReturnsFormattedString() {
        URL[] urls = new URL[] {new URL("http://example.com")};
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
    @Test
    void testGetURLsReturnsEmptyArrayForNullClassLoader() {
        URL[] urls = ClassLoaderUtils.getURLs(null);
        Assertions.assertNotNull(urls);
        Assertions.assertEquals(0, urls.length);
    }
    
    @Test
    void testGetURLsReturnsEmptyArrayForNonURLClassLoader() {
        ClassLoader classLoader = new ClassLoader() {};
        URL[] urls = ClassLoaderUtils.getURLs(classLoader);
        Assertions.assertNotNull(urls);
        Assertions.assertEquals(0, urls.length);
    }
    
    @Test
    void testGetURLsReturnsURLsForURLClassLoader() {
        URL url1 = getClass().getResource("file1.jar");
        URL url2 = getClass().getResource("file2.jar");
        URLClassLoader classLoader = new URLClassLoader(new URL[] {url1, url2});
        URL[] urls = ClassLoaderUtils.getURLs(classLoader);
        Assertions.assertNotNull(urls);
        Assertions.assertEquals(2, urls.length);
        Assertions.assertTrue(Arrays.asList(urls).contains(url1));
        Assertions.assertTrue(Arrays.asList(urls).contains(url2));
    }
    
    @Test
    void testGetURLsReturnsEmptyArrayForEmptyURLClassLoader() {
        URLClassLoader classLoader = new URLClassLoader(new URL[] {});
        URL[] urls = ClassLoaderUtils.getURLs(classLoader);
        Assertions.assertNotNull(urls);
        Assertions.assertEquals(0, urls.length);
    }

}