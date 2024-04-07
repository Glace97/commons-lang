
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setTestRecursiveTest {

    private EqualsBuilder equalsBuilder;

    @BeforeEach
    void setUp() {
        equalsBuilder = new EqualsBuilder();
    }

    @Test
    void testSetTestRecursive_True() {
        equalsBuilder.setTestRecursive(true);
        assertTrue(equalsBuilder.testRecursive);
    }

    @Test
    void testSetTestRecursive_False() {
        equalsBuilder.setTestRecursive(false);
        assertFalse(equalsBuilder.testRecursive);
    }
}
