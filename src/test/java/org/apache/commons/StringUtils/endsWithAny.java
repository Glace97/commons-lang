import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class endsWithAnyTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testEndsWithAny_NullSequenceAndNullSearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.endsWithAny(null, null));
    }

    @Test
    void testEndsWithAny_NullSequenceAndNonEmptySearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.endsWithAny(null, "abc"));
    }

    @Test
    void testEndsWithAny_NonNullSequenceAndNullSearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.endsWithAny("abcxyz", null));
    }

    @Test
    void testEndsWithAny_NonNullSequenceAndEmptySearchStrings_ReturnsTrue() {
        assertTrue(StringUtils.endsWithAny("abcxyz", ""));
    }

    @Test
    void testEndsWithAny_NonNullSequenceAndSearchStringNotPresent_ReturnsFalse() {
        assertFalse(StringUtils.endsWithAny("abcxyz", "def"));
    }

    @Test
    void testEndsWithAny_NonNullSequenceAndSearchStringPresent_ReturnsTrue() {
        assertTrue(StringUtils.endsWithAny("abcxyz", "xyz"));
    }

    @Test
    void testEndsWithAny_NonNullSequenceAndSearchStringListWithNull_ReturnsTrue() {
        assertTrue(StringUtils.endsWithAny("abcxyz", null, "xyz", "abc"));
    }

    @Test
    void testEndsWithAny_NonNullSequenceAndCaseSensitiveSearchStringPresent_ReturnsTrue() {
        assertTrue(StringUtils.endsWithAny("abcXYZ", "def", "XYZ"));
    }

    @Test
    void testEndsWithAny_NonNullSequenceAndCaseSensitiveSearchStringNotPresent_ReturnsFalse() {
        assertFalse(StringUtils.endsWithAny("abcXYZ", "def", "xyz"));
    }
}