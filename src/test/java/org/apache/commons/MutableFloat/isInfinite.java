import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isInfiniteTest {

    @Test
    void testIsInfiniteReturnsTrueForPositiveInfinity() {
        MutableFloat mutableFloat = new MutableFloat(Float.POSITIVE_INFINITY);
        assertTrue(mutableFloat.isInfinite());
    }
    
    @Test
    void testIsInfiniteReturnsTrueForNegativeInfinity() {
        MutableFloat mutableFloat = new MutableFloat(Float.NEGATIVE_INFINITY);
        assertTrue(mutableFloat.isInfinite());
    }
    
    @Test
    void testIsInfiniteReturnsFalseForNormalFloatValue() {
        MutableFloat mutableFloat = new MutableFloat(10.5f);
        assertFalse(mutableFloat.isInfinite());
    }
    
    @Test
    void testIsInfiniteReturnsFalseForZeroValue() {
        MutableFloat mutableFloat = new MutableFloat(0f);
        assertFalse(mutableFloat.isInfinite());
    }
    
    @Test
    void testIsInfiniteReturnsFalseForNaNValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.NaN);
        assertFalse(mutableFloat.isInfinite());
    }
    
    @Test
    void testIsInfiniteReturnsTrueForStringRepresentationOfPositiveInfinity() {
        MutableFloat mutableFloat = new MutableFloat("Infinity");
        assertTrue(mutableFloat.isInfinite());
    }
    
    @Test
    void testIsInfiniteReturnsTrueForStringRepresentationOfNegativeInfinity() {
        MutableFloat mutableFloat = new MutableFloat("-Infinity");
        assertTrue(mutableFloat.isInfinite());
    }
    
    @Test
    void testIsInfiniteThrowsNumberFormatExceptionForInvalidStringRepresentation() {
        assertThrows(NumberFormatException.class, () -> {
            MutableFloat mutableFloat = new MutableFloat("abc");
            mutableFloat.isInfinite();
        });
    }
    
    @Test
    void testIsInfiniteReturnsFalseForNullNumberValue() {
        MutableFloat mutableFloat = new MutableFloat((Number) null);
        assertFalse(mutableFloat.isInfinite());
    }
    
    @Test
    void testIsInfiniteReturnsFalseForNullStringValue() {
        MutableFloat mutableFloat = new MutableFloat((String) null);
        assertFalse(mutableFloat.isInfinite());
    }
    
}