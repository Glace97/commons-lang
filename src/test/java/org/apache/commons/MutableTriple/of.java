import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ofTest {

    @Test
    void testOfNulls() {
        MutableTriple<?, ?, ?> triple = MutableTriple.of(null, null, null);
        assertNull(triple.left);
        assertNull(triple.middle);
        assertNull(triple.right);
    }

    @Test
    void testOfNonNulls() {
        String left = "left";
        Integer middle = 1;
        Double right = 2.0;
        MutableTriple<String, Integer, Double> triple = MutableTriple.of(left, middle, right);
        assertEquals(left, triple.left);
        assertEquals(middle, triple.middle);
        assertEquals(right, triple.right);
    }

    @Test
    void testOfMixedTypes() {
        Object left = new Object();
        String middle = "middle";
        Integer right = 3;
        MutableTriple<Object, String, Integer> triple = MutableTriple.of(left, middle, right);
        assertEquals(left, triple.left);
        assertEquals(middle, triple.middle);
        assertEquals(right, triple.right);
    }
}