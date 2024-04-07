import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class doubleValueTest {

    private MutableInt mutableInt;

    @Test
    void testDoubleValue() {
        mutableInt = new MutableInt(0);
        assertEquals(0.0, mutableInt.doubleValue());
        
        mutableInt = new MutableInt(10);
        assertEquals(10.0, mutableInt.doubleValue());
        
        mutableInt = new MutableInt(-5);
        assertEquals(-5.0, mutableInt.doubleValue());
        
        mutableInt = new MutableInt(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, mutableInt.doubleValue());
        
        mutableInt = new MutableInt(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, mutableInt.doubleValue());
    }
    
    @Test
    void testDoubleValueFromString() {
        mutableInt = new MutableInt("0");
        assertEquals(0.0, mutableInt.doubleValue());
        
        mutableInt = new MutableInt("10");
        assertEquals(10.0, mutableInt.doubleValue());
        
        mutableInt = new MutableInt("-5");
        assertEquals(-5.0, mutableInt.doubleValue());
        
        mutableInt = new MutableInt(String.valueOf(Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, mutableInt.doubleValue());
        
        mutableInt = new MutableInt(String.valueOf(Integer.MIN_VALUE));
        assertEquals(Integer.MIN_VALUE, mutableInt.doubleValue());
    }
    
    @Test
    void testDoubleValueFromNumber() {
        mutableInt = new MutableInt(NumberUtils.createNumber("0"));
        assertEquals(0.0, mutableInt.doubleValue());
        
        mutableInt = new MutableInt(NumberUtils.createNumber("10"));
        assertEquals(10.0, mutableInt.doubleValue());
        
        mutableInt = new MutableInt(NumberUtils.createNumber("-5"));
        assertEquals(-5.0, mutableInt.doubleValue());
        
        mutableInt = new MutableInt(NumberUtils.createNumber(String.valueOf(Integer.MAX_VALUE)));
        assertEquals(Integer.MAX_VALUE, mutableInt.doubleValue());
        
        mutableInt = new MutableInt(NumberUtils.createNumber(String.valueOf(Integer.MIN_VALUE)));
        assertEquals(Integer.MIN_VALUE, mutableInt.doubleValue());
    }
}