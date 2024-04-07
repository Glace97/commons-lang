import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class setValueTest {
    private MutableShort mutableShort;

    @BeforeEach
    void setUp() {
        mutableShort = new MutableShort();
    }

    @Test
    void testSetValueWithNumber() {
        mutableShort.setValue((Number) 10);
        assertEquals((short) 10, mutableShort.getValue());
    }

    @Test
    void testSetValueWithShort() {
        mutableShort.setValue((short) 20);
        assertEquals((short) 20, mutableShort.getValue());
    }

    @Test
    void testSetValueWithNullNumber() {
        assertThrows(NullPointerException.class, () -> mutableShort.setValue((Number) null));
    }

    @Test
    void testSetValueWithNullShort() {
        assertThrows(NullPointerException.class, () -> mutableShort.setValue((short) null));
    }

    @Test
    void testSetValueWithString() {
        mutableShort.setValue("30");
        assertEquals((short) 30, mutableShort.getValue());
    }

    @Test
    void testSetValueWithInvalidString() {
        assertThrows(NumberFormatException.class, () -> mutableShort.setValue("abc"));
    }
}