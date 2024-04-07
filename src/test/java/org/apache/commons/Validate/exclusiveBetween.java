
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class exclusiveBetweenTest {

    @Test
    void testExclusiveBetweenDouble() {
        // Test with values within the exclusive range
        assertThrows(IllegalArgumentException.class, () -> Validate.exclusiveBetween(0.1, 2.1, 0.0));
        assertThrows(IllegalArgumentException.class, () -> Validate.exclusiveBetween(0.1, 2.1, 2.2));

        // Test with values outside the exclusive range
        assertDoesNotThrow(() -> Validate.exclusiveBetween(0.1, 2.1, 1.1));
        assertDoesNotThrow(() -> Validate.exclusiveBetween(0.1, 2.1, 1.5));
    }

    @Test
    void testExclusiveBetweenDoubleWithMessage() {
        // Test with values within the exclusive range
        assertThrows(IllegalArgumentException.class, () -> Validate.exclusiveBetween(0.1, 2.1, 0.0, "Not in range"));
        assertThrows(IllegalArgumentException.class, () -> Validate.exclusiveBetween(0.1, 2.1, 2.2, "Not in range"));

        // Test with values outside the exclusive range
        assertDoesNotThrow(() -> Validate.exclusiveBetween(0.1, 2.1, 1.1, "Not in range"));
        assertDoesNotThrow(() -> Validate.exclusiveBetween(0.1, 2.1, 1.5, "Not in range"));
    }

    @Test
    void testExclusiveBetweenLong() {
        // Test with values within the exclusive range
        assertThrows(IllegalArgumentException.class, () -> Validate.exclusiveBetween(0, 2, -1));
        assertThrows(IllegalArgumentException.class, () -> Validate.exclusiveBetween(0, 2, 3));

        // Test with values outside the exclusive range
        assertDoesNotThrow(() -> Validate.exclusiveBetween(0, 2, 1));
        assertDoesNotThrow(() -> Validate.exclusiveBetween(0, 2, 1));
    }

    @Test
    void testExclusiveBetweenLongWithMessage() {
        // Test with values within the exclusive range
        assertThrows(IllegalArgumentException.class, () -> Validate.exclusiveBetween(0, 2, -1, "Not in range"));
        assertThrows(IllegalArgumentException.class, () -> Validate.exclusiveBetween(0, 2, 3, "Not in range"));

        // Test with values outside the exclusive range
        assertDoesNotThrow(() -> Validate.exclusiveBetween(0, 2, 1, "Not in range"));
        assertDoesNotThrow(() -> Validate.exclusiveBetween(0, 2, 1, "Not in range"));
    }

    @Test
    void testExclusiveBetweenComparable() {
        // Test with values within the exclusive range
        assertThrows(IllegalArgumentException.class, () -> Validate.exclusiveBetween(0, 2, -1));
        assertThrows(IllegalArgumentException.class, () -> Validate.exclusiveBetween(0, 2, 3));

        // Test with values outside the exclusive range
        assertDoesNotThrow(() -> Validate.exclusiveBetween(0, 2, 1));
        assertDoesNotThrow(() -> Validate.exclusiveBetween(0, 2, 1));
    }

    @Test
    void testExclusiveBetweenComparableWithMessage() {
        // Test with values within the exclusive range
        assertThrows(IllegalArgumentException.class, () -> Validate.exclusiveBetween(0, 2, -1, "Not in range"));
        assertThrows(IllegalArgumentException.class, () -> Validate.exclusiveBetween(0, 2, 3, "Not in range"));

        // Test with values outside the exclusive range
        assertDoesNotThrow(() -> Validate.exclusiveBetween(0, 2, 1, "Not in range"));
        assertDoesNotThrow(() -> Validate.exclusiveBetween(0, 2, 1, "Not in range"));
    }
}
