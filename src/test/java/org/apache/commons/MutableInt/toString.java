import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toStringTest {

    @Test
    void testToString() {
        MutableInt mutableInt1 = new MutableInt(); // test with default value of zero
        assertEquals("0", mutableInt1.toString());

        MutableInt mutableInt2 = new MutableInt(5); // test with positive value
        assertEquals("5", mutableInt2.toString());

        MutableInt mutableInt3 = new MutableInt(-3); // test with negative value
        assertEquals("-3", mutableInt3.toString());

        MutableInt mutableInt4 = new MutableInt(NumberUtils.INTEGER_ONE); // test with Number object
        assertEquals("1", mutableInt4.toString());

        MutableInt mutableInt5 = new MutableInt("10"); // test with valid string
        assertEquals("10", mutableInt5.toString());

        assertThrows(NumberFormatException.class, () -> {
            MutableInt mutableInt6 = new MutableInt("abc"); // test with invalid string
            mutableInt6.toString();
        });
    }
}