import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getEnvironmentVariableTest {

    @Test
    void testGetEnvironmentVariable() {
        // Test when the environment variable exists
        String result1 = SystemUtils.getEnvironmentVariable("JAVA_HOME", "default");
        assertNotNull(result1);
        
        // Test when the environment variable does not exist
        String result2 = SystemUtils.getEnvironmentVariable("NOT_EXIST", "default");
        assertEquals("default", result2);
        
        // Test when the security exception is thrown
        SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("getProperty")) {
                    throw new SecurityException();
                }
            }
        };
        System.setSecurityManager(securityManager);
        String result3 = SystemUtils.getEnvironmentVariable("JAVA_HOME", "default");
        assertEquals("default", result3);
        System.setSecurityManager(null);
    }
}