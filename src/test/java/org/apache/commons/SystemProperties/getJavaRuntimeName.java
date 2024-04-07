
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getJavaRuntimeNameTest {
    private static SystemProperties systemProperties;

    @BeforeAll
    static void setup() {
        systemProperties = new SystemProperties();
    }

    @Test
    @DisplayName("Test getJavaRuntimeName returns correct value")
    void testGetJavaRuntimeName() {
        String expected = System.getProperty("java.runtime.name");
        String actual = systemProperties.getJavaRuntimeName();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test getJavaRuntimeName returns null when SecurityException occurs")
    void testGetJavaRuntimeNameWithSecurityException() {
        SecurityManager originalSecurityManager = System.getSecurityManager();
        try {
            System.setSecurityManager(new SecurityManager() {
                @Override
                public void checkPropertyAccess(String key) {
                    throw new SecurityException("Access denied");
                }
            });

            assertNull(systemProperties.getJavaRuntimeName());
        } finally {
            System.setSecurityManager(originalSecurityManager);
        }
    }
}
