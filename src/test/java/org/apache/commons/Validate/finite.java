import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class finiteTest {

    @Test
    void testFiniteWithValidValue() {
        double value = 10.5;
        assertDoesNotThrow(() -> Validate.finite(value));
    }

    @Test
    void testFiniteWithNaNValue() {
        double value = Double.NaN;
        assertThrows(IllegalArgumentException.class, () -> Validate.finite(value));
    }

    @Test
    void testFiniteWithPositiveInfinityValue() {
        double value = Double.POSITIVE_INFINITY;
        assertThrows(IllegalArgumentException.class, () -> Validate.finite(value));
    }

    @Test
    void testFiniteWithNegativeInfinityValue() {
        double value = Double.NEGATIVE_INFINITY;
        assertThrows(IllegalArgumentException.class, () -> Validate.finite(value));
    }

    @Test
    void testFiniteWithValidValueAndCustomMessage() {
        double value = 10.5;
        String message = "Value must be finite";
        assertDoesNotThrow(() -> Validate.finite(value, message));
    }

    @Test
    void testFiniteWithNaNValueAndCustomMessage() {
        double value = Double.NaN;
        String message = "Value must be finite";
        assertThrows(IllegalArgumentException.class, () -> Validate.finite(value, message));
    }

    @Test
    void testFiniteWithPositiveInfinityValueAndCustomMessage() {
        double value = Double.POSITIVE_INFINITY;
        String message = "Value must be finite";
        assertThrows(IllegalArgumentException.class, () -> Validate.finite(value, message));
    }

    @Test
    void testFiniteWithNegativeInfinityValueAndCustomMessage() {
        double value = Double.NEGATIVE_INFINITY;
        String message = "Value must be finite";
        assertThrows(IllegalArgumentException.class, () -> Validate.finite(value, message));
    }

}