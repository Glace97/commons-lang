import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FirstNonNullTest {

    @Test
    void testFirstNonNullWithNullValues() {
        assertNull(ObjectUtils.firstNonNull());
    }

    @Test
    void testFirstNonNullWithNullAndNonNullValues() {
        assertNull(ObjectUtils.firstNonNull(null, null));
        assertEquals("", ObjectUtils.firstNonNull(null, ""));
        assertEquals("", ObjectUtils.firstNonNull(null, null, ""));
        assertEquals("zz", ObjectUtils.firstNonNull(null, "zz"));
        assertEquals("abc", ObjectUtils.firstNonNull("abc"));
        assertEquals("xyz", ObjectUtils.firstNonNull(null, "xyz", "*"));
        assertEquals(Boolean.TRUE, ObjectUtils.firstNonNull(Boolean.TRUE, "*"));
    }

    @Test
    void testFirstNonNullWithNonNullValues() {
        assertEquals("abc", ObjectUtils.firstNonNull("abc", "def", "ghi"));
        assertEquals(123, ObjectUtils.firstNonNull(123, 456, 789));
        assertEquals(3.14, ObjectUtils.firstNonNull(3.14, 2.71, 1.618));
        assertEquals(true, ObjectUtils.firstNonNull(true, false));
    }

    @Test
    void testFirstNonNullWithEmptyArray() {
        assertNull(ObjectUtils.firstNonNull(new String[] {}));
        assertNull(ObjectUtils.firstNonNull(new Integer[] {}));
        assertNull(ObjectUtils.firstNonNull(new Double[] {}));
        assertNull(ObjectUtils.firstNonNull(new Boolean[] {}));
    }

    @Test
    void testFirstNonNullWithArrayContainingNull() {
        assertNull(ObjectUtils.firstNonNull(new String[] {null}));
        assertNull(ObjectUtils.firstNonNull(new Integer[] {null}));
        assertNull(ObjectUtils.firstNonNull(new Double[] {null}));
        assertNull(ObjectUtils.firstNonNull(new Boolean[] {null}));
    }

    @Test
    void testFirstNonNullWithArrayContainingNonNullValues() {
        assertEquals("abc", ObjectUtils.firstNonNull(new String[] {"abc", "def", "ghi"}));
        assertEquals(123, ObjectUtils.firstNonNull(new Integer[] {null, 123, 456}));
        assertEquals(3.14, ObjectUtils.firstNonNull(new Double[] {3.14, null, 2.71}));
        assertEquals(true, ObjectUtils.firstNonNull(new Boolean[] {null, true, false}));
    }
}