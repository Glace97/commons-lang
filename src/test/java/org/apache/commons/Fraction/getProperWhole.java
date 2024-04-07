import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class getProperWholeTest {

    private Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(0, 1);
    }

    @Test
    void testGetProperWholeWithPositiveFraction() {
        fraction = new Fraction(7, 4);
        int expected = 1;
        int actual = fraction.getProperWhole();
        assertEquals(expected, actual);
    }

    @Test
    void testGetProperWholeWithNegativeFraction() {
        fraction = new Fraction(-7, 4);
        int expected = -1;
        int actual = fraction.getProperWhole();
        assertEquals(expected, actual);
    }

    @Test
    void testGetProperWholeWithZeroFraction() {
        int expected = 0;
        int actual = fraction.getProperWhole();
        assertEquals(expected, actual);
    }
}