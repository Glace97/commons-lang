import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class squeezeTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testSqueeze_nullString() {
        assertNull(CharSetUtils.squeeze(null, "a-z"));
    }

    @Test
    void testSqueeze_emptyString() {
        assertEquals("", CharSetUtils.squeeze("", "a-z"));
    }

    @Test
    void testSqueeze_nullSet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", null));
    }

    @Test
    void testSqueeze_emptySet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", ""));
    }

    @Test
    void testSqueeze_noRepetitions() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-e"));
    }

    @Test
    void testSqueeze_repetitionsInSet() {
        assertEquals("helo", CharSetUtils.squeeze("hello", "k-p"));
    }

    @Test
    void testSqueeze_repetitionsNotInSet() {
        assertEquals("hello", CharSetUtils.squeeze("hello", "a-z"));
    }
}