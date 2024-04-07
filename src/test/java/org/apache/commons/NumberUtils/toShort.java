import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class toShortTest {

    @Test
    void testToShort_NullInput_ReturnsZero() {
        short result = NumberUtils.toShort(null);
        assertEquals(0, result);
    }

    @Test
    void testToShort_EmptyString_ReturnsZero() {
        short result = NumberUtils.toShort("");
        assertEquals(0, result);
    }

    @Test
    void testToShort_ValidString_ReturnsShortValue() {
        short result = NumberUtils.toShort("1");
        assertEquals(1, result);
    }

    @Test
    void testToShort_InvalidString_ReturnsDefaultValue() {
        short result = NumberUtils.toShort("abc", (short) 2);
        assertEquals(2, result);
    }
}