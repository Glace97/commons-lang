import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isPreserveEscapesTest {

    private StrSubstitutor substitutor;

    @BeforeEach
    void setUp() {
        substitutor = new StrSubstitutor();
    }

    @Test
    void testIsPreserveEscapes_DefaultValue() {
        assertFalse(substitutor.isPreserveEscapes());
    }

    @Test
    void testIsPreserveEscapes_SetToTrue() {
        substitutor.setPreserveEscapes(true);
        assertTrue(substitutor.isPreserveEscapes());
    }

    @Test
    void testIsPreserveEscapes_SetToFalse() {
        substitutor.setPreserveEscapes(false);
        assertFalse(substitutor.isPreserveEscapes());
    }
}