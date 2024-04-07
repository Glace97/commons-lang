import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getJavaVmVendorTest {

    @Test
    void testGetJavaVmVendor() {
        String javaVmVendor = SystemProperties.getJavaVmVendor();
        Assertions.assertNotNull(javaVmVendor);
    }
}