import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class xorTest {

    @Test
    void testXorWithBooleanArray() {
        // Test case 1: Empty array
        assertFalse(BooleanUtils.xor());

        // Test case 2: Array with one element
        assertTrue(BooleanUtils.xor(true));
        assertFalse(BooleanUtils.xor(false));

        // Test case 3: Array with two elements
        assertFalse(BooleanUtils.xor(true, true));
        assertFalse(BooleanUtils.xor(false, false));
        assertTrue(BooleanUtils.xor(true, false));

        // Test case 4: Array with three elements
        assertTrue(BooleanUtils.xor(true, false, false));
        assertTrue(BooleanUtils.xor(true, true, true));

        // Test case 5: Array with four elements
        assertFalse(BooleanUtils.xor(true, true, true, true));
    }

    @Test
    void testXorWithBooleanObjectArray() {
        // Test case 1: Empty array
        assertFalse(BooleanUtils.xor());

        // Test case 2: Array with one element
        assertTrue(BooleanUtils.xor(Boolean.TRUE));
        assertFalse(BooleanUtils.xor(Boolean.FALSE));

        // Test case 3: Array with two elements
        assertFalse(BooleanUtils.xor(Boolean.TRUE, Boolean.TRUE));
        assertFalse(BooleanUtils.xor(Boolean.FALSE, Boolean.FALSE));
        assertTrue(BooleanUtils.xor(Boolean.TRUE, Boolean.FALSE));

        // Test case 4: Array with three elements
        assertTrue(BooleanUtils.xor(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
        assertTrue(BooleanUtils.xor(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE));

        // Test case 5: Array with four elements
        assertFalse(BooleanUtils.xor(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE));

        // Test case 6: Array with null element
        assertFalse(BooleanUtils.xor(Boolean.FALSE, null));
        assertTrue(BooleanUtils.xor(Boolean.TRUE, null));
    }
}