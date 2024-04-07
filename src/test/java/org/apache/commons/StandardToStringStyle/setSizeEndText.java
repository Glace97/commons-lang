import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class setSizeEndTextTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setup() {
        style = new StandardToStringStyle();
    }

    @Test
    void setSizeEndText_shouldSetSizeEndText() {
        String sizeEndText = " [end]";
        style.setSizeEndText(sizeEndText);
        assertEquals(sizeEndText, style.getSizeEndText());
    }

    @Test
    void setSizeEndText_withNull_shouldSetEmptyString() {
        style.setSizeEndText(null);
        assertEquals("", style.getSizeEndText());
    }

    @Nested
    class EdgeCases {

        @Test
        void setSizeEndText_withEmptyString_shouldSetEmptyString() {
            style.setSizeEndText("");
            assertEquals("", style.getSizeEndText());
        }

        @Test
        void setSizeEndText_withSpace_shouldSetSpace() {
            style.setSizeEndText(" ");
            assertEquals(" ", style.getSizeEndText());
        }

        @Test
        void setSizeEndText_withSpecialCharacters_shouldSetSpecialCharacters() {
            String sizeEndText = "!@#$%^&*()";
            style.setSizeEndText(sizeEndText);
            assertEquals(sizeEndText, style.getSizeEndText());
        }

        @Test
        void setSizeEndText_withNumericCharacters_shouldSetNumericCharacters() {
            String sizeEndText = "12345";
            style.setSizeEndText(sizeEndText);
            assertEquals(sizeEndText, style.getSizeEndText());
        }

        @Test
        void setSizeEndText_withAlphanumericCharacters_shouldSetAlphanumericCharacters() {
            String sizeEndText = "abc123";
            style.setSizeEndText(sizeEndText);
            assertEquals(sizeEndText, style.getSizeEndText());
        }

        @Test
        void setSizeEndText_withWhitespaceCharacters_shouldSetWhitespaceCharacters() {
            String sizeEndText = "\t\n\r\f";
            style.setSizeEndText(sizeEndText);
            assertEquals(sizeEndText, style.getSizeEndText());
        }
    }
}