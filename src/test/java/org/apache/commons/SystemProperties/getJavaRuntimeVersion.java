import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getJavaRuntimeVersionTest {

    private SystemProperties systemProperties = new SystemProperties();

    @Test
    void testGetJavaRuntimeVersion() {
        String runtimeVersion = systemProperties.getJavaRuntimeVersion();
        Assertions.assertNotNull(runtimeVersion);
    }
}