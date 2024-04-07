import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.BigInteger;

class createNumberTest {
    
    @Test
    void testCreateNumber_NullInput_ReturnNull() {
        assertNull(NumberUtils.createNumber(null));
    }
    
    @Test
    void testCreateNumber_BlankInput_ThrowNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            NumberUtils.createNumber("  ");
        });
    }
    
    @Test
    void testCreateNumber_HexadecimalInteger_ReturnInteger() {
        assertEquals(16, NumberUtils.createNumber("0x10"));
        assertEquals(16, NumberUtils.createNumber("0X10"));
        assertEquals(16, NumberUtils.createNumber("#10"));
    }
    
    @Test
    void testCreateNumber_HexadecimalLong_ReturnLong() {
        assertEquals(10000000000000000L, NumberUtils.createNumber("0x2386F26FC10000"));
        assertEquals(10000000000000000L, NumberUtils.createNumber("0X2386F26FC10000"));
        assertEquals(10000000000000000L, NumberUtils.createNumber("#2386F26FC10000"));
    }
    
    @Test
    void testCreateNumber_HexadecimalBigInteger_ReturnBigInteger() {
        assertEquals(new BigInteger("12345678901234567890"), NumberUtils.createNumber("0x2D79883DCE4A9F0A"));
        assertEquals(new BigInteger("12345678901234567890"), NumberUtils.createNumber("0X2D79883DCE4A9F0A"));
        assertEquals(new BigInteger("12345678901234567890"), NumberUtils.createNumber("#2D79883DCE4A9F0A"));
    }
    
    @Test
    void testCreateNumber_Decimal_ReturnBigDecimal() {
        assertEquals(new BigDecimal("3.14"), NumberUtils.createNumber("3.14"));
        assertEquals(new BigDecimal("1234567890.1234567890"), NumberUtils.createNumber("1234567890.1234567890"));
    }
    
    @Test
    void testCreateNumber_IntegerWithDecimal_ReturnInteger() {
        assertEquals(123, NumberUtils.createNumber("123.0"));
        assertEquals(456, NumberUtils.createNumber("456.00"));
    }
    
    @Test
    void testCreateNumber_IntegerWithExponent_ReturnInteger() {
        assertEquals(1000000, NumberUtils.createNumber("1e6"));
        assertEquals(1000000, NumberUtils.createNumber("1E6"));
        assertEquals(1000000, NumberUtils.createNumber("1E+6"));
        assertEquals(0.000001, NumberUtils.createNumber("1e-6"));
    }
    
    @Test
    void testCreateNumber_LongWithExponent_ReturnLong() {
        assertEquals(10000000000000000L, NumberUtils.createNumber("1e16"));
        assertEquals(10000000000000000L, NumberUtils.createNumber("1E16"));
        assertEquals(10000000000000000L, NumberUtils.createNumber("1E+16"));
        assertEquals(0.0000000000000001, NumberUtils.createNumber("1e-16"));
    }
    
    @Test
    void testCreateNumber_Float_ReturnFloat() {
        assertEquals(3.14f, NumberUtils.createNumber("3.14f"));
        assertEquals(3.14f, NumberUtils.createNumber("3.14F"));
    }
    
    @Test
    void testCreateNumber_Double_ReturnDouble() {
        assertEquals(3.14, NumberUtils.createNumber("3.14d"));
        assertEquals(3.14, NumberUtils.createNumber("3.14D"));
    }
    
    @Test
    void testCreateNumber_BigInteger_ReturnBigInteger() {
        assertEquals(new BigInteger("12345678901234567890"), NumberUtils.createNumber("12345678901234567890"));
    }
    
    @Test
    void testCreateNumber_InvalidNumber_ThrowNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            NumberUtils.createNumber("abc");
        });
    }
    
}