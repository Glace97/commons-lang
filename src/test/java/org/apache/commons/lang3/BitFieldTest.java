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

public class BitFieldTest {
//    @Test
//    void testGetShortValue() {
//        // Test with positive value
//        short holder = 0b011100101;
//        assertEquals(37, bitField.getShortValue(holder));
//
//        // Test with negative value
//        holder = (short) 0b1111111111111111;
//        assertEquals(-1, bitField.getShortValue(holder));
//
//        // Test with zero value
//        holder = 0;
//        assertEquals(0, bitField.getShortValue(holder));
//
//        // Test with minimum value
//        holder = Short.MIN_VALUE;
//        assertEquals(-32768, bitField.getShortValue(holder));
//
//        // Test with maximum value
//        holder = Short.MAX_VALUE;
//        assertEquals(32767, bitField.getShortValue(holder));
//    }
//    @Test
//    public void testSetBoolean_SetFlag_ReturnsSetBits() {
//        int holder = 0b0000;
//        boolean flag = true;
//
//        int result = bitField.setBoolean(holder, flag);
//
//        assertEquals(0b1111, result);
//    }
//
//    @Test
//    public void testSetBoolean_ClearFlag_ReturnsClearedBits() {
//        int holder = 0b1111;
//        boolean flag = false;
//
//        int result = bitField.setBoolean(holder, flag);
//
//        assertEquals(0b0000, result);
//    }
    BitField bitField = new BitField(1);
    @Test
    public void testSetBoolean_MaskZero_ReturnsOriginalHolder() {
        BitField bitField = new BitField(0b0000);
        int holder = 0b1111;
        boolean flag = true;
    
        int result = bitField.setBoolean(holder, flag);
    
        assertEquals(0b1111, result);
    }
    
    @Test
    public void testSetBoolean_MaskAllOnes_ReturnsSetBits() {
        BitField bitField = new BitField(0b1111_1111);
        int holder = 0b0000_0000;
        boolean flag = true;
    
        int result = bitField.setBoolean(holder, flag);
    
        assertEquals(0b1111_1111, result);
    }
    
    @Test
    public void testSetBoolean_MaskAllZeros_ReturnsClearedBits() {
        BitField bitField = new BitField(0b0000_0000);
        int holder = 0b1111_1111;
        boolean flag = false;
    
        int result = bitField.setBoolean(holder, flag);
    
        assertEquals(0b0000_0000, result);
    }
//    @Test
//    public void testSetShortBoolean_SetFlag_ReturnsSetBits() {
//        short holder = 0; // No bits set initially
//        short result = bitField.setShortBoolean(holder, true);
//
//        assertEquals(0xFFFF, result); // All bits should be set
//    }
//
//    @Test
//    public void testSetShortBoolean_ClearFlag_ReturnsClearedBits() {
//        short holder = 0xFFFF; // All bits set initially
//        short result = bitField.setShortBoolean(holder, false);
//
//        assertEquals(0, result); // All bits should be cleared
//    }
//
//    @Test
//    public void testSetShortBoolean_InvalidMask_ReturnsSameValue() {
//        BitField invalidBitField = new BitField(0); // Invalid mask with no applicable bits
//        short holder = 0xAAAA; // Some bits set
//        short result = invalidBitField.setShortBoolean(holder, true);
//
//        assertEquals(holder, result); // Value should remain the same
//    }
//    @Test
//    public void testIsAllSet_AllBitsSet_ReturnsTrue() {
//        int holder = 0b1111;
//        assertTrue(bitField.isAllSet(holder));
//    }
//
//    @Test
//    public void testIsAllSet_NoBitsSet_ReturnsFalse() {
//        int holder = 0b0000;
//        assertFalse(bitField.isAllSet(holder));
//    }
//
//    @Test
//    public void testIsAllSet_SomeBitsSet_ReturnsFalse() {
//        int holder = 0b1100;
//        assertFalse(bitField.isAllSet(holder));
//    }
    
    @Test
    public void testIsAllSet_MaskZero_ReturnsTrue() {
        BitField bitField = new BitField(0);
        int holder = 0b1111;
        assertTrue(bitField.isAllSet(holder));
    }
    
    @Test
    public void testIsAllSet_MaskZero_ReturnsFalse() {
        BitField bitField = new BitField(0);
        int holder = 0b0000;
        assertFalse(bitField.isAllSet(holder));
    }
//    @Test
//    public void testSetByte() {
//        // Test with all bits set to 1
//        bitField = new BitField(MASK);
//        byte result = bitField.setByte((byte) 0x00);
//        Assertions.assertEquals((byte) 0xFF, result);
//
//        // Test with all bits set to 0
//        bitField = new BitField(0x00);
//        result = bitField.setByte((byte) 0xFF);
//        Assertions.assertEquals((byte) 0x00, result);
//
//        // Test with only the first bit set to 1
//        bitField = new BitField(0x01);
//        result = bitField.setByte((byte) 0x00);
//        Assertions.assertEquals((byte) 0x01, result);
//
//        // Test with only the first bit set to 0
//        bitField = new BitField(0xFE);
//        result = bitField.setByte((byte) 0xFF);
//        Assertions.assertEquals((byte) 0xFE, result);
//
//        // Test with shiftCount equal to 0
//        bitField = new BitField(0xFF);
//        result = bitField.setByte((byte) 0x00);
//        Assertions.assertEquals((byte) 0xFF, result);
//
//        // Test with mask equal to 0
//        bitField = new BitField(0x00);
//        result = bitField.setByte((byte) 0xFF);
//        Assertions.assertEquals((byte) 0x00, result);
//    }
//    @Test
//    public void testGetShortRawValue_AllBitsSet() {
//        short holder = 0b1111111111111111;
//        short expected = 0b1111;
//        assertEquals(expected, bitField.getShortRawValue(holder));
//    }
//
//    @Test
//    public void testGetShortRawValue_NoBitsSet() {
//        short holder = 0b0000000000000000;
//        short expected = 0b0000;
//        assertEquals(expected, bitField.getShortRawValue(holder));
//    }
//
//    @Test
//    public void testGetShortRawValue_SomeBitsSet() {
//        short holder = 0b1010101010101010;
//        short expected = 0b1010;
//        assertEquals(expected, bitField.getShortRawValue(holder));
//    }
//
//    @Test
//    public void testGetShortRawValue_MaskWithNoBitsSet() {
//        BitField bitField = new BitField(0b0000);
//        short holder = 0b1111111111111111;
//        short expected = 0b0000;
//        assertEquals(expected, bitField.getShortRawValue(holder));
//    }
    
    @Test
    public void testGetShortRawValue_MaskWithAllBitsSet() {
        BitField bitField = new BitField(0b1111111111111111);
        short holder = 0b0000000000000000;
        short expected = 0b0000;
        assertEquals(expected, bitField.getShortRawValue(holder));
    }
    
//    @Test
//    public void testGetShortRawValue_MaskWithSomeBitsSet() {
//        BitField bitField = new BitField(0b1010101010101010);
//        short holder = 0b1111111111111111;
//        short expected = 0b1010;
//        assertEquals(expected, bitField.getShortRawValue(holder));
//    }
    @Test
    @DisplayName("should clear all bits when mask is 0")
    void shouldClearAllBitsWhenMaskIsZero() {
        BitField bitField = new BitField(0);
        int holder = 0b101010;
        int expected = 0;

        int result = bitField.clear(holder);

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("should clear specified bits when mask is not 0")
    void shouldClearSpecifiedBitsWhenMaskIsNotZero() {
        int holder = 0b101010;
        int expected = 0b101000;

        int result = bitField.clear(holder);

        Assertions.assertEquals(expected, result);
    }
    @Test
        public void testSetShort() {
            // Test when mask is 0
            BitField bitField1 = new BitField(0);
            short holder1 = 5;
            Assertions.assertEquals(holder1, bitField1.setShort(holder1));

            // Test when mask is positive
            BitField bitField2 = new BitField(3);
            short holder2 = 10;
            Assertions.assertEquals((short) 11, bitField2.setShort(holder2));

            // Test when mask is negative
            BitField bitField3 = new BitField(-3);
            short holder3 = -10;
            Assertions.assertEquals((short) -9, bitField3.setShort(holder3));

            // Test when mask is maximum value
            BitField bitField4 = new BitField(Integer.MAX_VALUE);
            short holder4 = 100;
            Assertions.assertEquals(holder4, bitField4.setShort(holder4));

            // Test when mask is minimum value
            BitField bitField5 = new BitField(Integer.MIN_VALUE);
            short holder5 = -50;
            Assertions.assertEquals((short) -50, bitField5.setShort(holder5));
        }
    @Test
    public void testGetRawValue_AllBitsSet() {
        int holder = 0b11111111;
        int expected = 0b1111;
        assertEquals(expected, bitField.getRawValue(holder));
    }

    @Test
    public void testGetRawValue_NoBitsSet() {
        int holder = 0b00000000;
        int expected = 0b0000;
        assertEquals(expected, bitField.getRawValue(holder));
    }

    @Test
    public void testGetRawValue_SomeBitsSet() {
        int holder = 0b10101010;
        int expected = 0b1010;
        assertEquals(expected, bitField.getRawValue(holder));
    }

    @Test
    public void testGetRawValue_MaskZero() {
        BitField bitField = new BitField(0b0000);
        int holder = 0b10101010;
        int expected = 0b0000;
        assertEquals(expected, bitField.getRawValue(holder));
    }
    @Test
    public void testClearByte_AllBitsSet() {
        byte holder = (byte) 0xFF;
        byte expected = (byte) 0x00;
        byte result = bitField.clearByte(holder);
        assertEquals(expected, result);
    }

    @Test
    public void testClearByte_NoBitsSet() {
        byte holder = (byte) 0x00;
        byte expected = (byte) 0x00;
        byte result = bitField.clearByte(holder);
        assertEquals(expected, result);
    }

    // Add more tests to cover all edge cases and achieve high coverage
    @Test
    @DisplayName("Test setting value with all bits set")
    void testSetValueAllBitsSet() {
        int holder = 0xFFFFFFFF; // All bits set
        int value = 0x0000FFFF; // Example value
        int expected = 0xFFFF0000; // Expected result
        int result = bitField.setValue(holder, value);
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Test setting value with no bits set")
    void testSetValueNoBitsSet() {
        int holder = 0x00000000; // No bits set
        int value = 0xFFFFFFFF; // Example value
        int expected = 0xFFFFFFFF; // Expected result
        int result = bitField.setValue(holder, value);
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Test setting value with some bits set")
    void testSetValueSomeBitsSet() {
        int holder = 0xAAAAAAAA; // Example holder value
        int value = 0x55555555; // Example value
        int expected = 0xAAAA5555; // Expected result
        int result = bitField.setValue(holder, value);
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Test setting value with mask of zero")
    void testSetValueMaskZero() {
        BitField bitField = new BitField(0x00); // Mask of zero
        int holder = 0xFFFFFFFF; // Example holder value
        int value = 0x00000000; // Example value
        int expected = 0xFFFFFFFF; // Expected result
        int result = bitField.setValue(holder, value);
        assertEquals(expected, result);
    }
//    @Test
//    public void testGetValueWithZeroMask() {
//        BitField zeroMaskBitField = new BitField(MIN_MASK);
//        int holder = 10;
//        int expectedValue = 0;
//
//        int actualValue = zeroMaskBitField.getValue(holder);
//
//        Assertions.assertEquals(expectedValue, actualValue);
//    }
//
//    @Test
//    public void testGetValueWithMaxMask() {
//        BitField maxMaskBitField = new BitField(MAX_MASK);
//        int holder = Integer.MAX_VALUE;
//        int expectedValue = Integer.MAX_VALUE;
//
//        int actualValue = maxMaskBitField.getValue(holder);
//
//        Assertions.assertEquals(expectedValue, actualValue);
//    }
//
//    @Test
//    public void testGetValueWithRandomMask() {
//        int holder = 12345;
//        int expectedValue = holder >> Integer.numberOfTrailingZeros(RANDOM_MASK);
//
//        int actualValue = bitField.getValue(holder);
//
//        Assertions.assertEquals(expectedValue, actualValue);
//    }
//    @Test
//    public void testSetShortValue() {
//        short holder = 0b1111111111111111;
//        short value = 0b0000000000000000;
//        short result = bitField.setShortValue(holder, value);
//        Assertions.assertEquals(value, result);
//    }
//
//    @Test
//    public void testSetShortValueWithMask0() {
//        BitField bitFieldWithMask0 = new BitField(0);
//        short holder = 0b1111111111111111;
//        short value = 0b0000000000000000;
//        short result = bitFieldWithMask0.setShortValue(holder, value);
//        Assertions.assertEquals(holder, result);
//    }
//
//    @Test
//    public void testSetShortValueWithMask1() {
//        BitField bitFieldWithMask1 = new BitField(0b0000000000000001);
//        short holder = 0b1111111111111111;
//        short value = 0b0000000000000000;
//        short result = bitFieldWithMask1.setShortValue(holder, value);
//        Assertions.assertEquals(0b1111111111111110, result);
//    }
//
//    @Test
//    public void testSetShortValueWithShiftCount0() {
//        BitField bitFieldWithShiftCount0 = new BitField(0xFFFF);
//        short holder = 0b1111111111111111;
//        short value = 0b0000000000000000;
//        short result = bitFieldWithShiftCount0.setShortValue(holder, value);
//        Assertions.assertEquals(value, result);
//    }
//
//    @Test
//    public void testSetShortValueWithShiftCount1() {
//        BitField bitFieldWithShiftCount1 = new BitField(0xFFFF << 1);
//        short holder = 0b1111111111111111;
//        short value = 0b0000000000000001;
//        short result = bitFieldWithShiftCount1.setShortValue(holder, value);
//        Assertions.assertEquals(0b1111111111111110, result);
//    }
//
//    @Test
//    public void testSetShortValueWithShiftCount15() {
//        BitField bitFieldWithShiftCount15 = new BitField(0xFFFF << 15);
//        short holder = 0b1111111111111111;
//        short value = 0b0000000000000001;
//        short result = bitFieldWithShiftCount15.setShortValue(holder, value);
//        Assertions.assertEquals(0b0000000000000001, result);
//    }
    @Test
    public void testSet() {
        // Test setting all bits to 1
        assertEquals(0b10101011, bitField.set(0b10101010));
    
        // Test setting all bits to 0
        assertEquals(0b00000000, bitField.set(0b00000000));
    
        // Test setting some bits to 1 and some to 0
        assertEquals(0b10101000, bitField.set(0b10100000));
    
        // Test setting only the least significant bit to 1
        assertEquals(0b10101011, bitField.set(0b10101010));
    
        // Test setting only the most significant bit to 1
        assertEquals(0b10101011, bitField.set(0b00000001));
    
        // Test setting the same bits multiple times
        int holder = 0b10101010;
        assertEquals(0b10101011, bitField.set(holder));
        assertEquals(0b10101011, bitField.set(holder));
    }
//    @Test
//    @DisplayName("Test clearShort method with all bits set")
//    void testClearShortAllBitsSet() {
//        short holder = 0b1111111111111111; // All bits set
//        short expected = 0b0000000000000000; // Expected result after clearing bits
//        short actual = bitField.clearShort(holder);
//        assertEquals(expected, actual);
//    }
    
    @Test
    @DisplayName("Test clearShort method with no bits set")
    void testClearShortNoBitsSet() {
        short holder = 0b0000000000000000; // No bits set
        short expected = 0b0000000000000000; // Expected result after clearing bits (no change)
        short actual = bitField.clearShort(holder);
        assertEquals(expected, actual);
    }
    
//    @Test
//    @DisplayName("Test clearShort method with some bits set")
//    void testClearShortSomeBitsSet() {
//        short holder = 0b1010101010101010; // Some bits set
//        short expected = 0b0000000000000000; // Expected result after clearing bits
//        short actual = bitField.clearShort(holder);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    @DisplayName("Test clearShort method with mask of 0")
//    void testClearShortMaskZero() {
//        BitField zeroMaskBitField = new BitField(0);
//        short holder = 0b1010101010101010; // Some bits set
//        short expected = holder; // Expected result (no change)
//        short actual = zeroMaskBitField.clearShort(holder);
//        assertEquals(expected, actual);
//    }
    @Test
    public void testSetByteBoolean_SetFlag_ReturnsByteWithSetBits() {
      byte holder = 0b0000; // example initial byte
      byte expected = 0b1111; // expected byte after setting bits
    
      byte result = bitField.setByteBoolean(holder, true);
    
      Assertions.assertEquals(expected, result);
    }
    
    @Test
    public void testSetByteBoolean_ClearFlag_ReturnsByteWithClearedBits() {
      byte holder = 0b1111; // example initial byte
      byte expected = 0b0000; // expected byte after clearing bits
    
      byte result = bitField.setByteBoolean(holder, false);
    
      Assertions.assertEquals(expected, result);
    }
    
    @Test
    public void testSetByteBoolean_InvalidMask_ReturnsOriginalByte() {
      byte holder = 0b0101; // example initial byte
      byte expected = holder; // expected byte should be the same as the original
    
      bitField = new BitField(0b0000); // invalid mask
    
      byte result = bitField.setByteBoolean(holder, true);
    
      Assertions.assertEquals(expected, result);
    }
    
    @Test
    public void testSetByteBoolean_InvalidHolder_ReturnsOriginalByte() {
      byte holder = (byte) 0b10000000_00000000_00000000_00000000; // example initial byte
      byte expected = holder; // expected byte should be the same as the original
    
      byte result = bitField.setByteBoolean(holder, true);
    
      Assertions.assertEquals(expected, result);
    }
    
    @Test
    public void testSetByteBoolean_AllBitsSet_ReturnsByteWithSetBits() {
      byte holder = (byte) 0xFF; // example initial byte
      byte expected = (byte) 0xFF; // expected byte with all bits set
    
      byte result = bitField.setByteBoolean(holder, true);
    
      Assertions.assertEquals(expected, result);
    }
    
    @Test
    public void testSetByteBoolean_AllBitsCleared_ReturnsByteWithClearedBits() {
      byte holder = (byte) 0x00; // example initial byte
      byte expected = (byte) 0x00; // expected byte with all bits cleared
    
      byte result = bitField.setByteBoolean(holder, false);
    
      Assertions.assertEquals(expected, result);
    }
    
    @Test
    public void testSetByteBoolean_RandomBitsSet_ReturnsByteWithSetBits() {
      byte holder = (byte) 0b10101010; // example initial byte
      byte expected = (byte) 0b11111111; // expected byte with all bits set
    
      byte result = bitField.setByteBoolean(holder, true);
    
      Assertions.assertEquals(expected, result);
    }
    
    @Test
    public void testSetByteBoolean_RandomBitsCleared_ReturnsByteWithClearedBits() {
      byte holder = (byte) 0b01010101; // example initial byte
      byte expected = (byte) 0b00000000; // expected byte with all bits cleared
    
      byte result = bitField.setByteBoolean(holder, false);
    
      Assertions.assertEquals(expected, result);
    }
    @Test
    public void testIsSetReturnsTrueWhenBitIsSet() {
        int holder = 0b1010; // Example holder
        Assertions.assertTrue(bitField.isSet(holder));
    }
    
    @Test
    public void testIsSetReturnsFalseWhenBitIsNotSet() {
        int holder = 0b0101; // Example holder
        Assertions.assertFalse(bitField.isSet(holder));
    }
    
    @Test
    public void testIsSetReturnsFalseWhenHolderIsZero() {
        int holder = 0;
        Assertions.assertFalse(bitField.isSet(holder));
    }
    
    @Test
    public void testIsSetReturnsTrueWhenBitIsSetInMultiBitField() {
        bitField = new BitField(0b1111); // Example mask for multi-bit field
        int holder = 0b1010; // Example holder
        Assertions.assertTrue(bitField.isSet(holder));
    }
    
    @Test
    public void testIsSetReturnsFalseWhenBitIsNotSetInMultiBitField() {
        bitField = new BitField(0b1111); // Example mask for multi-bit field
        int holder = 0b0101; // Example holder
        Assertions.assertFalse(bitField.isSet(holder));
    }
    
    @Test
    public void testIsSetReturnsFalseWhenAllBitsAreNotSet() {
        bitField = new BitField(0b1111); // Example mask for multi-bit field
        int holder = 0b0000; // Example holder
        Assertions.assertFalse(bitField.isSet(holder));
    }
    
    @Test
    public void testIsSetReturnsTrueWhenAllBitsAreSet() {
        bitField = new BitField(0b1111); // Example mask for multi-bit field
        int holder = 0b1111; // Example holder
        Assertions.assertTrue(bitField.isSet(holder));
    }
    
    @Test
    public void testIsSetReturnsFalseWhenHolderIsNegative() {
        int holder = -1; // Example holder
        Assertions.assertFalse(bitField.isSet(holder));
    }
    
    @Test
    public void testIsSetReturnsTrueWhenBitIsSetInNegativeHolder() {
        int holder = -10; // Example holder
        Assertions.assertTrue(bitField.isSet(holder));
    }

}