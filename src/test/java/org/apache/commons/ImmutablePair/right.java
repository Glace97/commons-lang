import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class rightTest {

    @Test
    void testRightWithNonNullValue() {
        Integer value = 10;
        ImmutablePair<Integer, String> pair = ImmutablePair.right(value);
        
        assertNull(pair.left);
        assertEquals(value, pair.right);
    }

    @Test
    void testRightWithNullValue() {
        ImmutablePair<Integer, String> pair = ImmutablePair.right(null);
        
        assertNull(pair.left);
        assertNull(pair.right);
    }
    
    @Test
    void testRightWithDifferentTypes() {
        String value = "Hello";
        ImmutablePair<Integer, String> pair = ImmutablePair.right(value);
        
        assertNull(pair.left);
        assertEquals(value, pair.right);
    }
    
    @Test
    void testRightWithEmptyArray() {
        ImmutablePair<?, ?>[] array = ImmutablePair.EMPTY_ARRAY;
        ImmutablePair<ImmutablePair<?, ?>[], String> pair = ImmutablePair.right(array);
        
        assertNull(pair.left);
        assertArrayEquals(array, pair.right);
    }
    
    @Test
    void testRightWithNullPair() {
        ImmutablePair<?, ?> nullPair = ImmutablePair.NULL;
        ImmutablePair<ImmutablePair<?, ?>, String> pair = ImmutablePair.right(nullPair);
        
        assertNull(pair.left);
        assertEquals(nullPair, pair.right);
    }
    
    // Add more test cases to cover edge cases and achieve high coverage
    
}