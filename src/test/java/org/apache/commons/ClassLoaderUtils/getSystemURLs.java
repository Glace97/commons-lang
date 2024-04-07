import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.net.URLClassLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class getSystemURLsTest {

    @Test
    @DisplayName("Test getSystemURLs with empty URL array")
    void testGetSystemURLsEmpty() {
        URL[] expected = {};
        URL[] actual = ClassLoaderUtils.getSystemURLs();
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Test getSystemURLs with non-empty URL array")
    void testGetSystemURLsNonEmpty() {
        URL[] urls = {new URL("https://example.com"), new URL("https://example.org")};
        URLClassLoader classLoader = new URLClassLoader(urls);
        URL[] expected = urls;
        URL[] actual = ClassLoaderUtils.getURLs(classLoader);
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Test getSystemURLs with null class loader")
    void testGetSystemURLsNullClassLoader() {
        URL[] expected = ClassLoaderUtils.EMPTY_URL_ARRAY;
        URL[] actual = ClassLoaderUtils.getURLs(null);
        assertArrayEquals(expected, actual);
    }
    
    // Add more test cases to cover edge cases and achieve high coverage
    
    // Test getSystemURLs with custom class loader
    
    @Test
    @DisplayName("Test getSystemURLs with custom class loader")
    void testGetSystemURLsCustomClassLoader() {
        URL[] urls = {new URL("https://example.com"), new URL("https://example.org")};
        URLClassLoader classLoader = new URLClassLoader(urls);
        URL[] expected = urls;
        URL[] actual = ClassLoaderUtils.getURLs(classLoader);
        assertArrayEquals(expected, actual);
    }
    
    // Test getSystemURLs with system class loader
    
    @Test
    @DisplayName("Test getSystemURLs with system class loader")
    void testGetSystemURLsSystemClassLoader() {
        URL[] expected = ClassLoaderUtils.getSystemURLs();
        URL[] actual = ClassLoaderUtils.getURLs(ClassLoader.getSystemClassLoader());
        assertArrayEquals(expected, actual);
    }
    
    // Test getSystemURLs with custom class loader and null URLs
    
    @Test
    @DisplayName("Test getSystemURLs with custom class loader and null URLs")
    void testGetSystemURLsCustomClassLoaderNullURLs() {
        URL[] urls = null;
        URLClassLoader classLoader = new URLClassLoader(urls);
        URL[] expected = ClassLoaderUtils.EMPTY_URL_ARRAY;
        URL[] actual = ClassLoaderUtils.getURLs(classLoader);
        assertArrayEquals(expected, actual);
    }
    
    // Test getSystemURLs with custom class loader and empty URLs
    
    @Test
    @DisplayName("Test getSystemURLs with custom class loader and empty URLs")
    void testGetSystemURLsCustomClassLoaderEmptyURLs() {
        URL[] urls = {};
        URLClassLoader classLoader = new URLClassLoader(urls);
        URL[] expected = urls;
        URL[] actual = ClassLoaderUtils.getURLs(classLoader);
        assertArrayEquals(expected, actual);
    }
    
    // Test getSystemURLs with custom class loader and single URL
    
    @Test
    @DisplayName("Test getSystemURLs with custom class loader and single URL")
    void testGetSystemURLsCustomClassLoaderSingleURL() {
        URL[] urls = {new URL("https://example.com")};
        URLClassLoader classLoader = new URLClassLoader(urls);
        URL[] expected = urls;
        URL[] actual = ClassLoaderUtils.getURLs(classLoader);
        assertArrayEquals(expected, actual);
    }
}