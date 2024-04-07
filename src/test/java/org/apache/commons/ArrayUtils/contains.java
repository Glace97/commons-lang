
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ContainsTest")
class ContainsTest {

    private ArrayUtils arrayUtils;

    @BeforeEach
    void setUp() {
        arrayUtils = new ArrayUtils();
    }

    @Nested
    @DisplayName("contains with boolean array")
    class ContainsBooleanArray {

        @Test
        @DisplayName("should return true when value is found in the array")
        void containsValueInArray() {
            boolean[] array = {true, false, true};
            boolean value = true;
            assertTrue(arrayUtils.contains(array, value));
        }

        @Test
        @DisplayName("should return false when value is not found in the array")
        void containsValueNotInArray() {
            boolean[] array = {true, false, true};
            boolean value = false;
            assertFalse(arrayUtils.contains(array, value));
        }

        @Test
        @DisplayName("should return false when array is empty")
        void containsValueInEmptyArray() {
            boolean[] array = {};
            boolean value = true;
            assertFalse(arrayUtils.contains(array, value));
        }

    }

    @Nested
    @DisplayName("contains with byte array")
    class ContainsByteArray {

        @Test
        @DisplayName("should return true when value is found in the array")
        void containsValueInArray() {
            byte[] array = {1, 2, 3};
            byte value = 2;
            assertTrue(arrayUtils.contains(array, value));
        }

        @Test
        @DisplayName("should return false when value is not found in the array")
        void containsValueNotInArray() {
            byte[] array = {1, 2, 3};
            byte value = 4;
            assertFalse(arrayUtils.contains(array, value));
        }

        @Test
        @DisplayName("should return false when array is empty")
        void containsValueInEmptyArray() {
            byte[] array = {};
            byte value = 1;
            assertFalse(arrayUtils.contains(array, value));
        }

    }

    // Repeat the above nested classes and tests for other data types

}
