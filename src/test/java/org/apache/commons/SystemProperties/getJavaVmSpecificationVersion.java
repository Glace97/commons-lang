
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getJavaVmSpecificationVersionTest {

    @Test
    void testGetJavaVmSpecificationVersion() {
        SystemProperties systemProperties = new SystemProperties();

        // Test when the property is not set
        assertNull(systemProperties.getJavaVmSpecificationVersion());

        // Test when the property is set with a valid value
        System.setProperty("java.vm.specification.version", "1.8");
        assertEquals("1.8", systemProperties.getJavaVmSpecificationVersion());

        // Test when the property is set with an empty value
        System.setProperty("java.vm.specification.version", "");
        assertEquals("", systemProperties.getJavaVmSpecificationVersion());

        // Test when the property is set with a null value
        System.setProperty("java.vm.specification.version", null);
        assertNull(systemProperties.getJavaVmSpecificationVersion());
    }
}
