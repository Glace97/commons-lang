import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getIntTest {
    private SystemProperties systemProperties;

    @BeforeAll
    void setup() {
        systemProperties = new SystemProperties();
    }

    @ParameterizedTest
    @CsvSource({"awt.toolkit, 1", "file.encoding, 2", "file.separator, -1", "java.awt.fonts, 0", "java.awt.graphicsenv, 10"})
    void testGetIntWithExistingProperty(String key, int expected) {
        int result = systemProperties.getInt(key, null);
        assertEquals(expected, result);
    }

    @Test
    void testGetIntWithNonExistingPropertyAndNoDefault() {
        int result = systemProperties.getInt("non.existing.property", null);
        assertEquals(0, result);
    }

    @Test
    void testGetIntWithNonExistingPropertyAndDefault() {
        int result = systemProperties.getInt("non.existing.property", () -> 5);
        assertEquals(5, result);
    }
}