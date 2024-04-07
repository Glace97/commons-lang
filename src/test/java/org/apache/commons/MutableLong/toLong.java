import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toLongTest {

    @Test
    void testToLong() {
        // Test case 1: Default value of zero
        MutableLong mutableLong1 = new MutableLong();
        Long expected1 = 0L;
        assertEquals(expected1, mutableLong1.toLong());

        // Test case 2: Positive value
        MutableLong mutableLong2 = new MutableLong(10);
        Long expected2 = 10L;
        assertEquals(expected2, mutableLong2.toLong());

        // Test case 3: Negative value
        MutableLong mutableLong3 = new MutableLong(-5);
        Long expected3 = -5L;
        assertEquals(expected3, mutableLong3.toLong());

        // Test case 4: Value from Number object
        MutableLong mutableLong4 = new MutableLong(15.5);
        Long expected4 = 15L;
        assertEquals(expected4, mutableLong4.toLong());

        // Test case 5: Value from String
        MutableLong mutableLong5 = new MutableLong("20");
        Long expected5 = 20L;
        assertEquals(expected5, mutableLong5.toLong());

        // Test case 6: Edge case - Maximum value
        MutableLong mutableLong6 = new MutableLong(Long.MAX_VALUE);
        Long expected6 = Long.MAX_VALUE;
        assertEquals(expected6, mutableLong6.toLong());

        // Test case 7: Edge case - Minimum value
        MutableLong mutableLong7 = new MutableLong(Long.MIN_VALUE);
        Long expected7 = Long.MIN_VALUE;
        assertEquals(expected7, mutableLong7.toLong());
    }
}