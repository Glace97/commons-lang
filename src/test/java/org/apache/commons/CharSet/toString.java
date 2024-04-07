import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toStringTest {
    private CharSet charSet;

    @BeforeEach
    void setUp() {
        charSet = new CharSet("a-z", "A-Z", "0-9");
    }

    @Test
    void testToString() {
        String expected = "[CharRange [start='a', end='z'], CharRange [start='A', end='Z'], CharRange [start='0', end='9']]";
        assertEquals(expected, charSet.toString());
    }
}