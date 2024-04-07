import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class stripStartTest {
  
  StringUtils stringUtils = new StringUtils();
  
  @Test
  void testStripStartWithNullString() {
    String str = null;
    String stripChars = "abc";
    String expectedResult = null;
    
    String result = StringUtils.stripStart(str, stripChars);
    
    assertEquals(expectedResult, result);
  }
  
  @Test
  void testStripStartWithEmptyString() {
    String str = "";
    String stripChars = "abc";
    String expectedResult = "";
    
    String result = StringUtils.stripStart(str, stripChars);
    
    assertEquals(expectedResult, result);
  }
  
  @Test
  void testStripStartWithNullStripChars() {
    String str = "  abc";
    String stripChars = null;
    String expectedResult = "abc";
    
    String result = StringUtils.stripStart(str, stripChars);
    
    assertEquals(expectedResult, result);
  }
  
  @Test
  void testStripStartWithEmptyStripChars() {
    String str = "abc";
    String stripChars = "";
    String expectedResult = "abc";
    
    String result = StringUtils.stripStart(str, stripChars);
    
    assertEquals(expectedResult, result);
  }
  
  @Test
  void testStripStartWithWhitespaceStripChars() {
    String str = "  abc";
    String stripChars = " ";
    String expectedResult = "abc";
    
    String result = StringUtils.stripStart(str, stripChars);
    
    assertEquals(expectedResult, result);
  }
  
  @Test
  void testStripStartWithNonWhitespaceStripChars() {
    String str = "yxabc  ";
    String stripChars = "xyz";
    String expectedResult = "abc  ";
    
    String result = StringUtils.stripStart(str, stripChars);
    
    assertEquals(expectedResult, result);
  }
  
  @Test
  void testStripStartWithStripCharsNotFound() {
    String str = "abc";
    String stripChars = "xyz";
    String expectedResult = "abc";
    
    String result = StringUtils.stripStart(str, stripChars);
    
    assertEquals(expectedResult, result);
  }
  
  @Test
  void testStripStartWithStripCharsFoundAtStart() {
    String str = "abcxyz";
    String stripChars = "abc";
    String expectedResult = "xyz";
    
    String result = StringUtils.stripStart(str, stripChars);
    
    assertEquals(expectedResult, result);
  }
  
  @Test
  void testStripStartWithStripCharsFoundInMiddle() {
    String str = "axyzbc";
    String stripChars = "abc";
    String expectedResult = "xyzbc";
    
    String result = StringUtils.stripStart(str, stripChars);
    
    assertEquals(expectedResult, result);
  }
  
  @Test
  void testStripStartWithStripCharsFoundAtEnd() {
    String str = "xyzabc";
    String stripChars = "abc";
    String expectedResult = "xyzabc";
    
    String result = StringUtils.stripStart(str, stripChars);
    
    assertEquals(expectedResult, result);
  }
  
  @Test
  void testStripStartWithStripCharsFoundMultipleTimes() {
    String str = "abcabcxyz";
    String stripChars = "abc";
    String expectedResult = "xyz";
    
    String result = StringUtils.stripStart(str, stripChars);
    
    assertEquals(expectedResult, result);
  }
}