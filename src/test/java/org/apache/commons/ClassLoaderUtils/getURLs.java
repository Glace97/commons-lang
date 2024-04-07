import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.net.URL;
import java.net.URLClassLoader;

class getURLsTest {

    @Test
    void testGetURLs() {
        // Test when ClassLoader is an instance of URLClassLoader
        URL[] urls = {new URL("https://www.example.com"), new URL("https://www.test.com")};
        ClassLoader urlClassLoader = new URLClassLoader(urls);
        
        URL[] result = ClassLoaderUtils.getURLs(urlClassLoader);
        
        assertArrayEquals(urls, result);
        
        // Test when ClassLoader is not an instance of URLClassLoader
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        
        URL[] emptyResult = ClassLoaderUtils.getURLs(classLoader);
        
        assertArrayEquals(ClassLoaderUtils.EMPTY_URL_ARRAY, emptyResult);
    }
}