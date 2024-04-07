import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getLongTest {
    SystemProperties systemProperties;

    @BeforeEach
    void setUp() {
        systemProperties = new SystemProperties();
    }

    @Test
    void testGetLongWithExistingKey() {
        long expected = 1234567890L;
        System.setProperty("test.key", String.valueOf(expected));
        long actual = systemProperties.getLong("test.key", Suppliers.ofInstance(9876543210L));
        assertEquals(expected, actual);
    }

    @Test
    void testGetLongWithNonExistingKeyAndDefaultIfAbsent() {
        long expected = 9876543210L;
        long actual = systemProperties.getLong("non.existing.key", Suppliers.ofInstance(expected));
        assertEquals(expected, actual);
    }

    @Test
    void testGetLongWithNonExistingKeyAndNoDefaultIfAbsent() {
        long expected = 0;
        long actual = systemProperties.getLong("non.existing.key", null);
        assertEquals(expected, actual);
    }

    @Test
    void testGetLongWithInvalidValueAndDefaultIfAbsent() {
        System.setProperty("test.key", "invalid");
        long expected = 9876543210L;
        long actual = systemProperties.getLong("test.key", Suppliers.ofInstance(expected));
        assertEquals(expected, actual);
    }

    @Test
    void testGetLongWithInvalidValueAndNoDefaultIfAbsent() {
        System.setProperty("test.key", "invalid");
        long expected = 0;
        long actual = systemProperties.getLong("test.key", null);
        assertEquals(expected, actual);
    }
}