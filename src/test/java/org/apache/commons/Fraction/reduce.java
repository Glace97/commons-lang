import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class reduceTest {
  
  @Test
  void testReduce() {
    // Test case 1: Reduce fraction with numerator and denominator both positive
    Fraction fraction1 = new Fraction(4, 8);
    Fraction expected1 = new Fraction(1, 2);
    Assertions.assertEquals(expected1, fraction1.reduce());
    
    // Test case 2: Reduce fraction with negative numerator and positive denominator
    Fraction fraction2 = new Fraction(-6, 12);
    Fraction expected2 = new Fraction(-1, 2);
    Assertions.assertEquals(expected2, fraction2.reduce());
    
    // Test case 3: Reduce fraction with positive numerator and negative denominator
    Fraction fraction3 = new Fraction(15, -30);
    Fraction expected3 = new Fraction(-1, 2);
    Assertions.assertEquals(expected3, fraction3.reduce());
    
    // Test case 4: Reduce fraction with negative numerator and negative denominator
    Fraction fraction4 = new Fraction(-9, -18);
    Fraction expected4 = new Fraction(1, 2);
    Assertions.assertEquals(expected4, fraction4.reduce());
    
    // Test case 5: Reduce fraction with numerator equal to 0
    Fraction fraction5 = new Fraction(0, 5);
    Fraction expected5 = new Fraction(0, 1);
    Assertions.assertEquals(expected5, fraction5.reduce());
    
    // Test case 6: Reduce fraction with denominator equal to 1
    Fraction fraction6 = new Fraction(7, 1);
    Fraction expected6 = new Fraction(7, 1);
    Assertions.assertEquals(expected6, fraction6.reduce());
    
    // Test case 7: Reduce fraction with numerator and denominator equal to 1
    Fraction fraction7 = new Fraction(1, 1);
    Fraction expected7 = new Fraction(1, 1);
    Assertions.assertEquals(expected7, fraction7.reduce());
  }
  
  @Test
  void testReduceEdgeCases() {
    // Test case 1: Reduce fraction with large numerator and large denominator
    Fraction fraction1 = new Fraction(BigInteger.valueOf(1000000), BigInteger.valueOf(2000000));
    Fraction expected1 = new Fraction(1, 2);
    Assertions.assertEquals(expected1, fraction1.reduce());
    
    // Test case 2: Reduce fraction with large negative numerator and large negative denominator
    Fraction fraction2 = new Fraction(BigInteger.valueOf(-500000), BigInteger.valueOf(-1000000));
    Fraction expected2 = new Fraction(1, 2);
    Assertions.assertEquals(expected2, fraction2.reduce());
    
    // Test case 3: Reduce fraction with large numerator and large negative denominator
    Fraction fraction3 = new Fraction(BigInteger.valueOf(750000), BigInteger.valueOf(-1500000));
    Fraction expected3 = new Fraction(-1, 2);
    Assertions.assertEquals(expected3, fraction3.reduce());
    
    // Test case 4: Reduce fraction with large negative numerator and large denominator
    Fraction fraction4 = new Fraction(BigInteger.valueOf(-900000), BigInteger.valueOf(1800000));
    Fraction expected4 = new Fraction(-1, 2);
    Assertions.assertEquals(expected4, fraction4.reduce());
  }
  
  @Test
  void testReduceEdgeCasesZero() {
    // Test case 1: Reduce fraction with numerator and denominator equal to 0
    Fraction fraction1 = new Fraction(0, 0);
    Fraction expected1 = new Fraction(0, 1);
    Assertions.assertEquals(expected1, fraction1.reduce());
    
    // Test case 2: Reduce fraction with numerator equal to 0 and denominator not equal to 0
    Fraction fraction2 = new Fraction(0, 5);
    Fraction expected2 = new Fraction(0, 1);
    Assertions.assertEquals(expected2, fraction2.reduce());
    
    // Test case 3: Reduce fraction with numerator not equal to 0 and denominator equal to 0
    Fraction fraction3 = new Fraction(10, 0);
    Fraction expected3 = new Fraction(0, 1);
    Assertions.assertEquals(expected3, fraction3.reduce());
  }
  
  @Test
  void testReduceEdgeCasesOne() {
    // Test case 1: Reduce fraction with numerator and denominator both equal to 1
    Fraction fraction1 = new Fraction(1, 1);
    Fraction expected1 = new Fraction(1, 1);
    Assertions.assertEquals(expected1, fraction1.reduce());
    
    // Test case 2: Reduce fraction with numerator equal to 1 and denominator not equal to 1
    Fraction fraction2 = new Fraction(1, 5);
    Fraction expected2 = new Fraction(1, 5);
    Assertions.assertEquals(expected2, fraction2.reduce());
    
    // Test case 3: Reduce fraction with numerator not equal to 1 and denominator equal to 1
    Fraction fraction3 = new Fraction(10, 1);
    Fraction expected3 = new Fraction(10, 1);
    Assertions.assertEquals(expected3, fraction3.reduce());
  }
}