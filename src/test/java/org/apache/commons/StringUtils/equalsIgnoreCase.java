
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class equalsIgnoreCaseTest {

    @Test
    void testEqualsIgnoreCase_SameStrings_ReturnsTrue() {
        String str1 = "abc";
        String str2 = "abc";
        assertTrue(StringUtils.equalsIgnoreCase(str1, str2));
    }

    @Test
    void testEqualsIgnoreCase_NullStrings_ReturnsTrue() {
        assertTrue(StringUtils.equalsIgnoreCase(null, null));
    }

    @Test
    void testEqualsIgnoreCase_NullAndNonNullStrings_ReturnsFalse() {
        assertFalse(StringUtils.equalsIgnoreCase(null, "abc"));
        assertFalse(StringUtils.equalsIgnoreCase("abc", null));
    }

    @Test
    void testEqualsIgnoreCase_DifferentStrings_ReturnsFalse() {
        assertFalse(StringUtils.equalsIgnoreCase("abc", "def"));
    }

    @Test
    void testEqualsIgnoreCase_DifferentCaseStrings_ReturnsTrue() {
        assertTrue(StringUtils.equalsIgnoreCase("abc", "ABC"));
    }

    @Test
    void testEqualsIgnoreCase_EmptyStrings_ReturnsTrue() {
        assertTrue(StringUtils.equalsIgnoreCase("", ""));
    }

    @Test
    void testEqualsIgnoreCase_DifferentLengthStrings_ReturnsFalse() {
        assertFalse(StringUtils.equalsIgnoreCase("abc", "abcd"));
    }

    @Test
    void testEqualsIgnoreCase_UnicodeStrings_ReturnsTrue() {
        assertTrue(StringUtils.equalsIgnoreCase("Äpfel", "äPFEL"));
    }

    @Test
    void testEqualsIgnoreCase_UnicodeStrings_ReturnsFalse() {
        assertFalse(StringUtils.equalsIgnoreCase("Äpfel", "öPFEL"));
    }
}
