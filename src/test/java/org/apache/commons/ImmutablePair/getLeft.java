import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getLeftTest {

    @Test
    void testGetLeft() {
        // Test case 1: Left value is not null
        ImmutablePair<Integer, String> pair1 = new ImmutablePair<>(10, "Hello");
        assertEquals(10, pair1.getLeft());

        // Test case 2: Left value is null
        ImmutablePair<Integer, String> pair2 = new ImmutablePair<>(null, "World");
        assertNull(pair2.getLeft());

        // Test case 3: Both left and right values are null
        ImmutablePair<Integer, String> pair3 = new ImmutablePair<>(null, null);
        assertNull(pair3.getLeft());

        // Test case 4: Left value is an object of a custom class
        CustomClass customObj = new CustomClass();
        ImmutablePair<CustomClass, String> pair4 = new ImmutablePair<>(customObj, "Test");
        assertSame(customObj, pair4.getLeft());
    }
    
    // Additional edge cases to consider:
    
    @Test
    void testGetLeftWithEmptyArray() {
        // Test case 5: Left value is an empty array
        ImmutablePair<Integer[], String> pair5 = new ImmutablePair<>(new Integer[0], "Empty");
        assertArrayEquals(new Integer[0], pair5.getLeft());
    }

    @Test
    void testGetLeftWithNullPair() {
        // Test case 6: Left value of a null pair
        ImmutablePair<Integer, String> pair6 = ImmutablePair.NULL;
        assertNull(pair6.getLeft());
    }
    
    // Additional test cases for specific scenarios or edge cases can be added as needed.
}
