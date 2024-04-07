import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class keepTest {

    private CharSetUtils charSetUtils;

    @BeforeEach
    void setUp() {
        charSetUtils = new CharSetUtils();
    }

    @Test
    void testKeep_NullStringInput_ReturnsNull() {
        String result = charSetUtils.keep(null, "hl");
        assertNull(result);
    }

    @Test
    void testKeep_EmptyStringInput_ReturnsEmptyString() {
        String result = charSetUtils.keep("", "hl");
        assertEquals("", result);
    }

    @Test
    void testKeep_NullSet_ReturnsEmptyString() {
        String result = charSetUtils.keep("hello", null);
        assertEquals("", result);
    }

    @Test
    void testKeep_EmptySet_ReturnsEmptyString() {
        String result = charSetUtils.keep("hello", "");
        assertEquals("", result);
    }

    @Test
    void testKeep_StringToKeepCharactersFrom_ReturnsModifiedString() {
        String result = charSetUtils.keep("hello", "hl");
        assertEquals("hll", result);
    }

    @Test
    void testKeep_StringToKeepCharactersFrom_ReturnsModifiedString2() {
        String result = charSetUtils.keep("hello", "le");
        assertEquals("ell", result);
    }
}