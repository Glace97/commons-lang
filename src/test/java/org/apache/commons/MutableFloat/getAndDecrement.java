import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getAndDecrementTest {

    @Test
    void testGetAndDecrement() {
        MutableFloat mf1 = new MutableFloat(5.0f);
        assertEquals(5.0f, mf1.getAndDecrement()); // test initial value

        MutableFloat mf2 = new MutableFloat(-3.5f);
        assertEquals(-3.5f, mf2.getAndDecrement()); // test negative value

        MutableFloat mf3 = new MutableFloat(0.0f);
        assertEquals(0.0f, mf3.getAndDecrement()); // test zero value

        MutableFloat mf4 = new MutableFloat(Float.NaN);
        assertTrue(Float.isNaN(mf4.getAndDecrement())); // test NaN value

        MutableFloat mf5 = new MutableFloat(Float.POSITIVE_INFINITY);
        assertEquals(Float.POSITIVE_INFINITY, mf5.getAndDecrement()); // test positive infinity value

        MutableFloat mf6 = new MutableFloat(Float.NEGATIVE_INFINITY);
        assertEquals(Float.NEGATIVE_INFINITY, mf6.getAndDecrement()); // test negative infinity value
    }
}