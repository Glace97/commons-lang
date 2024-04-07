import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.BigInteger;

class createDoubleTest {
  
  @Test
  void testCreateDouble() {
    // Test case 1: Valid positive integer string
    String num1 = "123";
    Double expected1 = 123.0;
    assertEquals(expected1, NumberUtils.createDouble(num1));
    
    // Test case 2: Valid negative integer string
    String num2 = "-456";
    Double expected2 = -456.0;
    assertEquals(expected2, NumberUtils.createDouble(num2));
    
    // Test case 3: Valid positive decimal string
    String num3 = "3.14";
    Double expected3 = 3.14;
    assertEquals(expected3, NumberUtils.createDouble(num3));
    
    // Test case 4: Valid negative decimal string
    String num4 = "-2.5";
    Double expected4 = -2.5;
    assertEquals(expected4, NumberUtils.createDouble(num4));
    
    // Test case 5: Valid scientific notation string
    String num5 = "1.23E+2";
    Double expected5 = 123.0;
    assertEquals(expected5, NumberUtils.createDouble(num5));
    
    // Test case 6: Valid string with leading and trailing whitespace
    String num6 = "   7.89   ";
    Double expected6 = 7.89;
    assertEquals(expected6, NumberUtils.createDouble(num6));
    
    // Test case 7: Empty string
    String num7 = "";
    assertNull(NumberUtils.createDouble(num7));
    
    // Test case 8: Null string
    String num8 = null;
    assertNull(NumberUtils.createDouble(num8));
    
    // Test case 9: Invalid string with alphabetic characters
    String num9 = "abc";
    assertThrows(NumberFormatException.class, () -> {
      NumberUtils.createDouble(num9);
    });
    
    // Test case 10: Invalid string with special characters
    String num10 = "!@#$";
    assertThrows(NumberFormatException.class, () -> {
      NumberUtils.createDouble(num10);
    });
    
    // Test case 11: Invalid string with multiple decimal points
    String num11 = "1.2.3";
    assertThrows(NumberFormatException.class, () -> {
      NumberUtils.createDouble(num11);
    });
    
    // Test case 12: Invalid string with leading + sign
    String num12 = "+4.56";
    assertThrows(NumberFormatException.class, () -> {
      NumberUtils.createDouble(num12);
    });
    
    // Test case 13: Invalid string with leading - sign without digits
    String num13 = "-";
    assertThrows(NumberFormatException.class, () -> {
      NumberUtils.createDouble(num13);
    });
    
    // Test case 14: Valid string with leading - sign and no digits after it
    String num14 = "-0";
    Double expected14 = -0.0;
    assertEquals(expected14, NumberUtils.createDouble(num14));
  }
}