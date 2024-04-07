
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ofNonNullTest {

    private MutablePair<Integer, String> pair;

    @BeforeEach
    void setUp() {
        pair = new MutablePair<>();
    }

    @Test
    void ofNonNull_withNonNullValues_shouldReturnNonNullPair() {
        Integer left = 10;
        String right = "Hello";
        MutablePair<Integer, String> result = MutablePair.ofNonNull(left, right);
        assertNotNull(result);
        assertEquals(left, result.left);
        assertEquals(right, result.right);
    }

    @Test
    void ofNonNull_withNullLeftValue_shouldThrowNullPointerException() {
        Integer left = null;
        String right = "Hello";
        assertThrows(NullPointerException.class, () -> MutablePair.ofNonNull(left, right));
    }

    @Test
    void ofNonNull_withNullRightValue_shouldThrowNullPointerException() {
        Integer left = 10;
        String right = null;
        assertThrows(NullPointerException.class, () -> MutablePair.ofNonNull(left, right));
    }

    @Test
    void ofNonNull_withBothNullValues_shouldThrowNullPointerException() {
        Integer left = null;
        String right = null;
        assertThrows(NullPointerException.class, () -> MutablePair.ofNonNull(left, right));
    }

}
