import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class intValueTest {

    private Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(3, 7);
    }

    @Test
    void testIntValue() {
        assertEquals(0, Fraction.ZERO.intValue());
        assertEquals(1, Fraction.ONE.intValue());
        assertEquals(0, Fraction.ONE_HALF.intValue());
        assertEquals(0, Fraction.ONE_THIRD.intValue());
        assertEquals(0, Fraction.TWO_THIRDS.intValue());
        assertEquals(0, Fraction.ONE_QUARTER.intValue());
        assertEquals(0, Fraction.TWO_QUARTERS.intValue());
        assertEquals(0, Fraction.THREE_QUARTERS.intValue());
        assertEquals(0, Fraction.ONE_FIFTH.intValue());
        assertEquals(0, Fraction.TWO_FIFTHS.intValue());
        assertEquals(0, Fraction.THREE_FIFTHS.intValue());
        assertEquals(0, Fraction.FOUR_FIFTHS.intValue());
        assertEquals(0, fraction.intValue());
    }
}