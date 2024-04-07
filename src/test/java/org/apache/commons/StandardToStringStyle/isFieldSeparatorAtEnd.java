import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isFieldSeparatorAtEndTest {

    @Test
    void testIsFieldSeparatorAtEndReturnsTrue() {
        StandardToStringStyle style = new StandardToStringStyle();
        assertTrue(style.isFieldSeparatorAtEnd());
    }
    
    @Test
    void testIsFieldSeparatorAtEndReturnsFalse() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setFieldSeparatorAtEnd(false);
        assertFalse(style.isFieldSeparatorAtEnd());
    }
    
    @Test
    void testIsFieldSeparatorAtEndReturnsTrueAfterSettingFalse() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setFieldSeparatorAtEnd(false);
        style.setFieldSeparatorAtEnd(true);
        assertTrue(style.isFieldSeparatorAtEnd());
    }
    
    @Test
    void testIsFieldSeparatorAtEndReturnsFalseAfterSettingTrue() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setFieldSeparatorAtEnd(true);
        style.setFieldSeparatorAtEnd(false);
        assertFalse(style.isFieldSeparatorAtEnd());
    }
    
    @Test
    void testIsFieldSeparatorAtEndReturnsFalseAfterSettingNull() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setFieldSeparatorAtEnd(null);
        assertFalse(style.isFieldSeparatorAtEnd());
    }
    
    @Test
    void testIsFieldSeparatorAtEndReturnsFalseForEmptyString() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setFieldSeparatorAtEnd("");
        assertFalse(style.isFieldSeparatorAtEnd());
    }
    
    @Test
    void testIsFieldSeparatorAtEndReturnsTrueForNonEmptyString() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setFieldSeparatorAtEnd(" ");
        assertTrue(style.isFieldSeparatorAtEnd());
    }

}
