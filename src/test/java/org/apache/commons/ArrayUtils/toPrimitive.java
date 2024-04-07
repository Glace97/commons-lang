import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class toPrimitiveTest {

    @Test
    void testToPrimitive_WithNullArray_ShouldReturnNull() {
        Boolean[] array = null;
        boolean[] result = ArrayUtils.toPrimitive(array);
        assertNull(result);
    }

    @Test
    void testToPrimitive_WithEmptyArray_ShouldReturnEmptyArray() {
        Boolean[] array = {};
        boolean[] result = ArrayUtils.toPrimitive(array);
        assertEquals(0, result.length);
    }

    @Test
    void testToPrimitive_WithNullElement_ShouldReturnDefaultValue() {
        Boolean[] array = { true, null, false };
        boolean[] result = ArrayUtils.toPrimitive(array, false);
        assertEquals(3, result.length);
        assertTrue(result[0]);
        assertFalse(result[1]);
        assertFalse(result[2]);
    }

    @Test
    void testToPrimitive_WithNonNullArray_ShouldReturnPrimitiveArray() {
        Boolean[] array = { true, false, true };
        boolean[] result = ArrayUtils.toPrimitive(array);
        assertEquals(3, result.length);
        assertTrue(result[0]);
        assertFalse(result[1]);
        assertTrue(result[2]);
    }

    @Test
    void testToPrimitive_WithNullArrayAndDefaultValue_ShouldReturnNull() {
        Boolean[] array = null;
        boolean[] result = ArrayUtils.toPrimitive(array, true);
        assertNull(result);
    }

    @Test
    void testToPrimitive_WithEmptyArrayAndDefaultValue_ShouldReturnEmptyArray() {
        Boolean[] array = {};
        boolean[] result = ArrayUtils.toPrimitive(array, true);
        assertEquals(0, result.length);
    }

    @Test
    void testToPrimitive_WithNullElementAndDefaultValue_ShouldReturnDefaultValue() {
        Boolean[] array = { true, null, false };
        boolean[] result = ArrayUtils.toPrimitive(array, true);
        assertEquals(3, result.length);
        assertTrue(result[0]);
        assertTrue(result[1]);
        assertFalse(result[2]);
    }

    @Test
    void testToPrimitive_WithNonNullArrayAndDefaultValue_ShouldReturnPrimitiveArray() {
        Boolean[] array = { true, false, true };
        boolean[] result = ArrayUtils.toPrimitive(array, false);
        assertEquals(3, result.length);
        assertTrue(result[0]);
        assertFalse(result[1]);
        assertTrue(result[2]);
    }
}
Note: This is just a sample test suite that covers some of the edge cases. Depending on the requirements and complexity of the method, more test cases may need to be added to achieve high coverage.