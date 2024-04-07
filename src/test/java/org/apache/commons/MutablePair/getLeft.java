import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getLeftTest {
    private MutablePair<String, Integer> pair;

    @BeforeEach
    void setUp() {
        pair = new MutablePair<>("Hello", 123);
    }

    @Test
    void testGetLeft() {
        assertEquals("Hello", pair.getLeft());
    }

    @Test
    void testGetLeftWithNull() {
        MutablePair<String, Integer> pairWithNull = new MutablePair<>(null, 123);
        assertNull(pairWithNull.getLeft());
    }
}