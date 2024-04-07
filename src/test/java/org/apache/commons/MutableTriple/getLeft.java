import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getLeftTest {

    private MutableTriple<String, Integer, Double> triple;

    @BeforeEach
    void setUp() {
        triple = new MutableTriple<>("left", 10, 3.14);
    }

    @Test
    void testGetLeft() {
        assertEquals("left", triple.getLeft());
    }

    @Test
    void testGetLeft_Null() {
        triple = new MutableTriple<>(null, 10, 3.14);
        assertNull(triple.getLeft());
    }
    
    @Test
    void testGetLeft_EdgeCase() {
        triple = new MutableTriple<>("left", 10, 3.14);
        assertNotNull(triple.getLeft());
    }
    
    @Test
    void testGetLeft_CustomObject() {
        CustomObject leftObject = new CustomObject();
        triple = new MutableTriple<>(leftObject, 10, 3.14);
        assertSame(leftObject, triple.getLeft());
    }

    class CustomObject {
        // Custom Object implementation
    }
}