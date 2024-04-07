import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class appendAsObjectToStringTest {

    @Test
    void testAppendAsObjectToString() {
        Object obj = new Object();
        ToStringBuilder builder = new ToStringBuilder(obj);
        
        builder.appendAsObjectToString(obj);
        
        String expected = obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
        String actual = builder.getStringBuffer().toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testAppendAsObjectToString_NullObject() {
        ToStringBuilder builder = new ToStringBuilder(null);
        
        builder.appendAsObjectToString(null);
        
        String expected = "null";
        String actual = builder.getStringBuffer().toString();
        
        assertEquals(expected, actual);
    }
    
    @Test
    void testAppendAsObjectToString_CustomStyle() {
        Object obj = new Object();
        ToStringStyle style = new ToStringStyle() {
            @Override
            public void appendStart(StringBuffer buffer, Object object) {
                buffer.append("Object: ");
            }
        };
        ToStringBuilder builder = new ToStringBuilder(obj, style);
        
        builder.appendAsObjectToString(obj);
        
        String expected = "Object: " + obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
        String actual = builder.getStringBuffer().toString();
        
        assertEquals(expected, actual);
    }
}