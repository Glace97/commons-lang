import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class containsAnyTest {

    @Test
    void testEmptyStringAndEmptySet() {
        assertFalse(CharSetUtils.containsAny("", ""));
    }

    @Test
    void testNullStringAndEmptySet() {
        assertFalse(CharSetUtils.containsAny(null, ""));
    }

    @Test
    void testEmptyStringAndNullSet() {
        assertFalse(CharSetUtils.containsAny("", (String[]) null));
    }

    @Test
    void testNullStringAndNullSet() {
        assertFalse(CharSetUtils.containsAny(null, (String[]) null));
    }

    @Test
    void testEmptyStringAndNonEmptySet() {
        assertFalse(CharSetUtils.containsAny("", "a", "b", "c"));
    }

    @Test
    void testNullStringAndNonEmptySet() {
        assertFalse(CharSetUtils.containsAny(null, "a", "b", "c"));
    }

    @Test
    void testNonEmptyStringAndEmptySet() {
        assertFalse(CharSetUtils.containsAny("hello", ""));
    }

    @Test
    void testNonEmptyStringAndNullSet() {
        assertFalse(CharSetUtils.containsAny("hello", (String[]) null));
    }

    @Test
    void testNonEmptyStringAndSetWithMatchingCharacters() {
        assertTrue(CharSetUtils.containsAny("hello", "k-p"));
    }

    @Test
    void testNonEmptyStringAndSetWithoutMatchingCharacters() {
        assertFalse(CharSetUtils.containsAny("hello", "a-d"));
    }

}