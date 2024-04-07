import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class compareToTest {

    @Test
    void testCompareToLessThan() {
        MutableByte byte1 = new MutableByte((byte) 10);
        MutableByte byte2 = new MutableByte((byte) 20);
        assertTrue(byte1.compareTo(byte2) < 0);
    }

    @Test
    void testCompareToGreaterThan() {
        MutableByte byte1 = new MutableByte((byte) 20);
        MutableByte byte2 = new MutableByte((byte) 10);
        assertTrue(byte1.compareTo(byte2) > 0);
    }

    @Test
    void testCompareToEqual() {
        MutableByte byte1 = new MutableByte((byte) 10);
        MutableByte byte2 = new MutableByte((byte) 10);
        assertEquals(0, byte1.compareTo(byte2));
    }

    @Test
    void testCompareToNull() {
        MutableByte byte1 = new MutableByte((byte) 10);
        assertThrows(NullPointerException.class, () -> byte1.compareTo(null));
    }

    @Test
    void testCompareToString() {
        MutableByte byte1 = new MutableByte((byte) 10);
        MutableByte byte2 = new MutableByte("20");
        assertTrue(byte1.compareTo(byte2) < 0);
    }
}