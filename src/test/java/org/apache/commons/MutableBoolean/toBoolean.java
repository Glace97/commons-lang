import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class toBooleanTest {

    private MutableBoolean mutableBoolean;

    @BeforeEach
    void setUp() {
        mutableBoolean = new MutableBoolean();
    }

    @Test
    void testToBoolean_DefaultValue_ReturnsFalse() {
        assertFalse(mutableBoolean.toBoolean());
    }

    @Test
    void testToBoolean_TrueValue_ReturnsTrue() {
        mutableBoolean = new MutableBoolean(true);
        assertTrue(mutableBoolean.toBoolean());
    }

    @Test
    void testToBoolean_FalseValue_ReturnsFalse() {
        mutableBoolean = new MutableBoolean(false);
        assertFalse(mutableBoolean.toBoolean());
    }

    @Test
    void testToBoolean_NullValue_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new MutableBoolean((Boolean) null).toBoolean());
    }
}