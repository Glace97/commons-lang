import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getFileEncodingTest {
    @Test
    void testGetFileEncoding() {
        String fileEncoding = SystemProperties.getFileEncoding();
        Assertions.assertNotNull(fileEncoding);
    }
}