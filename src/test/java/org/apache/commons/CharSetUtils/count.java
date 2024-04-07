import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class countTest {

    @Test
    void testCount_NullString_ReturnsZero() {
        int result = CharSetUtils.count(null, "a", "b", "c");
        assertEquals(0, result);
    }

    @Test
    void testCount_EmptyString_ReturnsZero() {
        int result = CharSetUtils.count("", "a", "b", "c");
        assertEquals(0, result);
    }

    @Test
    void testCount_NullSet_ReturnsZero() {
        int result = CharSetUtils.count("hello", null);
        assertEquals(0, result);
    }

    @Test
    void testCount_EmptySet_ReturnsZero() {
        int result = CharSetUtils.count("hello", "");
        assertEquals(0, result);
    }

    @Test
    void testCount_ValidStringAndSet_ReturnsCount() {
        int result = CharSetUtils.count("hello", "k-p");
        assertEquals(3, result);
    }

    @Test
    void testCount_ValidStringAndSet_ReturnsCount2() {
        int result = CharSetUtils.count("hello", "a-e");
        assertEquals(1, result);
    }

    @Test
    void testCount_ValidStringAndSet_ReturnsZero() {
        int result = CharSetUtils.count("hello", "x-z");
        assertEquals(0, result);
    }
}