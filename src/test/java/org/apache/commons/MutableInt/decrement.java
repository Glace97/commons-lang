import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class decrementTest {

    @Test
    void testDecrement() {
        // Test decrementing a positive value
        MutableInt mutableInt1 = new MutableInt(5);
        mutableInt1.decrement();
        assertEquals(4, mutableInt1.getValue());

        // Test decrementing a negative value
        MutableInt mutableInt2 = new MutableInt(-3);
        mutableInt2.decrement();
        assertEquals(-4, mutableInt2.getValue());

        // Test decrementing zero
        MutableInt mutableInt3 = new MutableInt(0);
        mutableInt3.decrement();
        assertEquals(-1, mutableInt3.getValue());
    }
}