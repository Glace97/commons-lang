import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class filterTest {

    @Test
    void testFilterWithEmptyList() {
        List<Integer> numbers = Arrays.asList();
        List<Integer> result = numbers.stream()
                .filter(num -> num > 0)
                .collect(Collectors.toList());
        assertEquals(0, result.size());
    }

    @Test
    void testFilterWithPositiveNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = numbers.stream()
                .filter(num -> num > 2)
                .collect(Collectors.toList());
        assertEquals(Arrays.asList(3, 4, 5), result);
    }

    @Test
    void testFilterWithNegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, -3, -4, -5);
        List<Integer> result = numbers.stream()
                .filter(num -> num < -2)
                .collect(Collectors.toList());
        assertEquals(Arrays.asList(-3, -4, -5), result);
    }

    @Test
    void testFilterWithMixedNumbers() {
        List<Integer> numbers = Arrays.asList(-1, 2, -3, 4, -5);
        List<Integer> result = numbers.stream()
                .filter(num -> num < 0)
                .collect(Collectors.toList());
        assertEquals(Arrays.asList(-1, -3, -5), result);
    }
}