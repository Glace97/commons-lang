import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class doubleValueTest {

    @Test
    void testDoubleValueWithDefaultValueZero() {
        MutableShort mutableShort = new MutableShort();
        assertEquals(0.0, mutableShort.doubleValue());
    }
    
    @Test
    void testDoubleValueWithPositiveValue() {
        MutableShort mutableShort = new MutableShort((short) 10);
        assertEquals(10.0, mutableShort.doubleValue());
    }
    
    @Test
    void testDoubleValueWithNegativeValue() {
        MutableShort mutableShort = new MutableShort((short) -5);
        assertEquals(-5.0, mutableShort.doubleValue());
    }
    
    @Test
    void testDoubleValueWithMaxValue() {
        MutableShort mutableShort = new MutableShort(Short.MAX_VALUE);
        assertEquals((double) Short.MAX_VALUE, mutableShort.doubleValue());
    }
    
    @Test
    void testDoubleValueWithMinValue() {
        MutableShort mutableShort = new MutableShort(Short.MIN_VALUE);
        assertEquals((double) Short.MIN_VALUE, mutableShort.doubleValue());
    }
    
    @Test
    void testDoubleValueWithStringValue() {
        MutableShort mutableShort = new MutableShort("15");
        assertEquals(15.0, mutableShort.doubleValue());
    }
    
    @Test
    void testDoubleValueWithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> {
            MutableShort mutableShort = new MutableShort("abc");
            mutableShort.doubleValue();
        });
    }
}