import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class nullTripleTest {

    @Test
    void testNullTriple() {
        ImmutableTriple<?, ?, ?> result = ImmutableTriple.nullTriple();

        assertNull(result.getLeft());
        assertNull(result.getMiddle());
        assertNull(result.getRight());
    }
}