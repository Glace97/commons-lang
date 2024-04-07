
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

class byteArrayToUuidTest {

    @Test
    void testByteArrayToUuid() {
        // Test case 1
        byte[] src1 = {0x12, 0x34, 0x56, 0x78, (byte) 0x9A, (byte) 0xBC, (byte) 0xDE, (byte) 0xF0,
                       (byte) 0x12, 0x34, 0x56, 0x78, (byte) 0x9A, (byte) 0xBC, (byte) 0xDE, (byte) 0xF0};
        int srcPos1 = 0;
        UUID expected1 = UUID.fromString("78563412-9ABC-F0DE-1234-56789ABCDEF0");
        UUID result1 = Conversion.byteArrayToUuid(src1, srcPos1);
        assertEquals(expected1, result1);

        // Test case 2
        byte[] src2 = {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                       (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                       (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
        int srcPos2 = 0;
        UUID expected2 = UUID.fromString("FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF");
        UUID result2 = Conversion.byteArrayToUuid(src2, srcPos2);
        assertEquals(expected2, result2);
        
        // Test case 3
        byte[] src3 = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                       0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                       0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
        int srcPos3 = 0;
        UUID expected3 = UUID.fromString("00000000-0000-0000-0000-000000000000");
        UUID result3 = Conversion.byteArrayToUuid(src3, srcPos3);
        assertEquals(expected3, result3);

        // Additional test cases for edge cases and coverage
        
        // Test case with srcPos at the end of src array
        byte[] src4 = {0x12, 0x34, 0x56, 0x78, (byte) 0x9A, (byte) 0xBC, (byte) 0xDE, (byte) 0xF0,
                       (byte) 0x12, 0x34, 0x56, 0x78, (byte) 0x9A, (byte) 0xBC, (byte) 0xDE, (byte) 0xF0};
        int srcPos4 = src4.length - 16;
        UUID expected4 = UUID.fromString("78563412-9ABC-F0DE-1234-56789ABCDEF0");
        UUID result4 = Conversion.byteArrayToUuid(src4, srcPos4);
        assertEquals(expected4, result4);
        
        // Test case with srcPos in the middle of src array
        byte[] src5 = {0x12, 0x34, 0x56, 0x78, (byte) 0x9A, (byte) 0xBC, (byte) 0xDE, (byte) 0xF0,
                       (byte) 0x12, 0x34, 0x56, 0x78, (byte) 0x9A, (byte) 0xBC, (byte) 0xDE, (byte) 0xF0};
        int srcPos5 = 8;
        UUID expected5 = UUID.fromString("56789ABC-DEF0-1234-5678-9ABCDEF01234");
        UUID result5 = Conversion.byteArrayToUuid(src5, srcPos5);
        assertEquals(expected5, result5);
        
        // Test case with srcPos at the beginning of src array
        byte[] src6 = {0x12, 0x34, 0x56, 0x78, (byte) 0x9A, (byte) 0xBC, (byte) 0xDE, (byte) 0xF0,
                       (byte) 0x12, 0x34, 0x56, 0x78, (byte) 0x9A, (byte) 0xBC, (byte) 0xDE, (byte) 0xF0};
        int srcPos6 = 0;
        UUID expected6 = UUID.fromString("12345678-9ABC-DEF0-1234-56789ABCDEF0");
        UUID result6 = Conversion.byteArrayToUuid(src6, srcPos6);
        assertEquals(expected6, result6);
        
        // Test case with srcPos in the middle of src array and negative bytes
        byte[] src7 = {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                       (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                       (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
        int srcPos7 = 8;
        UUID expected7 = UUID.fromString("FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF");
        UUID result7 = Conversion.byteArrayToUuid(src7, srcPos7);
        assertEquals(expected7, result7);
    }
}
