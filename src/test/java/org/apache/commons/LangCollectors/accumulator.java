import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

class accumulatorTest {
    
    @Test
    void testAccumulator() {
        // Test case 1: Empty list
        List<String> list1 = new ArrayList<>();
        Supplier<List<String>> supplier1 = ArrayList::new;
        BiConsumer<List<String>, String> accumulator1 = List::add;
        BinaryOperator<List<String>> combiner1 = (l1, l2) -> {
            l1.addAll(l2);
            return l1;
        };
        Function<List<String>, String> finisher1 = l -> String.join(",", l);
        Collector<String, List<String>, String> collector1 = new SimpleCollector<>(supplier1, accumulator1, combiner1, finisher1, CH_NOID);
        String result1 = list1.stream().collect(collector1);
        assertEquals("", result1);
        
        // Test case 2: List with elements
        List<String> list2 = Arrays.asList("a", "b", "c");
        Supplier<List<String>> supplier2 = ArrayList::new;
        BiConsumer<List<String>, String> accumulator2 = List::add;
        BinaryOperator<List<String>> combiner2 = (l1, l2) -> {
            l1.addAll(l2);
            return l1;
        };
        Function<List<String>, String> finisher2 = l -> String.join(",", l);
        Collector<String, List<String>, String> collector2 = new SimpleCollector<>(supplier2, accumulator2, combiner2, finisher2, CH_NOID);
        String result2 = list2.stream().collect(collector2);
        assertEquals("a,b,c", result2);
    }
}