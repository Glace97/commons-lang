import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getJavaAwtHeadlessTest {

    @Test
    void testGetJavaAwtHeadless() {
        SystemProperties systemProperties = new SystemProperties();

        // Test when the property is not set
        assertNull(systemProperties.getJavaAwtHeadless());

        // Test when the property is set to "true"
        System.setProperty("java.awt.headless", "true");
        assertEquals("true", systemProperties.getJavaAwtHeadless());

        // Test when the property is set to "false"
        System.setProperty("java.awt.headless", "false");
        assertEquals("false", systemProperties.getJavaAwtHeadless());

        // Test when the property is set to an empty string
        System.setProperty("java.awt.headless", "");
        assertEquals("", systemProperties.getJavaAwtHeadless());

        // Test when the property is set to a non-boolean value
        System.setProperty("java.awt.headless", "test");
        assertEquals("test", systemProperties.getJavaAwtHeadless());
    }
}