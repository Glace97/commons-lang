import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class createBigDecimalTest {
  
  private NumberUtils numberUtils;
  
  @BeforeEach
  void setUp() {
    numberUtils = new NumberUtils();
  }
  
  @Nested
  @DisplayName("createBigDecimal")
  class createBigDecimalTests {
    
    @Test
    @DisplayName("Should return null for null input")
    void shouldReturnNullForNullInput() {
      assertNull(numberUtils.createBigDecimal(null));
    }
    
    @Test
    @DisplayName("Should throw NumberFormatException for blank string")
    void shouldThrowNumberFormatExceptionForBlankString() {
      assertThrows(NumberFormatException.class, () -> numberUtils.createBigDecimal(""));
      assertThrows(NumberFormatException.class, () -> numberUtils.createBigDecimal(" "));
      assertThrows(NumberFormatException.class, () -> numberUtils.createBigDecimal("\t"));
    }
    
    @Test
    @DisplayName("Should create BigDecimal from valid string")
    void shouldCreateBigDecimalFromValidString() {
      assertEquals(new BigDecimal("0"), numberUtils.createBigDecimal("0"));
      assertEquals(new BigDecimal("1"), numberUtils.createBigDecimal("1"));
      assertEquals(new BigDecimal("-1"), numberUtils.createBigDecimal("-1"));
      assertEquals(new BigDecimal("3.14"), numberUtils.createBigDecimal("3.14"));
      assertEquals(new BigDecimal("123456789"), numberUtils.createBigDecimal("123456789"));
    }
    
  }
  
}