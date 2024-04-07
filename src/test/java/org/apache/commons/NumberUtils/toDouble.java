
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NumberUtilsTest {

  @Nested
  @DisplayName("Tests for toDouble(BigDecimal value)")
  class ToDoubleBigDecimal {

    @Test
    @DisplayName("Should return 0.0d when BigDecimal value is null")
    void shouldReturnZeroWhenValueIsNull() {
      BigDecimal value = null;
      double expected = 0.0d;

      double actual = NumberUtils.toDouble(value);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should return the double value of the BigDecimal")
    void shouldReturnDoubleValueOfBigDecimal() {
      BigDecimal value = BigDecimal.valueOf(8.5d);
      double expected = 8.5d;

      double actual = NumberUtils.toDouble(value);

      assertEquals(expected, actual);
    }
  }

  @Nested
  @DisplayName("Tests for toDouble(BigDecimal value, double defaultValue)")
  class ToDoubleBigDecimalWithDefaultValue {

    @Test
    @DisplayName("Should return defaultValue when BigDecimal value is null")
    void shouldReturnDefaultValueWhenValueIsNull() {
      BigDecimal value = null;
      double defaultValue = 1.1d;
      double expected = defaultValue;

      double actual = NumberUtils.toDouble(value, defaultValue);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should return the double value of the BigDecimal")
    void shouldReturnDoubleValueOfBigDecimal() {
      BigDecimal value = BigDecimal.valueOf(8.5d);
      double defaultValue = 1.1d;
      double expected = 8.5d;

      double actual = NumberUtils.toDouble(value, defaultValue);

      assertEquals(expected, actual);
    }
  }

  @Nested
  @DisplayName("Tests for toDouble(String str)")
  class ToDoubleString {

    @Test
    @DisplayName("Should return 0.0d when str is null")
    void shouldReturnZeroWhenStringIsNull() {
      String str = null;
      double expected = 0.0d;

      double actual = NumberUtils.toDouble(str);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should return 0.0d when str is an empty string")
    void shouldReturnZeroWhenStringIsEmpty() {
      String str = "";
      double expected = 0.0d;

      double actual = NumberUtils.toDouble(str);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should return the double value of the string")
    void shouldReturnDoubleValueOfString() {
      String str = "1.5";
      double expected = 1.5d;

      double actual = NumberUtils.toDouble(str);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should throw NumberFormatException when str is not a valid double")
    void shouldThrowNumberFormatExceptionWhenStringIsInvalid() {
      String str = "abc";

      assertThrows(NumberFormatException.class, () -> NumberUtils.toDouble(str));
    }
  }

  @Nested
  @DisplayName("Tests for toDouble(String str, double defaultValue)")
  class ToDoubleStringWithDefaultValue {

    @Test
    @DisplayName("Should return defaultValue when str is null")
    void shouldReturnDefaultValueWhenStringIsNull() {
      String str = null;
      double defaultValue = 1.1d;
      double expected = defaultValue;

      double actual = NumberUtils.toDouble(str, defaultValue);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should return defaultValue when str is an empty string")
    void shouldReturnDefaultValueWhenStringIsEmpty() {
      String str = "";
      double defaultValue = 1.1d;
      double expected = defaultValue;

      double actual = NumberUtils.toDouble(str, defaultValue);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should return the double value of the string")
    void shouldReturnDoubleValueOfString() {
      String str = "1.5";
      double defaultValue = 0.0d;
      double expected = 1.5d;

      double actual = NumberUtils.toDouble(str, defaultValue);

      assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should return defaultValue when str is not a valid double")
    void shouldReturnDefaultValueWhenStringIsInvalid() {
      String str = "abc";
      double defaultValue = 1.1d;
      double expected = defaultValue;

      double actual = NumberUtils.toDouble(str, defaultValue);

      assertEquals(expected, actual);
    }
  }
}
