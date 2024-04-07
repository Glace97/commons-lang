import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class anyMatchTest {

    private FailableStream<Integer> stream;

    @BeforeEach
    void setUp() {
        stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5));
    }

    @Test
    void testAnyMatch_ReturnsTrue_WhenPredicateMatchesAtLeastOneElement() {
        assertTrue(stream.anyMatch(x -> x > 3));
    }

    @Test
    void testAnyMatch_ReturnsFalse_WhenPredicateDoesNotMatchAnyElement() {
        assertFalse(stream.anyMatch(x -> x > 5));
    }

    @Test
    void testAnyMatch_ReturnsFalse_WhenPredicateMatchesAllElements() {
        assertFalse(stream.anyMatch(x -> x <= 5));
    }

    @Test
    void testAnyMatch_ReturnsFalse_WhenStreamIsEmpty() {
        stream = new FailableStream<>(Stream.empty());
        assertFalse(stream.anyMatch(x -> x > 0));
    }

    @Test
    void testAnyMatch_ThrowsException_WhenPredicateThrowsException() {
        assertThrows(Exception.class, () -> stream.anyMatch(x -> {
            throw new Exception("Test Exception");
        }));
    }
}