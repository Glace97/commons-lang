import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class addAndGetTest {
    
    private MutableDouble mutableDouble;
    
    @BeforeEach
    public void setUp() {
        mutableDouble = new MutableDouble(5.0);
    }
    
    @Test
    public void testAddAndGetWithDoubleOperand() {
        double result = mutableDouble.addAndGet(2.5);
        Assertions.assertEquals(7.5, result);
    }
    
    @Test
    public void testAddAndGetWithIntegerOperand() {
        double result = mutableDouble.addAndGet(10);
        Assertions.assertEquals(15.0, result);
    }
    
    @Test
    public void testAddAndGetWithNegativeOperand() {
        double result = mutableDouble.addAndGet(-3.0);
        Assertions.assertEquals(2.0, result);
    }
    
    @Test
    public void testAddAndGetWithZeroOperand() {
        double result = mutableDouble.addAndGet(0.0);
        Assertions.assertEquals(5.0, result);
    }
    
    @Test
    public void testAddAndGetWithNullOperand() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            mutableDouble.addAndGet(null);
        });
    }
    
    @Test
    public void testAddAndGetWithLargeOperand() {
        double result = mutableDouble.addAndGet(Double.MAX_VALUE);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, result);
    }
    
    @Test
    public void testAddAndGetWithSmallOperand() {
        double result = mutableDouble.addAndGet(Double.MIN_VALUE);
        Assertions.assertEquals(5.0 + Double.MIN_VALUE, result);
    }
    
    @Test
    public void testAddAndGetWithStringOperand() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            mutableDouble.addAndGet("abc");
        });
    }
    
}
