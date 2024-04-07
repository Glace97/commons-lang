import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isNoneEmptyTest {

    @Test
    void testIsNoneEmpty_NullInput_ReturnsFalse() {
        boolean result = StringUtils.isNoneEmpty((CharSequence[]) null);
        assertFalse(result);
    }

    @Test
    void testIsNoneEmpty_NullElement_ReturnsFalse() {
        boolean result = StringUtils.isNoneEmpty("foo", null);
        assertFalse(result);
    }

    @Test
    void testIsNoneEmpty_EmptyString_ReturnsFalse() {
        boolean result = StringUtils.isNoneEmpty("");
        assertFalse(result);
    }

    @Test
    void testIsNoneEmpty_SpaceString_ReturnsTrue() {
        boolean result = StringUtils.isNoneEmpty(" ");
        assertTrue(result);
    }

    @Test
    void testIsNoneEmpty_NonEmptyStrings_ReturnsTrue() {
        boolean result = StringUtils.isNoneEmpty("foo", "bar");
        assertTrue(result);
    }

    @Test
    void testIsNoneEmpty_EmptyArray_ReturnsTrue() {
        boolean result = StringUtils.isNoneEmpty(new CharSequence[]{});
        assertTrue(result);
    }

    @Test
    void testIsNoneEmpty_ArrayWithEmptyString_ReturnsFalse() {
        boolean result = StringUtils.isNoneEmpty(new CharSequence[]{""});
        assertFalse(result);
    }

    @Test
    void testIsNoneEmpty_ArrayWithNonEmptyStrings_ReturnsTrue() {
        boolean result = StringUtils.isNoneEmpty(new CharSequence[]{"foo", "bar"});
        assertTrue(result);
    }
}