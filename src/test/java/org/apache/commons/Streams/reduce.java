import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class reduceTest {

    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5);
    }

    @Test
    void testReduceSum() {
        int expected = 15;
        int actual = numbers.stream().reduce(0, (a, b) -> a + b);
        assertEquals(expected, actual);
    }

    @Test
    void testReduceProduct() {
        int expected = 120;
        int actual = numbers.stream().reduce(1, (a, b) -> a * b);
        assertEquals(expected, actual);
    }

    @Test
    void testReduceMax() {
        int expected = 5;
        int actual = numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
        assertEquals(expected, actual);
    }

    @Test
    void testReduceMin() {
        int expected = 1;
        int actual = numbers.stream().reduce(Integer.MAX_VALUE, Integer::min);
        assertEquals(expected, actual);
    }

    @Test
    void testAllMatchTrue() {
        boolean actual = numbers.stream().allMatch(n -> n > 0);
        assertTrue(actual);
    }

    @Test
    void testAllMatchFalse() {
        boolean actual = numbers.stream().allMatch(n -> n > 5);
        assertFalse(actual);
    }

    @Test
    void testAnyMatchTrue() {
        boolean actual = numbers.stream().anyMatch(n -> n == 3);
        assertTrue(actual);
    }

    @Test
    void testAnyMatchFalse() {
        boolean actual = numbers.stream().anyMatch(n -> n == 6);
        assertFalse(actual);
    }

    @Test
    void testFilter() {
        List<Integer> expected = Arrays.asList(2, 4);
        List<Integer> actual = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        assertEquals(expected, actual);
    }

    @Test
    void testMap() {
        List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> actual = numbers.stream().map(n -> n * 2).collect(Collectors.toList());
        assertEquals(expected, actual);
    }

    @Test
    void testForEach() {
        List<Integer> results = new ArrayList<>();
        numbers.stream().forEach(results::add);
        assertEquals(numbers, results);
    }

    @Test
    void testCollect() {
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] actual = numbers.stream().collect(new ArrayCollector<>(Integer.class));
        assertArrayEquals(expected, actual);
    }
}