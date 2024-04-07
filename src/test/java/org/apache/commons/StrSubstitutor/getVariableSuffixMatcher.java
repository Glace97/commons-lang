import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class getVariableSuffixMatcherTest {

    private StrSubstitutor strSubstitutor;

    @BeforeEach
    void setUp() {
        strSubstitutor = new StrSubstitutor();
    }

    @Test
    @DisplayName("Test getVariableSuffixMatcher returns the correct suffix matcher")
    void testGetVariableSuffixMatcher() {
        StrMatcher expectedSuffixMatcher = StrMatcher.stringMatcher("}");
        StrMatcher actualSuffixMatcher = strSubstitutor.getVariableSuffixMatcher();

        assertSame(expectedSuffixMatcher, actualSuffixMatcher);
    }
}