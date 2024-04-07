import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ofNonNullTest {

    @Test
    void testOfNonNull() {
        // Test with non-null inputs
        MutableTriple<String, Integer, Double> triple = MutableTriple.ofNonNull("left", 100, 3.14);
        assertNotNull(triple);
        assertEquals("left", triple.left);
        assertEquals(100, triple.middle);
        assertEquals(3.14, triple.right);

        // Test with null inputs
        assertThrows(NullPointerException.class, () -> MutableTriple.ofNonNull(null, "middle", "right"));
        assertThrows(NullPointerException.class, () -> MutableTriple.ofNonNull("left", null, "right"));
        assertThrows(NullPointerException.class, () -> MutableTriple.ofNonNull("left", "middle", null));
    }
}