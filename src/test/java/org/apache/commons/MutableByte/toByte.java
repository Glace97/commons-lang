import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class toByteTest {

    MutableByte mutableByte;

    @BeforeEach
    void setUp() {
        mutableByte = new MutableByte();
    }

    @Nested
    @DisplayName("Testing toByte()")
    class ToByteTests {

        @Test
        @DisplayName("Converts the default value to Byte")
        void testDefaultValue() {
            Byte result = mutableByte.toByte();
            assertEquals((byte) 0, result.byteValue());
        }

        @Test
        @DisplayName("Converts a positive value to Byte")
        void testPositiveValue() {
            mutableByte = new MutableByte((byte) 5);
            Byte result = mutableByte.toByte();
            assertEquals((byte) 5, result.byteValue());
        }

        @Test
        @DisplayName("Converts a negative value to Byte")
        void testNegativeValue() {
            mutableByte = new MutableByte((byte) -5);
            Byte result = mutableByte.toByte();
            assertEquals((byte) -5, result.byteValue());
        }
    }

    @Nested
    @DisplayName("Testing toByte() - Edge Cases")
    class ToByteEdgeCases {

        @Test
        @DisplayName("Converts the maximum byte value to Byte")
        void testMaxValue() {
            mutableByte = new MutableByte(Byte.MAX_VALUE);
            Byte result = mutableByte.toByte();
            assertEquals(Byte.MAX_VALUE, result.byteValue());
        }

        @Test
        @DisplayName("Converts the minimum byte value to Byte")
        void testMinValue() {
            mutableByte = new MutableByte(Byte.MIN_VALUE);
            Byte result = mutableByte.toByte();
            assertEquals(Byte.MIN_VALUE, result.byteValue());
        }

        @Test
        @DisplayName("Throws NumberFormatException when the value is not a valid byte")
        void testInvalidValue() {
            assertThrows(NumberFormatException.class, () -> new MutableByte("abc").toByte());
        }
    }
}