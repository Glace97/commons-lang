
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class toArrayTest {

    @Nested
    @DisplayName("When calling toArray with empty items")
    class EmptyItems {

        @Test
        @DisplayName("Should return an empty array")
        void shouldReturnEmptyArray() {
            Object[] result = ArrayUtils.toArray();
            assertArrayEquals(new Object[]{}, result);
        }
    }

    @Nested
    @DisplayName("When calling toArray with non-empty items")
    class NonEmptyItems {

        @Test
        @DisplayName("Should return an array with the same elements")
        void shouldReturnArrayWithSameElements() {
            Integer[] items = {1, 2, 3};
            Integer[] result = ArrayUtils.toArray(items);
            assertArrayEquals(items, result);
        }
    }
}
