import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getValueTest {

    @Test
    void testGetValue() {
        MutableInt mutableInt = new MutableInt(5);
        Assertions.assertEquals(5, mutableInt.getValue());
    }
    
    @Test
    void testGetValueWithZero() {
        MutableInt mutableInt = new MutableInt(0);
        Assertions.assertEquals(0, mutableInt.getValue());
    }
    
    @Test
    void testGetValueWithNegativeValue() {
        MutableInt mutableInt = new MutableInt(-5);
        Assertions.assertEquals(-5, mutableInt.getValue());
    }
    
    @Test
    void testGetValueWithMaxIntegerValue() {
        MutableInt mutableInt = new MutableInt(Integer.MAX_VALUE);
        Assertions.assertEquals(Integer.MAX_VALUE, mutableInt.getValue());
    }
    
    @Test
    void testGetValueWithMinIntegerValue() {
        MutableInt mutableInt = new MutableInt(Integer.MIN_VALUE);
        Assertions.assertEquals(Integer.MIN_VALUE, mutableInt.getValue());
    }
    
    @Test
    void testGetValueWithNullValue() {
        MutableInt mutableInt = new MutableInt((Number) null);
        Assertions.assertThrows(NullPointerException.class, mutableInt::getValue);
    }
    
    @Test
    void testGetValueWithEmptyStringValue() {
        MutableInt mutableInt = new MutableInt("");
        Assertions.assertThrows(NumberFormatException.class, mutableInt::getValue);
    }
    
    @Test
    void testGetValueWithNonNumericStringValue() {
        MutableInt mutableInt = new MutableInt("abc");
        Assertions.assertThrows(NumberFormatException.class, mutableInt::getValue);
    }
    
    @Test
    void testGetValueWithValidStringValue() {
        MutableInt mutableInt = new MutableInt("10");
        Assertions.assertEquals(10, mutableInt.getValue());
    }
}