import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

class getEndTest {

    private CharRange charRange;

    @BeforeEach
    void setUp() {
        charRange = new CharRange('a', 'z', false);
    }

    @Test
    void testGetEnd() {
        char expectedEnd = 'z';
        char actualEnd = charRange.getEnd();
        Assertions.assertEquals(expectedEnd, actualEnd);
    }

    @Test
    void testGetEndWithNegatedRange() {
        charRange = new CharRange('a', 'z', true);
        char expectedEnd = 'z';
        char actualEnd = charRange.getEnd();
        Assertions.assertEquals(expectedEnd, actualEnd);
    }
}