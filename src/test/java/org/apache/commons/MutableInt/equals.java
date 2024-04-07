import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class equalsTest {

    @Test
    void testEquals() {
        MutableInt mutableInt1 = new MutableInt(5);
        MutableInt mutableInt2 = new MutableInt(5);
        MutableInt mutableInt3 = new MutableInt(10);

        // Test equal objects
        assertTrue(mutableInt1.equals(mutableInt1));

        // Test equal values
        assertTrue(mutableInt1.equals(mutableInt2));

        // Test different values
        assertFalse(mutableInt1.equals(mutableInt3));

        // Test null object
        assertFalse(mutableInt1.equals(null));

        // Test object of different type
        assertFalse(mutableInt1.equals("5"));
    }

}