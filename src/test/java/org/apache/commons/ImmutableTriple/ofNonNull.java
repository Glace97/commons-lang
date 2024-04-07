
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ofNonNullTest {
    
    @Test
    void testOfNonNull() {
        // Test with non-null values
        ImmutableTriple<String, Integer, Boolean> triple = ImmutableTriple.ofNonNull("foo", 42, true);
        assertEquals("foo", triple.left);
        assertEquals(42, triple.middle);
        assertEquals(true, triple.right);
        
        // Test with null values (should throw NullPointerException)
        assertThrows(NullPointerException.class, () -> {
            ImmutableTriple.ofNonNull(null, "bar", false);
        });
        assertThrows(NullPointerException.class, () -> {
            ImmutableTriple.ofNonNull("baz", null, true);
        });
        assertThrows(NullPointerException.class, () -> {
            ImmutableTriple.ofNonNull("qux", 123, null);
        });
    }
    
}
