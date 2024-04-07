
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getJavaIoTmpdirTest {

    private SystemProperties systemProperties;

    @BeforeEach
    void setUp() {
        systemProperties = new SystemProperties();
    }

    @Test
    void testGetJavaIoTmpdir() {
        String tmpdir = System.getProperty("java.io.tmpdir");
        String result = systemProperties.getJavaIoTmpdir();
        
        assertEquals(tmpdir, result);
    }
}
