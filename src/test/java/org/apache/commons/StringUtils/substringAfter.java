import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(Lifecycle.PER_CLASS)
class SubstringAfterTest {
  
  @Test
  void testSubstringAfter_charSeparator() {
    String str = "abc";
    char separator = 'a';
    String expected = "bc";
    String actual = StringUtils.substringAfter(str, separator);
    assertEquals(expected, actual);
  }
  
  @Test
  void testSubstringAfter_charSeparator_noMatch() {
    String str = "abc";
    char separator = 'd';
    String expected = "";
    String actual = StringUtils.substringAfter(str, separator);
    assertEquals(expected, actual);
  }
  
  @Test
  void testSubstringAfter_charSeparator_nullString() {
    String str = null;
    char separator = 'a';
    String expected = null;
    String actual = StringUtils.substringAfter(str, separator);
    assertEquals(expected, actual);
  }
  
  @Test
  void testSubstringAfter_charSeparator_emptyString() {
    String str = "";
    char separator = 'a';
    String expected = "";
    String actual = StringUtils.substringAfter(str, separator);
    assertEquals(expected, actual);
  }
  
  @Test
  void testSubstringAfter_stringSeparator() {
    String str = "abc";
    String separator = "a";
    String expected = "bc";
    String actual = StringUtils.substringAfter(str, separator);
    assertEquals(expected, actual);
  }
  
  @Test
  void testSubstringAfter_stringSeparator_noMatch() {
    String str = "abc";
    String separator = "d";
    String expected = "";
    String actual = StringUtils.substringAfter(str, separator);
    assertEquals(expected, actual);
  }
  
  @Test
  void testSubstringAfter_stringSeparator_nullString() {
    String str = null;
    String separator = "a";
    String expected = null;
    String actual = StringUtils.substringAfter(str, separator);
    assertEquals(expected, actual);
  }
  
  @Test
  void testSubstringAfter_stringSeparator_nullSeparator() {
    String str = "abc";
    String separator = null;
    String expected = "";
    String actual = StringUtils.substringAfter(str, separator);
    assertEquals(expected, actual);
  }
  
  @Test
  void testSubstringAfter_stringSeparator_emptyString() {
    String str = "";
    String separator = "a";
    String expected = "";
    String actual = StringUtils.substringAfter(str, separator);
    assertEquals(expected, actual);
  }
  
  @Test
  void testSubstringAfter_stringSeparator_emptySeparator() {
    String str = "abc";
    String separator = "";
    String expected = "abc";
    String actual = StringUtils.substringAfter(str, separator);
    assertEquals(expected, actual);
  }
  
  @ParameterizedTest
  @ValueSource(chars = {' ', '\n', '\r', '\t'})
  void testSubstringAfter_specialCharSeparator(char separator) {
    String str = " abc";
    String expected = "abc";
    String actual = StringUtils.substringAfter(str, separator);
    assertEquals(expected, actual);
  }
  
}