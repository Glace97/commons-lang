import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class isUseClassNameTest {
    
    private StandardToStringStyle style;
    
    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }
    
    @Test
    void testIsUseClassNameReturnsTrueByDefault() {
        assertTrue(style.isUseClassName());
    }
    
    @Test
    void testIsUseClassNameReturnsFalseAfterSettingToFalse() {
        style.setUseClassName(false);
        assertFalse(style.isUseClassName());
    }
    
    @Test
    void testIsUseClassNameReturnsTrueAfterSettingToTrue() {
        style.setUseClassName(true);
        assertTrue(style.isUseClassName());
    }
    
}