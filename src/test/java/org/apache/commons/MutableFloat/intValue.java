import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class intValueTest {
    
    private MutableFloat mutableFloat;
    
    @BeforeEach
    public void setup() {
        mutableFloat = new MutableFloat();
    }
    
    @Test
    public void testIntValueWithZero() {
        mutableFloat = new MutableFloat(0);
        assertEquals(0, mutableFloat.intValue());
    }
    
    @Test
    public void testIntValueWithPositiveValue() {
        mutableFloat = new MutableFloat(10.5f);
        assertEquals(10, mutableFloat.intValue());
    }
    
    @Test
    public void testIntValueWithNegativeValue() {
        mutableFloat = new MutableFloat(-5.75f);
        assertEquals(-5, mutableFloat.intValue());
    }
    
    @Test
    public void testIntValueWithMaxValue() {
        mutableFloat = new MutableFloat(Float.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, mutableFloat.intValue());
    }
    
    @Test
    public void testIntValueWithMinValue() {
        mutableFloat = new MutableFloat(Float.MIN_VALUE);
        assertEquals(0, mutableFloat.intValue());
    }
    
    @Test
    public void testIntValueWithNullValue() {
        mutableFloat = new MutableFloat((Number) null);
        assertEquals(0, mutableFloat.intValue());
    }
    
    @Test
    public void testIntValueWithStringValue() {
        mutableFloat = new MutableFloat("10.5");
        assertEquals(10, mutableFloat.intValue());
    }
    
    @Test
    public void testIntValueWithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> new MutableFloat("abc").intValue());
    }
    
}