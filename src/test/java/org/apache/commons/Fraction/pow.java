import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class powTest {

    @Test
    void powWithPowerOne() {
        Fraction fraction = new Fraction(3, 4);
        Fraction result = fraction.pow(1);
        assertEquals(fraction, result);
    }

    @Test
    void powWithPowerZero() {
        Fraction fraction = new Fraction(3, 4);
        Fraction result = fraction.pow(0);
        assertEquals(Fraction.ONE, result);
    }

    @Test
    void powWithNegativePower() {
        Fraction fraction = new Fraction(3, 4);
        Fraction result = fraction.pow(-2);
        Fraction expected = new Fraction(16, 9);
        assertEquals(expected, result);
    }

    @Test
    void powWithEvenPower() {
        Fraction fraction = new Fraction(3, 4);
        Fraction result = fraction.pow(4);
        Fraction expected = new Fraction(81, 256);
        assertEquals(expected, result);
    }

    @Test
    void powWithOddPower() {
        Fraction fraction = new Fraction(3, 4);
        Fraction result = fraction.pow(3);
        Fraction expected = new Fraction(27, 64);
        assertEquals(expected, result);
    }

    @Test
    void powWithNegativeEvenPower() {
        Fraction fraction = new Fraction(3, 4);
        Fraction result = fraction.pow(-4);
        Fraction expected = new Fraction(256, 81);
        assertEquals(expected, result);
    }

    @Test
    void powWithNegativeOddPower() {
        Fraction fraction = new Fraction(3, 4);
        Fraction result = fraction.pow(-3);
        Fraction expected = new Fraction(64, 27);
        assertEquals(expected, result);
    }

    @Test
    void powWithLargePower() {
        Fraction fraction = new Fraction(1, 2);
        Fraction result = fraction.pow(100);
        Fraction expected = new Fraction(new BigInteger("1267650600228229401496703205376"), new BigInteger("633825300114114700748351602688"));
        assertEquals(expected, result);
    }

    @Test
    void powWithNegativeLargePower() {
        Fraction fraction = new Fraction(1, 2);
        Fraction result = fraction.pow(-100);
        Fraction expected = new Fraction(new BigInteger("633825300114114700748351602688"), new BigInteger("1267650600228229401496703205376"));
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void powWithPowerInRange(int power) {
        Fraction fraction = new Fraction(3, 4);
        Fraction result = fraction.pow(power);
        Fraction expected = new Fraction((int) Math.pow(3, power), (int) Math.pow(4, power));
        assertEquals(expected, result);
    }
}