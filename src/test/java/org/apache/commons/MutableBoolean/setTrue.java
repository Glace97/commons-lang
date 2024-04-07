import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class setTrueTest {
    
    @Test
    void testSetTrue() {
        MutableBoolean mutableBoolean = new MutableBoolean();
        mutableBoolean.setTrue();
        assertEquals(true, mutableBoolean.getValue(), "Value should be true");
    }
    
    @Test
    void testSetTrueWithExistingValue() {
        MutableBoolean mutableBoolean = new MutableBoolean(false);
        mutableBoolean.setTrue();
        assertEquals(true, mutableBoolean.getValue(), "Value should be true");
    }
    
    @Test
    void testSetTrueWithNullValue() {
        MutableBoolean mutableBoolean = new MutableBoolean((Boolean) null);
        mutableBoolean.setTrue();
        assertEquals(true, mutableBoolean.getValue(), "Value should be true");
    }
}