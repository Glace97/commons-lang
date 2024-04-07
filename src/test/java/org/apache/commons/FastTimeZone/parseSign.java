import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(Lifecycle.PER_CLASS)
class parseSignTest {

    @Test
    void testParseSignWithNullGroup() {
        assertFalse(FastTimeZone.parseSign(null));
    }

    @ParameterizedTest
    @ValueSource(strings = { "-", "+", "*", "/", "0", "1", "a", "A", "!", "@", "#", "$", "%", "^", "&", "(", ")" })
    void testParseSignWithInvalidGroup(String group) {
        assertFalse(FastTimeZone.parseSign(group));
    }

    @ParameterizedTest
    @ValueSource(strings = { "-1", "-10", "-100", "-01", "-001" })
    void testParseSignWithNegativeGroup(String group) {
        assertTrue(FastTimeZone.parseSign(group));
    }

    @ParameterizedTest
    @ValueSource(strings = { "+1", "+10", "+100", "+01", "+001" })
    void testParseSignWithPositiveGroup(String group) {
        assertFalse(FastTimeZone.parseSign(group));
    }
}