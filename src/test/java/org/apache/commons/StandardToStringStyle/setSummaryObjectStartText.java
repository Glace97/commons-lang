import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class setSummaryObjectStartTextTest {
    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void testSetSummaryObjectStartText() {
        // Test when summaryObjectStartText is not null
        String summaryObjectStartText = "Start";
        style.setSummaryObjectStartText(summaryObjectStartText);
        assertEquals(summaryObjectStartText, style.getSummaryObjectStartText());

        // Test when summaryObjectStartText is null
        style.setSummaryObjectStartText(null);
        assertEquals("", style.getSummaryObjectStartText());
    }
}