import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getOsVersionTest {

    @Test
    void testGetOsVersion() {
        String osVersion = SystemProperties.getOsVersion();
        assertNotNull(osVersion);
        assertFalse(osVersion.isEmpty());
    }
}