import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class shortValueTest {

    @Test
    void testShortValueWithDefaultConstructor() {
        MutableShort mutableShort = new MutableShort();
        assertEquals(0, mutableShort.shortValue());
    }

    @Test
    void testShortValueWithNumberConstructor() {
        MutableShort mutableShort = new MutableShort(10);
        assertEquals(10, mutableShort.shortValue());
    }

    @Test
    void testShortValueWithStringConstructor() {
        MutableShort mutableShort = new MutableShort("20");
        assertEquals(20, mutableShort.shortValue());
    }

    @Test
    void testShortValueWithInvalidStringConstructor() {
        assertThrows(NumberFormatException.class, () -> new MutableShort("abc"));
    }
}