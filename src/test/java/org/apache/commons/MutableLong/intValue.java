import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class intValueTest {

    @Test
    void testIntValue() {
        // Test case 1: Default value of zero
        MutableLong mutableLong1 = new MutableLong();
        assertEquals(0, mutableLong1.intValue());

        // Test case 2: Positive value
        MutableLong mutableLong2 = new MutableLong(10);
        assertEquals(10, mutableLong2.intValue());

        // Test case 3: Negative value
        MutableLong mutableLong3 = new MutableLong(-5);
        assertEquals(-5, mutableLong3.intValue());

        // Test case 4: Value from Number object
        MutableLong mutableLong4 = new MutableLong(15L);
        assertEquals(15, mutableLong4.intValue());

        // Test case 5: Value from String
        MutableLong mutableLong5 = new MutableLong("20");
        assertEquals(20, mutableLong5.intValue());
    }

}