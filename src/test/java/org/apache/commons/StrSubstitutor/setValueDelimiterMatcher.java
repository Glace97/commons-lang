import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class setValueDelimiterMatcherTest {
    private StrSubstitutor substitutor;

    @BeforeEach
    void setUp() {
        substitutor = new StrSubstitutor();
    }

    @Test
    void testSetValueDelimiterMatcher_Null() {
        substitutor.setValueDelimiterMatcher(null);
        assertNull(substitutor.getValueDelimiterMatcher());
    }

    @Test
    void testSetValueDelimiterMatcher_NotNull() {
        StrMatcher valueDelimiterMatcher = StrMatcher.stringMatcher(":=");
        substitutor.setValueDelimiterMatcher(valueDelimiterMatcher);
        assertEquals(valueDelimiterMatcher, substitutor.getValueDelimiterMatcher());
    }
}