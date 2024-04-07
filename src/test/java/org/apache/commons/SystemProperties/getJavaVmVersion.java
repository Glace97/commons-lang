
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getJavaVmVersionTest {

    @Test
    void testGetJavaVmVersion() {
        SystemProperties systemProperties = new SystemProperties();

        // Test when the property exists
        String version = systemProperties.getJavaVmVersion();
        assertNotNull(version);
        assertTrue(version.length() > 0);

        // Test when the property does not exist
        System.clearProperty(SystemProperties.JAVA_VM_VERSION);
        version = systemProperties.getJavaVmVersion();
        assertNull(version);

        // Test when a SecurityException is thrown
        System.setSecurityManager(new SecurityManager());
        version = systemProperties.getJavaVmVersion();
        assertNull(version);
        System.setSecurityManager(null);
    }

}
