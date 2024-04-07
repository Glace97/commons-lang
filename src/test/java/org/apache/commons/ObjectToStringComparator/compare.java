import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompareTest {
    private final ObjectToStringComparator comparator = ObjectToStringComparator.INSTANCE;

    @Test
    void testCompare_bothNull_shouldReturnZero() {
        assertEquals(0, comparator.compare(null, null));
    }

    @Test
    void testCompare_firstNull_shouldReturnOne() {
        assertEquals(1, comparator.compare(null, new Object()));
    }

    @Test
    void testCompare_secondNull_shouldReturnNegativeOne() {
        assertEquals(-1, comparator.compare(new Object(), null));
    }

    @Test
    void testCompare_bothNonNull_shouldCompareToStrings() {
        assertEquals(0, comparator.compare(new Object(), new Object()));
        assertEquals(-1, comparator.compare("abc", "def"));
        assertEquals(1, comparator.compare("def", "abc"));
    }
}