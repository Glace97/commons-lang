import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getContentStartTest {

    StandardToStringStyle style = new StandardToStringStyle();

    @Test
    void testGetContentStart() {
        String contentStart = style.getContentStart();
        assertNotNull(contentStart);
        assertEquals("", contentStart);
    }
}