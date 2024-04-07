import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class setEscapeCharTest {
    private StrSubstitutor substitutor;

    @BeforeEach
    void setUp() {
        substitutor = new StrSubstitutor();
    }

    @Test
    void testSetEscapeChar() {
        substitutor.setEscapeChar('$');
        assertEquals('$', substitutor.escapeChar);
    }
}