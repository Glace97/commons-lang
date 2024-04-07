import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.BigInteger;

class isParsableTest {
  
  @Test
  void testEmptyString() {
    assertFalse(NumberUtils.isParsable(""));
  }
  
  @Test
  void testNullString() {
    assertFalse(NumberUtils.isParsable(null));
  }
  
  @Test
  void testPositiveInteger() {
    assertTrue(NumberUtils.isParsable("123"));
  }
  
  @Test
  void testNegativeInteger() {
    assertTrue(NumberUtils.isParsable("-123"));
  }
  
  @Test
  void testZero() {
    assertTrue(NumberUtils.isParsable("0"));
  }
  
  @Test
  void testPositiveDecimal() {
    assertTrue(NumberUtils.isParsable("123.45"));
  }
  
  @Test
  void testNegativeDecimal() {
    assertTrue(NumberUtils.isParsable("-123.45"));
  }
  
  @Test
  void testPositiveScientificNotation() {
    assertFalse(NumberUtils.isParsable("1.2E+10"));
  }
  
  @Test
  void testNegativeScientificNotation() {
    assertFalse(NumberUtils.isParsable("-1.2E+10"));
  }
  
  @Test
  void testHexadecimal() {
    assertFalse(NumberUtils.isParsable("0x123"));
  }
  
  @Test
  void testStringWithDot() {
    assertFalse(NumberUtils.isParsable("123."));
  }
  
  @Test
  void testStringWithDash() {
    assertFalse(NumberUtils.isParsable("-"));
  }
  
  @Test
  void testStringWithDashAndDot() {
    assertFalse(NumberUtils.isParsable("-."));
  }
  
  @Test
  void testStringWithLeadingZeros() {
    assertTrue(NumberUtils.isParsable("00123"));
  }
  
  @Test
  void testStringWithLeadingZerosAndDecimal() {
    assertTrue(NumberUtils.isParsable("00123.45"));
  }
  
  @Test
  void testStringWithLeadingZerosAndScientificNotation() {
    assertFalse(NumberUtils.isParsable("00123E+10"));
  }
  
  @Test
  void testStringWithTrailingZeros() {
    assertTrue(NumberUtils.isParsable("12300"));
  }
  
  @Test
  void testStringWithTrailingZerosAndDecimal() {
    assertTrue(NumberUtils.isParsable("12300.00"));
  }
  
  @Test
  void testStringWithTrailingZerosAndScientificNotation() {
    assertFalse(NumberUtils.isParsable("12300E+10"));
  }
  
  @Test
  void testMaxInteger() {
    assertTrue(NumberUtils.isParsable(String.valueOf(Integer.MAX_VALUE)));
  }
  
  @Test
  void testMinInteger() {
    assertTrue(NumberUtils.isParsable(String.valueOf(Integer.MIN_VALUE)));
  }
  
  @Test
  void testMaxLong() {
    assertTrue(NumberUtils.isParsable(String.valueOf(Long.MAX_VALUE)));
  }
  
  @Test
  void testMinLong() {
    assertTrue(NumberUtils.isParsable(String.valueOf(Long.MIN_VALUE)));
  }
  
  @Test
  void testMaxBigInteger() {
    BigInteger maxBigInteger = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);
    assertTrue(NumberUtils.isParsable(maxBigInteger.toString()));
  }
  
  @Test
  void testMinBigInteger() {
    BigInteger minBigInteger = BigInteger.valueOf(Long.MIN_VALUE).subtract(BigInteger.ONE);
    assertTrue(NumberUtils.isParsable(minBigInteger.toString()));
  }
  
  @Test
  void testMaxBigDecimal() {
    BigDecimal maxBigDecimal = BigDecimal.valueOf(Double.MAX_VALUE).add(BigDecimal.ONE);
    assertTrue(NumberUtils.isParsable(maxBigDecimal.toString()));
  }
  
  @Test
  void testMinBigDecimal() {
    BigDecimal minBigDecimal = BigDecimal.valueOf(Double.MIN_VALUE).subtract(BigDecimal.ONE);
    assertTrue(NumberUtils.isParsable(minBigDecimal.toString()));
  }
}