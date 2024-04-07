import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class getContentEndTest {
    @Test
    void testGetContentEnd() {
        StandardToStringStyle style = new StandardToStringStyle();
        assertEquals("", style.getContentEnd());
    }
}