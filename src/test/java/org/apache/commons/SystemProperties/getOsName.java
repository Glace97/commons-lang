import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getOsNameTest {
    
    @Test
    void testGetOsName() {
        // Test when OS_NAME is not set
        System.clearProperty("os.name");
        String osName = SystemProperties.getOsName();
        assertEquals(null, osName);
        
        // Test when OS_NAME is set
        System.setProperty("os.name", "Windows");
        osName = SystemProperties.getOsName();
        assertEquals("Windows", osName);
    }
    
}