import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getValueTest {

    private MutableShort mutableShort;

    @BeforeEach
    void setUp() {
        mutableShort = new MutableShort();
    }

    @Test
    void testGetValueWithDefaultConstructor() {
        assertNotNull(mutableShort.getValue());
        assertEquals(0, mutableShort.getValue());
    }

    @Test
    void testGetValueWithNumberConstructor() {
        MutableShort numberConstructor = new MutableShort(10);
        assertNotNull(numberConstructor.getValue());
        assertEquals(10, numberConstructor.getValue());
    }

    @Test
    void testGetValueWithStringConstructor() {
        MutableShort stringConstructor = new MutableShort("5");
        assertNotNull(stringConstructor.getValue());
        assertEquals(5, stringConstructor.getValue());
    }

    @Test
    void testGetValueWithInvalidStringConstructor() {
        try {
            MutableShort invalidStringConstructor = new MutableShort("abc");
            assertNotNull(invalidStringConstructor.getValue());
        } catch (NumberFormatException e) {
            // NumberFormatException expected
        }
    }

    @Test
    void testGetValueWithNegativeNumberConstructor() {
        MutableShort negativeNumberConstructor = new MutableShort(-10);
        assertNotNull(negativeNumberConstructor.getValue());
        assertEquals(-10, negativeNumberConstructor.getValue());
    }
}