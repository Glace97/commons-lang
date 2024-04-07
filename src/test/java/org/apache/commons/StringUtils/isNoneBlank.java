import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class isNoneBlankTest {

    @Test
    void testIsNoneBlank_WithNoArguments_ShouldReturnTrue() {
        assertTrue(StringUtils.isNoneBlank());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testIsNoneBlank_WithNullAndEmptyStrings_ShouldReturnFalse(String css) {
        assertFalse(StringUtils.isNoneBlank(css));
    }

    @Test
    void testIsNoneBlank_WithWhitespaceStrings_ShouldReturnFalse() {
        assertFalse(StringUtils.isNoneBlank(" ", " ", " "));
    }

    @Test
    void testIsNoneBlank_WithNonEmptyStrings_ShouldReturnTrue() {
        assertTrue(StringUtils.isNoneBlank("foo", "bar"));
    }

    @Test
    void testIsNoneBlank_WithMixedNullAndNonEmptyStrings_ShouldReturnFalse() {
        assertFalse(StringUtils.isNoneBlank(null, "bar", ""));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "\t"})
    void testIsNoneBlank_WithWhitespaceStrings_ShouldReturnFalse(String css) {
        assertFalse(StringUtils.isNoneBlank(css));
    }
}