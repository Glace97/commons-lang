import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getUserNameTest {
    
    @Test
    void testGetUserName() {
        String username = System.getProperty(SystemProperties.USER_NAME);
        assertNotNull(username);
    }
    
    @Test
    void testGetUserNameWithDefaultValue() {
        String defaultValue = "Guest";
        String username = System.getProperty(SystemProperties.USER_NAME, defaultValue);
        assertNotNull(username);
        assertNotEquals(defaultValue, username);
    }
    
}