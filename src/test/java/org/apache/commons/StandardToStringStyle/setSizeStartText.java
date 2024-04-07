import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class setSizeStartTextTest {
    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    @DisplayName("Test setSizeStartText with non-null input")
    void testSetSizeStartTextNonNull() {
        String sizeStartText = "Size: ";
        style.setSizeStartText(sizeStartText);
        assertEquals(sizeStartText, style.getSizeStartText());
    }

    @Test
    @DisplayName("Test setSizeStartText with null input")
    void testSetSizeStartTextNull() {
        style.setSizeStartText(null);
        assertEquals("", style.getSizeStartText());
    }
}