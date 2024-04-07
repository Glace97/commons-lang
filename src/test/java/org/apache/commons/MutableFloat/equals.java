import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EqualsTest {
    
    private MutableFloat mutableFloat;
    
    @BeforeEach
    void setUp() {
        mutableFloat = new MutableFloat(5.0f);
    }
    
    @Test
    @DisplayName("Test equals method with same MutableFloat object")
    void testEqualsWithSameObject() {
        assertTrue(mutableFloat.equals(mutableFloat));
    }
    
    @Test
    @DisplayName("Test equals method with null object")
    void testEqualsWithNull() {
        assertFalse(mutableFloat.equals(null));
    }
    
    @Test
    @DisplayName("Test equals method with different class object")
    void testEqualsWithDifferentClassObject() {
        assertFalse(mutableFloat.equals("5.0"));
    }
    
    @Test
    @DisplayName("Test equals method with MutableFloat object having different value")
    void testEqualsWithDifferentValue() {
        MutableFloat other = new MutableFloat(10.0f);
        assertFalse(mutableFloat.equals(other));
    }
    
    @Test
    @DisplayName("Test equals method with MutableFloat object having same value")
    void testEqualsWithSameValue() {
        MutableFloat other = new MutableFloat(5.0f);
        assertTrue(mutableFloat.equals(other));
    }
    
    @Test
    @DisplayName("Test equals method with MutableFloat object having NaN value")
    void testEqualsWithNaNValue() {
        MutableFloat nanFloat = new MutableFloat(Float.NaN);
        assertTrue(nanFloat.equals(nanFloat));
        
        MutableFloat other = new MutableFloat(Float.NaN);
        assertTrue(nanFloat.equals(other));
    }
    
    @Test
    @DisplayName("Test equals method with MutableFloat object having +0.0f and -0.0f values")
    void testEqualsWithZeroValues() {
        MutableFloat zeroFloat1 = new MutableFloat(0.0f);
        MutableFloat zeroFloat2 = new MutableFloat(-0.0f);
        
        assertFalse(zeroFloat1.equals(zeroFloat2));
        assertFalse(zeroFloat2.equals(zeroFloat1));
    }
    
    @Test
    @DisplayName("Test equals method with MutableFloat object having different bit pattern")
    void testEqualsWithDifferentBitPattern() {
        MutableFloat float1 = new MutableFloat(Float.intBitsToFloat(1234567));
        MutableFloat float2 = new MutableFloat(Float.intBitsToFloat(7654321));
        
        assertFalse(float1.equals(float2));
    }
}