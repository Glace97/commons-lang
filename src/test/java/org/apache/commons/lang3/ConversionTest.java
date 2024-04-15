package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


import org.junit.jupiter.api.*;

import java.util.UUID;

public class ConversionTest {

    private Conversion conversion;

    @BeforeEach
    void setUp() {
        conversion = new Conversion();
    }


    @Test
    public void testByteArrayToShort_EmptyArrayZeroLength() {
        // test code here
    }

    @Test
    public void testByteArrayToShort_EmptyArrayNonZeroLength() {
        // test code here
    }

    @Test
    public void testByteArrayToShort_NegativeDstPos() {
        // test code here
    }

    @Test
    public void testByteArrayToShort_DstPosGreaterThan16() {
        // test code here
    }

    @Test
    public void testByteArrayToShort_LowestValues() {
        // test code here
    }

    @Test
    public void testByteArrayToShort_HighestValues() {
        // test code here
    }

    @Test
    public void testByteArrayToShort_MiddleValues() {
        // test code here
    }

    // Add more tests for edge cases and different scenarios as needed
    @Test
    @DisplayName("Testing valid hexadecimal digits")
    void testValidHexDigits() {
        Assertions.assertArrayEquals(new boolean[]{false, false, false, false}, Conversion.hexDigitMsb0ToBinary('0'));
        Assertions.assertArrayEquals(new boolean[]{false, false, false, true}, Conversion.hexDigitMsb0ToBinary('1'));
        Assertions.assertArrayEquals(new boolean[]{false, false, true, false}, Conversion.hexDigitMsb0ToBinary('2'));
        Assertions.assertArrayEquals(new boolean[]{false, false, true, true}, Conversion.hexDigitMsb0ToBinary('3'));
        Assertions.assertArrayEquals(new boolean[]{false, true, false, false}, Conversion.hexDigitMsb0ToBinary('4'));
        Assertions.assertArrayEquals(new boolean[]{false, true, false, true}, Conversion.hexDigitMsb0ToBinary('5'));
        Assertions.assertArrayEquals(new boolean[]{false, true, true, false}, Conversion.hexDigitMsb0ToBinary('6'));
        Assertions.assertArrayEquals(new boolean[]{false, true, true, true}, Conversion.hexDigitMsb0ToBinary('7'));
        Assertions.assertArrayEquals(new boolean[]{true, false, false, false}, Conversion.hexDigitMsb0ToBinary('8'));
        Assertions.assertArrayEquals(new boolean[]{true, false, false, true}, Conversion.hexDigitMsb0ToBinary('9'));
        Assertions.assertArrayEquals(new boolean[]{true, false, true, false}, Conversion.hexDigitMsb0ToBinary('A'));
        Assertions.assertArrayEquals(new boolean[]{true, false, true, true}, Conversion.hexDigitMsb0ToBinary('B'));
        Assertions.assertArrayEquals(new boolean[]{true, true, false, false}, Conversion.hexDigitMsb0ToBinary('C'));
        Assertions.assertArrayEquals(new boolean[]{true, true, false, true}, Conversion.hexDigitMsb0ToBinary('D'));
        Assertions.assertArrayEquals(new boolean[]{true, true, true, false}, Conversion.hexDigitMsb0ToBinary('E'));
        Assertions.assertArrayEquals(new boolean[]{true, true, true, true}, Conversion.hexDigitMsb0ToBinary('F'));
    }


    @Test
    void testBinaryToShortWithEmptyArray() {
        boolean[] src = {};
        int srcPos = 0;
        short dstInit = 0;
        int dstPos = 0;
        int nBools = 0;

        short result = Conversion.binaryToShort(src, srcPos, dstInit, dstPos, nBools);

        assertEquals(dstInit, result);
    }


    @Test
    void testLongToByteArray_ZeroBytes() {
        long src = 123456789;
        int srcPos = 0;
        byte[] dst = new byte[8];
        int dstPos = 0;
        int nBytes = 0;

        byte[] result = conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);

        assertArrayEquals(dst, result);
    }

    @Test
    void testLongToByteArray_GreaterThan64Bytes() {
        long src = 123456789;
        int srcPos = 0;
        byte[] dst = new byte[8];
        int dstPos = 0;
        int nBytes = 10;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes));

        assertEquals("(nBytes-1)*8+srcPos is greater or equal to than 64", exception.getMessage());
    }


    @Test
    void testHexDigitToBinary_0() {
        boolean[] expected = {false, false, false, false};
        assertArrayEquals(expected, Conversion.hexDigitToBinary('0'));
    }

    @Test
    void testHexDigitToBinary_1() {
        boolean[] expected = {true, false, false, false};
        assertArrayEquals(expected, Conversion.hexDigitToBinary('1'));
    }

    @Test
    void testHexDigitToBinary_2() {
        boolean[] expected = {false, true, false, false};
        assertArrayEquals(expected, Conversion.hexDigitToBinary('2'));
    }

    @Test
    void testHexDigitToBinary_edgeCases() {
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToBinary('G'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToBinary('g'));
    }

    @Test
    void testByteArrayToLong_EmptySrcArray_ReturnsDstInit() {
        byte[] src = {};
        int srcPos = 0;
        long dstInit = 123456789L;
        int dstPos = 0;
        int nBytes = 0;

        long result = conversion.byteArrayToLong(src, srcPos, dstInit, dstPos, nBytes);

        assertEquals(dstInit, result);
    }

    @Test
    void testByteArrayToLong_InvalidDstPos_ThrowsIllegalArgumentException() {
        byte[] src = {0x12, 0x34, 0x56};
        int srcPos = 0;
        long dstInit = 0L;
        int dstPos = 57; // (nBytes - 1) * 8 + dstPos >= 64
        int nBytes = 3;

        assertThrows(IllegalArgumentException.class, () -> {
            conversion.byteArrayToLong(src, srcPos, dstInit, dstPos, nBytes);
        });
    }

    @Test
    void testByteArrayToLong_ArrayIndexOutOfBounds_ThrowsArrayIndexOutOfBoundsException() {
        byte[] src = {0x12, 0x34, 0x56};
        int srcPos = 0;
        long dstInit = 0L;
        int dstPos = 0;
        int nBytes = 4; // srcPos + nBytes > src.length

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            conversion.byteArrayToLong(src, srcPos, dstInit, dstPos, nBytes);
        });
    }

    @Test
    @DisplayName("Test byteToBinary with null dst")
    void testByteToBinary_NullDst() {
        assertThrows(NullPointerException.class, () ->
                Conversion.byteToBinary((byte) 0, 0, null, 0, 8));
    }

    @Test
    @DisplayName("Test binaryToHexDigit with all true input")
    void testBinaryToHexDigitAllTrue() {
        boolean[] input = {true, true, true, true};
        char expected = 'f';
        char actual = Conversion.binaryToHexDigit(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test binaryToHexDigit with all false input")
    void testBinaryToHexDigitAllFalse() {
        boolean[] input = {false, false, false, false};
        char expected = '0';
        char actual = Conversion.binaryToHexDigit(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test binaryToHexDigit with mixed input")
    void testBinaryToHexDigitMixed() {
        boolean[] input = {true, false, true, false};
        char expected = '5';
        char actual = Conversion.binaryToHexDigit(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test binaryToHexDigit with empty array")
    void testBinaryToHexDigitEmptyArray() {
        boolean[] input = {};
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.binaryToHexDigit(input);
        });
    }

    @Test
    @DisplayName("Test binaryToHexDigit with null array")
    void testBinaryToHexDigitNullArray() {
        assertThrows(NullPointerException.class, () -> {
            Conversion.binaryToHexDigit(null);
        });
    }

    @Test
    public void testHexToInt_ZeroLength() {
        int result = Conversion.hexToInt("", 0, 0, 0, 0);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testHexToInt_AllZeros() {
        int result = Conversion.hexToInt("00000000", 0, 0, 0, 8);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testHexToInt_AllOnes() {
        int result = Conversion.hexToInt("FFFFFFFF", 0, 0, 0, 8);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void testHexToInt_InvalidHexChar() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToInt("G", 0, 0, 0, 1);
        });
    }

    @Test
    void testBinaryToInt_AllTrueBits() {
        boolean[] src = {true, true, true, true};
        int result = Conversion.binaryToInt(src, 0, 0, 0, 4);
        assertEquals(15, result);
    }

    @Test
    void testBinaryToInt_AllFalseBits() {
        boolean[] src = {false, false, false, false};
        int result = Conversion.binaryToInt(src, 0, 0, 0, 4);
        assertEquals(0, result);
    }

    @Test
    void testBinaryToInt_MixedBits() {
        boolean[] src = {true, false, true, false};
        int result = Conversion.binaryToInt(src, 0, 0, 0, 4);
        assertEquals(5, result);
    }

    @Test
    void testBinaryToInt_OneBit() {
        boolean[] src = {true};
        int result = Conversion.binaryToInt(src, 0, 0, 0, 1);
        assertEquals(1, result);
    }

    @Test
    void testBinaryToInt_LargeNumber() {
        boolean[] src = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
        int result = Conversion.binaryToInt(src, 0, 0, 0, 16);
        assertEquals(65535, result);
    }

    @Test
    void testBinaryToInt_EmptySrc() {
        boolean[] src = {};
        int result = Conversion.binaryToInt(src, 0, 0, 0, 0);
        assertEquals(0, result);
    }


    @Test
    void testBinaryToHexDigitMsb0_4bits_invalidInput() {
        // Test empty input array
        boolean[] empty = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.binaryToHexDigitMsb0_4bits(empty);
        });

        // Test input array with length < 4
        boolean[] lessThan4 = {true, false, false};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.binaryToHexDigitMsb0_4bits(lessThan4);
        });

        // Test input array with length > 8
        boolean[] greaterThan8 = {true, false, false, true, true, false, true, false, false};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.binaryToHexDigitMsb0_4bits(greaterThan8);
        });

        // Test srcPos > src.length - 4
        boolean[] binary = {true, false, false, true, true, false, true, false};
        int invalidSrcPos = 6;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.binaryToHexDigitMsb0_4bits(binary, invalidSrcPos);
        });
    }

    @Test
    public void testIntToHexDigit_Zero() {
        char result = Conversion.intToHexDigit(0);
        Assertions.assertEquals('0', result);
    }

    @Test
    public void testIntToHexDigit_One() {
        char result = Conversion.intToHexDigit(1);
        Assertions.assertEquals('1', result);
    }


    @Test
    public void testIntToHexDigit_NegativeValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intToHexDigit(-1);
        });
    }

    @Test
    public void testIntToHexDigit_ValueOutOfRange() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intToHexDigit(16);
        });
    }


    @Test
    void testHexToShort_EmptyString() {
        String src = "";
        int srcPos = 0;
        short dstInit = 0;
        int dstPos = 0;
        int nHex = 0;

        short result = Conversion.hexToShort(src, srcPos, dstInit, dstPos, nHex);

        assertEquals(dstInit, result);
    }


    @Test
    void testHexToShort_OneHexDigit() {
        String src = "A";
        int srcPos = 0;
        short dstInit = 0;
        int dstPos = 0;
        int nHex = 1;

        short result = Conversion.hexToShort(src, srcPos, dstInit, dstPos, nHex);

        assertEquals(10, result);
    }


    @Test
    void testHexToShort_AllDigitsZero() {
        String src = "0000";
        int srcPos = 0;
        short dstInit = 0;
        int dstPos = 0;
        int nHex = 4;

        short result = Conversion.hexToShort(src, srcPos, dstInit, dstPos, nHex);

        assertEquals(0, result);
    }

    @Test
    void testHexToShort_AllDigitsF() {
        String src = "FFFF";
        int srcPos = 0;
        short dstInit = 0;
        int dstPos = 0;
        int nHex = 4;

        short result = Conversion.hexToShort(src, srcPos, dstInit, dstPos, nHex);

        assertEquals(-1, result);
    }


    @Test
    void testShortArrayToLong_EmptySrcArray() {
        short[] src = {};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nShorts = 0;

        long result = Conversion.shortArrayToLong(src, srcPos, dstInit, dstPos, nShorts);

        assertEquals(dstInit, result);
    }

    @Test
    void testShortArrayToLong_ZeroNShorts() {
        short[] src = {1, 2, 3};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nShorts = 0;

        long result = Conversion.shortArrayToLong(src, srcPos, dstInit, dstPos, nShorts);

        assertEquals(dstInit, result);
    }

    @Test
    void testShortArrayToLong_InvalidDstPos() {
        short[] src = {1, 2, 3};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 64;
        int nShorts = 3;

        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.shortArrayToLong(src, srcPos, dstInit, dstPos, nShorts);
        });
    }

    @Test
    void testShortArrayToLong_SrcPosAndNShortsOutOfRange() {
        short[] src = {1, 2, 3};
        int srcPos = 2;
        long dstInit = 0;
        int dstPos = 0;
        int nShorts = 2;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Conversion.shortArrayToLong(src, srcPos, dstInit, dstPos, nShorts);
        });
    }

    @Test
    @DisplayName("Test case: nBytes is 0")
    void testUuidToByteArrayWithNBytesZero() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        byte[] result = conversion.uuidToByteArray(uuid, dst, 0, 0);
        Assertions.assertSame(dst, result);
    }

    @Test
    @DisplayName("Test case: nBytes is greater than 16")
    void testUuidToByteArrayWithNBytesGreaterThanSixteen() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            conversion.uuidToByteArray(uuid, dst, 0, 17);
        });
    }

    @Test
    @DisplayName("Test case: nBytes is less than or equal to 16")
    void testUuidToByteArrayWithNBytesLessThanOrEqualSixteen() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        byte[] result = conversion.uuidToByteArray(uuid, dst, 0, 16);
        Assertions.assertSame(dst, result);
    }

    @Test
    @DisplayName("Test case: nBytes is less than 8")
    void testUuidToByteArrayWithNBytesLessThanEight() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        byte[] result = conversion.uuidToByteArray(uuid, dst, 0, 7);
        Assertions.assertSame(dst, result);
    }

    @Test
    @DisplayName("Test case: nBytes is equal to 8")
    void testUuidToByteArrayWithNBytesEqualToEight() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        byte[] result = conversion.uuidToByteArray(uuid, dst, 0, 8);
        Assertions.assertSame(dst, result);
    }

    @Test
    @DisplayName("Test case: nBytes is greater than 8")
    void testUuidToByteArrayWithNBytesGreaterThanEight() {
        UUID uuid = UUID.randomUUID();
        byte[] dst = new byte[16];
        byte[] result = conversion.uuidToByteArray(uuid, dst, 0, 9);
        Assertions.assertSame(dst, result);
    }

    @Test
    void testByteArrayToUuidThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> conversion.byteArrayToUuid(null, 0));
    }

    @Test
    void testByteArrayToUuidThrowsIllegalArgumentException() {
        byte[] src = new byte[15];
        assertThrows(IllegalArgumentException.class, () -> conversion.byteArrayToUuid(src, 0));
    }

    @Test
    void testByteArrayToUuidReturnsUuid() {
        byte[] src = new byte[16];
        UUID uuid = conversion.byteArrayToUuid(src, 0);
        assertNotNull(uuid);
    }


    @Test
    @DisplayName("Throw IllegalArgumentException when nBools-1+srcPos >= 32")
    void testIntToBinary_InvalidInput() {
        int src = 0;
        int srcPos = 0;
        boolean[] dst = new boolean[32];
        int dstPos = 0;
        int nBools = 33;

        assertThrows(IllegalArgumentException.class, () -> {
            conversion.intToBinary(src, srcPos, dst, dstPos, nBools);
        });
    }

    @Test
    @DisplayName("Return the same destination array when nBools is 0")
    void testIntToBinary_ZeroNBools() {
        int src = 0;
        int srcPos = 0;
        boolean[] dst = new boolean[32];
        int dstPos = 0;
        int nBools = 0;

        boolean[] result = conversion.intToBinary(src, srcPos, dst, dstPos, nBools);

        assertNotNull(result);
        assertSame(dst, result);
    }

    @Test
    @DisplayName("Throw NullPointerException when destination array is null")
    void testIntToBinary_NullDestinationArray() {
        int src = 0;
        int srcPos = 0;
        boolean[] dst = null;
        int dstPos = 0;
        int nBools = 32;

        assertThrows(NullPointerException.class, () -> {
            conversion.intToBinary(src, srcPos, dst, dstPos, nBools);
        });
    }

    @Test
    @DisplayName("Throw ArrayIndexOutOfBoundsException when dstPos + nBools > dst.length")
    void testIntToBinary_OutOfBounds() {
        int src = 0;
        int srcPos = 0;
        boolean[] dst = new boolean[32];
        int dstPos = 32;
        int nBools = 1;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            conversion.intToBinary(src, srcPos, dst, dstPos, nBools);
        });
    }
    // Your Java code here

    @Test
    void testLongToIntArray_ZeroInts() {
        int[] dst = new int[4];
        int[] result = conversion.longToIntArray(123456789L, 0, dst, 0, 0);
        assertSame(dst, result);
    }

    @Test
    void testLongToIntArray_MoreIntsThanBits() {
        int[] dst = new int[4];
        assertThrows(IllegalArgumentException.class, () -> {
            conversion.longToIntArray(123456789L, 0, dst, 0, 3);
        });
    }

    @Test
    void testLongToIntArray_NullDestination() {
        assertThrows(NullPointerException.class, () -> {
            conversion.longToIntArray(123456789L, 0, null, 0, 1);
        });
    }

    @Test
    void testLongToIntArray_OutOfBoundsDestination() {
        int[] dst = new int[2];
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            conversion.longToIntArray(123456789L, 0, dst, 1, 2);
        });
    }


    @Test
    void testLongToIntArray_InvalidSrcPos() {
        int[] dst = new int[4];
        assertThrows(IllegalArgumentException.class, () -> {
            conversion.longToIntArray(123456789L, 64, dst, 0, 4);
        });
    }

    @Test
    void testLongToIntArray_InvalidDstPos() {
        int[] dst = new int[4];
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            conversion.longToIntArray(123456789L, 0, dst, 3, 2);
        });
    }


    @Test
    @DisplayName("should return the destination array when nShorts is 0")
    void testIntToShortArrayWithZeroNShorts() {
        short[] dst = new short[5];
        short[] result = Conversion.intToShortArray(10, 0, dst, 2, 0);
        Assertions.assertSame(dst, result);
    }

    @Test
    @DisplayName("should throw IllegalArgumentException when (nShorts-1)*16+srcPos >= 32")
    void testIntToShortArrayWithInvalidNShorts() {
        short[] dst = new short[5];
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Conversion.intToShortArray(10, 16, dst, 0, 3));
    }


    @Test
    @DisplayName("should throw ArrayIndexOutOfBoundsException when dstPos + nShorts > dst.length")
    void testIntToShortArrayWithInvalidDstPos() {
        short[] dst = new short[5];
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> Conversion.intToShortArray(10, 0, dst, 4, 2));
    }

    @Test
    void testByteToHexWithZero() {
        byte src = 0;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 1;

        String result = conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);

        Assertions.assertEquals("0", result);
    }

    @Test
    void testByteToHexWithLargeNHexs() {
        byte src = 15;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 10;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);
        });
    }


    @Test
    void testShortToHex_zeroNHexs() {
        short src = 0x1234;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 0;

        String result = Conversion.shortToHex(src, srcPos, dstInit, dstPos, nHexs);

        Assertions.assertEquals("", result);
    }

    @Test
    void testShortToHex_invalidNHexs() {
        short src = 0x1234;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 5;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.shortToHex(src, srcPos, dstInit, dstPos, nHexs);
        });
    }

    @Test
    void testShortToHex_invalidDstPos() {
        short src = 0x1234;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 5;
        int nHexs = 3;

        Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Conversion.shortToHex(src, srcPos, dstInit, dstPos, nHexs);
        });
    }

    @Test
    public void testIntToHex_ZeroLength() {
        String result = Conversion.intToHex(10, 0, "0000", 0, 0);
        Assertions.assertEquals("0000", result);
    }

    @Test
    void testBinaryBeMsb0ToHexDigit_EmptyArray_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> conversion.binaryBeMsb0ToHexDigit(new boolean[]{}));
    }

    @Test
    void testBinaryBeMsb0ToHexDigit_NullArray_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> conversion.binaryBeMsb0ToHexDigit(null));
    }

    @Test
    void testBinaryBeMsb0ToHexDigit_InvalidSrcPos_ThrowsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> conversion.binaryBeMsb0ToHexDigit(new boolean[]{true, false, true}, 3));
    }

    @Test
    void testBinaryBeMsb0ToHexDigit_AllTrue_ReturnsF() {
        assertEquals('f', conversion.binaryBeMsb0ToHexDigit(new boolean[]{true, true, true, true}));
    }

    @Test
    void testBinaryBeMsb0ToHexDigit_AllFalse_Returns0() {
        assertEquals('0', conversion.binaryBeMsb0ToHexDigit(new boolean[]{false, false, false, false}));
    }

    @Test
    void testBinaryBeMsb0ToHexDigit_FirstTrue_Returns8() {
        assertEquals('8', conversion.binaryBeMsb0ToHexDigit(new boolean[]{true, false, false, false}));
    }


    @Test
    void testBinaryBeMsb0ToHexDigit_LastTrue_Returns1() {
        assertEquals('1', conversion.binaryBeMsb0ToHexDigit(new boolean[]{false, false, false, true}));
    }

    @Test
    void testIntArrayToLongWithEmptySrcArray() {
        int[] src = {};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nInts = 0;

        long result = Conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);

        Assertions.assertEquals(dstInit, result);
    }

    @Test
    void testIntArrayToLongWithNIntsEqualToOne() {
        int[] src = {1};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nInts = 1;

        long result = Conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);

        Assertions.assertEquals(0x00000001L, result);
    }

    @Test
    void testIntArrayToLongWithMaximumBits() {
        int[] src = {1, 2, 3, 4};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 32;
        int nInts = 2;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);
        });
    }

    @Test
    void testIntArrayToLongWithNullSrcArray() {
        int[] src = null;
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nInts = 0;

        Assertions.assertThrows(NullPointerException.class, () -> {
            Conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);
        });
    }


    @Test
    void testLongToBinary_AllTrue() {
        boolean[] expected = new boolean[]{true, true, true, true};
        Assertions.assertArrayEquals(expected, Conversion.longToBinary(15L, 0, new boolean[4], 0, 4));
    }

    @Test
    void testLongToBinary_FirstFalse() {
        boolean[] expected = new boolean[]{false, true, true, true};
        Assertions.assertArrayEquals(expected, Conversion.longToBinary(14L, 0, new boolean[4], 0, 4));
    }

    @Test
    void testLongToBinary_SecondFalse() {
        boolean[] expected = new boolean[]{true, false, true, true};
        Assertions.assertArrayEquals(expected, Conversion.longToBinary(13L, 0, new boolean[4], 0, 4));
    }

    @Test
    void testLongToBinary_ThirdFalse() {
        boolean[] expected = new boolean[]{true, true, false, true};
        Assertions.assertArrayEquals(expected, Conversion.longToBinary(11L, 0, new boolean[4], 0, 4));
    }

    @Test
    void testLongToBinary_FourthFalse() {
        boolean[] expected = new boolean[]{true, true, true, false};
        Assertions.assertArrayEquals(expected, Conversion.longToBinary(7L, 0, new boolean[4], 0, 4));
    }


    @Test
    void testLongToBinary_LastThreeFalse() {
        boolean[] expected = new boolean[]{true, true, true, false};
        Assertions.assertArrayEquals(expected, Conversion.longToBinary(7L, 0, new boolean[4], 0, 4));
    }

    @Test
    void testLongToBinary_AllFalse() {
        boolean[] expected = new boolean[]{false, false, false, false};
        Assertions.assertArrayEquals(expected, Conversion.longToBinary(0L, 0, new boolean[4], 0, 4));
    }

    @Test
    void testLongToBinary_NullDst() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Conversion.longToBinary(15L, 0, null, 0, 4);
        });
    }

    @Test
    void testLongToBinary_ArrayIndexOutOfBounds() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Conversion.longToBinary(15L, 0, new boolean[4], 0, 5);
        });
    }


    @Test
    public void testLongToHex_ZeroHexs() {
        String result = conversion.longToHex(123456789L, 0, "ABC", 2, 0);
        assertEquals("ABC", result);
    }


    @Test
    public void testLongToHex_OutOfBoundsDstPos() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            conversion.longToHex(123456789L, 0, "ABC", 5, 3);
        });
    }


    @Test
    void testByteArrayToInt_EmptySrcAndSrcPosZero() {
        byte[] src = {};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nBytes = 0;

        int result = conversion.byteArrayToInt(src, srcPos, dstInit, dstPos, nBytes);

        assertEquals(dstInit, result);
    }


    @Test
    void testByteArrayToInt_NonEmptySrcAndZeroNBytes() {
        byte[] src = {1, 2, 3};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nBytes = 0;

        int result = conversion.byteArrayToInt(src, srcPos, dstInit, dstPos, nBytes);

        assertEquals(dstInit, result);
    }

    @Test
    void testByteArrayToInt_NBytesDstPosGreaterThan32() {
        byte[] src = {1, 2, 3};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 30;
        int nBytes = 3;

        assertThrows(IllegalArgumentException.class, () -> {
            conversion.byteArrayToInt(src, srcPos, dstInit, dstPos, nBytes);
        });
    }

    @Test
    void testByteArrayToInt_AllTrueSrc() {
        byte[] src = {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nBytes = 4;

        int result = conversion.byteArrayToInt(src, srcPos, dstInit, dstPos, nBytes);

        assertEquals(-1, result);
    }

    @Test
    void testByteArrayToInt_AllFalseSrc() {
        byte[] src = {0, 0, 0, 0};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nBytes = 4;

        int result = conversion.byteArrayToInt(src, srcPos, dstInit, dstPos, nBytes);

        assertEquals(0, result);
    }


    @Test
    void testByteArrayToInt_NBytesGreaterThanSrcLength() {
        byte[] src = {1, 2, 3};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nBytes = 4;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            conversion.byteArrayToInt(src, srcPos, dstInit, dstPos, nBytes);
        });
    }


    @Test
    public void testIntToHexDigitMsb0() {
        // Test cases for digits 0-9
        Assertions.assertEquals('0', Conversion.intToHexDigitMsb0(0x0));
        Assertions.assertEquals('8', Conversion.intToHexDigitMsb0(0x1));
        Assertions.assertEquals('4', Conversion.intToHexDigitMsb0(0x2));
        Assertions.assertEquals('c', Conversion.intToHexDigitMsb0(0x3));
        Assertions.assertEquals('2', Conversion.intToHexDigitMsb0(0x4));
        Assertions.assertEquals('a', Conversion.intToHexDigitMsb0(0x5));
        Assertions.assertEquals('6', Conversion.intToHexDigitMsb0(0x6));
        Assertions.assertEquals('e', Conversion.intToHexDigitMsb0(0x7));
        Assertions.assertEquals('1', Conversion.intToHexDigitMsb0(0x8));
        Assertions.assertEquals('9', Conversion.intToHexDigitMsb0(0x9));

        // Test cases for digits A-F
        Assertions.assertEquals('5', Conversion.intToHexDigitMsb0(0xA));
        Assertions.assertEquals('d', Conversion.intToHexDigitMsb0(0xB));
        Assertions.assertEquals('3', Conversion.intToHexDigitMsb0(0xC));
        Assertions.assertEquals('b', Conversion.intToHexDigitMsb0(0xD));
        Assertions.assertEquals('7', Conversion.intToHexDigitMsb0(0xE));
        Assertions.assertEquals('f', Conversion.intToHexDigitMsb0(0xF));

        // Test cases for invalid input
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intToHexDigitMsb0(-1);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intToHexDigitMsb0(16);
        });
    }


    @Test
    void testBinaryToLong_AllFalse() {
        boolean[] binary = {false, false, false, false};
        long expected = 0L;
        long result = conversion.binaryToLong(binary, 0, 0L, 0, 4);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testBinaryToLong_OneBool() {
        boolean[] binary = {true};
        long expected = 1L;
        long result = conversion.binaryToLong(binary, 0, 0L, 0, 1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testBinaryToLong_ZeroBools() {
        boolean[] binary = {};
        long expected = 0L;
        long result = conversion.binaryToLong(binary, 0, 0L, 0, 0);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testBinaryToLong_InvalidPosition() {
        boolean[] binary = {true, true, true, true};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            conversion.binaryToLong(binary, 0, 0L, 61, 4);
        });
    }

    @Test
    void testBinaryToLong_NullSrc() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            conversion.binaryToLong(null, 0, 0L, 0, 4);
        });
    }

    @Test
    void testBinaryToLong_OutOfBounds() {
        boolean[] binary = {true, true, true, true};
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            conversion.binaryToLong(binary, 0, 0L, 0, 5);
        });
    }

    @Test
    void testShortToByteArray_AllBytesSet() {
        // test code here
    }

    @Test
    void testShortToByteArray_LeastSignificantByteSet() {
        // test code here
    }

    @Test
    void testShortToByteArray_MostSignificantByteSet() {
        // test code here
    }

    @Test
    void testShortToByteArray_OnlyLeastSignificantByte() {
        // test code here
    }

    @Test
    void testShortToByteArray_OnlyMostSignificantByte() {
        // test code here
    }

    @Test
    void testShortToByteArray_DifferentSrcPos() {
        // test code here
    }

    @Test
    void testShortToByteArray_DifferentDstPos() {
        // test code here
    }

    @Test
    void testShortToByteArray_ZeroBytes() {
        // test code here
    }

    @Test
    void testShortToByteArray_InvalidNBytes() {
        // test code here
    }

    @Test
    void testShortToByteArray_NullDst() {
        // test code here
    }

    @Test
    void testShortToByteArray_DstOutOfBounds() {
        // test code here
    }
    // @Test functions

    @Test
    void testHexToByte_ZeroLengthString_ReturnsDstInit() {
        byte dstInit = 0x00;
        int srcPos = 0;
        int dstPos = 0;
        int nHex = 0;

        byte result = Conversion.hexToByte("", srcPos, dstInit, dstPos, nHex);

        assertEquals(dstInit, result);
    }

    @Test
    void testHexToByte_InvalidPosition_ThrowsIllegalArgumentException() {
        byte dstInit = 0x00;
        int srcPos = 0;
        int dstPos = 4;
        int nHex = 2;

        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToByte("AB", srcPos, dstInit, dstPos, nHex);
        });
    }


    @Test
    void testHexToByte_ConvertsSingleHexDigitToByte() {
        byte dstInit = 0x00;
        int srcPos = 0;
        int dstPos = 0;
        int nHex = 1;

        byte result = Conversion.hexToByte("F", srcPos, dstInit, dstPos, nHex);

        assertEquals(0x0F, result);
    }

    @Test
    void testHexToByte_ConvertsHexStringToByte_WithNonZeroDstInit() {
        byte dstInit = (byte) 0x80;
        int srcPos = 0;
        int dstPos = 0;
        int nHex = 2;

        byte result = Conversion.hexToByte("FFFF", srcPos, dstInit, dstPos, nHex);

        assertEquals((byte) 0xFF, result);
    }

    @Test
    void testHexDigitToInt_ValidHexDigit_ReturnsIntValue() {
        char hexDigit = '1';
        int expected = 1;
        int actual = Conversion.hexDigitToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitToInt_InvalidHexDigit_ThrowsIllegalArgumentException() {
        char hexDigit = 'G';
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexDigitToInt(hexDigit);
        });
    }

    @Test
    void testHexDigitToInt_AllValidHexDigits_ReturnsIntValue() {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        for (char hexDigit : hexDigits) {
            int expected = Character.digit(hexDigit, 16);
            int actual = Conversion.hexDigitToInt(hexDigit);
            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    void testHexDigitToInt_AllInvalidHexDigits_ThrowsIllegalArgumentException() {
        char[] hexDigits = {'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (char hexDigit : hexDigits) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Conversion.hexDigitToInt(hexDigit);
            });
        }
    }

    @Test
    void testShortArrayToInt_EmptyArray() {
        short[] src = {};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nShorts = 0;

        int result = conversion.shortArrayToInt(src, srcPos, dstInit, dstPos, nShorts);

        assertEquals(0, result);
    }

    @Test
    void testShortArrayToInt_DstPosOutOfRange() {
        short[] src = {1, 2, 3};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 17;
        int nShorts = 3;

        assertThrows(IllegalArgumentException.class, () -> {
            conversion.shortArrayToInt(src, srcPos, dstInit, dstPos, nShorts);
        });
    }

    @Test
    void testShortArrayToInt_AllShortsMaxValue() {
        short[] src = {Short.MAX_VALUE, Short.MAX_VALUE};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nShorts = 2;

        int result = conversion.shortArrayToInt(src, srcPos, dstInit, dstPos, nShorts);

        assertEquals(2147450879, result);
    }



    @Test
    void testHexDigitMsb0ToIntWithDigit0() {
        char hexDigit = '0';
        int expected = 0x0;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigit1() {
        char hexDigit = '1';
        int expected = 0x8;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigit2() {
        char hexDigit = '2';
        int expected = 0x4;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigit3() {
        char hexDigit = '3';
        int expected = 0xC;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigit4() {
        char hexDigit = '4';
        int expected = 0x2;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigit5() {
        char hexDigit = '5';
        int expected = 0xA;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigit6() {
        char hexDigit = '6';
        int expected = 0x6;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigit7() {
        char hexDigit = '7';
        int expected = 0xE;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigit8() {
        char hexDigit = '8';
        int expected = 0x1;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigit9() {
        char hexDigit = '9';
        int expected = 0x9;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigitA() {
        char hexDigit = 'A';
        int expected = 0x5;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigitB() {
        char hexDigit = 'B';
        int expected = 0xD;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigitC() {
        char hexDigit = 'C';
        int expected = 0x3;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigitD() {
        char hexDigit = 'D';
        int expected = 0xB;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigitE() {
        char hexDigit = 'E';
        int expected = 0x7;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithDigitF() {
        char hexDigit = 'F';
        int expected = 0xF;
        int actual = Conversion.hexDigitMsb0ToInt(hexDigit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHexDigitMsb0ToIntWithInvalidDigit() {
        char hexDigit = 'G';
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexDigitMsb0ToInt(hexDigit);
        });
    }

    @Test
    void testHexToLong_EmptyString() {
        long result = Conversion.hexToLong("", 0, 0L, 0, 0);
        assertEquals(0L, result);
    }

    @Test
    void testHexToLong_OneHexDigit() {
        long result = Conversion.hexToLong("F", 0, 0L, 0, 1);
        assertEquals(15L, result);
    }

    @Test
    void testHexToLong_MultipleHexDigits() {
        long result = Conversion.hexToLong("FF", 0, 0L, 0, 2);
        assertEquals(255L, result);
    }

    @Test
    void testHexToLong_PositiveDstPos() {
        long result = Conversion.hexToLong("F", 0, 0L, 4, 1);
        assertEquals(240L, result);
    }

    @Test
    void testBinaryToByte_NullBinary() {
        boolean[] binary = null;
        assertThrows(NullPointerException.class, () -> {
            conversion.binaryToByte(binary, 0, (byte) 0b00000000, 0, 4);
        });
    }

    @Test
    void testBinaryToByte_BinaryOutOfBounds() {
        boolean[] binary = {true, true, true, true};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            conversion.binaryToByte(binary, 0, (byte) 0b00000000, 0, 5);
        });
    }

    @Test
    @DisplayName("Test shortToBinary with valid input")
    void testShortToBinaryValidInput() {
        boolean[] expected = {true, true, true, true};
        boolean[] actual = new boolean[4];
        actual = conversion.shortToBinary((short) 15, 0, actual, 0, 4);
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    @DisplayName("Test shortToBinary with dstPos exceeding length of destination array")
    void testShortToBinaryWithDstPosExceedingLength() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            boolean[] actual = new boolean[4];
            actual = conversion.shortToBinary((short) 15, 0, actual, 3, 4);
        });
    }


    @Test
    @DisplayName("Test shortToBinary with valid input and nBools = 1")
    void testShortToBinaryWithNBoolsOne() {
        boolean[] expected = {true, false, false, false};
        boolean[] actual = new boolean[4];
        actual = conversion.shortToBinary((short) 15, 0, actual, 0, 1);
        Assertions.assertArrayEquals(expected, actual);
    }

}