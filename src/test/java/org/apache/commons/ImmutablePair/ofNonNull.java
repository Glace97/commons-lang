
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ofNonNullTest {

    @Test
    void testOfNonNull() {
        // Test case 1: Both left and right are non-null
        ImmutablePair<Integer, String> pair1 = ImmutablePair.ofNonNull(1, "one");
        assertEquals(1, pair1.left);
        assertEquals("one", pair1.right);

        // Test case 2: Only left is null
        assertThrows(NullPointerException.class, () -> ImmutablePair.ofNonNull(null, "two"));

        // Test case 3: Only right is null
        assertThrows(NullPointerException.class, () -> ImmutablePair.ofNonNull(3, null));

        // Test case 4: Both left and right are null
        assertThrows(NullPointerException.class, () -> ImmutablePair.ofNonNull(null, null));
    }
}
