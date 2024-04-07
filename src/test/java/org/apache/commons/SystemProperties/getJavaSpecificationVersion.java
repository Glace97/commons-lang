import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getJavaSpecificationVersionTest {
    
    @Test
    void testJavaSpecificationVersion() {
        String expected = System.getProperty("java.specification.version");
        String actual = SystemProperties.getJavaSpecificationVersion();
        assertEquals(expected, actual);
    }
}