import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SetValueTest {

    private MutableByte mutableByte;

    @BeforeEach
    void setUp() {
        mutableByte = new MutableByte();
    }

    @Test
    void testSetValue() {
        mutableByte.setValue((byte) 10);
        assertEquals(10, mutableByte.getValue());
    }

    @Test
    void testSetValueFromNumber() {
        mutableByte.setValue((byte) 5);
        assertEquals(5, mutableByte.getValue());

        mutableByte.setValue((short) 10);
        assertEquals(10, mutableByte.getValue());

        mutableByte.setValue(15);
        assertEquals(15, mutableByte.getValue());

        mutableByte.setValue(20L);
        assertEquals(20, mutableByte.getValue());

        mutableByte.setValue(25.0f);
        assertEquals(25, mutableByte.getValue());

        mutableByte.setValue(30.0);
        assertEquals(30, mutableByte.getValue());
    }

    @Test
    void testSetValueFromString() {
        mutableByte.setValue("5");
        assertEquals(5, mutableByte.getValue());

        mutableByte.setValue("10");
        assertEquals(10, mutableByte.getValue());

        mutableByte.setValue("15");
        assertEquals(15, mutableByte.getValue());

        mutableByte.setValue("20");
        assertEquals(20, mutableByte.getValue());

        mutableByte.setValue("25");
        assertEquals(25, mutableByte.getValue());
    }

    @Test
    void testSetValueFromInvalidString() {
        assertThrows(NumberFormatException.class, () -> mutableByte.setValue("abc"));
    }
}