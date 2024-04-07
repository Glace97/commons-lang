import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class getOsArchTest {

    @Test
    void testGetOsArch() {
        String osArch = SystemProperties.getOsArch();
        assertEquals(System.getProperty("os.arch"), osArch);
    }
}