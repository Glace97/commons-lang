import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class getValueTest {

    @Test
    void testGetValueWithDefaultValue() {
        MutableLong mutableLong = new MutableLong();
        Long value = mutableLong.getValue();
        assertNotNull(value);
        assertEquals(0L, value);
    }

    @Test
    void testGetValueWithLongValue() {
        long expectedValue = 100L;
        MutableLong mutableLong = new MutableLong(expectedValue);
        Long value = mutableLong.getValue();
        assertNotNull(value);
        assertEquals(expectedValue, value);
    }

    @Test
    void testGetValueWithNumberValue() {
        long expectedValue = 200L;
        MutableLong mutableLong = new MutableLong(expectedValue);
        Long value = mutableLong.getValue();
        assertNotNull(value);
        assertEquals(expectedValue, value);
    }

    @Test
    void testGetValueWithStringValue() {
        String stringValue = "300";
        Long expectedValue = Long.parseLong(stringValue);
        MutableLong mutableLong = new MutableLong(stringValue);
        Long value = mutableLong.getValue();
        assertNotNull(value);
        assertEquals(expectedValue, value);
    }

    @Test
    void testGetValueWithInvalidStringValue() {
        String invalidStringValue = "abc";
        MutableLong mutableLong = new MutableLong(invalidStringValue);
        assertThrows(NumberFormatException.class, mutableLong::getValue);
    }

}