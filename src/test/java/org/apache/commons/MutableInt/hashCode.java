import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hashCodeTest {
    
    @Test
    void testHashCode() {
        MutableInt mutableInt1 = new MutableInt();
        MutableInt mutableInt2 = new MutableInt(0);
        MutableInt mutableInt3 = new MutableInt(10);
        MutableInt mutableInt4 = new MutableInt(100);
        MutableInt mutableInt5 = new MutableInt(NumberUtils.INTEGER_ONE);
        MutableInt mutableInt6 = new MutableInt(NumberUtils.INTEGER_MINUS_ONE);
        MutableInt mutableInt7 = new MutableInt("50");
        MutableInt mutableInt8 = new MutableInt("-50");
        
        // Test equality of hash codes
        assertEquals(mutableInt1.hashCode(), mutableInt2.hashCode());
        assertNotEquals(mutableInt1.hashCode(), mutableInt3.hashCode());
        
        // Test hash code consistency
        assertEquals(mutableInt1.hashCode(), mutableInt1.hashCode());
        
        // Test hash code distribution
        assertNotEquals(mutableInt3.hashCode(), mutableInt4.hashCode());
        
        // Test hash code with different initial values
        assertEquals(mutableInt5.hashCode(), mutableInt6.hashCode());
        assertNotEquals(mutableInt7.hashCode(), mutableInt8.hashCode());
    }
}