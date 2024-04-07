import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hashCodeTest {

    @Test
    void testHashCode() {
        MutableDouble mutableDouble1 = new MutableDouble(0.0);
        MutableDouble mutableDouble2 = new MutableDouble(0.0);
        
        assertEquals(mutableDouble1.hashCode(), mutableDouble2.hashCode());
    }
    
    @Test
    void testHashCodeWithDifferentValues() {
        MutableDouble mutableDouble1 = new MutableDouble(0.0);
        MutableDouble mutableDouble2 = new MutableDouble(1.0);
        
        assertNotEquals(mutableDouble1.hashCode(), mutableDouble2.hashCode());
    }
    
    @Test
    void testHashCodeWithNullValue() {
        MutableDouble mutableDouble = new MutableDouble();
        
        assertEquals(0, mutableDouble.hashCode());
    }
    
    @Test
    void testHashCodeWithPositiveInfinity() {
        MutableDouble mutableDouble = new MutableDouble(Double.POSITIVE_INFINITY);
        
        assertEquals(2146435072, mutableDouble.hashCode());
    }
    
    @Test
    void testHashCodeWithNegativeInfinity() {
        MutableDouble mutableDouble = new MutableDouble(Double.NEGATIVE_INFINITY);
        
        assertEquals(-1048576, mutableDouble.hashCode());
    }
    
    @Test
    void testHashCodeWithNaN() {
        MutableDouble mutableDouble = new MutableDouble(Double.NaN);
        
        assertEquals(2146959360, mutableDouble.hashCode());
    }
    
    @Test
    void testHashCodeWithStringValue() {
        MutableDouble mutableDouble = new MutableDouble("2.5");
        
        assertEquals(1073217536, mutableDouble.hashCode());
    }
    
    @Test
    void testHashCodeWithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> new MutableDouble("abc"));
    }
}