import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isUseShortClassNameTest {
    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void testIsUseShortClassNameDefault() {
        assertFalse(style.isUseShortClassName());
    }

    @Test
    void testIsUseShortClassNameAfterSet() {
        style.setUseShortClassName(true);
        assertTrue(style.isUseShortClassName());
    }

    @Test
    void testIsUseShortClassNameAfterSetFalse() {
        style.setUseShortClassName(false);
        assertFalse(style.isUseShortClassName());
    }

    @Test
    void testIsUseShortClassNameAfterSetMultipleTimes() {
        style.setUseShortClassName(true);
        style.setUseShortClassName(false);
        assertFalse(style.isUseShortClassName());
    }

    @Test
    void testIsUseShortClassNameAfterSetMultipleTimesReverseOrder() {
        style.setUseShortClassName(false);
        style.setUseShortClassName(true);
        assertTrue(style.isUseShortClassName());
    }
}