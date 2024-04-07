import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getVariablePrefixMatcherTest {

    private StrSubstitutor strSubstitutor;

    @BeforeEach
    void setUp() {
        strSubstitutor = new StrSubstitutor();
    }

    @Test
    void testGetVariablePrefixMatcher_DefaultPrefixMatcher() {
        StrMatcher expected = StrMatcher.stringMatcher("${");
        StrMatcher actual = strSubstitutor.getVariablePrefixMatcher();
        assertEquals(expected, actual);
    }

    @Test
    void testGetVariablePrefixMatcher_CustomPrefixMatcher() {
        StrMatcher prefixMatcher = StrMatcher.stringMatcher("$$");
        StrSubstitutor customSubstitutor = new StrSubstitutor(null, prefixMatcher, null, '$');
        StrMatcher expected = prefixMatcher;
        StrMatcher actual = customSubstitutor.getVariablePrefixMatcher();
        assertEquals(expected, actual);
    }
}