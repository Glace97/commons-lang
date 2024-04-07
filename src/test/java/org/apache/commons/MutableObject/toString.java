import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toStringTest {

    @Test
    void testToString_NullValue() {
        MutableObject obj = new MutableObject(null);
        assertEquals("null", obj.toString());
    }
    
    @Test
    void testToString_NonNullValue() {
        MutableObject obj = new MutableObject("Hello");
        assertEquals("Hello", obj.toString());
    }
    
    @Test
    void testToString_EmptyString() {
        MutableObject obj = new MutableObject("");
        assertEquals("", obj.toString());
    }
    
    @Test
    void testToString_NumberValue() {
        MutableObject obj = new MutableObject(123);
        assertEquals("123", obj.toString());
    }
    
    @Test
    void testToString_BooleanValue() {
        MutableObject obj = new MutableObject(true);
        assertEquals("true", obj.toString());
    }
    
    @Test
    void testToString_CustomObject() {
        CustomObject customObj = new CustomObject();
        MutableObject obj = new MutableObject(customObj);
        assertEquals(customObj.toString(), obj.toString());
    }
}