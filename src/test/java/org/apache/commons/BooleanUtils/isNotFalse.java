import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class isNotFalseTest {
    
    @Test
    void testNotNullTrue() {
        Boolean bool = Boolean.TRUE;
        boolean result = BooleanUtils.isNotFalse(bool);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testNotNullFalse() {
        Boolean bool = Boolean.FALSE;
        boolean result = BooleanUtils.isNotFalse(bool);
        Assertions.assertFalse(result);
    }
    
    @Test
    void testNull() {
        Boolean bool = null;
        boolean result = BooleanUtils.isNotFalse(bool);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testStringTrue() {
        Boolean bool = BooleanUtils.TRUE;
        boolean result = BooleanUtils.isNotFalse(bool);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testStringFalse() {
        Boolean bool = BooleanUtils.FALSE;
        boolean result = BooleanUtils.isNotFalse(bool);
        Assertions.assertFalse(result);
    }
    
    @Test
    void testStringNo() {
        Boolean bool = BooleanUtils.NO;
        boolean result = BooleanUtils.isNotFalse(bool);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testStringOff() {
        Boolean bool = BooleanUtils.OFF;
        boolean result = BooleanUtils.isNotFalse(bool);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testStringOn() {
        Boolean bool = BooleanUtils.ON;
        boolean result = BooleanUtils.isNotFalse(bool);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testStringYes() {
        Boolean bool = BooleanUtils.YES;
        boolean result = BooleanUtils.isNotFalse(bool);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testInvalidString() {
        Boolean bool = "invalid";
        boolean result = BooleanUtils.isNotFalse(bool);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testNumericValue() {
        Boolean bool = NumberUtils.createBoolean("1");
        boolean result = BooleanUtils.isNotFalse(bool);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testEmptyList() {
        Boolean bool = Collections.emptyList();
        boolean result = BooleanUtils.isNotFalse(bool);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testNonEmptyList() {
        List<Boolean> bool = Arrays.asList(Boolean.TRUE, Boolean.FALSE);
        boolean result = BooleanUtils.isNotFalse(bool);
        Assertions.assertTrue(result);
    }
}