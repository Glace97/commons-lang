import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SetValueTest {
    private MutableFloat mutableFloat;

    @BeforeEach
    void setUp() {
        mutableFloat = new MutableFloat();
    }

    @Test
    void testSetValue() {
        mutableFloat.setValue(5.0f);
        assertEquals(5.0f, mutableFloat.getValue());
    }

    @Test
    void testSetValueFromNumber() {
        mutableFloat.setValue(10);
        assertEquals(10.0f, mutableFloat.getValue());

        mutableFloat.setValue(10L);
        assertEquals(10.0f, mutableFloat.getValue());

        mutableFloat.setValue(10.5d);
        assertEquals(10.5f, mutableFloat.getValue());
    }

    @Test
    void testSetValueFromString() {
        mutableFloat.setValue("15.5");
        assertEquals(15.5f, mutableFloat.getValue());

        assertThrows(NumberFormatException.class, () -> mutableFloat.setValue("abc"));
    }
}