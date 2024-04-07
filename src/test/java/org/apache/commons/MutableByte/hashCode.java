import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hashCodeTest {

    @Test
    void testHashCode() {
        MutableByte byte1 = new MutableByte(0);
        MutableByte byte2 = new MutableByte(0);
        MutableByte byte3 = new MutableByte(1);
        MutableByte byte4 = new MutableByte(-1);
        MutableByte byte5 = new MutableByte(127);
        MutableByte byte6 = new MutableByte(-128);
        MutableByte byte7 = new MutableByte("0");
        MutableByte byte8 = new MutableByte("1");
        MutableByte byte9 = new MutableByte("-1");
        MutableByte byte10 = new MutableByte("127");
        MutableByte byte11 = new MutableByte("-128");

        assertEquals(byte1.hashCode(), byte2.hashCode());
        assertNotEquals(byte1.hashCode(), byte3.hashCode());
        assertNotEquals(byte1.hashCode(), byte4.hashCode());
        assertNotEquals(byte1.hashCode(), byte5.hashCode());
        assertNotEquals(byte1.hashCode(), byte6.hashCode());
        assertEquals(byte1.hashCode(), byte7.hashCode());
        assertNotEquals(byte1.hashCode(), byte8.hashCode());
        assertNotEquals(byte1.hashCode(), byte9.hashCode());
        assertNotEquals(byte1.hashCode(), byte10.hashCode());
        assertNotEquals(byte1.hashCode(), byte11.hashCode());
    }
}