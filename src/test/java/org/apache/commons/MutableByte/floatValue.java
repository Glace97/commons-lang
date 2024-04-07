import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class floatValueTest {

    @Test
    void testFloatValue() {
        // Test case 1: Testing with positive value
        MutableByte mutableByte1 = new MutableByte((byte) 10);
        assertEquals(10.0f, mutableByte1.floatValue());

        // Test case 2: Testing with zero value
        MutableByte mutableByte2 = new MutableByte((byte) 0);
        assertEquals(0.0f, mutableByte2.floatValue());

        // Test case 3: Testing with negative value
        MutableByte mutableByte3 = new MutableByte((byte) -5);
        assertEquals(-5.0f, mutableByte3.floatValue());

        // Test case 4: Testing with maximum value
        MutableByte mutableByte4 = new MutableByte(Byte.MAX_VALUE);
        assertEquals(127.0f, mutableByte4.floatValue());

        // Test case 5: Testing with minimum value
        MutableByte mutableByte5 = new MutableByte(Byte.MIN_VALUE);
        assertEquals(-128.0f, mutableByte5.floatValue());

        // Test case 6: Testing with large value
        MutableByte mutableByte6 = new MutableByte((byte) 1000);
        assertEquals(1000.0f, mutableByte6.floatValue());

        // Test case 7: Testing with string value
        MutableByte mutableByte7 = new MutableByte("50");
        assertEquals(50.0f, mutableByte7.floatValue());

        // Test case 8: Testing with invalid string value
        assertThrows(NumberFormatException.class, () -> {
            MutableByte mutableByte8 = new MutableByte("abc");
            mutableByte8.floatValue();
        });
    }
}