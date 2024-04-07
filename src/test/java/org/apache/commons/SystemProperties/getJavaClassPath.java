import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getJavaClassPathTest {

    @Test
    void testGetJavaClassPath() {
        SystemProperties properties = new SystemProperties();
        String javaClassPath = properties.getJavaClassPath();
        // Test if the returned value is not null
        assertNotNull(javaClassPath);
        // Test if the returned value is a string
        assertTrue(javaClassPath instanceof String);
        // Test if the returned value is equal to the expected value
        assertEquals(System.getProperty("java.class.path"), javaClassPath);
    }

    @Test
    void testGetJavaClassPath_Null() {
        // Mock a SecurityException
        SecurityManager originalSecurityManager = System.getSecurityManager();
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPropertiesAccess() {
                throw new SecurityException();
            }
        });

        SystemProperties properties = new SystemProperties();
        String javaClassPath = properties.getJavaClassPath();
        // Test if the returned value is null
        assertNull(javaClassPath);

        // Restore the original security manager
        System.setSecurityManager(originalSecurityManager);
    }
}
