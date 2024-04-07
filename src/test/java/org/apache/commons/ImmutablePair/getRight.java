import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class getRightTest {

    @Test
    void testGetRight() {
        // Create a new ImmutablePair with left and right values
        ImmutablePair<String, Integer> pair = new ImmutablePair<>("Hello", 123);

        // Test the getRight() method
        assertEquals(123, pair.getRight());
    }

    @Test
    void testGetRightWithNull() {
        // Create a new ImmutablePair with null values
        ImmutablePair<String, Integer> pair = new ImmutablePair<>(null, null);

        // Test the getRight() method with null values
        assertNull(pair.getRight());
    }

    @Test
    void testGetRightWithDifferentTypes() {
        // Create a new ImmutablePair with different types for left and right values
        ImmutablePair<String, Double> pair = new ImmutablePair<>("Hello", 3.14);

        // Test the getRight() method with different types
        assertEquals(3.14, pair.getRight());
    }
    
    @Test
    void testGetRightWithEmptyArray() {
        // Create a new ImmutablePair with an empty array as the right value
        ImmutablePair<String, ImmutablePair<?, ?>[]> pair = new ImmutablePair<>("Hello", ImmutablePair.EMPTY_ARRAY);

        // Test the getRight() method with an empty array
        assertArrayEquals(ImmutablePair.EMPTY_ARRAY, pair.getRight());
    }

    @Test
    void testGetRightWithNullPair() {
        // Create a new ImmutablePair with null values
        ImmutablePair<String, Integer> pair = ImmutablePair.NULL;

        // Test the getRight() method with null pair
        assertNull(pair.getRight());
    }

    @Test
    void testGetRightAfterSettingRight() {
        // Create a new ImmutablePair with initial right value
        ImmutablePair<String, Integer> pair = new ImmutablePair<>("Hello", 123);

        // Set a new right value
        pair.right = 456;

        // Test the getRight() method after setting right value
        assertEquals(456, pair.getRight());
    }

}