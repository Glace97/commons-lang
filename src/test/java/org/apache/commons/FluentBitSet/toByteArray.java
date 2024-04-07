import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toByteArrayTest {
    private FluentBitSet bitSet;

    @BeforeEach
    void setUp() {
        bitSet = new FluentBitSet();
    }

    @Test
    void testEmptyBitSet() {
        byte[] byteArray = bitSet.toByteArray();
        assertEquals(0, byteArray.length);
    }

    @Test
    void testBitSetWithSingleTrueBit() {
        bitSet.set(0);
        byte[] byteArray = bitSet.toByteArray();
        assertEquals(1, byteArray.length);
        assertEquals((byte) 1, byteArray[0]);
    }

    @Test
    void testBitSetWithSingleFalseBit() {
        bitSet.set(0, false);
        byte[] byteArray = bitSet.toByteArray();
        assertEquals(1, byteArray.length);
        assertEquals((byte) 0, byteArray[0]);
    }

    @Test
    void testBitSetWithMultipleBits() {
        bitSet.set(0);
        bitSet.set(2);
        bitSet.set(4);
        byte[] byteArray = bitSet.toByteArray();
        assertEquals(1, byteArray.length);
        assertEquals((byte) 21, byteArray[0]);
    }
    
    @Test
    void testBitSetWithLargeNumberOfBits() {
        FluentBitSet largeBitSet = new FluentBitSet(10000);
        largeBitSet.set(9999);
        byte[] byteArray = largeBitSet.toByteArray();
        assertEquals(1250, byteArray.length);
        assertEquals((byte) -128, byteArray[0]);
        assertEquals((byte) 1, byteArray[1249]);
    }
}