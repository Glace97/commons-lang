import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class compareToTest {
    private MutableInt mutableInt1;
    private MutableInt mutableInt2;
    private MutableInt mutableInt3;

    @BeforeEach
    void setUp() {
        mutableInt1 = new MutableInt(0);
        mutableInt2 = new MutableInt(0);
        mutableInt3 = new MutableInt(1);
    }

    @Test
    void testCompareTo_SameValue_ReturnsZero() {
        assertEquals(0, mutableInt1.compareTo(mutableInt2));
    }

    @Test
    void testCompareTo_LessThan_ReturnsNegative() {
        assertTrue(mutableInt1.compareTo(mutableInt3) < 0);
    }

    @Test
    void testCompareTo_GreaterThan_ReturnsPositive() {
        assertTrue(mutableInt3.compareTo(mutableInt1) > 0);
    }
}