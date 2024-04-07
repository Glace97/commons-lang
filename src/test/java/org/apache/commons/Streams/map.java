
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class mapTest {

    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5);
    }

    @Nested
    @DisplayName("Positive Test Cases")
    class PositiveTests {

        @Test
        @DisplayName("Map each number to its square")
        void mapToSquare() {
            List<Integer> squares = numbers.stream()
                    .map(n -> n * n)
                    .collect(Collectors.toList());

            List<Integer> expected = Arrays.asList(1, 4, 9, 16, 25);
            assertEquals(expected, squares);
        }

        @Test
        @DisplayName("Map each number to its string representation")
        void mapToString() {
            List<String> strings = numbers.stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());

            List<String> expected = Arrays.asList("1", "2", "3", "4", "5");
            assertEquals(expected, strings);
        }

        @Test
        @DisplayName("Map each number to its negative value")
        void mapToNegative() {
            List<Integer> negatives = numbers.stream()
                    .map(n -> -n)
                    .collect(Collectors.toList());

            List<Integer> expected = Arrays.asList(-1, -2, -3, -4, -5);
            assertEquals(expected, negatives);
        }
    }

    @Nested
    @DisplayName("Edge Test Cases")
    class EdgeTests {

        @Test
        @DisplayName("Map empty list")
        void mapEmptyList() {
            List<Integer> emptyList = Arrays.asList();
            List<Integer> result = emptyList.stream()
                    .map(n -> n * n)
                    .collect(Collectors.toList());

            assertTrue(result.isEmpty());
        }

        @Test
        @DisplayName("Map list with null elements")
        void mapListWithNullElements() {
            List<Integer> listWithNulls = Arrays.asList(1, null, 3, null, 5);
            List<Integer> result = listWithNulls.stream()
                    .map(n -> n != null ? n * n : null)
                    .collect(Collectors.toList());

            List<Integer> expected = Arrays.asList(1, null, 9, null, 25);
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Map list to array")
        void mapListToArray() {
            Integer[] array = numbers.stream()
                    .map(n -> n * n)
                    .toArray(Integer[]::new);

            Integer[] expected = { 1, 4, 9, 16, 25 };
            assertArrayEquals(expected, array);
        }
    }

}
