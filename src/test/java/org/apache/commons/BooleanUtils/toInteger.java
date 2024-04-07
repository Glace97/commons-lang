import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class toIntegerTest {
    
    @Test
    void testToIntegerTrue() {
        boolean bool = true;
        int expected = 1;
        int actual = BooleanUtils.toInteger(bool);
        assertEquals(expected, actual);
    }
    
    @Test
    void testToIntegerFalse() {
        boolean bool = false;
        int expected = 0;
        int actual = BooleanUtils.toInteger(bool);
        assertEquals(expected, actual);
    }
    
    @Test
    void testToIntegerTrueWithValues() {
        boolean bool = true;
        int trueValue = 1;
        int falseValue = -1;
        int expected = 1;
        int actual = BooleanUtils.toInteger(bool, trueValue, falseValue);
        assertEquals(expected, actual);
    }
    
    @Test
    void testToIntegerFalseWithValues() {
        boolean bool = false;
        int trueValue = 1;
        int falseValue = -1;
        int expected = -1;
        int actual = BooleanUtils.toInteger(bool, trueValue, falseValue);
        assertEquals(expected, actual);
    }
    
    @Test
    void testToIntegerTrueWithValuesAndNull() {
        Boolean bool = Boolean.TRUE;
        int trueValue = 1;
        int falseValue = -1;
        int nullValue = 0;
        int expected = 1;
        int actual = BooleanUtils.toInteger(bool, trueValue, falseValue, nullValue);
        assertEquals(expected, actual);
    }
    
    @Test
    void testToIntegerFalseWithValuesAndNull() {
        Boolean bool = Boolean.FALSE;
        int trueValue = 1;
        int falseValue = -1;
        int nullValue = 0;
        int expected = -1;
        int actual = BooleanUtils.toInteger(bool, trueValue, falseValue, nullValue);
        assertEquals(expected, actual);
    }
    
    @Test
    void testToIntegerNullWithValuesAndNull() {
        Boolean bool = null;
        int trueValue = 1;
        int falseValue = -1;
        int nullValue = 0;
        int expected = 0;
        int actual = BooleanUtils.toInteger(bool, trueValue, falseValue, nullValue);
        assertEquals(expected, actual);
    }
}