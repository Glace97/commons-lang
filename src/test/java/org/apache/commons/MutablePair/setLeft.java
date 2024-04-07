import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class setLeftTest {
    
    private MutablePair<String, Integer> pair;
    
    @BeforeEach
    void setUp() {
        pair = new MutablePair<>("Hello", 5);
    }
    
    @Test
    void testSetLeft() {
        pair.setLeft(null);
        assertNull(pair.left);
        
        pair.setLeft("World");
        assertEquals("World", pair.left);
    }
}