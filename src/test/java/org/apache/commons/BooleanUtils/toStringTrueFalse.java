import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class toStringTrueFalseTest {
    
    private BooleanUtils booleanUtils;
    
    @BeforeEach
    void setUp() {
        booleanUtils = new BooleanUtils();
    }
    
    @Test
    void testToStringTrueFalse_withTrueBoolean_shouldReturnTrue() {
        boolean bool = true;
        String expected = "true";
        
        String result = booleanUtils.toStringTrueFalse(bool);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testToStringTrueFalse_withFalseBoolean_shouldReturnFalse() {
        boolean bool = false;
        String expected = "false";
        
        String result = booleanUtils.toStringTrueFalse(bool);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testToStringTrueFalse_withTrueBooleanObject_shouldReturnTrue() {
        Boolean bool = Boolean.TRUE;
        String expected = "true";
        
        String result = booleanUtils.toStringTrueFalse(bool);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testToStringTrueFalse_withFalseBooleanObject_shouldReturnFalse() {
        Boolean bool = Boolean.FALSE;
        String expected = "false";
        
        String result = booleanUtils.toStringTrueFalse(bool);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testToStringTrueFalse_withNullBooleanObject_shouldReturnNull() {
        Boolean bool = null;
        String expected = null;
        
        String result = booleanUtils.toStringTrueFalse(bool);
        
        assertEquals(expected, result);
    }
    
}