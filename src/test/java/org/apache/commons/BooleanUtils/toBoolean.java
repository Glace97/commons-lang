import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toBooleanTest {
    
    @Test
    void testToBooleanWithBoolean() {
        assertFalse(BooleanUtils.toBoolean(null));
        assertTrue(BooleanUtils.toBoolean(Boolean.TRUE));
        assertFalse(BooleanUtils.toBoolean(Boolean.FALSE));
    }
    
    @Test
    void testToBooleanWithInt() {
        assertFalse(BooleanUtils.toBoolean(0));
        assertTrue(BooleanUtils.toBoolean(1));
        assertTrue(BooleanUtils.toBoolean(2));
    }
    
    @Test
    void testToBooleanWithIntAndValues() {
        assertFalse(BooleanUtils.toBoolean(0, 1, 0));
        assertTrue(BooleanUtils.toBoolean(1, 1, 0));
        assertTrue(BooleanUtils.toBoolean(1, 1, 1));
        assertFalse(BooleanUtils.toBoolean(2, 1, 2));
        assertTrue(BooleanUtils.toBoolean(2, 2, 0));
    }
    
    @Test
    void testToBooleanWithIntegerAndValues() {
        assertFalse(BooleanUtils.toBoolean(null, null, 0));
        assertFalse(BooleanUtils.toBoolean(0, null, 0));
        assertTrue(BooleanUtils.toBoolean(1, null, 0));
        assertFalse(BooleanUtils.toBoolean(2, null, 0));
        assertFalse(BooleanUtils.toBoolean(null, 1, 0));
        assertTrue(BooleanUtils.toBoolean(1, 1, 0));
        assertFalse(BooleanUtils.toBoolean(2, 1, 0));
        assertFalse(BooleanUtils.toBoolean(null, 1, 2));
        assertFalse(BooleanUtils.toBoolean(0, 1, 2));
        assertTrue(BooleanUtils.toBoolean(2, 1, 2));
    }
    
    @Test
    void testToBooleanWithString() {
        assertFalse(BooleanUtils.toBoolean(null));
        assertTrue(BooleanUtils.toBoolean("true"));
        assertTrue(BooleanUtils.toBoolean("TRUE"));
        assertTrue(BooleanUtils.toBoolean("tRUe"));
        assertTrue(BooleanUtils.toBoolean("on"));
        assertTrue(BooleanUtils.toBoolean("yes"));
        assertFalse(BooleanUtils.toBoolean("false"));
        assertFalse(BooleanUtils.toBoolean("x gti"));
        assertTrue(BooleanUtils.toBoolean("y"));
        assertFalse(BooleanUtils.toBoolean("n"));
        assertTrue(BooleanUtils.toBoolean("t"));
        assertFalse(BooleanUtils.toBoolean("f"));
    }
    
    @Test
    void testToBooleanWithStringAndValues() {
        assertTrue(BooleanUtils.toBoolean("true", "true", "false"));
        assertFalse(BooleanUtils.toBoolean("false", "true", "false"));
    }
}