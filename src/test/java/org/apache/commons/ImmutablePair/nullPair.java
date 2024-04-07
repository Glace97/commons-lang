import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class nullPairTest {

    @Test
    void testNullPair() {
        ImmutablePair<?, ?> pair = ImmutablePair.nullPair();
        assertEquals(null, pair.left);
        assertEquals(null, pair.right);
    }
}