import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toIntegerObjectTest {

    @Test
    void testToIntegerObject_true() {
        Boolean bool = true;
        Integer expected = 1;
        Integer result = BooleanUtils.toIntegerObject(bool);
        assertEquals(expected, result);
    }
    
    @Test
    void testToIntegerObject_false() {
        Boolean bool = false;
        Integer expected = 0;
        Integer result = BooleanUtils.toIntegerObject(bool);
        assertEquals(expected, result);
    }
    
    @Test
    void testToIntegerObject_null() {
        Boolean bool = null;
        Integer expected = null;
        Integer result = BooleanUtils.toIntegerObject(bool);
        assertEquals(expected, result);
    }
    
    @Test
    void testToIntegerObject_trueValue_falseValue() {
        Boolean bool = true;
        Integer trueValue = 10;
        Integer falseValue = 20;
        Integer expected = 10;
        Integer result = BooleanUtils.toIntegerObject(bool, trueValue, falseValue);
        assertEquals(expected, result);
    }
    
    @Test
    void testToIntegerObject_falseValue_trueValue() {
        Boolean bool = false;
        Integer trueValue = 10;
        Integer falseValue = 20;
        Integer expected = 20;
        Integer result = BooleanUtils.toIntegerObject(bool, trueValue, falseValue);
        assertEquals(expected, result);
    }
    
    @Test
    void testToIntegerObject_nullValue() {
        Boolean bool = null;
        Integer trueValue = 10;
        Integer falseValue = 20;
        Integer nullValue = 30;
        Integer expected = 30;
        Integer result = BooleanUtils.toIntegerObject(bool, trueValue, falseValue, nullValue);
        assertEquals(expected, result);
    }
}