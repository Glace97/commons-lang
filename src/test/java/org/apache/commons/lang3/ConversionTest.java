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
    @DisplayName("Testing invalid hexadecimal digits")
    void testInvalidHexDigits() {
        char[] invalidHexDigits = {'G', 'g', 'X', 'x', 'Z', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char digit : invalidHexDigits) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitMsb0ToBinary(digit));
        }
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

//    @Test
//    void testBinaryToShortWithZeroBools() {
//        boolean[] src = Conversion.TTTT;
//        int srcPos = 0;
//        short dstInit = 0;
//        int dstPos = 0;
//        int nBools = 0;
//
//        short result = Conversion.binaryToShort(src, srcPos, dstInit, dstPos, nBools);
//
//        assertEquals(dstInit, result);
//    }
//
//    @Test
//    void testBinaryToShortWithInvalidPosition() {
//        boolean[] src = Conversion.TTTT;
//        int srcPos = 0;
//        short dstInit = 0;
//        int dstPos = 15;
//        int nBools = 2;
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            Conversion.binaryToShort(src, srcPos, dstInit, dstPos, nBools);
//        });
//    }
//
//    @Test
//    void testBinaryToShortWithOutOfBoundsSource() {
//        boolean[] src = Conversion.TTTT;
//        int srcPos = 2;
//        short dstInit = 0;
//        int dstPos = 0;
//        int nBools = 3;
//
//        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
//            Conversion.binaryToShort(src, srcPos, dstInit, dstPos, nBools);
//        });
//    }
//
//    @Test
//    void testBinaryToShortWithAllTrueBits() {
//        boolean[] src = Conversion.TTTT;
//        int srcPos = 0;
//        short dstInit = 0;
//        int dstPos = 0;
//        int nBools = 4;
//
//        short result = Conversion.binaryToShort(src, srcPos, dstInit, dstPos, nBools);
//
//        assertEquals(15, result);
//    }
//
//    @Test
//    void testBinaryToShortWithAllFalseBits() {
//        boolean[] src = Conversion.FFFF;
//        int srcPos = 0;
//        short dstInit = 0;
//        int dstPos = 0;
//        int nBools = 4;
//
//        short result = Conversion.binaryToShort(src, srcPos, dstInit, dstPos, nBools);
//
//        assertEquals(0, result);
//    }
//
//    @Test
//    void testBinaryToShortWithDifferentPositions() {
//        boolean[] src = Conversion.TTTT;
//        int srcPos = 0;
//        short dstInit = 0;
//        int dstPos = 2;
//        int nBools = 2;
//
//        short result = Conversion.binaryToShort(src, srcPos, dstInit, dstPos, nBools);
//
//        assertEquals(12, result);
//    }


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
    void testLongToByteArray_LessThan64Bytes() {
        long src = 123456789;
        int srcPos = 0;
        byte[] dst = new byte[8];
        int dstPos = 0;
        int nBytes = 4;

        byte[] result = conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);

        byte[] expected = {21, -109, 7, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, result);
    }

    @Test
    void testLongToByteArray_EqualTo64Bytes() {
        long src = 123456789;
        int srcPos = 0;
        byte[] dst = new byte[8];
        int dstPos = 0;
        int nBytes = 8;

        byte[] result = conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);

        byte[] expected = {21, -109, 7, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, result);
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
    void testLongToByteArray_DstPosOutOfBounds() {
        long src = 123456789;
        int srcPos = 0;
        byte[] dst = new byte[8];
        int dstPos = 5;
        int nBytes = 4;

        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes));

        assertEquals("dstPos + nBytes > dst.length", exception.getMessage());
    }

    @Test
    void testLongToByteArray_NormalCase() {
        long src = 123456789;
        int srcPos = 8;
        byte[] dst = new byte[8];
        int dstPos = 2;
        int nBytes = 4;

        byte[] result = conversion.longToByteArray(src, srcPos, dst, dstPos, nBytes);

        byte[] expected = {0, 0, 0, 0, 21, -109, 7, 0};
        assertArrayEquals(expected, result);
    }

//    @Test
//    @DisplayName("should return the destination array when nBytes is 0")
//    void testIntToByteArrayWithZeroNBytes() {
//        assertArrayEquals(dst, Conversion.intToByteArray(10, 0, dst, 0, 0));
//    }
//
//    @Test
//    @DisplayName("should throw IllegalArgumentException when (nBytes-1)*8+srcPos >= 32")
//    void testIntToByteArrayWithInvalidRange() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            Conversion.intToByteArray(10, 24, dst, 0, 2);
//        });
//    }
//
//    @Test
//    @DisplayName("should convert int to byte array correctly")
//    void testIntToByteArray() {
//        byte[] expected = {0, 0, 0, 10};
//        assertArrayEquals(expected, Conversion.intToByteArray(10, 0, dst, 0, 4));
//    }
//
//    @Test
//    @DisplayName("should convert int to byte array with correct srcPos and dstPos")
//    void testIntToByteArrayWithPositions() {
//        byte[] expected = {0, 10, 0, 0};
//        assertArrayEquals(expected, Conversion.intToByteArray(10, 8, dst, 1, 2));
//    }
//
//    @Test
//    @DisplayName("should convert int to byte array with smaller nBytes")
//    void testIntToByteArrayWithSmallerNBytes() {
//        byte[] expected = {0, 10, 0, 0};
//        assertArrayEquals(expected, Conversion.intToByteArray(10, 0, dst, 1, 2));
//    }
//
//    @Test
//    @DisplayName("should convert int to byte array with larger nBytes")
//    void testIntToByteArrayWithLargerNBytes() {
//        byte[] expected = {0, 0, 0, 10};
//        assertArrayEquals(expected, Conversion.intToByteArray(10, 0, dst, 0, 8));
//    }
//
//    @Test
//    @DisplayName("should convert int to byte array with full range of values")
//    void testIntToByteArrayWithFullRange() {
//        for (int i = 0; i < 256; i++) {
//            byte[] expected = {0, 0, 0, (byte) i};
//            assertArrayEquals(expected, Conversion.intToByteArray(i, 0, dst, 0, 4));
//        }
//    }

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
    void testByteArrayToLong_NegativeDstPos_ThrowsIllegalArgumentException() {
        byte[] src = {0x12, 0x34, 0x56};
        int srcPos = 0;
        long dstInit = 0L;
        int dstPos = -8; // Negative dstPos
        int nBytes = 3;

        assertThrows(IllegalArgumentException.class, () -> {
            conversion.byteArrayToLong(src, srcPos, dstInit, dstPos, nBytes);
        });
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
    void testByteArrayToLong_ValidInput_ReturnsExpectedLong() {
        byte[] src = {0x12, 0x34, 0x56};
        int srcPos = 0;
        long dstInit = 0L;
        int dstPos = 0;
        int nBytes = 3;

        long result = conversion.byteArrayToLong(src, srcPos, dstInit, dstPos, nBytes);

        assertEquals(0x00123456L, result);
    }

//    @Test
//    @DisplayName("Test byteToBinary with src = 0, srcPos = 0, dstPos = 0, nBools = 8")
//    void testByteToBinary_AllTrue() {
//        boolean[] expected = {true, true, true, true, true, true, true, true};
//        boolean[] result = Conversion.byteToBinary((byte) 0, 0, dst, 0, 8);
//        assertArrayEquals(expected, result);
//    }
//
//    @Test
//    @DisplayName("Test byteToBinary with src = 0, srcPos = 0, dstPos = 0, nBools = 0")
//    void testByteToBinary_Empty() {
//        boolean[] expected = new boolean[8];
//        boolean[] result = Conversion.byteToBinary((byte) 0, 0, dst, 0, 0);
//        assertArrayEquals(expected, result);
//    }
//
//    @Test
//    @DisplayName("Test byteToBinary with src = -1, srcPos = 0, dstPos = 0, nBools = 8")
//    void testByteToBinary_AllFalse() {
//        boolean[] expected = {false, false, false, false, false, false, false, false};
//        boolean[] result = Conversion.byteToBinary((byte) -1, 0, dst, 0, 8);
//        assertArrayEquals(expected, result);
//    }
//
//    @Test
//    @DisplayName("Test byteToBinary with src = 0, srcPos = 4, dstPos = 2, nBools = 4")
//    void testByteToBinary_Partial() {
//        boolean[] expected = {false, false, false, true, true, false, false, false};
//        boolean[] result = Conversion.byteToBinary((byte) 0, 4, dst, 2, 4);
//        assertArrayEquals(expected, result);
//    }
//
//    @Test
//    @DisplayName("Test byteToBinary with src = 0, srcPos = 7, dstPos = 0, nBools = 1")
//    void testByteToBinary_Single() {
//        boolean[] expected = {false, false, false, false, false, false, false, true};
//        boolean[] result = Conversion.byteToBinary((byte) 0, 7, dst, 0, 1);
//        assertArrayEquals(expected, result);
//    }
//
//    @Test
//    @DisplayName("Test byteToBinary with invalid nBools")
//    void testByteToBinary_InvalidNBools() {
//        assertThrows(IllegalArgumentException.class, () ->
//                Conversion.byteToBinary((byte) 0, 0, dst, 0, 9));
//    }
//
//    @Test
//    @DisplayName("Test byteToBinary with invalid dstPos")
//    void testByteToBinary_InvalidDstPos() {
//        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
//                Conversion.byteToBinary((byte) 0, 0, dst, 7, 2));
//    }

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
    @DisplayName("Test binaryToHexDigit with srcPos")
    void testBinaryToHexDigitWithSrcPos() {
        boolean[] input = {true, true, true, true, false, false, false, false};
        int srcPos = 4;
        char expected = 'f';
        char actual = Conversion.binaryToHexDigit(input, srcPos);
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
    public void testHexToInt_NegativeLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToInt("F", 0, 0, 0, -1);
        });
    }

    @Test
    public void testHexToInt_PositionOutOfBounds() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToInt("F", 1, 0, 0, 1);
        });
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
    public void testHexToInt_LsbZero() {
        int result = Conversion.hexToInt("0F0F0F0F", 0, 0, 0, 8);
        Assertions.assertEquals(252645135, result);
    }

    @Test
    public void testHexToInt_LsbOne() {
        int result = Conversion.hexToInt("F0F0F0F0", 0, 0, 1, 8);
        Assertions.assertEquals(-134744072, result);
    }

    @Test
    public void testHexToInt_MsbZero() {
        int result = Conversion.hexToInt("0F0F0F0F", 0, 0, 31, 8);
        Assertions.assertEquals(536870911, result);
    }

    @Test
    public void testHexToInt_MsbOne() {
        int result = Conversion.hexToInt("F0F0F0F0", 0, 0, 0, 8);
        Assertions.assertEquals(-268435456, result);
    }

    @Test
    public void testHexToInt_MultipleChars() {
        int result = Conversion.hexToInt("0F0F0F0F", 2, 0, 0, 4);
        Assertions.assertEquals(983040, result);
    }

    @Test
    public void testHexToInt_InvalidHexChar() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToInt("G", 0, 0, 0, 1);
        });
    }

    @Test
    public void testHexToInt_UppercaseHex() {
        int result = Conversion.hexToInt("ABCDEF", 0, 0, 0, 6);
        Assertions.assertEquals(11259375, result);
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
    void testBinaryToInt_InvalidNBools() {
        boolean[] src = {true, true, true, true};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.binaryToInt(src, 0, 0, 0, 5);
        });
        assertEquals("nBools-1+dstPos is greater or equal to than 32", exception.getMessage());
    }

    @Test
    void testBinaryToInt_EmptySrc() {
        boolean[] src = {};
        int result = Conversion.binaryToInt(src, 0, 0, 0, 0);
        assertEquals(0, result);
    }

    @Test
    void testBinaryToInt_NullSrc() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            Conversion.binaryToInt(null, 0, 0, 0, 4);
        });
        assertEquals("src is null", exception.getMessage());
    }

    @Test
    void testBinaryToHexDigitMsb0_4bits_validInput() {
        // Test converting (1, 0, 0, 0) to '8'
        boolean[] binary1 = {true, false, false, false};
        char expected1 = '8';
        char result1 = Conversion.binaryToHexDigitMsb0_4bits(binary1);
        Assertions.assertEquals(expected1, result1);

        // Test converting (1, 0, 0, 0, 1, 1, 0, 1, 0) with srcPos = 3 to 'D'
        boolean[] binary2 = {true, false, false, true, true, false, true, false};
        char expected2 = 'D';
        char result2 = Conversion.binaryToHexDigitMsb0_4bits(binary2, 3);
        Assertions.assertEquals(expected2, result2);
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
    public void testIntToHexDigit_Ten() {
        char result = Conversion.intToHexDigit(10);
        Assertions.assertEquals('A', result);
    }

    @Test
    public void testIntToHexDigit_Fifteen() {
        char result = Conversion.intToHexDigit(15);
        Assertions.assertEquals('F', result);
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
    void testHexToShort_InvalidPosition() {
        String src = "ABCD";
        int srcPos = 0;
        short dstInit = 0;
        int dstPos = 12;
        int nHex = 1;

        assertThrows(IllegalArgumentException.class, () -> Conversion.hexToShort(src, srcPos, dstInit, dstPos, nHex));
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
    void testHexToShort_MultipleHexDigits() {
        String src = "ABCD";
        int srcPos = 0;
        short dstInit = 0;
        int dstPos = 0;
        int nHex = 2;

        short result = Conversion.hexToShort(src, srcPos, dstInit, dstPos, nHex);

        assertEquals(43981, result);
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
    void testHexToShort_DifferentPositions() {
        String src = "ABCD";
        int srcPos = 0;
        short dstInit = 0;
        int dstPos = 4;
        int nHex = 2;

        short result = Conversion.hexToShort(src, srcPos, dstInit, dstPos, nHex);

        assertEquals(175, result);
    }

    @Test
    void testHexToShort_LargeNumber() {
        String src = "123456789ABCDE";
        int srcPos = 0;
        short dstInit = 0;
        int dstPos = 0;
        int nHex = 8;

        short result = Conversion.hexToShort(src, srcPos, dstInit, dstPos, nHex);

        assertEquals(-31982, result);
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
    @DisplayName("Convert int 10 to binary")
    void testIntToBinary_Positive() {
        int src = 10;
        int srcPos = 0;
        boolean[] dst = new boolean[32];
        int dstPos = 0;
        int nBools = 32;

        boolean[] result = conversion.intToBinary(src, srcPos, dst, dstPos, nBools);

        assertNotNull(result);
        assertTrue(result[0]);
        assertFalse(result[1]);
        assertTrue(result[2]);
        assertFalse(result[3]);
        assertTrue(result[4]);
        assertFalse(result[5]);
        assertFalse(result[6]);
        assertFalse(result[7]);
        assertFalse(result[8]);
        assertFalse(result[9]);
        assertFalse(result[10]);
        assertFalse(result[11]);
        assertFalse(result[12]);
        assertFalse(result[13]);
        assertFalse(result[14]);
        assertFalse(result[15]);
        assertFalse(result[16]);
        assertFalse(result[17]);
        assertFalse(result[18]);
        assertFalse(result[19]);
        assertFalse(result[20]);
        assertFalse(result[21]);
        assertFalse(result[22]);
        assertFalse(result[23]);
        assertFalse(result[24]);
        assertFalse(result[25]);
        assertFalse(result[26]);
        assertFalse(result[27]);
        assertFalse(result[28]);
        assertFalse(result[29]);
        assertFalse(result[30]);
        assertFalse(result[31]);
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
    void testLongToIntArray_PositiveCase() {
        int[] dst = new int[4];
        int[] result = conversion.longToIntArray(123456789L, 0, dst, 0, 4);
        assertArrayEquals(new int[]{123456789, 0, 0, 0}, result);
    }

    @Test
    void testLongToIntArray_NegativeCase() {
        int[] dst = new int[4];
        int[] result = conversion.longToIntArray(-987654321L, 0, dst, 0, 4);
        assertArrayEquals(new int[]{-987654321, -1, -1, -1}, result);
    }

    @Test
    void testLongToIntArray_Lsb0BitOrdering() {
        int[] dst = new int[4];
        int[] result = conversion.longToIntArray(123456789L, 1, dst, 0, 4);
        assertArrayEquals(new int[]{246913578, 1, 0, 0}, result);
    }

    @Test
    void testLongToIntArray_BigEndianByteOrdering() {
        int[] dst = new int[4];
        int[] result = conversion.longToIntArray(123456789L, 0, dst, 0, 4);
        assertArrayEquals(new int[]{0x07, 0x5B, 0xCD, 0x15}, result);
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
    void testLongToIntArray_RandomValues() {
        int[] dst = new int[4];
        int[] result = conversion.longToIntArray(UUID.randomUUID().getLeastSignificantBits(), 0, dst, 0, 4);
        assertNotNull(result);
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
    @DisplayName("should convert int to short array with little-endian, Lsb0 byte and bit ordering")
    void testIntToShortArray() {
        short[] dst = new short[5];
        short[] expected = {0x0000, 0x0000, 0x0000, 0x0000, 0x0000};

        Conversion.intToShortArray(0x12345678, 0, dst, 0, 5);

        Assertions.assertArrayEquals(expected, dst);
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
    void testByteToHexWithPositiveValue() {
        byte src = 127;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 2;

        String result = conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);

        Assertions.assertEquals("7F", result);
    }

    @Test
    void testByteToHexWithNegativeValue() {
        byte src = -128;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 2;

        String result = conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);

        Assertions.assertEquals("80", result);
    }

    @Test
    void testByteToHexWithSrcPosGreaterThanZero() {
        byte src = 15;
        int srcPos = 4;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 1;

        String result = conversion.byteToHex(src, srcPos, dstInit, dstPos, nHexs);

        Assertions.assertEquals("1", result);
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
    void testLongToShortArray() {
        short[] dst = new short[4];

        // Test when nShorts is 0
        Assertions.assertArrayEquals(dst, Conversion.longToShortArray(0L, 0, dst, 0, 0));

        // Test when nShorts is 1
        Assertions.assertArrayEquals(new short[]{0x0000, 0x0000, 0x0000, 0x0001},
                Conversion.longToShortArray(1L, 0, dst, 0, 1));

//        // Test when nShorts is the maximum possible value
//        Assertions.assertArrayEquals(new short[]{0xffff, 0xffff, 0xffff, 0xffff},
//                Conversion.longToShortArray(0xffffffffffffffffL, 0, dst, 0, 4));

        // Test when nShorts is larger than the width of the input
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Conversion.longToShortArray(0xffffffffffffffffL, 0, dst, 0, 5));

        // Test when srcPos is 0
        Assertions.assertArrayEquals(new short[]{0x0000, 0x0000, 0x0000, 0x0001},
                Conversion.longToShortArray(0x0001000000000000L, 0, dst, 0, 1));

        // Test when srcPos is non-zero
        Assertions.assertArrayEquals(new short[]{0x0000, 0x0001, 0x0000, 0x0000},
                Conversion.longToShortArray(0x0000000000010000L, 16, dst, 0, 1));

        // Test when dstPos is non-zero
        Assertions.assertArrayEquals(new short[]{0x0000, 0x0000, 0x0000, 0x0001},
                Conversion.longToShortArray(0x0000000000000001L, 0, dst, 2, 1));

        // Test when dstPos + nShorts is larger than dst.length
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> Conversion.longToShortArray(0xffffffffffffffffL, 0, dst, 2, 3));

        // Test when dst is null
        Assertions.assertThrows(NullPointerException.class,
                () -> Conversion.longToShortArray(0xffffffffffffffffL, 0, null, 0, 4));
    }

    @Test
    void testShortToHex_zeroSrcPos() {
        short src = 0x1234;
        int srcPos = 0;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 4;

        String result = Conversion.shortToHex(src, srcPos, dstInit, dstPos, nHexs);

        Assertions.assertEquals("1234", result);
    }

    @Test
    void testShortToHex_nonZeroSrcPos() {
        short src = 0x1234;
        int srcPos = 4;
        String dstInit = "";
        int dstPos = 0;
        int nHexs = 3;

        String result = Conversion.shortToHex(src, srcPos, dstInit, dstPos, nHexs);

        Assertions.assertEquals("0123", result);
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
    void testShortToHex_fullCoverage() {
        short src = 0x1234;
        int srcPos = 0;
        String dstInit = "0000";
        int dstPos = 1;
        int nHexs = 3;

        String result = Conversion.shortToHex(src, srcPos, dstInit, dstPos, nHexs);

        Assertions.assertEquals("0123", result);
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
    public void testIntToHex_InvalidLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intToHex(10, 0, "0000", 0, 2);
        });
    }

    @Test
    public void testIntToHex_ValidInput() {
        String result = Conversion.intToHex(10, 0, "0000", 0, 2);
        Assertions.assertEquals("000A", result);
    }

    @Test
    public void testIntToHex_ValidInput_LargeNumber() {
        String result = Conversion.intToHex(987654321, 0, "00000000", 0, 8);
        Assertions.assertEquals("3ADE68B1", result);
    }

    @Test
    public void testIntToHex_ValidInput_Msb() {
        String result = Conversion.intToHex(10, 28, "00000000", 0, 1);
        Assertions.assertEquals("A0000000", result);
    }

    @Test
    public void testIntToHex_ValidInput_DstPos() {
        String result = Conversion.intToHex(10, 0, "0000", 2, 2);
        Assertions.assertEquals("00A0", result);
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
    void testBinaryBeMsb0ToHexDigit_FirstFalse_Returns4() {
        assertEquals('4', conversion.binaryBeMsb0ToHexDigit(new boolean[]{false, true, true, true}));
    }

    @Test
    void testBinaryBeMsb0ToHexDigit_LastTrue_Returns1() {
        assertEquals('1', conversion.binaryBeMsb0ToHexDigit(new boolean[]{false, false, false, true}));
    }

    @Test
    void testBinaryBeMsb0ToHexDigit_LastFalse_Returns0() {
        assertEquals('0', conversion.binaryBeMsb0ToHexDigit(new boolean[]{true, true, true, false}));
    }

    @Test
    void testBinaryBeMsb0ToHexDigit_MiddleTrue_Returns2() {
        assertEquals('2', conversion.binaryBeMsb0ToHexDigit(new boolean[]{true, true, false, true}));
    }

    @Test
    void testBinaryBeMsb0ToHexDigit_MiddleFalse_Returns4() {
        assertEquals('4', conversion.binaryBeMsb0ToHexDigit(new boolean[]{true, false, true, true}));
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
    void testIntArrayToLongWithNonEmptySrcArray() {
        int[] src = {1, 2, 3, 4};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nInts = 4;

        long result = Conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);

        Assertions.assertEquals(0x04030201L, result);
    }

    @Test
    void testIntArrayToLongWithSrcPosGreaterThanZero() {
        int[] src = {1, 2, 3, 4};
        int srcPos = 1;
        long dstInit = 0;
        int dstPos = 0;
        int nInts = 3;

        long result = Conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);

        Assertions.assertEquals(0x040302L, result);
    }

    @Test
    void testIntArrayToLongWithDstPosGreaterThanZero() {
        int[] src = {1, 2, 3, 4};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 8;
        int nInts = 4;

        long result = Conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);

        Assertions.assertEquals(0x04030201L << 8, result);
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
    void testIntArrayToLongWithNIntsGreaterThanOne() {
        int[] src = {1, 2, 3, 4, 5};
        int srcPos = 0;
        long dstInit = 0;
        int dstPos = 0;
        int nInts = 5;

        long result = Conversion.intArrayToLong(src, srcPos, dstInit, dstPos, nInts);

        Assertions.assertEquals(0x0504030201L, result);
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
    void testIntArrayToLongWithSrcPosAndNIntsExceedingSrcArrayLength() {
        int[] src = {1, 2, 3, 4};
        int srcPos = 2;
        long dstInit = 0;
        int dstPos = 0;
        int nInts = 4;

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
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
    void testLongToBinary_FirstThreeFalse() {
        boolean[] expected = new boolean[]{false, false, false, true};
        Assertions.assertArrayEquals(expected, Conversion.longToBinary(1L, 0, new boolean[4], 0, 4));
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
    void testLongToBinary_InvalidNBools() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.longToBinary(15L, 0, new boolean[4], 0, 5);
        });
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
    public void testLongToHex_InvalidHexs() {
        assertThrows(IllegalArgumentException.class, () -> {
            conversion.longToHex(123456789L, 0, "ABC", 2, 5);
        });
    }

    @Test
    public void testLongToHex_ValidHexs() {
        String result = conversion.longToHex(123456789L, 0, "ABC", 2, 3);
        assertEquals("AB123", result);
    }

    @Test
    public void testLongToHex_OutOfBoundsDstPos() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            conversion.longToHex(123456789L, 0, "ABC", 5, 3);
        });
    }

    @Test
    public void testLongToHex_SingleHex() {
        String result = conversion.longToHex(123456789L, 0, "ABC", 0, 1);
        assertEquals("C", result);
    }

    @Test
    public void testLongToHex_MultipleHexs() {
        String result = conversion.longToHex(123456789L, 4, "ABC", 1, 2);
        assertEquals("AFC", result);
    }

    @Test
    public void testLongToHex_MaxHexs() {
        String result = conversion.longToHex(123456789L, 0, "ABC", 0, 16);
        assertEquals("123456789ABCDEF0", result);
    }

    @Test
    public void testLongToHex_MaxSrcPos() {
        String result = conversion.longToHex(123456789L, 60, "ABC", 0, 4);
        assertEquals("FABC", result);
    }

    @Test
    public void testLongToHex_MinSrcPos() {
        String result = conversion.longToHex(123456789L, 0, "ABC", 0, 4);
        assertEquals("1234", result);
    }

    @Test
    public void testLongToHex_MaxSrc() {
        String result = conversion.longToHex(Long.MAX_VALUE, 0, "ABC", 0, 16);
        assertEquals("7FFFFFFFFFFFFFFF", result);
    }

    @Test
    public void testLongToHex_MinSrc() {
        String result = conversion.longToHex(Long.MIN_VALUE, 0, "ABC", 0, 16);
        assertEquals("8000000000000000", result);
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
    void testByteArrayToInt_EmptySrcAndNonZeroSrcPos() {
        byte[] src = {};
        int srcPos = 2;
        int dstInit = 0;
        int dstPos = 0;
        int nBytes = 0;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            conversion.byteArrayToInt(src, srcPos, dstInit, dstPos, nBytes);
        });
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
    void testByteArrayToInt_SrcPosNonZero_DstPosNonZero() {
        byte[] src = {1, 2, 3, 4};
        int srcPos = 1;
        int dstInit = 0;
        int dstPos = 4;
        int nBytes = 3;

        int result = conversion.byteArrayToInt(src, srcPos, dstInit, dstPos, nBytes);

        assertEquals(0x234, result);
    }

    @Test
    void testByteArrayToInt_SrcPosNonZero_DstPosZero() {
        byte[] src = {1, 2, 3, 4};
        int srcPos = 1;
        int dstInit = 0;
        int dstPos = 0;
        int nBytes = 3;

        int result = conversion.byteArrayToInt(src, srcPos, dstInit, dstPos, nBytes);

        assertEquals(0x123, result);
    }

    @Test
    void testByteArrayToInt_SrcPosZero_DstPosNonZero() {
        byte[] src = {1, 2, 3, 4};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 4;
        int nBytes = 3;

        int result = conversion.byteArrayToInt(src, srcPos, dstInit, dstPos, nBytes);

        assertEquals(0x345, result);
    }

    @Test
    void testByteArrayToInt_SrcPosZero_DstPosZero() {
        byte[] src = {1, 2, 3, 4};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nBytes = 3;

        int result = conversion.byteArrayToInt(src, srcPos, dstInit, dstPos, nBytes);

        assertEquals(0x123, result);
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
    void testByteArrayToInt_NBytesLessThanSrcLength() {
        byte[] src = {1, 2, 3, 4, 5};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nBytes = 3;

        int result = conversion.byteArrayToInt(src, srcPos, dstInit, dstPos, nBytes);

        assertEquals(0x123, result);
    }

    @Test
    void testByteArrayToInt_RandomSrc() {
        byte[] src = {1, 2, 3, 4};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nBytes = 4;

        int result = conversion.byteArrayToInt(src, srcPos, dstInit, dstPos, nBytes);

        assertEquals(0x01020304, result);
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
    void testBinaryToLong_AllTrue() {
        boolean[] binary = {true, true, true, true};
        long expected = -1L;
        long result = conversion.binaryToLong(binary, 0, 0L, 0, 4);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testBinaryToLong_FirstTrue() {
        boolean[] binary = {false, true, true, true};
        long expected = 7L;
        long result = conversion.binaryToLong(binary, 0, 0L, 0, 4);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testBinaryToLong_SecondTrue() {
        boolean[] binary = {true, false, true, true};
        long expected = 11L;
        long result = conversion.binaryToLong(binary, 0, 0L, 0, 4);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testBinaryToLong_ThirdTrue() {
        boolean[] binary = {true, true, false, true};
        long expected = 13L;
        long result = conversion.binaryToLong(binary, 0, 0L, 0, 4);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testBinaryToLong_FourthTrue() {
        boolean[] binary = {true, true, true, false};
        long expected = 14L;
        long result = conversion.binaryToLong(binary, 0, 0L, 0, 4);
        Assertions.assertEquals(expected, result);
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
    void testHexToByte_ConvertsHexStringToByte_LittleEndianLsb0() {
        byte dstInit = 0x00;
        int srcPos = 0;
        int dstPos = 0;
        int nHex = 4;

        byte result = Conversion.hexToByte("ABCD", srcPos, dstInit, dstPos, nHex);

        assertEquals(0xCD, result);
    }

    @Test
    void testHexToByte_ConvertsHexStringToByte_BigEndianMsb0() {
        byte dstInit = 0x00;
        int srcPos = 0;
        int dstPos = 4;
        int nHex = 4;

        byte result = Conversion.hexToByte("ABCD", srcPos, dstInit, dstPos, nHex);

        assertEquals(0xAB, result);
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
    void testHexToByte_ConvertsMultipleHexDigitsToByte() {
        byte dstInit = 0x00;
        int srcPos = 0;
        int dstPos = 0;
        int nHex = 2;

        byte result = Conversion.hexToByte("FF", srcPos, dstInit, dstPos, nHex);

        assertEquals(0xFF, result);
    }

    @Test
    void testHexToByte_ConvertsHexStringToByte_WithNonZeroSrcPos() {
        byte dstInit = 0x00;
        int srcPos = 1;
        int dstPos = 0;
        int nHex = 2;

        byte result = Conversion.hexToByte("00FF", srcPos, dstInit, dstPos, nHex);

        assertEquals(0xFF, result);
    }

    @Test
    void testHexToByte_ConvertsHexStringToByte_WithNonZeroDstPos() {
        byte dstInit = 0x00;
        int srcPos = 0;
        int dstPos = 2;
        int nHex = 2;

        byte result = Conversion.hexToByte("FFFF", srcPos, dstInit, dstPos, nHex);

        assertEquals(0xFF, result);
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
    void testHexToByte_ConvertsHexStringToByte_WithMaxHexDigits() {
        byte dstInit = 0x00;
        int srcPos = 0;
        int dstPos = 0;
        int nHex = 8;

        byte result = Conversion.hexToByte("FFFFFFFF", srcPos, dstInit, dstPos, nHex);

        assertEquals((byte) 0xFF, result);
    }

    @Test
    void testHexToByte_ConvertsHexStringToByte_WithMaxDstPos() {
        byte dstInit = 0x00;
        int srcPos = 0;
        int dstPos = 4;
        int nHex = 2;

        byte result = Conversion.hexToByte("FFFF", srcPos, dstInit, dstPos, nHex);

        assertEquals((byte) 0xF0, result);
    }

    @Test
    void testHexToByte_ConvertsHexStringToByte_WithOverflow() {
        byte dstInit = 0x00;
        int srcPos = 0;
        int dstPos = 0;
        int nHex = 3;

        byte result = Conversion.hexToByte("FFFF", srcPos, dstInit, dstPos, nHex);

        assertEquals((byte) 0xFF, result);
    }

    @Test
    void testHexToByte_ConvertsHexStringToByte_WithUnderflow() {
        byte dstInit = 0x00;
        int srcPos = 0;
        int dstPos = 4;
        int nHex = 3;

        byte result = Conversion.hexToByte("FFFF", srcPos, dstInit, dstPos, nHex);

        assertEquals((byte) 0x0F, result);
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
    void testShortArrayToInt_PositiveCase() {
        short[] src = {1, 2, 3};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nShorts = 3;

        int result = conversion.shortArrayToInt(src, srcPos, dstInit, dstPos, nShorts);

        assertEquals(197121, result);
    }

    @Test
    void testShortArrayToInt_NegativeCase() {
        short[] src = {-1, -2, -3};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nShorts = 3;

        int result = conversion.shortArrayToInt(src, srcPos, dstInit, dstPos, nShorts);

        assertEquals(-197121, result);
    }

    @Test
    void testShortArrayToInt_SrcPosOutOfRange() {
        short[] src = {1, 2, 3};
        int srcPos = 4;
        int dstInit = 0;
        int dstPos = 0;
        int nShorts = 3;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            conversion.shortArrayToInt(src, srcPos, dstInit, dstPos, nShorts);
        });
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
    void testShortArrayToInt_AllShortsMinValue() {
        short[] src = {Short.MIN_VALUE, Short.MIN_VALUE};
        int srcPos = 0;
        int dstInit = 0;
        int dstPos = 0;
        int nShorts = 2;

        int result = conversion.shortArrayToInt(src, srcPos, dstInit, dstPos, nShorts);

        assertEquals(-2147450879, result);
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
    void testHexToLong_LargeNumber() {
        long result = Conversion.hexToLong("FF00", 0, 0L, 0, 4);
        assertEquals(65280L, result);
    }

    @Test
    void testHexToLong_PositiveDstPos() {
        long result = Conversion.hexToLong("F", 0, 0L, 4, 1);
        assertEquals(240L, result);
    }

    @Test
    void testHexToLong_MaximumDstPos() {
        long result = Conversion.hexToLong("F", 0, 0L, 60, 1);
        assertEquals(-576460752303423488L, result);
    }

    @Test
    void testHexToLong_InvalidDstPos() {
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexToLong("F", 0, 0L, 61, 1);
        });
    }

    @Test
    void testBinaryToByte_AllTrue() {
        boolean[] binary = {true, true, true, true};
        byte expected = (byte) 0b11111111;
        byte actual = conversion.binaryToByte(binary, 0, (byte) 0b00000000, 0, 4);
        assertEquals(expected, actual);
    }

    @Test
    void testBinaryToByte_AllFalse() {
        boolean[] binary = {false, false, false, false};
        byte expected = (byte) 0b00000000;
        byte actual = conversion.binaryToByte(binary, 0, (byte) 0b11111111, 0, 4);
        assertEquals(expected, actual);
    }

    @Test
    void testBinaryToByte_MixedValues() {
        boolean[] binary = {true, false, true, false};
        byte expected = (byte) 0b01010101;
        byte actual = conversion.binaryToByte(binary, 0, (byte) 0b10101010, 0, 4);
        assertEquals(expected, actual);
    }

    @Test
    void testBinaryToByte_InvalidBitPosition() {
        boolean[] binary = {true, true, true, true};
        assertThrows(IllegalArgumentException.class, () -> {
            conversion.binaryToByte(binary, 0, (byte) 0b00000000, 4, 4);
        });
    }

    @Test
    void testBinaryToByte_EmptyBinary() {
        boolean[] binary = {};
        byte expected = (byte) 0b00000000;
        byte actual = conversion.binaryToByte(binary, 0, (byte) 0b11111111, 0, 0);
        assertEquals(expected, actual);
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
    @DisplayName("Test shortToBinary with nBools = 0")
    void testShortToBinaryWithNBoolsZero() {
        boolean[] expected = {};
        boolean[] actual = new boolean[4];
        actual = conversion.shortToBinary((short) 15, 0, actual, 0, 0);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Test shortToBinary with nBools exceeding width of input")
    void testShortToBinaryWithNBoolsExceedingWidth() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            boolean[] actual = new boolean[4];
            actual = conversion.shortToBinary((short) 15, 0, actual, 0, 5);
        });
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
    @DisplayName("Test shortToBinary with valid input and srcPos > 0")
    void testShortToBinaryWithSrcPosGreaterThanZero() {
        boolean[] expected = {false, true, true, true};
        boolean[] actual = new boolean[4];
        actual = conversion.shortToBinary((short) 15, 1, actual, 0, 4);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Test shortToBinary with valid input and dstPos > 0")
    void testShortToBinaryWithDstPosGreaterThanZero() {
        boolean[] expected = {true, true, true, false};
        boolean[] actual = new boolean[4];
        actual = conversion.shortToBinary((short) 15, 0, actual, 1, 4);
        Assertions.assertArrayEquals(expected, actual);
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