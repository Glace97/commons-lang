import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class accumulatorTest {

    private List<Integer> list;
    private Streams streams;

    @BeforeEach
    public void setup() {
        list = new ArrayList<>();
        streams = new Streams();
    }

    @Nested
    @DisplayName("accumulator method")
    class AccumulatorMethod {
        
        @Test
        @DisplayName("should add element to the list")
        public void shouldAddElementToList() {
            streams.accumulator().accept(list, 10);
            assertEquals(1, list.size());
            assertTrue(list.contains(10));
        }

        @Test
        @DisplayName("should accumulate multiple elements to the list")
        public void shouldAccumulateMultipleElementsToList() {
            streams.accumulator().accept(list, 10);
            streams.accumulator().accept(list, 20);
            streams.accumulator().accept(list, 30);
            assertEquals(3, list.size());
            assertTrue(list.contains(10));
            assertTrue(list.contains(20));
            assertTrue(list.contains(30));
        }
    }
}