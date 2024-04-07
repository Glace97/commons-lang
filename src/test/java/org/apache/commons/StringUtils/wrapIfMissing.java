
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WrapIfMissingTest {
  
  @Nested
  @DisplayName("wrapIfMissing with char parameter")
  class WrapIfMissingCharTest {
  
    @Test
    @DisplayName("should return null if input string is null")
    void testNullString() {
      String result = StringUtils.wrapIfMissing(null, 'x');
      Assertions.assertNull(result);
    }
    
    @Test
    @DisplayName("should return the input string if it is already wrapped")
    void testAlreadyWrapped() {
      String input = "xyx";
      String result = StringUtils.wrapIfMissing(input, 'x');
      Assertions.assertSame(input, result);
    }
    
    @Test
    @DisplayName("should wrap the input string with the char if it is missing from both start and end")
    void testWrapBothStartAndEnd() {
      String input = "abc";
      String result = StringUtils.wrapIfMissing(input, 'x');
      Assertions.assertEquals("xabcx", result);
    }
    
    @Test
    @DisplayName("should wrap the input string with the char if it is missing from the start")
    void testWrapStart() {
      String input = "bcx";
      String result = StringUtils.wrapIfMissing(input, 'x');
      Assertions.assertEquals("xbcx", result);
    }
    
    @Test
    @DisplayName("should wrap the input string with the char if it is missing from the end")
    void testWrapEnd() {
      String input = "xy";
      String result = StringUtils.wrapIfMissing(input, 'x');
      Assertions.assertEquals("xyx", result);
    }
    
    @Test
    @DisplayName("should return the input string if it is empty")
    void testEmptyString() {
      String input = "";
      String result = StringUtils.wrapIfMissing(input, 'x');
      Assertions.assertSame(input, result);
    }
    
    @Test
    @DisplayName("should return the input string if the wrapWith char is null")
    void testNullWrapWith() {
      String input = "abc";
      String result = StringUtils.wrapIfMissing(input, '\0');
      Assertions.assertSame(input, result);
    }
    
  }
  
  @Nested
  @DisplayName("wrapIfMissing with String parameter")
  class WrapIfMissingStringTest {
  
    @Test
    @DisplayName("should return null if input string is null")
    void testNullString() {
      String result = StringUtils.wrapIfMissing(null, "x");
      Assertions.assertNull(result);
    }
    
    @Test
    @DisplayName("should return the input string if it is already wrapped")
    void testAlreadyWrapped() {
      String input = "xyz";
      String result = StringUtils.wrapIfMissing(input, "x");
      Assertions.assertSame(input, result);
    }
    
    @Test
    @DisplayName("should wrap the input string with the string if it is missing from both start and end")
    void testWrapBothStartAndEnd() {
      String input = "abc";
      String result = StringUtils.wrapIfMissing(input, "xyz");
      Assertions.assertEquals("xyzabcxyz", result);
    }
    
    @Test
    @DisplayName("should wrap the input string with the string if it is missing from the start")
    void testWrapStart() {
      String input = "bcxyz";
      String result = StringUtils.wrapIfMissing(input, "xyz");
      Assertions.assertEquals("xyzbcxyz", result);
    }
    
    @Test
    @DisplayName("should wrap the input string with the string if it is missing from the end")
    void testWrapEnd() {
      String input = "xyz";
      String result = StringUtils.wrapIfMissing(input, "xyz");
      Assertions.assertEquals("xyzxyz", result);
    }
    
    @Test
    @DisplayName("should return the input string if it is empty")
    void testEmptyString() {
      String input = "";
      String result = StringUtils.wrapIfMissing(input, "xyz");
      Assertions.assertSame(input, result);
    }
    
    @Test
    @DisplayName("should return the input string if the wrapWith string is null")
    void testNullWrapWith() {
      String input = "abc";
      String result = StringUtils.wrapIfMissing(input, null);
      Assertions.assertSame(input, result);
    }
    
  }
  
}
