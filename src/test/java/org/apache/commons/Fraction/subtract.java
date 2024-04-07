import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubtractTest {
    private Fraction fraction1;
    private Fraction fraction2;
    private Fraction fraction3;
    private Fraction fraction4;
    private Fraction fraction5;
    
    @BeforeEach
    void setUp() {
        fraction1 = new Fraction(3, 7);
        fraction2 = new Fraction(2, 7);
        fraction3 = new Fraction(1, 2);
        fraction4 = new Fraction(1, 4);
        fraction5 = new Fraction(0, 1);
    }
    
    @Test
    void testSubtract() {
        // Test subtracting a smaller fraction from a larger fraction
        Fraction result1 = fraction1.subtract(fraction2);
        assertEquals(1, result1.getNumerator());
        assertEquals(7, result1.getDenominator());
        
        // Test subtracting a fraction from itself
        Fraction result2 = fraction3.subtract(fraction3);
        assertEquals(0, result2.getNumerator());
        assertEquals(1, result2.getDenominator());
        
        // Test subtracting a fraction from zero
        Fraction result3 = fraction5.subtract(fraction3);
        assertEquals(-1, result3.getNumerator());
        assertEquals(2, result3.getDenominator());
        
        // Test subtracting zero from a fraction
        Fraction result4 = fraction4.subtract(fraction5);
        assertEquals(1, result4.getNumerator());
        assertEquals(4, result4.getDenominator());
        
        // Test subtracting zero from zero
        Fraction result5 = fraction5.subtract(fraction5);
        assertEquals(0, result5.getNumerator());
        assertEquals(1, result5.getDenominator());
    }
}