import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class setPreserveEscapesTest {
    private StrSubstitutor substitutor;

    @BeforeEach
    void setUp() {
        substitutor = new StrSubstitutor();
    }

    @Test
    void testSetPreserveEscapes_True() {
        substitutor.setPreserveEscapes(true);
        assertTrue(substitutor.preserveEscapes);
    }

    @Test
    void testSetPreserveEscapes_False() {
        substitutor.setPreserveEscapes(false);
        assertFalse(substitutor.preserveEscapes);
    }
}