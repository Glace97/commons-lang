import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class getSummaryObjectStartTextTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void testGetSummaryObjectStartText() {
        String startText = style.getSummaryObjectStartText();
        assertNotNull(startText);
        assertEquals("", startText);
    }

}