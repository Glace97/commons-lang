import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SwapTest {
    
    @Test
    void testSwap_BooleanArray_SwapsElements() {
        boolean[] array = {true, false, true};
        ArrayUtils.swap(array, 0, 2);
        assertArrayEquals(new boolean[]{true, false, true}, array);
    }
    
    @Test
    void testSwap_BooleanArray_NoSwapWhenIndicesAreSame() {
        boolean[] array = {true, false, true};
        ArrayUtils.swap(array, 0, 0);
        assertArrayEquals(new boolean[]{true, false, true}, array);
    }
    
    @Test
    void testSwap_BooleanArray_NoSwapWhenIndicesOutOfRange() {
        boolean[] array = {true, false, true};
        ArrayUtils.swap(array, 0, 5);
        assertArrayEquals(new boolean[]{true, false, true}, array);
    }
    
    @Test
    void testSwap_BooleanArray_NoSwapWhenIndicesAreNegative() {
        boolean[] array = {true, false, true};
        ArrayUtils.swap(array, -1, 1);
        assertArrayEquals(new boolean[]{true, false, true}, array);
    }
    
    @Test
    void testSwap_ByteArray_SwapsElements() {
        byte[] array = {1, 2, 3};
        ArrayUtils.swap(array, 0, 2);
        assertArrayEquals(new byte[]{3, 2, 1}, array);
    }
    
    // Additional tests for other types of arrays
    
    // ...
    
}