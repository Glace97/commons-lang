import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setFieldNameValueSeparatorTest {
    
    private StandardToStringStyle style;
    
    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }
    
    @Test
    void testSetFieldNameValueSeparator() {
        // Test with non-null separator
        style.setFieldNameValueSeparator(":");
        assertEquals(":", style.getFieldNameValueSeparator());
        
        // Test with null separator
        style.setFieldNameValueSeparator(null);
        assertEquals("", style.getFieldNameValueSeparator());
    }
}