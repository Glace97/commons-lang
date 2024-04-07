import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class isEqualsTest {

    private ArrayUtils arrayUtils;

    @BeforeEach
    void setUp() {
        arrayUtils = new ArrayUtils();
    }

    @Nested
    @DisplayName("Testing isEquals method")
    class isEqualsMethodTests {

        @Test
        @DisplayName("Test for two null arrays")
        void testIsEqualsWithNullArrays() {
            Object[] array1 = null;
            Object[] array2 = null;

            assertTrue(ArrayUtils.isEquals(array1, array2));
        }

        @Test
        @DisplayName("Test for null and non-null arrays")
        void testIsEqualsWithNullAndNonNullArrays() {
            Object[] array1 = null;
            Object[] array2 = {1, 2, 3};

            assertFalse(ArrayUtils.isEquals(array1, array2));
        }

        @Test
        @DisplayName("Test for equal arrays")
        void testIsEqualsWithEqualArrays() {
            Object[] array1 = {1, 2, 3};
            Object[] array2 = {1, 2, 3};

            assertTrue(ArrayUtils.isEquals(array1, array2));
        }

        @Test
        @DisplayName("Test for arrays with different lengths")
        void testIsEqualsWithDifferentLengthArrays() {
            Object[] array1 = {1, 2, 3};
            Object[] array2 = {1, 2};

            assertFalse(ArrayUtils.isEquals(array1, array2));
        }

        @Test
        @DisplayName("Test for arrays with different elements")
        void testIsEqualsWithDifferentElementsArrays() {
            Object[] array1 = {1, 2, 3};
            Object[] array2 = {4, 5, 6};

            assertFalse(ArrayUtils.isEquals(array1, array2));
        }
    }
}