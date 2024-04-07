import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getJavaHomeTest {

    private SystemProperties systemProperties;

    @BeforeEach
    void setUp() {
        systemProperties = new SystemProperties();
    }

    @Test
    void testGetJavaHomeReturnsNonNullValue() {
        assertNotNull(systemProperties.getJavaHome());
    }

    @Test
    void testGetJavaHomeReturnsCorrectValue() {
        String expected = System.getProperty("java.home");
        assertEquals(expected, systemProperties.getJavaHome());
    }

    @Test
    void testGetJavaHomeReturnsNullIfSecurityExceptionOccurs() {
        // Mocking a SecurityException by temporarily setting a security manager
        System.setSecurityManager(new SecurityManager());
        assertNull(systemProperties.getJavaHome());
        System.setSecurityManager(null);
    }
}