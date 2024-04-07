import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isJavaVersionAtMostTest {
    
    @Test
    void testIsJavaVersionAtMost() {
        // Test with required version less than actual version
        assertFalse(SystemUtils.isJavaVersionAtMost(JavaVersion.JAVA_1_1));
        
        // Test with required version equal to actual version
        assertTrue(SystemUtils.isJavaVersionAtMost(JavaVersion.JAVA_1_8));
        
        // Test with required version greater than actual version
        assertTrue(SystemUtils.isJavaVersionAtMost(JavaVersion.JAVA_16));
    }
}