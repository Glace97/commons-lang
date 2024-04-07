import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class getUserNameTest {
    
    @Test
    void testGetUserName() {
        SystemProperties systemProperties = new SystemProperties();
        
        // Test case 1: When USER_NAME property is set
        System.setProperty("user.name", "John");
        assertEquals("John", systemProperties.getUserName());
        
        // Test case 2: When USER_NAME property is not set
        System.clearProperty("user.name");
        assertEquals(null, systemProperties.getUserName());
        
        // Test case 3: When USER_NAME property is empty
        System.setProperty("user.name", "");
        assertEquals("", systemProperties.getUserName());
        
        // Test case 4: When USER_NAME property contains spaces
        System.setProperty("user.name", "    ");
        assertEquals("    ", systemProperties.getUserName());
        
        // Test case 5: When USER_NAME property is very long
        System.setProperty("user.name", "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
        assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789", systemProperties.getUserName());
        
        // Test case 6: When USER_NAME property contains special characters
        System.setProperty("user.name", "!@#$%^&*()_+-={}[]|:;<>,.?/~`");
        assertEquals("!@#$%^&*()_+-={}[]|:;<>,.?/~`", systemProperties.getUserName());
    }
}