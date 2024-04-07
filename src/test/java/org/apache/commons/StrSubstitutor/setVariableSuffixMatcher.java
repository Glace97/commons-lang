import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class setVariableSuffixMatcherTest {
    private StrSubstitutor strSubstitutor;

    @BeforeEach
    void setUp() {
        strSubstitutor = new StrSubstitutor();
    }

    @Test
    void testSetVariableSuffixMatcher_ValidMatcher() {
        StrMatcher suffixMatcher = StrMatcher.charMatcher('}');
        StrSubstitutor result = strSubstitutor.setVariableSuffixMatcher(suffixMatcher);
        assertEquals(suffixMatcher, result.getVariableSuffixMatcher());
    }

    @Test
    void testSetVariableSuffixMatcher_NullMatcher() {
        assertThrows(NullPointerException.class, () -> {
            strSubstitutor.setVariableSuffixMatcher(null);
        });
    }
}