import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CombinerTest {
    private Combiner combiner;

    @BeforeEach
    void setUp() {
        combiner = new Combiner();
    }

    @Test
    void testCombinerWithEmptyLists() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        List<String> result = combiner.combine(list1, list2);

        assertTrue(result.isEmpty());
    }

    @Test
    void testCombinerWithNonEmptyLists() {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("d", "e", "f");

        List<String> expected = Arrays.asList("a", "b", "c", "d", "e", "f");
        List<String> result = combiner.combine(list1, list2);

        assertEquals(expected, result);
    }

    @Test
    void testCombinerWithOneEmptyList() {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = new ArrayList<>();

        List<String> expected = Arrays.asList("a", "b", "c");
        List<String> result = combiner.combine(list1, list2);

        assertEquals(expected, result);
    }

    @Test
    void testCombinerWithNullLists() {
        List<String> list1 = null;
        List<String> list2 = null;

        List<String> result = combiner.combine(list1, list2);

        assertTrue(result.isEmpty());
    }
}