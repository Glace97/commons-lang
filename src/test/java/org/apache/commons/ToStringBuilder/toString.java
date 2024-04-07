import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToStringTest {
    
    @Test
    void testToStringWithNullObject() {
        ToStringBuilder builder = new ToStringBuilder(null);
        assertEquals("null", builder.toString());
    }
    
    @Test
    void testToStringWithNonNullObject() {
        ToStringBuilder builder = new ToStringBuilder("Hello", ToStringStyle.SHORT_PREFIX_STYLE);
        assertEquals("Hello", builder.toString());
    }
    
    @Test
    void testToStringWithDefaultStyle() {
        ToStringBuilder builder = new ToStringBuilder("Hello");
        assertEquals("Hello", builder.toString());
    }
    
    @Test
    void testToStringWithCustomStyle() {
        ToStringStyle customStyle = new ToStringStyle() {
            @Override
            public void appendStart(StringBuffer buffer, Object object) {
                buffer.append("Start: ");
            }

            @Override
            public void appendEnd(StringBuffer buffer, Object object) {
                buffer.append(" End");
            }
        };
        
        ToStringBuilder builder = new ToStringBuilder("Hello", customStyle);
        assertEquals("Start: Hello End", builder.toString());
    }
}