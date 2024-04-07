import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class toBooleanDefaultIfNullTest {

    private final BooleanUtils booleanUtils = new BooleanUtils();

    @Test
    void testToBooleanDefaultIfNullWithTrue() {
        boolean result = booleanUtils.toBooleanDefaultIfNull(Boolean.TRUE, false);
        assertEquals(true, result);
    }

    @Test
    void testToBooleanDefaultIfNullWithFalse() {
        boolean result = booleanUtils.toBooleanDefaultIfNull(Boolean.FALSE, true);
        assertEquals(false, result);
    }

    @Test
    void testToBooleanDefaultIfNullWithNullAndTrueValue() {
        boolean result = booleanUtils.toBooleanDefaultIfNull(null, true);
        assertEquals(true, result);
    }

    @Test
    void testToBooleanDefaultIfNullWithNullAndFalseValue() {
        boolean result = booleanUtils.toBooleanDefaultIfNull(null, false);
        assertEquals(false, result);
    }
}