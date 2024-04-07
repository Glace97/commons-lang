import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import java.util.Arrays;

class valueOfTest {

  @Nested
  @DisplayName("Testing valueOf method")
  class ValueOfMethodTests {

    @Test
    @DisplayName("Test valueOf with null input")
    void testValueOfWithNullInput() {
      char[] input = null;
      String expected = null;
      String actual = StringUtils.valueOf(input);
      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test valueOf with empty input")
    void testValueOfWithEmptyInput() {
      char[] input = new char[0];
      String expected = "";
      String actual = StringUtils.valueOf(input);
      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test valueOf with non-empty input")
    void testValueOfWithNonEmptyInput() {
      char[] input = {'a', 'b', 'c'};
      String expected = "abc";
      String actual = StringUtils.valueOf(input);
      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test valueOf with large input")
    void testValueOfWithLargeInput() {
      char[] input = new char[8192];
      Arrays.fill(input, 'a');
      String expected = new String(input);
      String actual = StringUtils.valueOf(input);
      assertEquals(expected, actual);
    }
  }
}