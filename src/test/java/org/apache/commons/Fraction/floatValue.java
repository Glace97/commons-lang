import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class floatValueTest {
  
  private Fraction fraction;
  
  @BeforeEach
  void setUp() {
    fraction = new Fraction(3, 7);
  }
  
  @Test
  void testFloatValue() {
    assertEquals(0.42857143, fraction.floatValue(), 0.00000001);
  }
  
  @Test
  void testFloatValueWithZeroDenominator() {
    Fraction zeroDenominator = new Fraction(3, 0);
    assertEquals(Float.POSITIVE_INFINITY, zeroDenominator.floatValue());
  }
  
  @Test
  void testFloatValueWithNegativeDenominator() {
    Fraction negativeDenominator = new Fraction(3, -7);
    assertEquals(-0.42857143, negativeDenominator.floatValue(), 0.00000001);
  }
  
  @Test
  void testFloatValueWithNegativeNumerator() {
    Fraction negativeNumerator = new Fraction(-3, 7);
    assertEquals(-0.42857143, negativeNumerator.floatValue(), 0.00000001);
  }
  
  @Test
  void testFloatValueWithNegativeNumeratorAndDenominator() {
    Fraction negativeFraction = new Fraction(-3, -7);
    assertEquals(0.42857143, negativeFraction.floatValue(), 0.00000001);
  }
  
  @Test
  void testFloatValueWithOneAsNumeratorAndDenominator() {
    Fraction oneFraction = new Fraction(1, 1);
    assertEquals(1.0, oneFraction.floatValue());
  }
  
  @Test
  void testFloatValueWithZeroAsNumerator() {
    Fraction zeroNumerator = new Fraction(0, 7);
    assertEquals(0.0, zeroNumerator.floatValue());
  }
  
  @Test
  void testFloatValueWithZeroAsNumeratorAndDenominator() {
    assertEquals(0.0, Fraction.ZERO.floatValue());
  }
  
  @Test
  void testFloatValueWithLargeNumbers() {
    Fraction largeFraction = new Fraction(Integer.MAX_VALUE, Integer.MAX_VALUE - 1);
    assertEquals(1.0000000004656613, largeFraction.floatValue(), 0.0000000000000001);
  }
  
  @Test
  void testFloatValueWithSmallNumbers() {
    Fraction smallFraction = new Fraction(1, Integer.MAX_VALUE);
    assertEquals(4.6566129e-10, smallFraction.floatValue(), 1e-19);
  }
}