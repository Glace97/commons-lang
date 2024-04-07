import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class removeElementsTest {

    @Nested
    @DisplayName("Tests for removeElements with boolean array")
    class BooleanArrayTests {
        boolean[] array;

        @BeforeEach
        void setUp() {
            array = new boolean[] { true, false, true, false, true };
        }

        @Test
        @DisplayName("remove a single element")
        void testRemoveSingleElement() {
            boolean[] result = ArrayUtils.removeElements(array, true);
            assertArrayEquals(new boolean[] { false, true, false, true }, result);
        }

        @Test
        @DisplayName("remove multiple elements")
        void testRemoveMultipleElements() {
            boolean[] result = ArrayUtils.removeElements(array, true, false);
            assertArrayEquals(new boolean[] { true, true }, result);
        }

        @Test
        @DisplayName("remove elements in greater quantities than in the original array")
        void testRemoveElementsInGreaterQuantities() {
            boolean[] result = ArrayUtils.removeElements(array, true, true, true);
            assertArrayEquals(new boolean[] { false, false }, result);
        }

        @Test
        @DisplayName("remove elements from an empty array")
        void testRemoveElementsFromEmptyArray() {
            boolean[] emptyArray = new boolean[0];
            boolean[] result = ArrayUtils.removeElements(emptyArray, true, false);
            assertArrayEquals(emptyArray, result);
        }

        @Test
        @DisplayName("remove elements from a null array")
        void testRemoveElementsFromNullArray() {
            boolean[] result = ArrayUtils.removeElements(null, true, false);
            assertNull(result);
        }
    }

    // Repeat the nested classes for other types of arrays
    // byte, char, double, float, int, long, short, and Object
    // Use similar test cases to achieve high coverage and cover all edge cases
}