import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class getJavaClassVersionTest {

    private SystemProperties systemProperties;

    @BeforeEach
    void setUp() {
        systemProperties = new SystemProperties();
    }

    @Test
    void testGetJavaClassVersion() {
        String javaClassVersion = systemProperties.getJavaClassVersion();
        assertEquals(System.getProperty("java.class.version"), javaClassVersion);
    }

    @Test
    void testGetJavaClassVersionReturnsNullOnSecurityException() {
        SecurityManager originalSecurityManager = System.getSecurityManager();
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPropertyAccess(String key) {
                throw new SecurityException();
            }
        });

        String javaClassVersion = systemProperties.getJavaClassVersion();

        System.setSecurityManager(originalSecurityManager);

        assertNull(javaClassVersion);
    }
}