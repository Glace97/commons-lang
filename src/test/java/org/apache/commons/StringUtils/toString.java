import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toStringTest {
    
    @Test
    void testToStringWithEmptyByteArrayAndCharset() {
        byte[] bytes = new byte[0];
        String charsetName = "UTF-8";
        
        assertDoesNotThrow(() -> {
            StringUtils.toString(bytes, charsetName);
        });
    }
    
    @Test
    void testToStringWithNonEmptyByteArrayAndCharset() {
        byte[] bytes = {72, 101, 108, 108, 111};
        String charsetName = "UTF-8";
        
        assertDoesNotThrow(() -> {
            StringUtils.toString(bytes, charsetName);
        });
    }
    
    @Test
    void testToStringWithNullByteArrayAndCharset() {
        byte[] bytes = null;
        String charsetName = "UTF-8";
        
        assertThrows(NullPointerException.class, () -> {
            StringUtils.toString(bytes, charsetName);
        });
    }
    
    @Test
    void testToStringWithEmptyByteArrayAndNullCharset() {
        byte[] bytes = new byte[0];
        String charsetName = null;
        
        assertDoesNotThrow(() -> {
            StringUtils.toString(bytes, charsetName);
        });
    }
    
    @Test
    void testToStringWithNonEmptyByteArrayAndNullCharset() {
        byte[] bytes = {72, 101, 108, 108, 111};
        String charsetName = null;
        
        assertDoesNotThrow(() -> {
            StringUtils.toString(bytes, charsetName);
        });
    }
    
    @Test
    void testToStringWithNullByteArrayAndNullCharset() {
        byte[] bytes = null;
        String charsetName = null;
        
        assertThrows(NullPointerException.class, () -> {
            StringUtils.toString(bytes, charsetName);
        });
    }
    
    @Test
    void testToStringWithUnsupportedCharset() {
        byte[] bytes = {72, 101, 108, 108, 111};
        String charsetName = "invalidCharset";
        
        assertThrows(UnsupportedEncodingException.class, () -> {
            StringUtils.toString(bytes, charsetName);
        });
    }
}