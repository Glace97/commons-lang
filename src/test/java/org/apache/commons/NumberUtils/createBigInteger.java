import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class createBigIntegerTest {

    @Test
    void testCreateBigInteger_NullString_ReturnsNull() {
        assertNull(NumberUtils.createBigInteger(null));
    }
    
    @Test
    void testCreateBigInteger_EmptyString_ThrowsNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            NumberUtils.createBigInteger("");
        });
    }
    
    @Test
    void testCreateBigInteger_PositiveDecimalString_ReturnsBigInteger() {
        String str = "123456789";
        BigInteger expected = new BigInteger(str);
        BigInteger result = NumberUtils.createBigInteger(str);
        assertEquals(expected, result);
    }
    
    @Test
    void testCreateBigInteger_NegativeDecimalString_ReturnsNegatedBigInteger() {
        String str = "-123456789";
        BigInteger expected = new BigInteger(str);
        BigInteger result = NumberUtils.createBigInteger(str);
        assertEquals(expected, result);
    }
    
    @Test
    void testCreateBigInteger_HexadecimalString_ReturnsBigInteger() {
        String str = "0xABCDEF";
        BigInteger expected = new BigInteger("ABCDEF", 16);
        BigInteger result = NumberUtils.createBigInteger(str);
        assertEquals(expected, result);
    }
    
    @Test
    void testCreateBigInteger_AlternativeHexadecimalString_ReturnsBigInteger() {
        String str = "#ABCDEF";
        BigInteger expected = new BigInteger("ABCDEF", 16);
        BigInteger result = NumberUtils.createBigInteger(str);
        assertEquals(expected, result);
    }
    
    @Test
    void testCreateBigInteger_OctalString_ReturnsBigInteger() {
        String str = "01234567";
        BigInteger expected = new BigInteger("1234567", 8);
        BigInteger result = NumberUtils.createBigInteger(str);
        assertEquals(expected, result);
    }
    
    @Test
    void testCreateBigInteger_DecimalStringWithLeadingZeroes_ReturnsBigInteger() {
        String str = "000012345";
        BigInteger expected = new BigInteger(str);
        BigInteger result = NumberUtils.createBigInteger(str);
        assertEquals(expected, result);
    }
    
    @Test
    void testCreateBigInteger_InvalidDecimalString_ThrowsNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            NumberUtils.createBigInteger("12a34");
        });
    }
    
    @Test
    void testCreateBigInteger_MaxIntegerValue_ReturnsBigInteger() {
        String str = String.valueOf(Integer.MAX_VALUE);
        BigInteger expected = new BigInteger(str);
        BigInteger result = NumberUtils.createBigInteger(str);
        assertEquals(expected, result);
    }
    
    @Test
    void testCreateBigInteger_MinIntegerValue_ReturnsBigInteger() {
        String str = String.valueOf(Integer.MIN_VALUE);
        BigInteger expected = new BigInteger(str);
        BigInteger result = NumberUtils.createBigInteger(str);
        assertEquals(expected, result);
    }
}