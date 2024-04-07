import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
public class equalsTest {

    private IDKey idKey1;
    private IDKey idKey2;
    private IDKey idKey3;
    private IDKey idKey4;
    private Object obj1;
    private Object obj2;

    @BeforeEach
    void setup() {
        obj1 = new Object();
        obj2 = new Object();
        idKey1 = new IDKey(obj1);
        idKey2 = new IDKey(obj1);
        idKey3 = new IDKey(obj2);
        idKey4 = new IDKey(obj2);
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(idKey1.equals(idKey1));
    }

    @Test
    void testEqualsNull() {
        assertFalse(idKey1.equals(null));
    }

    @Test
    void testEqualsDifferentClass() {
        assertFalse(idKey1.equals(obj1));
    }

    @Test
    void testEqualsDifferentID() {
        assertFalse(idKey1.equals(idKey3));
    }

    @Test
    void testEqualsSameIDDifferentValue() {
        assertFalse(idKey1.equals(idKey2));
    }

    @Test
    void testEqualsSameIDSameValue() {
        assertTrue(idKey3.equals(idKey4));
    }
}