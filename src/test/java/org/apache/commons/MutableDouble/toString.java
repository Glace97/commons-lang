import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class toStringTest {

    @Test
    void testToStringWithDefaultConstructor() {
        MutableDouble mutableDouble = new MutableDouble();
        String expected = "0.0";
        assertEquals(expected, mutableDouble.toString());
    }

    @Test
    void testToStringWithConstructorWithValue() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        String expected = "5.0";
        assertEquals(expected, mutableDouble.toString());
    }

    @Test
    void testToStringWithConstructorWithNumber() {
        MutableDouble mutableDouble = new MutableDouble(10);
        String expected = "10.0";
        assertEquals(expected, mutableDouble.toString());
    }

    @Test
    void testToStringWithConstructorWithString() {
        MutableDouble mutableDouble = new MutableDouble("15.5");
        String expected = "15.5";
        assertEquals(expected, mutableDouble.toString());
    }
}