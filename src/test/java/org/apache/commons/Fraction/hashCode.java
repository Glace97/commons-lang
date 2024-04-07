import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HashCodeTest {

    @Test
    void testHashCode() {
        Fraction fraction1 = new Fraction(3, 7);
        Fraction fraction2 = new Fraction(3, 7);

        Assertions.assertEquals(fraction1.hashCode(), fraction2.hashCode());
    }

    @Test
    void testHashCodeConsistency() {
        Fraction fraction = new Fraction(3, 7);

        int hashCode1 = fraction.hashCode();
        int hashCode2 = fraction.hashCode();

        Assertions.assertEquals(hashCode1, hashCode2);
    }

    @Test
    void testHashCodeDistribution() {
        Fraction fraction1 = new Fraction(3, 7);
        Fraction fraction2 = new Fraction(5, 9);

        Assertions.assertNotEquals(fraction1.hashCode(), fraction2.hashCode());
    }
}