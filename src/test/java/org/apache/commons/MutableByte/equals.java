import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class equalsTest {

    @Test
    void testEqualsSameObject() {
        MutableByte byte1 = new MutableByte((byte) 10);
        assertTrue(byte1.equals(byte1));
    }
    
    @Test
    void testEqualsNullObject() {
        MutableByte byte1 = new MutableByte((byte) 10);
        assertFalse(byte1.equals(null));
    }
    
    @Test
    void testEqualsDifferentClass() {
        MutableByte byte1 = new MutableByte((byte) 10);
        assertFalse(byte1.equals("10"));
    }
    
    @Test
    void testEqualsDifferentValue() {
        MutableByte byte1 = new MutableByte((byte) 10);
        MutableByte byte2 = new MutableByte((byte) 20);
        assertFalse(byte1.equals(byte2));
    }
    
    @Test
    void testEqualsSameValue() {
        MutableByte byte1 = new MutableByte((byte) 10);
        MutableByte byte2 = new MutableByte((byte) 10);
        assertTrue(byte1.equals(byte2));
    }
    
    @Test
    void testEqualsSameValueDifferentType() {
        MutableByte byte1 = new MutableByte((byte) 10);
        Byte byte2 = new Byte((byte) 10);
        assertTrue(byte1.equals(byte2));
    }
    
    @Test
    void testEqualsStringValue() {
        MutableByte byte1 = new MutableByte((byte) 10);
        assertFalse(byte1.equals("10"));
    }
    
    @Test
    void testEqualsStringObject() {
        MutableByte byte1 = new MutableByte((byte) 10);
        Object object = new Object();
        assertFalse(byte1.equals(object));
    }
}