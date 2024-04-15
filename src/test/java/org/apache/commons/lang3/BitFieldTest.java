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
    public void testIsAllSet_MaskZero_ReturnsTrue() {
        BitField bitField = new BitField(0);
        int holder = 0b1111;
        assertTrue(bitField.isAllSet(holder));
    }


    @Test
    public void testGetShortRawValue_MaskWithAllBitsSet() {
        BitField bitField = new BitField(0b1111111111111111);
        short holder = 0b0000000000000000;
        short expected = 0b0000;
        assertEquals(expected, bitField.getShortRawValue(holder));
    }


    @Test
    public void testGetRawValue_NoBitsSet() {
        int holder = 0b00000000;
        int expected = 0b0000;
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
    public void testClearByte_NoBitsSet() {
        byte holder = (byte) 0x00;
        byte expected = (byte) 0x00;
        byte result = bitField.clearByte(holder);
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


    @Test
    @DisplayName("Test clearShort method with no bits set")
    void testClearShortNoBitsSet() {
        short holder = 0b0000000000000000; // No bits set
        short expected = 0b0000000000000000; // Expected result after clearing bits (no change)
        short actual = bitField.clearShort(holder);
        assertEquals(expected, actual);
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

}