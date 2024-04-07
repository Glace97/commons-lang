import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getJavaVmSpecificationNameTest {

    @Test
    void shouldReturnJavaVmSpecificationName() {
        SystemProperties systemProperties = new SystemProperties();
        String expected = System.getProperty("java.vm.specification.name");
        String actual = systemProperties.getJavaVmSpecificationName();
        assertEquals(expected, actual);
    }
}