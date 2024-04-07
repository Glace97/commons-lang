import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setSummaryObjectEndTextTest {
    
    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void testSetSummaryObjectEndText() {
        // Test with non-null summaryObjectEndText
        style.setSummaryObjectEndText("End Text");
        assertEquals("End Text", style.getSummaryObjectEndText());
        
        // Test with null summaryObjectEndText
        style.setSummaryObjectEndText(null);
        assertEquals("", style.getSummaryObjectEndText());
    }
}