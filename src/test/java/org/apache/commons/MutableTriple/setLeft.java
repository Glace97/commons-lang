import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class setLeftTest {
    private MutableTriple<Integer, String, Double> triple;

    @BeforeEach
    void setUp() {
        triple = new MutableTriple<>(1, "abc", 3.14);
    }
    
    @Test
    void testSetLeft() {
        triple.setLeft(2);
        Assertions.assertEquals(2, triple.left);
    }
    
    @Test
    void testSetLeftNull() {
        triple.setLeft(null);
        Assertions.assertNull(triple.left);
    }
    
    @Test
    void testSetLeftTwice() {
        triple.setLeft(2);
        triple.setLeft(3);
        Assertions.assertEquals(3, triple.left);
    }
}