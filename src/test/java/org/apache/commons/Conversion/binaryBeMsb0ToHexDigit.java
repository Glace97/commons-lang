package org.apache.commons.Conversion;

import org.apache.commons.lang3.Conversion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class binaryBeMsb0ToHexDigitTest {

    @Test
    void testBinaryBeMsb0ToHexDigitEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> Conversion.binaryBeMsb0ToHexDigit(new boolean[0]));
    }

    @Test
    void testBinaryBeMsb0ToHexDigitNullArray() {
        assertThrows(NullPointerException.class, () -> Conversion.binaryBeMsb0ToHexDigit(null));
    }

    @Test
    void testBinaryBeMsb0ToHexDigitOutOfRange() {
        boolean[] src = {true, true, true, true};
        assertThrows(IndexOutOfBoundsException.class, () -> Conversion.binaryBeMsb0ToHexDigit(src, 5));
    }

    @Test
    void testBinaryBeMsb0ToHexDigitAllTrue() {
        boolean[] src = {true, true, true, true};
        assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(src));
    }

    @Test
    void testBinaryBeMsb0ToHexDigitAllFalse() {
        boolean[] src = {false, false, false, false};
        assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(src));
    }

    @Test
    void testBinaryBeMsb0ToHexDigitMixedValues() {
        boolean[] src = {true, false, true, false};
        assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(src));
    }
}
