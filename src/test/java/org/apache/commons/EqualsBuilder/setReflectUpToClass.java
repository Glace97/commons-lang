import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setReflectUpToClassTest {
    
    @Test
    void testSetReflectUpToClass() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        
        // Test setting reflectUpToClass to null
        equalsBuilder.setReflectUpToClass(null);
        assertNull(equalsBuilder.reflectUpToClass);
        
        // Test setting reflectUpToClass to a class
        Class<?> testClass = String.class;
        equalsBuilder.setReflectUpToClass(testClass);
        assertEquals(testClass, equalsBuilder.reflectUpToClass);
    }
    
}