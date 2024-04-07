import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class equalsTest {

    @Test
    void testEquals() {
        MutableBoolean mb1 = new MutableBoolean(true);
        MutableBoolean mb2 = new MutableBoolean(true);
        MutableBoolean mb3 = new MutableBoolean(false);

        // Test equal objects
        assertTrue(mb1.equals(mb1));

        // Test objects with same value
        assertTrue(mb1.equals(mb2));

        // Test objects with different values
        assertFalse(mb1.equals(mb3));

        // Test objects with different types
        assertFalse(mb1.equals("test"));
        assertFalse(mb1.equals(null));
    }
}