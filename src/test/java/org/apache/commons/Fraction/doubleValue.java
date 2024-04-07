import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class doubleValueTest {
    
    private Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(3, 7);
    }

    @Test
    void testDoubleValue() {
        double expected = 3.0 / 7.0;
        double actual = fraction.doubleValue();
        assertEquals(expected, actual);
    }
}