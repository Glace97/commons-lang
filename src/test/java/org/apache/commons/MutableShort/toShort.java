import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toShortTest {

    @Test
    void testToShort() {
        // Test with positive value
        MutableShort mutableShort1 = new MutableShort(100);
        Short expected1 = 100;
        assertEquals(expected1, mutableShort1.toShort());

        // Test with negative value
        MutableShort mutableShort2 = new MutableShort(-50);
        Short expected2 = -50;
        assertEquals(expected2, mutableShort2.toShort());

        // Test with zero value
        MutableShort mutableShort3 = new MutableShort(0);
        Short expected3 = 0;
        assertEquals(expected3, mutableShort3.toShort());

        // Test with string value
        MutableShort mutableShort4 = new MutableShort("50");
        Short expected4 = 50;
        assertEquals(expected4, mutableShort4.toShort());

        // Test with invalid string value
        MutableShort mutableShort5 = new MutableShort("abc");
        assertThrows(NumberFormatException.class, () -> {
            mutableShort5.toShort();
        });
    }
}