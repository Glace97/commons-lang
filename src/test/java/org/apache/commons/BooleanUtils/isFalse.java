import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isFalseTest {

    @Test
    void testIsFalseWithTrue() {
        assertFalse(BooleanUtils.isFalse(Boolean.TRUE));
    }

    @Test
    void testIsFalseWithFalse() {
        assertTrue(BooleanUtils.isFalse(Boolean.FALSE));
    }

    @Test
    void testIsFalseWithNull() {
        assertFalse(BooleanUtils.isFalse(null));
    }
}