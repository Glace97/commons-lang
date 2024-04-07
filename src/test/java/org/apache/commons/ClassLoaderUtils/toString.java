import org.junit.jupiter.api.Test;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class toStringTest {

    @Test
    void testToStringWithNullClassLoader() {
        String expected = "null";
        String actual = ClassLoaderUtils.toString(null);
        assertEquals(expected, actual);
    }

    @Test
    void testToStringWithNonURLClassLoader() {
        ClassLoader classLoader = new ClassLoader() {};
        String expected = classLoader.toString();
        String actual = ClassLoaderUtils.toString(classLoader);
        assertEquals(expected, actual);
    }

    @Test
    void testToStringWithURLClassLoader() {
        URLClassLoader classLoader = new URLClassLoader(new URL[]{});
        String expected = classLoader.toString() + Arrays.toString(classLoader.getURLs());
        String actual = ClassLoaderUtils.toString(classLoader);
        assertEquals(expected, actual);
    }
}