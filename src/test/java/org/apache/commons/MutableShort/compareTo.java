import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class compareToTest {

    private MutableShort mutableShort1;
    private MutableShort mutableShort2;

    @BeforeEach
    void setUp() {
        mutableShort1 = new MutableShort((short) 10);
        mutableShort2 = new MutableShort((short) 20);
    }

    @Test
    void testCompareToLessThan() {
        int result = mutableShort1.compareTo(mutableShort2);
        assertTrue(result < 0);
    }

    @Test
    void testCompareToGreaterThan() {
        int result = mutableShort2.compareTo(mutableShort1);
        assertTrue(result > 0);
    }

    @Test
    void testCompareToEqual() {
        int result = mutableShort1.compareTo(mutableShort1);
        assertEquals(0, result);
    }

    @Test
    void testCompareToNull() {
        assertThrows(NullPointerException.class, () -> {
            mutableShort1.compareTo(null);
        });
    }

    @Test
    void testCompareToEdgeCases() {
        MutableShort minShort = new MutableShort(Short.MIN_VALUE);
        MutableShort maxShort = new MutableShort(Short.MAX_VALUE);

        // Compare to MIN_VALUE
        int minResult = mutableShort1.compareTo(minShort);
        assertTrue(minResult > 0);

        // Compare to MAX_VALUE
        int maxResult = mutableShort1.compareTo(maxShort);
        assertTrue(maxResult < 0);
    }

}