import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getRightTest {

    @Test
    void testGetRightWithNullRightValue() {
        MutablePair<Integer, String> pair = new MutablePair<>(1, null);
        assertNull(pair.getRight());
    }
    
    @Test
    void testGetRightWithNonNullRightValue() {
        MutablePair<Integer, String> pair = new MutablePair<>(1, "Hello");
        assertEquals("Hello", pair.getRight());
    }
    
    @Test
    void testGetRightWithNullLeftAndRightValues() {
        MutablePair<String, Integer> pair = new MutablePair<>(null, null);
        assertNull(pair.getRight());
    }
    
    @Test
    void testGetRightWithNonNullLeftAndRightValues() {
        MutablePair<String, Integer> pair = new MutablePair<>("Hello", 123);
        assertEquals(123, pair.getRight());
    }
    
    @Test
    void testGetRightWithEmptyPair() {
        MutablePair<?, ?> pair = new MutablePair<>();
        assertNull(pair.getRight());
    }
    
}