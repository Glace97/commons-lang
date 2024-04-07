
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isAssignableFromTest {

    @Test
    void testIsAssignableFrom() {
        // Test with valid arguments
        assertDoesNotThrow(() -> Validate.isAssignableFrom(Number.class, Integer.class));
        assertDoesNotThrow(() -> Validate.isAssignableFrom(Number.class, Double.class));
        assertDoesNotThrow(() -> Validate.isAssignableFrom(Collection.class, List.class));
        assertDoesNotThrow(() -> Validate.isAssignableFrom(Map.class, HashMap.class));

        // Test with invalid arguments
        assertThrows(IllegalArgumentException.class, () -> Validate.isAssignableFrom(Integer.class, Number.class));
        assertThrows(IllegalArgumentException.class, () -> Validate.isAssignableFrom(Double.class, Number.class));
        assertThrows(IllegalArgumentException.class, () -> Validate.isAssignableFrom(List.class, Collection.class));
        assertThrows(IllegalArgumentException.class, () -> Validate.isAssignableFrom(HashMap.class, Map.class));
    }

    @Test
    void testIsAssignableFromWithMessage() {
        // Test with valid arguments
        assertDoesNotThrow(() -> Validate.isAssignableFrom(Number.class, Integer.class, "Custom message"));
        assertDoesNotThrow(() -> Validate.isAssignableFrom(Number.class, Double.class, "Custom message"));
        assertDoesNotThrow(() -> Validate.isAssignableFrom(Collection.class, List.class, "Custom message"));
        assertDoesNotThrow(() -> Validate.isAssignableFrom(Map.class, HashMap.class, "Custom message"));

        // Test with invalid arguments
        assertThrows(IllegalArgumentException.class, () -> Validate.isAssignableFrom(Integer.class, Number.class, "Custom message"));
        assertThrows(IllegalArgumentException.class, () -> Validate.isAssignableFrom(Double.class, Number.class, "Custom message"));
        assertThrows(IllegalArgumentException.class, () -> Validate.isAssignableFrom(List.class, Collection.class, "Custom message"));
        assertThrows(IllegalArgumentException.class, () -> Validate.isAssignableFrom(HashMap.class, Map.class, "Custom message"));
    }
}
