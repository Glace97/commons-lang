import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getLeftTest {

    @Test
    void testGetLeft() {
        // Test case 1: left is null
        ImmutableTriple<Integer, String, Double> triple1 = new ImmutableTriple<>(null, "middle", 1.5);
        assertNull(triple1.getLeft());

        // Test case 2: left is not null
        ImmutableTriple<Integer, String, Double> triple2 = new ImmutableTriple<>(10, "middle", 1.5);
        assertEquals(10, triple2.getLeft());

        // Test case 3: left is null, middle is null, right is null
        ImmutableTriple<Object, Object, Object> triple3 = ImmutableTriple.NULL;
        assertNull(triple3.getLeft());

        // Test case 4: left is null, middle is not null, right is null
        ImmutableTriple<String, Boolean, Object> triple4 = new ImmutableTriple<>(null, true, null);
        assertNull(triple4.getLeft());

        // Test case 5: left is null, middle is null, right is not null
        ImmutableTriple<Object, Object, Integer> triple5 = new ImmutableTriple<>(null, null, 100);
        assertNull(triple5.getLeft());

        // Test case 6: left is not null, middle is null, right is null
        ImmutableTriple<Integer, Object, Object> triple6 = new ImmutableTriple<>(5, null, null);
        assertEquals(5, triple6.getLeft());

        // Test case 7: left is not null, middle is not null, right is null
        ImmutableTriple<Integer, String, Object> triple7 = new ImmutableTriple<>(15, "middle", null);
        assertEquals(15, triple7.getLeft());

        // Test case 8: left is not null, middle is null, right is not null
        ImmutableTriple<Integer, Object, Double> triple8 = new ImmutableTriple<>(20, null, 2.5);
        assertEquals(20, triple8.getLeft());

        // Test case 9: left is null, middle is not null, right is not null
        ImmutableTriple<String, Boolean, Double> triple9 = new ImmutableTriple<>(null, true, 3.5);
        assertNull(triple9.getLeft());

        // Test case 10: left is not null, middle is not null, right is not null
        ImmutableTriple<Integer, String, Double> triple10 = new ImmutableTriple<>(25, "middle", 4.5);
        assertEquals(25, triple10.getLeft());
    }
}