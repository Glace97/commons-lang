
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class startsWithAnyTest {

    @Test
    void testStartsWithAny_NullSequenceAndNullSearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.startsWithAny(null, (CharSequence[]) null));
    }

    @Test
    void testStartsWithAny_NullSequenceAndEmptySearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.startsWithAny(null, new CharSequence[] {}));
    }

    @Test
    void testStartsWithAny_NullSequenceAndNonEmptySearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.startsWithAny(null, "abc", "xyz"));
    }

    @Test
    void testStartsWithAny_EmptySequenceAndNullSearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.startsWithAny("", (CharSequence[]) null));
    }

    @Test
    void testStartsWithAny_EmptySequenceAndEmptySearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.startsWithAny("", new CharSequence[] {}));
    }

    @Test
    void testStartsWithAny_EmptySequenceAndNonEmptySearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.startsWithAny("", "abc", "xyz"));
    }

    @Test
    void testStartsWithAny_SequenceAndNullSearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.startsWithAny("abcxyz", (CharSequence[]) null));
    }

    @Test
    void testStartsWithAny_SequenceAndEmptySearchStrings_ReturnsTrue() {
        assertTrue(StringUtils.startsWithAny("abcxyz", new CharSequence[] {""}));
    }

    @Test
    void testStartsWithAny_SequenceAndMatchingSearchStrings_ReturnsTrue() {
        assertTrue(StringUtils.startsWithAny("abcxyz", "abc"));
    }

    @Test
    void testStartsWithAny_SequenceAndNonMatchingSearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.startsWithAny("abcxyz", "xyz", "ABCX"));
    }

    @Test
    void testStartsWithAny_SequenceAndCaseInsensitiveMatchingSearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.startsWithAny("ABCXYZ", "xyz", "abc"));
    }
}
