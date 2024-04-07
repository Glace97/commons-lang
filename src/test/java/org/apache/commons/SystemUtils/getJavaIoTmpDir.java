import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getJavaIoTmpDirTest {

    @Test
    void testGetJavaIoTmpDir() {
        String tmpDir = System.getProperty("java.io.tmpdir");
        File expectedDir = new File(tmpDir);

        assertEquals(expectedDir, SystemUtils.getJavaIoTmpDir());
    }
}