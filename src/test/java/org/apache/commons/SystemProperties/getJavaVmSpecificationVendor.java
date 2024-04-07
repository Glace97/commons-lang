import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getJavaVmSpecificationVendorTest {

    private SystemProperties systemProperties;

    @BeforeAll
    void setUp() {
        systemProperties = new SystemProperties();
    }

    @Test
    void testGetJavaVmSpecificationVendor() {
        String vendor = systemProperties.getJavaVmSpecificationVendor();
        Assertions.assertNotNull(vendor);
    }
}