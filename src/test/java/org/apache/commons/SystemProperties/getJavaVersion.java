import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class getJavaVersionTest {

    @Test
    void testGetJavaVersion() {
        // Test when JAVA_VERSION property is set
        System.setProperty("java.version", "1.8.0_251");
        assertEquals("1.8.0_251", SystemProperties.getJavaVersion());

        // Test when JAVA_VERSION property is not set
        System.clearProperty("java.version");
        assertNull(SystemProperties.getJavaVersion());

        // Test when JAVA_VERSION property is empty string
        System.setProperty("java.version", "");
        assertEquals("", SystemProperties.getJavaVersion());

        // Test when SecurityException is thrown
        System.setSecurityManager(new SecurityManager());
        assertNull(SystemProperties.getJavaVersion());
        System.setSecurityManager(null);
    }
}