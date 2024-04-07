import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class uuidToByteArrayTest {

    @Test
    void testUuidToByteArray_ZeroBytes() {
        byte[] dst = new byte[16];
        UUID uuid = UUID.randomUUID();
        byte[] result = Conversion.uuidToByteArray(uuid, dst, 0, 0);
        assertArrayEquals(dst, result);
    }

    @Test
    void testUuidToByteArray_LessThan16Bytes() {
        byte[] dst = new byte[16];
        UUID uuid = UUID.randomUUID();
        byte[] result = Conversion.uuidToByteArray(uuid, dst, 0, 12);
        assertEquals(12, result.length);
        assertArrayEquals(dst, result);
    }

    @Test
    void testUuidToByteArray_MoreThan16Bytes() {
        byte[] dst = new byte[16];
        UUID uuid = UUID.randomUUID();
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.uuidToByteArray(uuid, dst, 0, 20);
        });
    }

    @Test
    void testUuidToByteArray_Lsb0Ordering() {
        byte[] dst = new byte[16];
        UUID uuid = UUID.fromString("00000000-0000-0000-0000-000000000001");
        byte[] expected = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] result = Conversion.uuidToByteArray(uuid, dst, 0, 16);
        assertArrayEquals(expected, result);
    }

    @Test
    void testUuidToByteArray_BigEndianOrdering() {
        byte[] dst = new byte[16];
        UUID uuid = UUID.fromString("00000000-0000-0000-0000-000000000001");
        byte[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        byte[] result = Conversion.uuidToByteArray(uuid, dst, 0, 16);
        assertArrayEquals(expected, result);
    }

    @Test
    void testUuidToByteArray_DestinationArrayNotEmpty() {
        byte[] dst = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        UUID uuid = UUID.fromString("00000000-0000-0000-0000-000000000001");
        byte[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        byte[] result = Conversion.uuidToByteArray(uuid, dst, 0, 16);
        assertArrayEquals(expected, result);
    }

    @Test
    void testUuidToByteArray_DestinationArrayInsufficientSize() {
        byte[] dst = new byte[8];
        UUID uuid = UUID.randomUUID();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Conversion.uuidToByteArray(uuid, dst, 0, 16);
        });
    }
}