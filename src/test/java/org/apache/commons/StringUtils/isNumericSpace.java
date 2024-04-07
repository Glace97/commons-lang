import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class isNumericSpaceTest {
  
  @Test
  void testIsNumericSpace_NullString_ReturnsFalse() {
    assertFalse(StringUtils.isNumericSpace(null));
  }
  
  @Test
  void testIsNumericSpace_EmptyString_ReturnsTrue() {
    assertTrue(StringUtils.isNumericSpace(""));
  }
  
  @Test
  void testIsNumericSpace_OnlySpace_ReturnsTrue() {
    assertTrue(StringUtils.isNumericSpace(" "));
  }
  
  @Test
  void testIsNumericSpace_OnlyDigits_ReturnsTrue() {
    assertTrue(StringUtils.isNumericSpace("123"));
  }
  
  @Test
  void testIsNumericSpace_DigitsAndSpace_ReturnsTrue() {
    assertTrue(StringUtils.isNumericSpace("12 3"));
  }
  
  @Test
  void testIsNumericSpace_UnicodeDigits_ReturnsTrue() {
    assertTrue(StringUtils.isNumericSpace("\u0967\u0968\u0969"));
  }
  
  @Test
  void testIsNumericSpace_UnicodeDigitsAndSpace_ReturnsTrue() {
    assertTrue(StringUtils.isNumericSpace("\u0967\u0968 \u0969"));
  }
  
  @Test
  void testIsNumericSpace_ContainsNonDigitAndNonSpace_ReturnsFalse() {
    assertFalse(StringUtils.isNumericSpace("ab2c"));
  }
  
  @Test
  void testIsNumericSpace_ContainsHyphen_ReturnsFalse() {
    assertFalse(StringUtils.isNumericSpace("12-3"));
  }
  
  @Test
  void testIsNumericSpace_ContainsDecimalPoint_ReturnsFalse() {
    assertFalse(StringUtils.isNumericSpace("12.3"));
  }
  
}