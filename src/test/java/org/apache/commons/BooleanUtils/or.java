import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class orTest {

    @Test
    void testOr_withBooleans_allTrue_shouldReturnTrue() {
        assertTrue(BooleanUtils.or(true, true));
        assertTrue(BooleanUtils.or(true, true, true));
    }

    @Test
    void testOr_withBooleans_allFalse_shouldReturnFalse() {
        assertFalse(BooleanUtils.or(false, false));
        assertFalse(BooleanUtils.or(false, false, false));
    }

    @Test
    void testOr_withBooleans_mixedValues_shouldReturnTrue() {
        assertTrue(BooleanUtils.or(true, false));
        assertTrue(BooleanUtils.or(true, true, false));
    }

    @Test
    void testOr_withBooleans_emptyArray_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> BooleanUtils.or());
    }

    @Test
    void testOr_withBooleans_nullArray_shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> BooleanUtils.or((boolean[]) null));
    }

    @Test
    void testOr_withBooleans_nullElement_shouldReturnTrue() {
        assertTrue(BooleanUtils.or(true, null));
        assertTrue(BooleanUtils.or(false, null));
    }

    @Test
    void testOr_withBooleans_allNullElements_shouldReturnFalse() {
        assertFalse(BooleanUtils.or((boolean[]) null));
    }

    @Test
    void testOr_withBooleanObjects_allTrue_shouldReturnTrue() {
        assertTrue(BooleanUtils.or(Boolean.TRUE, Boolean.TRUE));
        assertTrue(BooleanUtils.or(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE));
    }

    @Test
    void testOr_withBooleanObjects_allFalse_shouldReturnFalse() {
        assertFalse(BooleanUtils.or(Boolean.FALSE, Boolean.FALSE));
        assertFalse(BooleanUtils.or(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
    }

    @Test
    void testOr_withBooleanObjects_mixedValues_shouldReturnTrue() {
        assertTrue(BooleanUtils.or(Boolean.TRUE, Boolean.FALSE));
        assertTrue(BooleanUtils.or(Boolean.TRUE, Boolean.TRUE, Boolean.FALSE));
    }

    @Test
    void testOr_withBooleanObjects_emptyArray_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> BooleanUtils.or((Boolean[]) null));
    }

    @Test
    void testOr_withBooleanObjects_nullArray_shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> BooleanUtils.or());
    }

    @Test
    void testOr_withBooleanObjects_nullElement_shouldReturnTrue() {
        assertTrue(BooleanUtils.or(Boolean.TRUE, null));
        assertTrue(BooleanUtils.or(Boolean.FALSE, null));
    }

    @Test
    void testOr_withBooleanObjects_allNullElements_shouldReturnFalse() {
        assertFalse(BooleanUtils.or((Boolean[]) null));
    }
}