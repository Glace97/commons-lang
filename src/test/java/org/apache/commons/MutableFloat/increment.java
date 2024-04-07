import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class incrementTest {
    @Test
    void testIncrement() {
        MutableFloat mutableFloat = new MutableFloat();

        // Test initial value
        assertEquals(0.0f, mutableFloat.getValue());

        // Test increment
        mutableFloat.increment();
        assertEquals(1.0f, mutableFloat.getValue());

        // Test multiple increments
        mutableFloat.increment();
        mutableFloat.increment();
        assertEquals(3.0f, mutableFloat.getValue());
    }
}