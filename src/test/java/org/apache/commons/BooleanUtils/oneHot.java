import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class oneHotTest {

    private BooleanUtils booleanUtils;

    @BeforeEach
    void setUp() {
        booleanUtils = new BooleanUtils();
    }

    @Test
    void testOneHot_withEmptyArray_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> booleanUtils.oneHot());
    }

    @Test
    void testOneHot_withNullArray_shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> booleanUtils.oneHot((Boolean[]) null));
    }

    @Test
    void testOneHot_withAllFalseArray_shouldReturnFalse() {
        boolean result = booleanUtils.oneHot(false, false, false);
        assertFalse(result);
    }

    @Test
    void testOneHot_withAllTrueArray_shouldReturnFalse() {
        boolean result = booleanUtils.oneHot(true, true, true);
        assertFalse(result);
    }

    @Test
    void testOneHot_withOneTrueValue_shouldReturnTrue() {
        boolean result = booleanUtils.oneHot(false, false, true);
        assertTrue(result);
    }

    @Test
    void testOneHot_withMultipleTrueValues_shouldReturnFalse() {
        boolean result = booleanUtils.oneHot(true, false, true);
        assertFalse(result);
    }

    @Test
    void testOneHot_withMixedTrueAndFalseValues_shouldReturnFalse() {
        boolean result = booleanUtils.oneHot(true, false, true, false);
        assertFalse(result);
    }

    @Test
    void testOneHot_withNullElementArray_shouldReturnFalse() {
        boolean result = booleanUtils.oneHot(null, false, true);
        assertFalse(result);
    }
}