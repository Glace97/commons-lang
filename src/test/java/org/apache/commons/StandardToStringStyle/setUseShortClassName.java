import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class setUseShortClassNameTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void testSetUseShortClassName() {
        // Test case 1: useShortClassName is true
        style.setUseShortClassName(true);
        assertTrue(style.isUseShortClassName());

        // Test case 2: useShortClassName is false
        style.setUseShortClassName(false);
        assertFalse(style.isUseShortClassName());
    }
}