import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class equalsTest {

    @Test
    void testEquals() {
        MutableLong ml1 = new MutableLong(10);
        MutableLong ml2 = new MutableLong(10);
        MutableLong ml3 = new MutableLong(15);

        // Test equal objects
        assertTrue(ml1.equals(ml1));
        assertTrue(ml1.equals(ml2));

        // Test different objects with same value
        assertTrue(ml1.equals(new MutableLong(10)));

        // Test different objects with different values
        assertFalse(ml1.equals(ml3));
        assertFalse(ml1.equals(new MutableLong(5)));

        // Test null object
        assertFalse(ml1.equals(null));

        // Test non-MutableLong object
        assertFalse(ml1.equals("not a MutableLong"));

        // Test edge cases
        MutableLong ml4 = new MutableLong(Long.MAX_VALUE);
        MutableLong ml5 = new MutableLong(Long.MIN_VALUE);
        MutableLong ml6 = new MutableLong(NumberUtils.LONG_MINUS_ONE);
        MutableLong ml7 = new MutableLong(NumberUtils.LONG_ZERO);
        MutableLong ml8 = new MutableLong(NumberUtils.LONG_ONE);

        assertTrue(ml4.equals(ml4));
        assertFalse(ml4.equals(ml5));
        assertFalse(ml4.equals(ml6));
        assertFalse(ml4.equals(ml7));
        assertFalse(ml4.equals(ml8));

        assertFalse(ml5.equals(ml4));
        assertTrue(ml5.equals(ml5));
        assertFalse(ml5.equals(ml6));
        assertFalse(ml5.equals(ml7));
        assertFalse(ml5.equals(ml8));

        assertFalse(ml6.equals(ml4));
        assertFalse(ml6.equals(ml5));
        assertTrue(ml6.equals(ml6));
        assertFalse(ml6.equals(ml7));
        assertFalse(ml6.equals(ml8));

        assertFalse(ml7.equals(ml4));
        assertFalse(ml7.equals(ml5));
        assertFalse(ml7.equals(ml6));
        assertTrue(ml7.equals(ml7));
        assertFalse(ml7.equals(ml8));

        assertFalse(ml8.equals(ml4));
        assertFalse(ml8.equals(ml5));
        assertFalse(ml8.equals(ml6));
        assertFalse(ml8.equals(ml7));
        assertTrue(ml8.equals(ml8));
    }
}