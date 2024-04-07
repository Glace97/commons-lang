import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class equalsTest {

    @Test
    void testEqualsSameObject() {
        MutableShort ms1 = new MutableShort((short) 5);
        assertTrue(ms1.equals(ms1));
    }

    @Test
    void testEqualsNullObject() {
        MutableShort ms1 = new MutableShort((short) 5);
        assertFalse(ms1.equals(null));
    }

    @Test
    void testEqualsDifferentClass() {
        MutableShort ms1 = new MutableShort((short) 5);
        assertFalse(ms1.equals("test"));
    }

    @Test
    void testEqualsDifferentValue() {
        MutableShort ms1 = new MutableShort((short) 5);
        MutableShort ms2 = new MutableShort((short) 10);
        assertFalse(ms1.equals(ms2));
    }

    @Test
    void testEqualsSameValue() {
        MutableShort ms1 = new MutableShort((short) 5);
        MutableShort ms2 = new MutableShort((short) 5);
        assertTrue(ms1.equals(ms2));
    }

    @Test
    void testEqualsObjectWithDifferentType() {
        MutableShort ms1 = new MutableShort((short) 5);
        Integer integer = 5;
        assertFalse(ms1.equals(integer));
    }
}