import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class hashCodeTest {
    private MutableShort mutableShort;

    @BeforeEach
    void setUp() {
        mutableShort = new MutableShort();
    }

    @Test
    void testHashCode() {
        assertEquals(0, mutableShort.hashCode());

        mutableShort = new MutableShort(10);
        assertEquals(10, mutableShort.hashCode());

        mutableShort = new MutableShort(-5);
        assertEquals(-5, mutableShort.hashCode());

        mutableShort = new MutableShort("20");
        assertEquals(20, mutableShort.hashCode());

        mutableShort = new MutableShort("-15");
        assertEquals(-15, mutableShort.hashCode());

        mutableShort = new MutableShort(NumberUtils.LONG_ZERO);
        assertEquals(0, mutableShort.hashCode());

        mutableShort = new MutableShort(NumberUtils.LONG_ONE);
        assertEquals(1, mutableShort.hashCode());

        mutableShort = new MutableShort(NumberUtils.LONG_MINUS_ONE);
        assertEquals(-1, mutableShort.hashCode());
    }

    @Test
    void testHashCodeWithSameValue() {
        MutableShort mutableShort1 = new MutableShort(10);
        MutableShort mutableShort2 = new MutableShort(10);

        assertEquals(mutableShort1.hashCode(), mutableShort2.hashCode());
    }

    @Test
    void testHashCodeWithDifferentValue() {
        MutableShort mutableShort1 = new MutableShort(10);
        MutableShort mutableShort2 = new MutableShort(20);

        assertNotEquals(mutableShort1.hashCode(), mutableShort2.hashCode());
    }
}