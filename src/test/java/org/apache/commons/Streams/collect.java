import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class collectTest {

    private Streams streams;

    @BeforeEach
    void setUp() {
        streams = new Streams();
    }

    @Test
    void testCollect_EmptyStream_ReturnsEmptyArray() {
        Integer[] input = {};
        Integer[] expected = {};
        Integer[] result = streams.of(input)
                .collect(new Streams.ArrayCollector<>(Integer.class));
        assertArrayEquals(expected, result);
    }

    @Test
    void testCollect_SingleElementStream_ReturnsArrayWithSingleElement() {
        Integer[] input = {5};
        Integer[] expected = {5};
        Integer[] result = streams.of(input)
                .collect(new Streams.ArrayCollector<>(Integer.class));
        assertArrayEquals(expected, result);
    }

    @Test
    void testCollect_MultipleElementStream_ReturnsArrayWithAllElements() {
        Integer[] input = {1, 2, 3};
        Integer[] expected = {1, 2, 3};
        Integer[] result = streams.of(input)
                .collect(new Streams.ArrayCollector<>(Integer.class));
        assertArrayEquals(expected, result);
    }

    @Test
    void testCollect_StreamWithNullElement_ReturnsArrayWithNullElement() {
        Integer[] input = {1, null, 3};
        Integer[] expected = {1, null, 3};
        Integer[] result = streams.of(input)
                .collect(new Streams.ArrayCollector<>(Integer.class));
        assertArrayEquals(expected, result);
    }
}