import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class setVariableSuffixTest {
    private StrSubstitutor substitutor;

    @BeforeEach
    void setUp() {
        substitutor = new StrSubstitutor();
    }

    @Test
    void testSetVariableSuffixWithChar() {
        char suffix = ']';
        substitutor.setVariableSuffix(suffix);
        assertEquals(suffix, substitutor.getVariableSuffixMatcher().getMatcherChar());
    }

    @Test
    void testSetVariableSuffixWithString() {
        String suffix = "]";
        substitutor.setVariableSuffix(suffix);
        assertEquals(suffix, substitutor.getVariableSuffixMatcher().toString());
    }
}