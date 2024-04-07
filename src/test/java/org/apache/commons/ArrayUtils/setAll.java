import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.IntFunction;
import java.util.function.Supplier;

class setAllTest {
    private Integer[] array;
    
    @BeforeEach
    void setUp() {
        array = new Integer[5];
    }
    
    @Test
    void testSetAllWithIntFunction() {
        IntFunction<Integer> generator = (index) -> index + 1;
        ArrayUtils.setAll(array, generator);
        assertArrayEquals(new Integer[] {1, 2, 3, 4, 5}, array);
    }
    
    @Test
    void testSetAllWithSupplier() {
        Supplier<Integer> generator = () -> 10;
        ArrayUtils.setAll(array, generator);
        assertArrayEquals(new Integer[] {10, 10, 10, 10, 10}, array);
    }
    
    @Test
    void testSetAllWithNullArray() {
        Integer[] nullArray = null;
        IntFunction<Integer> generator = (index) -> index + 1;
        assertNull(ArrayUtils.setAll(nullArray, generator));
    }
    
    @Test
    void testSetAllWithNullGenerator() {
        IntFunction<Integer> nullGenerator = null;
        assertArrayEquals(new Integer[5], ArrayUtils.setAll(array, nullGenerator));
    }
    
    @Test
    void testSetAllWithEmptyArray() {
        Integer[] emptyArray = {};
        IntFunction<Integer> generator = (index) -> index + 1;
        assertArrayEquals(emptyArray, ArrayUtils.setAll(emptyArray, generator));
    }
    
    @Test
    void testSetAllWithEmptyArrayAndSupplier() {
        Integer[] emptyArray = {};
        Supplier<Integer> generator = () -> 10;
        assertArrayEquals(emptyArray, ArrayUtils.setAll(emptyArray, generator));
    }
}