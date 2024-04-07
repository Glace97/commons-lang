import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class compareToTest {

    @Test
    void testCompareToLessThan() {
        MutableDouble md1 = new MutableDouble(5.0);
        MutableDouble md2 = new MutableDouble(10.0);
        assertTrue(md1.compareTo(md2) < 0);
    }

    @Test
    void testCompareToGreaterThan() {
        MutableDouble md1 = new MutableDouble(10.0);
        MutableDouble md2 = new MutableDouble(5.0);
        assertTrue(md1.compareTo(md2) > 0);
    }

    @Test
    void testCompareToEqualTo() {
        MutableDouble md1 = new MutableDouble(5.0);
        MutableDouble md2 = new MutableDouble(5.0);
        assertEquals(0, md1.compareTo(md2));
    }

    @Test
    void testCompareToWithNull() {
        MutableDouble md1 = new MutableDouble(5.0);
        assertThrows(NullPointerException.class, () -> md1.compareTo(null));
    }

    @Test
    void testCompareToWithDifferentObjects() {
        MutableDouble md1 = new MutableDouble(5.0);
        Double d = 5.0;
        assertThrows(ClassCastException.class, () -> md1.compareTo(d));
    }

    @Test
    void testCompareToWithNegativeInfinity() {
        MutableDouble md1 = new MutableDouble(Double.NEGATIVE_INFINITY);
        MutableDouble md2 = new MutableDouble(0.0);
        assertTrue(md1.compareTo(md2) < 0);
    }

    @Test
    void testCompareToWithPositiveInfinity() {
        MutableDouble md1 = new MutableDouble(Double.POSITIVE_INFINITY);
        MutableDouble md2 = new MutableDouble(0.0);
        assertTrue(md1.compareTo(md2) > 0);
    }

    @Test
    void testCompareToWithNaN() {
        MutableDouble md1 = new MutableDouble(Double.NaN);
        MutableDouble md2 = new MutableDouble(0.0);
        assertTrue(md1.compareTo(md2) < 0);
    }
  
    @Test
    void testCompareToWithPositiveZero() {
        MutableDouble md1 = new MutableDouble(0.0);
        MutableDouble md2 = new MutableDouble(0.0);
        assertEquals(0, md1.compareTo(md2));
    }

    @Test
    void testCompareToWithNegativeZero() {
        MutableDouble md1 = new MutableDouble(-0.0);
        MutableDouble md2 = new MutableDouble(0.0);
        assertTrue(md1.compareTo(md2) < 0);
    }
}