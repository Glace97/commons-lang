
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SetVariablePrefixTest {

    private StrSubstitutor substitutor;

    @BeforeEach
    void setUp() {
        substitutor = new StrSubstitutor();
    }

    @Test
    void setVariablePrefix_withCharPrefix_shouldSetPrefix() {
        char prefix = '$';
        substitutor.setVariablePrefix(prefix);
        assertEquals(prefix, substitutor.getVariablePrefixMatcher().getChar());
    }

    @Test
    void setVariablePrefix_withStringPrefix_shouldSetPrefix() {
        String prefix = "${";
        substitutor.setVariablePrefix(prefix);
        assertEquals(prefix, substitutor.getVariablePrefixMatcher().toString());
    }

    @Test
    void setVariablePrefix_withNull_shouldSetNullPrefixMatcher() {
        substitutor.setVariablePrefix(null);
        assertNull(substitutor.getVariablePrefixMatcher());
    }

}
