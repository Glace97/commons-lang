import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getThreadURLsTest {

    @Test
    void testGetThreadURLsWithNullClassLoader() {
        URL[] urls = ClassLoaderUtils.getThreadURLs();
        assertNotNull(urls);
        assertEquals(0, urls.length);
    }

    @Test
    void testGetThreadURLsWithEmptyClassLoader() {
        ClassLoader classLoader = new URLClassLoader(new URL[]{});
        Thread.currentThread().setContextClassLoader(classLoader);

        URL[] urls = ClassLoaderUtils.getThreadURLs();
        assertNotNull(urls);
        assertEquals(0, urls.length);
    }
    
    @Test
    void testGetThreadURLsWithClassLoader() {
        URL url = getClass().getResource("/test.jar");
        ClassLoader classLoader = new URLClassLoader(new URL[]{url});
        Thread.currentThread().setContextClassLoader(classLoader);

        URL[] urls = ClassLoaderUtils.getThreadURLs();
        assertNotNull(urls);
        assertEquals(1, urls.length);
        assertEquals(url, urls[0]);
    }
}