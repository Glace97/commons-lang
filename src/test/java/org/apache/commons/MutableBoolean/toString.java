import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class toStringTest {
    
    @Test
    void testToStringWithTrueValue() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        assertEquals("true", mutableBoolean.toString());
    }
    
    @Test
    void testToStringWithFalseValue() {
        MutableBoolean mutableBoolean = new MutableBoolean(false);
        assertEquals("false", mutableBoolean.toString());
    }
    
    @Test
    void testToStringWithNullValue() {
        MutableBoolean mutableBoolean = new MutableBoolean((Boolean) null);
        assertEquals("false", mutableBoolean.toString());
    }
    
    @Test
    void testToStringWithNonNullValue() {
        MutableBoolean mutableBoolean = new MutableBoolean(Boolean.TRUE);
        assertEquals("true", mutableBoolean.toString());
    }
    
}