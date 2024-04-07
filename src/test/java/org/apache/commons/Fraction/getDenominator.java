import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class getDenominatorTest {
    private Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(3, 7);
    }

    @Test
    void testGetDenominator() {
        assertEquals(7, fraction.getDenominator());
    }
}