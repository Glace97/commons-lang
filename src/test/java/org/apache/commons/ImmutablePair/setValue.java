import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setValueTest {

    @Test
    void testSetValue() {
        ImmutablePair<String, Integer> pair = new ImmutablePair<>("Hello", 10);

        // Verify original values
        assertEquals("Hello", pair.left);
        assertEquals(10, pair.right);

        // Set new value
        assertThrows(UnsupportedOperationException.class, () -> pair.setValue(20));

        // Verify values are unchanged
        assertEquals("Hello", pair.left);
        assertEquals(10, pair.right);
    }
}