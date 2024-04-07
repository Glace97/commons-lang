import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getRightTest {

    @Test
    void testGetRight() {
        // Test case 1: right is null
        MutableTriple<Integer, String, Boolean> triple1 = new MutableTriple<>(1, "hello", null);
        assertNull(triple1.getRight());

        // Test case 2: right is not null
        MutableTriple<Integer, String, Boolean> triple2 = new MutableTriple<>(2, "world", true);
        assertTrue(triple2.getRight());

        // Test case 3: empty triple
        MutableTriple<?, ?, ?> triple3 = new MutableTriple<>();
        assertNull(triple3.getRight());
    }
    
    @Test
    void testGetRightWithNonNullValues() {
        // Test case 1: right is an integer
        MutableTriple<String, Double, Integer> triple1 = new MutableTriple<>("abc", 3.14, 42);
        assertEquals(42, triple1.getRight());

        // Test case 2: right is a string
        MutableTriple<Boolean, Float, String> triple2 = new MutableTriple<>(true, 1.23f, "xyz");
        assertEquals("xyz", triple2.getRight());

        // Test case 3: right is a boolean
        MutableTriple<Double, Character, Boolean> triple3 = new MutableTriple<>(2.71, 'a', false);
        assertFalse(triple3.getRight());
    }
    
    @Test
    void testGetRightWithNullValues() {
        // Test case 1: all values are null
        MutableTriple<?, ?, ?> triple1 = new MutableTriple<>();
        assertNull(triple1.getRight());

        // Test case 2: left and middle are null, right is not null
        MutableTriple<?, ?, Integer> triple2 = new MutableTriple<>(null, null, 123);
        assertEquals(123, triple2.getRight());

        // Test case 3: left and right are null, middle is not null
        MutableTriple<?, String, ?> triple3 = new MutableTriple<>(null, "hello", null);
        assertNull(triple3.getRight());
    }
}