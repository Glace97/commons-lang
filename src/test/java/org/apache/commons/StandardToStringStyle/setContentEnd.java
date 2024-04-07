import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setContentEndTest {

    @Test
    void testNullContentEnd() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setContentEnd(null);
        assertEquals("", style.getContentEnd());
    }

    @Test
    void testEmptyContentEnd() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setContentEnd("");
        assertEquals("", style.getContentEnd());
    }

    @Test
    void testNonEmptyContentEnd() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setContentEnd("end");
        assertEquals("end", style.getContentEnd());
    }
    
    @Test
    void testMultipleSetContentEnd() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setContentEnd("end1");
        style.setContentEnd("end2");
        assertEquals("end2", style.getContentEnd());
    }
    
    @Test
    void testSpecialCharactersContentEnd() {
        StandardToStringStyle style = new StandardToStringStyle();
        style.setContentEnd("!@#$%^&*()");
        assertEquals("!@#$%^&*()", style.getContentEnd());
    }
}