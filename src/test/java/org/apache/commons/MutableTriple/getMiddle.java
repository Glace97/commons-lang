import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getMiddleTest {

    @Test
    void testGetMiddle() {
        // Test case 1: middle object is null
        MutableTriple<Integer, String, Double> triple1 = new MutableTriple<>(1, null, 3.14);
        assertNull(triple1.getMiddle());

        // Test case 2: middle object is not null
        MutableTriple<String, Integer, Boolean> triple2 = new MutableTriple<>("hello", 42, true);
        assertEquals(42, triple2.getMiddle());

        // Test case 3: all objects are null
        MutableTriple<Object, Object, Object> triple3 = new MutableTriple<>(null, null, null);
        assertNull(triple3.getMiddle());

        // Test case 4: middle object is a custom object
        CustomObject obj = new CustomObject();
        MutableTriple<CustomObject, Integer, String> triple4 = new MutableTriple<>(obj, 10, "example");
        assertSame(obj, triple4.getMiddle());
    }
}