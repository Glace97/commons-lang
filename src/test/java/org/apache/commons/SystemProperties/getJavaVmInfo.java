import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getJavaVmInfoTest {

    @Test
    void testGetJavaVmInfo() {
        String javaVmInfo = SystemProperties.getJavaVmInfo();
        assertEquals(System.getProperty("java.vm.info"), javaVmInfo);
    }
}