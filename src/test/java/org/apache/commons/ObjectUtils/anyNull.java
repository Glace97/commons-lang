import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class anyNullTest {

    @Test
    void testAnyNullWithNullValues() {
        assertTrue(ObjectUtils.anyNull(null));
        assertTrue(ObjectUtils.anyNull(null, null));
        assertTrue(ObjectUtils.anyNull(null, "value"));
        assertTrue(ObjectUtils.anyNull("value", null));
        assertTrue(ObjectUtils.anyNull("value", "value", null, "value"));
    }

    @Test
    void testAnyNullWithNonNullValues() {
        assertFalse(ObjectUtils.anyNull("value"));
        assertFalse(ObjectUtils.anyNull("value", "value"));
        assertFalse(ObjectUtils.anyNull("value", "value", "value"));
    }

    @Test
    void testAnyNullWithEmptyArray() {
        assertTrue(ObjectUtils.anyNull());
    }

    @Test
    void testAnyNullWithNonArrayValues() {
        assertFalse(ObjectUtils.anyNull("value"));
        assertFalse(ObjectUtils.anyNull(1));
        assertFalse(ObjectUtils.anyNull(true));
    }

    @Test
    void testAnyNullWithMixedArrayAndNonArrayValues() {
        assertTrue(ObjectUtils.anyNull(null, "value", 1));
        assertTrue(ObjectUtils.anyNull("value", null, true));
        assertTrue(ObjectUtils.anyNull(null, "value", 1, true));
    }
}