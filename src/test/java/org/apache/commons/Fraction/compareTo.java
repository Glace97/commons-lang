import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class compareToTest {
  
  private Fraction fraction1;
  private Fraction fraction2;
  
  @BeforeEach
  void setUp() {
    fraction1 = new Fraction(1, 2);
    fraction2 = new Fraction(2, 3);
  }
  
  @Test
  void testCompareToEqualFractions() {
    assertEquals(0, fraction1.compareTo(fraction1));
  }
  
  @Test
  void testCompareToDifferentFractions() {
    assertTrue(fraction1.compareTo(fraction2) < 0);
    assertTrue(fraction2.compareTo(fraction1) > 0);
  }
  
  @Test
  void testCompareToEqualNumeratorsDifferentDenominators() {
    Fraction fraction3 = new Fraction(1, 4);
    Fraction fraction4 = new Fraction(1, 3);
    int result = fraction3.compareTo(fraction4);
    assertTrue(result < 0);
  }
  
  @Test
  void testCompareToDifferentNumeratorsEqualDenominators() {
    Fraction fraction5 = new Fraction(1, 2);
    Fraction fraction6 = new Fraction(2, 2);
    int result = fraction5.compareTo(fraction6);
    assertTrue(result < 0);
  }
  
  @Test
  void testCompareToEqualFractionsInDifferentForms() {
    Fraction fraction7 = new Fraction(1, 2);
    Fraction fraction8 = new Fraction(2, 4);
    assertEquals(0, fraction7.compareTo(fraction8));
  }
  
  @Test
  void testCompareToNullFraction() {
    assertThrows(NullPointerException.class, () -> {
      fraction1.compareTo(null);
    });
  }
}