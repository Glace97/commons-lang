import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import static org.junit.jupiter.api.Assertions.*;

class TranslateTest {
    private final CharSequenceTranslator translator = new StringEscapeUtils();

    @Test
    void testCsvEscaperTranslate() throws IOException {
        CharSequence input = "Hello, World!";
        Writer out = new StringWriter();
        int result = translator.CsvEscaper().translate(input, 0, out);
        assertEquals("Hello, World!", out.toString());
        assertEquals(13, result);
    }

    @Test
    void testCsvEscaperTranslateWithQuotes() throws IOException {
        CharSequence input = "\"Hello, World!\"";
        Writer out = new StringWriter();
        int result = translator.CsvEscaper().translate(input, 0, out);
        assertEquals("\"\"Hello, World!\"\"", out.toString());
        assertEquals(17, result);
    }

    @Test
    void testCsvEscaperTranslateWithQuotesAndEscapedQuotes() throws IOException {
        CharSequence input = "\"Hello, \"\"World!\"\"\"";
        Writer out = new StringWriter();
        int result = translator.CsvEscaper().translate(input, 0, out);
        assertEquals("\"\"Hello, \"\"\"\"World!\"\"\"\"\"", out.toString());
        assertEquals(21, result);
    }

    @Test
    void testCsvUnescaperTranslate() throws IOException {
        CharSequence input = "Hello, World!";
        Writer out = new StringWriter();
        int result = translator.CsvUnescaper().translate(input, 0, out);
        assertEquals("Hello, World!", out.toString());
        assertEquals(13, result);
    }

    @Test
    void testCsvUnescaperTranslateWithQuotes() throws IOException {
        CharSequence input = "\"Hello, World!\"";
        Writer out = new StringWriter();
        int result = translator.CsvUnescaper().translate(input, 0, out);
        assertEquals("Hello, World!", out.toString());
        assertEquals(17, result);
    }

    @Test
    void testCsvUnescaperTranslateWithQuotesAndEscapedQuotes() throws IOException {
        CharSequence input = "\"\"Hello, \"\"\"\"World!\"\"\"\"\"";
        Writer out = new StringWriter();
        int result = translator.CsvUnescaper().translate(input, 0, out);
        assertEquals("\"Hello, \"\"World!\"\"\"", out.toString());
        assertEquals(21, result);
    }
}