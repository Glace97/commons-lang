import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getJavaExtDirsTest {

    @Test
    void testGetJavaExtDirs() {
        SystemProperties systemProperties = new SystemProperties();

        // Test when the property exists
        String extDirs = systemProperties.getJavaExtDirs();
        assertNotNull(extDirs);

        // Test when the property does not exist
        System.clearProperty("java.ext.dirs");
        extDirs = systemProperties.getJavaExtDirs();
        assertNull(extDirs);
    }
}