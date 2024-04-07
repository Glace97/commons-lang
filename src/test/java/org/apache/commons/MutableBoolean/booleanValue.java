import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class booleanValueTest {
    
    private MutableBoolean mutableBooleanTrue;
    private MutableBoolean mutableBooleanFalse;
    
    @BeforeEach
    void setUp() {
        mutableBooleanTrue = new MutableBoolean(true);
        mutableBooleanFalse = new MutableBoolean(false);
    }
    
    @Test
    void testBooleanValue() {
        assertTrue(mutableBooleanTrue.booleanValue());
        assertFalse(mutableBooleanFalse.booleanValue());
    }
    
    @Test
    void testBooleanValueWithNullValue() {
        assertThrows(NullPointerException.class, () -> {
            MutableBoolean mutableBoolean = new MutableBoolean(null);
            mutableBoolean.booleanValue();
        });
    }
    
}