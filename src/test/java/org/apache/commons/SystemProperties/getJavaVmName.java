import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getJavaVmNameTest {

    @Test
    void testGetJavaVmName() {
        String expected = System.getProperty("java.vm.name");
        String actual = SystemProperties.getJavaVmName();
        assertEquals(expected, actual);
    }
}