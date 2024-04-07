import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class removeElementTest {

    @Test
    void testRemoveElementWithNullArray() {
        boolean[] array = null;
        boolean element = true;
        boolean[] result = ArrayUtils.removeElement(array, element);
        assertNull(result);
    }
    
    @Test
    void testRemoveElementWithEmptyArray() {
        boolean[] array = {};
        boolean element = true;
        boolean[] result = ArrayUtils.removeElement(array, element);
        assertArrayEquals(array, result);
    }
    
    @Test
    void testRemoveElementWithArrayContainingOneElement() {
        boolean[] array = {true};
        boolean element = false;
        boolean[] result = ArrayUtils.removeElement(array, element);
        assertArrayEquals(array, result);
    }
    
    @Test
    void testRemoveElementWithArrayContainingMultipleElements() {
        boolean[] array = {true, false, true};
        boolean element = true;
        boolean[] expected = {false, true};
        boolean[] result = ArrayUtils.removeElement(array, element);
        assertArrayEquals(expected, result);
    }
    
    @Test
    void testRemoveElementWithArrayContainingNoMatchingElement() {
        boolean[] array = {true, false, true};
        boolean element = false;
        boolean[] result = ArrayUtils.removeElement(array, element);
        assertArrayEquals(array, result);
    }
    
    // Repeat the above tests for other data types (byte, char, double, float, int, long, short, Object)
    // ...
    
}