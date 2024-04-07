import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isRegisteredTest {

    private HashCodeBuilder hashCodeBuilder;

    @BeforeEach
    void setUp() {
        hashCodeBuilder = new HashCodeBuilder();
    }

    @Test
    void testIsRegisteredWithNullValue() {
        assertFalse(HashCodeBuilder.isRegistered(null));
    }
    
    @Test
    void testIsRegisteredWithNonRegisteredObject() {
        assertFalse(HashCodeBuilder.isRegistered(new Object()));
    }
    
    @Test
    void testIsRegisteredWithRegisteredObject() {
        Object obj = new Object();
        Set<IDKey> registry = HashCodeBuilder.getRegistry();
        registry.add(new IDKey(obj));
        
        assertTrue(HashCodeBuilder.isRegistered(obj));
    }
}