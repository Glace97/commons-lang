import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class validStateTest {

    @Test
    void testValidState() {
        // Test valid state
        Validate.validState(true);
    }

    @Test
    void testInvalidState() {
        // Test invalid state
        assertThrows(IllegalStateException.class, () -> Validate.validState(false));
    }

    @Test
    void testValidStateWithMessage() {
        // Test valid state with message
        Validate.validState(true, "This is a valid state");
    }

    @Test
    void testInvalidStateWithMessage() {
        // Test invalid state with message
        assertThrows(IllegalStateException.class, () -> Validate.validState(false, "This is an invalid state"));
    }

    @Test
    void testValidStateWithMessageAndValues() {
        // Test valid state with message and values
        Validate.validState(true, "The value is %d", 5);
    }

    @Test
    void testInvalidStateWithMessageAndValues() {
        // Test invalid state with message and values
        assertThrows(IllegalStateException.class, () -> Validate.validState(false, "The value is %d", 10));
    }
}