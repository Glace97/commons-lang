
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppendSuperTest {
    private ToStringBuilder toStringBuilder;

    @BeforeEach
    void setUp() {
        toStringBuilder = new ToStringBuilder(new Object());
    }

    @Test
    void appendSuper_withNullSuperToString_shouldNotChangeBuffer() {
        String superToString = null;

        ToStringBuilder result = toStringBuilder.appendSuper(superToString);

        assertEquals("", result.buffer.toString());
    }

    @Test
    void appendSuper_withEmptySuperToString_shouldNotChangeBuffer() {
        String superToString = "";

        ToStringBuilder result = toStringBuilder.appendSuper(superToString);

        assertEquals("", result.buffer.toString());
    }

    @Test
    void appendSuper_withNonEmptySuperToString_shouldAppendSuperToStringToBuffer() {
        String superToString = "SuperToString";

        ToStringBuilder result = toStringBuilder.appendSuper(superToString);

        assertEquals(superToString, result.buffer.toString());
    }
}
