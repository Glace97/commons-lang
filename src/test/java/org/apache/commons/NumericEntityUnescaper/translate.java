import org.junit.jupiter.api.*;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.EnumSet;

class TranslateTest {

    private NumericEntityUnescaper unescaper;

    @BeforeEach
    void setUp() {
        unescaper = new NumericEntityUnescaper();
    }

    @Test
    void testTranslateWithValidInputAndSemicolonRequired() throws IOException {
        CharSequence input = "&#65;";
        Writer writer = new StringWriter();
        int result = unescaper.translate(input, 0, writer);
        Assertions.assertEquals(5, result);
        Assertions.assertEquals("A", writer.toString());
    }

    @Test
    void testTranslateWithValidInputAndSemicolonOptional() throws IOException {
        unescaper = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.semiColonOptional);
        CharSequence input = "&#65";
        Writer writer = new StringWriter();
        int result = unescaper.translate(input, 0, writer);
        Assertions.assertEquals(4, result);
        Assertions.assertEquals("A", writer.toString());
    }

    @Test
    void testTranslateWithValidInputAndErrorIfNoSemicolon() throws IOException {
        unescaper = new NumericEntityUnescaper(NumericEntityUnescaper.OPTION.errorIfNoSemiColon);
        CharSequence input = "&#65";
        Writer writer = new StringWriter();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            unescaper.translate(input, 0, writer);
        });
    }

    @Test
    void testTranslateWithInvalidInput() throws IOException {
        CharSequence input = "&#65A;";
        Writer writer = new StringWriter();
        int result = unescaper.translate(input, 0, writer);
        Assertions.assertEquals(0, result);
        Assertions.assertEquals("", writer.toString());
    }

    @Test
    void testTranslateWithHexadecimalInput() throws IOException {
        CharSequence input = "&#x41;";
        Writer writer = new StringWriter();
        int result = unescaper.translate(input, 0, writer);
        Assertions.assertEquals(5, result);
        Assertions.assertEquals("A", writer.toString());
    }

    @Test
    void testTranslateWithInvalidHexadecimalInput() throws IOException {
        CharSequence input = "&#x41G;";
        Writer writer = new StringWriter();
        int result = unescaper.translate(input, 0, writer);
        Assertions.assertEquals(0, result);
        Assertions.assertEquals("", writer.toString());
    }

    @Test
    void testTranslateWithEntityValueGreaterThan0xFFFF() throws IOException {
        CharSequence input = "&#123456;";
        Writer writer = new StringWriter();
        int result = unescaper.translate(input, 0, writer);
        Assertions.assertEquals(10, result);
        Assertions.assertEquals("\uD83D\uDC28", writer.toString());
    }

    @Test
    void testTranslateWithEntityValueLessThan0xFFFF() throws IOException {
        CharSequence input = "&#65;";
        Writer writer = new StringWriter();
        int result = unescaper.translate(input, 0, writer);
        Assertions.assertEquals(5, result);
        Assertions.assertEquals("A", writer.toString());
    }

    private boolean isSet(NumericEntityUnescaper.OPTION option) {
        return unescaper.options.contains(option);
    }
}