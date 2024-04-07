import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isJavaVersionMatchTest {
    
    @Test
    void testIsJavaVersionMatch() {
        // Test cases for different Java versions
        assertTrue(SystemUtils.isJavaVersionMatch("1.8.0_251", "1.8"));
        assertTrue(SystemUtils.isJavaVersionMatch("11.0.7", "11"));
        assertTrue(SystemUtils.isJavaVersionMatch("14.0.2", "14"));
        assertFalse(SystemUtils.isJavaVersionMatch("1.7.0_80", "1.8"));
        assertFalse(SystemUtils.isJavaVersionMatch("10.0.2", "11"));
    }
}