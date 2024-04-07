import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getAndAddTest {
    
    @Test
    void testGetAndAdd_double() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        double result = mutableDouble.getAndAdd(2.5);
        Assertions.assertEquals(5.0, result);
        Assertions.assertEquals(7.5, mutableDouble.getValue());
    }
    
    @Test
    void testGetAndAdd_double_negative() {
        MutableDouble mutableDouble = new MutableDouble(-3.0);
        double result = mutableDouble.getAndAdd(-1.5);
        Assertions.assertEquals(-3.0, result);
        Assertions.assertEquals(-4.5, mutableDouble.getValue());
    }
    
    @Test
    void testGetAndAdd_double_zero() {
        MutableDouble mutableDouble = new MutableDouble(0.0);
        double result = mutableDouble.getAndAdd(1.0);
        Assertions.assertEquals(0.0, result);
        Assertions.assertEquals(1.0, mutableDouble.getValue());
    }
    
    @Test
    void testGetAndAdd_Number() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        double result = mutableDouble.getAndAdd(2.5);
        Assertions.assertEquals(5.0, result);
        Assertions.assertEquals(7.5, mutableDouble.getValue());
    }
    
    @Test
    void testGetAndAdd_Number_negative() {
        MutableDouble mutableDouble = new MutableDouble(-3.0);
        double result = mutableDouble.getAndAdd(-1.5);
        Assertions.assertEquals(-3.0, result);
        Assertions.assertEquals(-4.5, mutableDouble.getValue());
    }
    
    @Test
    void testGetAndAdd_Number_zero() {
        MutableDouble mutableDouble = new MutableDouble(0.0);
        double result = mutableDouble.getAndAdd(1.0);
        Assertions.assertEquals(0.0, result);
        Assertions.assertEquals(1.0, mutableDouble.getValue());
    }
    
    @Test
    void testGetAndAdd_Number_null() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        Assertions.assertThrows(NullPointerException.class, () -> {
            mutableDouble.getAndAdd(null);
        });
    }
    
    @Test
    void testGetAndAdd_String() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        double result = mutableDouble.getAndAdd("2.5");
        Assertions.assertEquals(5.0, result);
        Assertions.assertEquals(7.5, mutableDouble.getValue());
    }
    
    @Test
    void testGetAndAdd_String_negative() {
        MutableDouble mutableDouble = new MutableDouble(-3.0);
        double result = mutableDouble.getAndAdd("-1.5");
        Assertions.assertEquals(-3.0, result);
        Assertions.assertEquals(-4.5, mutableDouble.getValue());
    }
    
    @Test
    void testGetAndAdd_String_zero() {
        MutableDouble mutableDouble = new MutableDouble(0.0);
        double result = mutableDouble.getAndAdd("1.0");
        Assertions.assertEquals(0.0, result);
        Assertions.assertEquals(1.0, mutableDouble.getValue());
    }
    
    @Test
    void testGetAndAdd_String_invalidFormat() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        Assertions.assertThrows(NumberFormatException.class, () -> {
            mutableDouble.getAndAdd("abc");
        });
    }
    
}