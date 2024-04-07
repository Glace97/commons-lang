import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class finisherTest {

    @Test
    void finisher_ShouldReturnEmptyArray_WhenListIsEmpty() {
        Function<List<String>, String[]> finisher = new Streams().finisher();
        List<String> list = new ArrayList<>();
        String[] result = finisher.apply(list);
        assertEquals(0, result.length);
    }

    @Test
    void finisher_ShouldReturnArrayWithSameElements_WhenListContainsElements() {
        Function<List<String>, String[]> finisher = new Streams().finisher();
        List<String> list = Arrays.asList("a", "b", "c");
        String[] result = finisher.apply(list);
        assertArrayEquals(new String[]{"a", "b", "c"}, result);
    }

    @Test
    void finisher_ShouldReturnArrayWithSameElements_WhenListContainsDuplicateElements() {
        Function<List<String>, String[]> finisher = new Streams().finisher();
        List<String> list = Arrays.asList("a", "b", "a");
        String[] result = finisher.apply(list);
        assertArrayEquals(new String[]{"a", "b", "a"}, result);
    }
}