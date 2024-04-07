import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class equalsTest {

    private MutableObject<Integer> mutableObject1;
    private MutableObject<Integer> mutableObject2;
    private MutableObject<Integer> mutableObject3;
    private MutableObject<String> mutableObject4;

    @BeforeEach
    void setUp() {
        mutableObject1 = new MutableObject<>(1);
        mutableObject2 = new MutableObject<>(1);
        mutableObject3 = new MutableObject<>(2);
        mutableObject4 = new MutableObject<>("Hello");
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(mutableObject1.equals(mutableObject1));
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(mutableObject1.equals(null));
    }

    @Test
    void testEquals_DifferentClassObject() {
        assertFalse(mutableObject1.equals("Hello"));
    }

    @Test
    void testEquals_EqualObjects() {
        assertTrue(mutableObject1.equals(mutableObject2));
    }

    @Test
    void testEquals_DifferentValueObjects() {
        assertFalse(mutableObject1.equals(mutableObject3));
    }

    @Test
    void testEquals_DifferentTypeObjects() {
        assertFalse(mutableObject1.equals(mutableObject4));
    }
}