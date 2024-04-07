import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class getSummaryObjectEndTextTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    @DisplayName("Test getSummaryObjectEndText with default value")
    void testGetSummaryObjectEndTextDefault() {
        String expected = "";
        String actual = style.getSummaryObjectEndText();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test getSummaryObjectEndText after setting value")
    void testGetSummaryObjectEndTextAfterSet() {
        String expected = " - End Text";
        style.setSummaryObjectEndText(" - End Text");
        String actual = style.getSummaryObjectEndText();
        assertEquals(expected, actual);
    }
}