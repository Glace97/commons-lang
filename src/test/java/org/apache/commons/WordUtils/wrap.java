import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WrapTest {
    @Test
    void testWrap_NullString_ReturnsNull() {
        Assertions.assertNull(WordUtils.wrap(null, 20));
    }
    
    @Test
    void testWrap_EmptyString_ReturnsEmptyString() {
        Assertions.assertEquals("", WordUtils.wrap("", 20));
    }
    
    @Test
    void testWrap_ShortString_ReturnsSameString() {
        String input = "Short string";
        Assertions.assertEquals(input, WordUtils.wrap(input, 20));
    }
    
    @Test
    void testWrap_LongString_WrapsCorrectly() {
        String input = "Here is one line of text that is going to be wrapped after 20 columns.";
        String expected = "Here is one line of\ntext that is going\nto be wrapped after\n20 columns.";
        Assertions.assertEquals(expected, WordUtils.wrap(input, 20));
    }
    
    @Test
    void testWrap_LongStringWithUrl_WrapsCorrectly() {
        String input = "Click here to jump to the commons website - https://commons.apache.org";
        String expected = "Click here to jump\nto the commons\nwebsite -\nhttps://commons.apache.org";
        Assertions.assertEquals(expected, WordUtils.wrap(input, 20));
    }
    
    @Test
    void testWrap_LongStringWithUrlAndLineSeparator_WrapsCorrectly() {
        String input = "Click here to jump to the commons website - https://commons.apache.org";
        String expected = "Click here to jump\nto the commons\nwebsite -\nhttps://commons.apach\ne.org";
        Assertions.assertEquals(expected, WordUtils.wrap(input, 20, "\n", true));
    }
    
    @Test
    void testWrap_LongStringWithUrlAndHtmlLineBreak_WrapsCorrectly() {
        String input = "Click here to jump to the commons website - https://commons.apache.org";
        String expected = "Click here to jump\nto the commons\nwebsite -\nhttps://commons.apache.org";
        Assertions.assertEquals(expected, WordUtils.wrap(input, 20, "<br />", true));
    }
    
    @Test
    void testWrap_LongStringWithUrlAndNullLineSeparator_WrapsCorrectly() {
        String input = "Click here to jump to the commons website - https://commons.apache.org";
        String expected = "Click here to jump\nto the commons\nwebsite -\nhttps://commons.apache.org";
        Assertions.assertEquals(expected, WordUtils.wrap(input, 20, null, true));
    }
    
    @Test
    void testWrap_LongStringWithUrlAndNoWrapLongWords_WrapsCorrectly() {
        String input = "Click here to jump to the commons website - https://commons.apache.org";
        String expected = "Click here to jump\nto the commons\nwebsite -\nhttps://commons.apache.org";
        Assertions.assertEquals(expected, WordUtils.wrap(input, 20, "\n", false));
    }
    
    @Test
    void testWrap_LongStringWithUrlAndWrapOnSlash_WrapsCorrectly() {
        String input = "flammable/inflammable";
        String expected = "flammable\ninflammable";
        Assertions.assertEquals(expected, WordUtils.wrap(input, 20, "\n", true, "/"));
    }
}