import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class setRightTest {
    private MutablePair<String, Integer> pair;

    @BeforeEach
    void setUp() {
        pair = new MutablePair<>("left", 1);
    }

    @Test
    void testSetRight() {
        // Test setting right element to null
        pair.setRight(null);
        assertNull(pair.right);

        // Test setting right element to a non-null value
        pair.setRight(2);
        assertEquals(2, pair.right);

        // Test setting right element to a different value
        pair.setRight(3);
        assertEquals(3, pair.right);
    }
}