import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isDefaultFullDetailTest {

    @Test
    void testIsDefaultFullDetailReturnsTrueByDefault() {
        StandardToStringStyle style = new StandardToStringStyle();
        assertTrue(style.isDefaultFullDetail());
    }
    
    @Test
    void testIsDefaultFullDetailReturnsFalseWhenSetToFalse() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setDefaultFullDetail(false);
        assertFalse(style.isDefaultFullDetail());
    }
    
    @Test
    void testIsDefaultFullDetailReturnsTrueWhenSetToTrue() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setDefaultFullDetail(true);
        assertTrue(style.isDefaultFullDetail());
    }
    
    @Test
    void testIsDefaultFullDetailReturnsFalseWhenSetToTrueAndThenFalse() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setDefaultFullDetail(true);
        style.setDefaultFullDetail(false);
        assertFalse(style.isDefaultFullDetail());
    }
    
    @Test
    void testIsDefaultFullDetailReturnsTrueWhenSetToFalseAndThenTrue() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setDefaultFullDetail(false);
        style.setDefaultFullDetail(true);
        assertTrue(style.isDefaultFullDetail());
    }
    
    @Test
    void testIsDefaultFullDetailReturnsFalseWhenSetToTrueAndThenReset() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setDefaultFullDetail(true);
        style.resetDefaultFullDetail();
        assertFalse(style.isDefaultFullDetail());
    }
    
    @Test
    void testIsDefaultFullDetailReturnsTrueWhenSetToFalseAndThenReset() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setDefaultFullDetail(false);
        style.resetDefaultFullDetail();
        assertTrue(style.isDefaultFullDetail());
    }
}