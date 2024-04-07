import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class toStringTest {

    @Test
    void testToStringWithDefaultConstructor() {
        MutableLong mutableLong = new MutableLong();
        assertEquals("0", mutableLong.toString());
    }

    @Test
    void testToStringWithLongConstructor() {
        long initialValue = 100L;
        MutableLong mutableLong = new MutableLong(initialValue);
        assertEquals("100", mutableLong.toString());
    }

    @Test
    void testToStringWithNumberConstructor() {
        long initialValue = 100L;
        MutableLong mutableLong = new MutableLong(initialValue);
        assertEquals("100", mutableLong.toString());
    }

    @Test
    void testToStringWithStringConstructor() {
        String initialValue = "100";
        MutableLong mutableLong = new MutableLong(initialValue);
        assertEquals("100", mutableLong.toString());
    }

    @Test
    void testToStringWithNegativeValue() {
        long initialValue = -100L;
        MutableLong mutableLong = new MutableLong(initialValue);
        assertEquals("-100", mutableLong.toString());
    }
}