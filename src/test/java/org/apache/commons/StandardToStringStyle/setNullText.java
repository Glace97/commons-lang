import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("setNullTextTest")
class SetNullTextTest {

    @Test
    @DisplayName("Test setNullText method with null input")
    void testSetNullTextWithNullInput() {
        StandardToStringStyle style = new StandardToStringStyle();

        style.setNullText(null);

        assertEquals("", style.getNullText());
    }

    @Test
    @DisplayName("Test setNullText method with empty string input")
    void testSetNullTextWithEmptyStringInput() {
        StandardToStringStyle style = new StandardToStringStyle();

        style.setNullText("");

        assertEquals("", style.getNullText());
    }

    @Test
    @DisplayName("Test setNullText method with non-empty string input")
    void testSetNullTextWithNonEmptyStringInput() {
        StandardToStringStyle style = new StandardToStringStyle();

        String nullText = "N/A";
        style.setNullText(nullText);

        assertEquals(nullText, style.getNullText());
    }
}