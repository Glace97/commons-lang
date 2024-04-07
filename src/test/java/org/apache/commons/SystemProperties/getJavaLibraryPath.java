
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class getJavaLibraryPathTest {

    @Test
    void testGetJavaLibraryPath() {
        String javaLibraryPath = SystemProperties.getJavaLibraryPath();
        assertNotNull(javaLibraryPath);
    }

    @Test
    void testGetJavaLibraryPath_NullWhenSecurityException() {
        // Simulating SecurityException by mocking the SecurityManager
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPropertiesAccess() {
                throw new SecurityException();
            }
        });

        String javaLibraryPath = SystemProperties.getJavaLibraryPath();
        assertNull(javaLibraryPath);

        // Resetting the SecurityManager
        System.setSecurityManager(null);
    }

    @Test
    void testGetJavaLibraryPath_EdgeCases() {
        // Test when the property is not set
        System.clearProperty("java.library.path");
        String javaLibraryPath = SystemProperties.getJavaLibraryPath();
        assertNull(javaLibraryPath);

        // Test when the property is empty
        System.setProperty("java.library.path", "");
        javaLibraryPath = SystemProperties.getJavaLibraryPath();
        assertEquals("", javaLibraryPath);

        // Test when the property has a value
        System.setProperty("java.library.path", "/usr/local/lib");
        javaLibraryPath = SystemProperties.getJavaLibraryPath();
        assertEquals("/usr/local/lib", javaLibraryPath);
    }
}
