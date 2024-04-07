import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class joinWithTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    @DisplayName("Test joinWith with delimiter and non-null elements")
    void testJoinWithDelimiterAndNonNullElements() {
        String result = stringUtils.joinWith(",", "a", "b", "c");
        assertEquals("a,b,c", result);
    }

    @Test
    @DisplayName("Test joinWith with delimiter and null elements")
    void testJoinWithDelimiterAndNullElements() {
        String result = stringUtils.joinWith(",", "a", null, "b", "");
        assertEquals("a,,b,", result);
    }

    @Test
    @DisplayName("Test joinWith with null delimiter and non-null elements")
    void testJoinWithNullDelimiterAndNonNullElements() {
        String result = stringUtils.joinWith(null, "a", "b", "c");
        assertEquals("abc", result);
    }

    @Test
    @DisplayName("Test joinWith with null delimiter and null elements")
    void testJoinWithNullDelimiterAndNullElements() {
        String result = stringUtils.joinWith(null, "a", null, "b", "");
        assertEquals("ab", result);
    }

    @Test
    @DisplayName("Test joinWith with empty delimiter and non-null elements")
    void testJoinWithEmptyDelimiterAndNonNullElements() {
        String result = stringUtils.joinWith("", "a", "b", "c");
        assertEquals("abc", result);
    }

    @Test
    @DisplayName("Test joinWith with empty delimiter and null elements")
    void testJoinWithEmptyDelimiterAndNullElements() {
        String result = stringUtils.joinWith("", "a", null, "b", "");
        assertEquals("ab", result);
    }

    @Test
    @DisplayName("Test joinWith with empty delimiter and empty elements")
    void testJoinWithEmptyDelimiterAndEmptyElements() {
        String result = stringUtils.joinWith("", "", "", "");
        assertEquals("", result);
    }

    @Test
    @DisplayName("Test joinWith with different types of elements")
    void testJoinWithDifferentTypesOfElements() {
        String result = stringUtils.joinWith(",", "a", 1, true, Arrays.asList("x", "y", "z"));
        assertEquals("a,1,true,[x, y, z]", result);
    }

    @Test
    @DisplayName("Test joinWith with large number of elements")
    void testJoinWithLargeNumberOfElements() {
        String[] elements = new String[1000000];
        Arrays.fill(elements, "a");
        String result = stringUtils.joinWith(",", elements);
        assertEquals("a,a,a,a,a,...,a", result);
    }
}