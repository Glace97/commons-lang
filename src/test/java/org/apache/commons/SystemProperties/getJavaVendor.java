import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getJavaVendorTest {
    
    @Test
    void testGetJavaVendor() {
        String javaVendor = SystemProperties.getJavaVendor();
        assertNotNull(javaVendor);
    }
    
}