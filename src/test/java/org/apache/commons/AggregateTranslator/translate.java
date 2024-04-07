import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import static org.junit.jupiter.api.Assertions.*;

class TranslateTest {
    private AggregateTranslator translator;

    @BeforeEach
    void setUp() {
        translator = new AggregateTranslator();
    }

    @Test
    void testTranslate_EmptyInput() throws IOException {
        Writer out = new StringWriter();
        int consumed = translator.translate("", 0, out);
        assertEquals(0, consumed);
        assertEquals("", out.toString());
    }

    @Test
    void testTranslate_NoTranslators() throws IOException {
        Writer out = new StringWriter();
        int consumed = translator.translate("abc", 0, out);
        assertEquals(0, consumed);
        assertEquals("", out.toString());
    }

    @Test
    void testTranslate_OneTranslator() throws IOException {
        CharSequenceTranslator translator1 = new MyTranslator();
        translator = new AggregateTranslator(translator1);

        Writer out = new StringWriter();
        int consumed = translator.translate("abc", 0, out);
        assertEquals(3, consumed);
        assertEquals("xyz", out.toString());
    }

    @Test
    void testTranslate_MultipleTranslators_FirstTranslatorWins() throws IOException {
        CharSequenceTranslator translator1 = new MyTranslator();
        CharSequenceTranslator translator2 = new MyOtherTranslator();
        translator = new AggregateTranslator(translator1, translator2);

        Writer out = new StringWriter();
        int consumed = translator.translate("abc", 0, out);
        assertEquals(3, consumed);
        assertEquals("xyz", out.toString());
    }

    @Test
    void testTranslate_MultipleTranslators_SecondTranslatorWins() throws IOException {
        CharSequenceTranslator translator1 = new MyOtherTranslator();
        CharSequenceTranslator translator2 = new MyTranslator();
        translator = new AggregateTranslator(translator1, translator2);

        Writer out = new StringWriter();
        int consumed = translator.translate("abc", 0, out);
        assertEquals(3, consumed);
        assertEquals("def", out.toString());
    }

    @Test
    void testTranslate_TranslatorConsumesPartOfInput() throws IOException {
        CharSequenceTranslator translator1 = new MyPartialTranslator();
        translator = new AggregateTranslator(translator1);

        Writer out = new StringWriter();
        int consumed = translator.translate("abcdef", 0, out);
        assertEquals(3, consumed);
        assertEquals("abc", out.toString());
    }

    @Test
    void testTranslate_TranslatorThrowsIOException() {
        CharSequenceTranslator translator1 = new MyExceptionTranslator();
        translator = new AggregateTranslator(translator1);

        Writer out = new StringWriter();
        assertThrows(IOException.class, () -> translator.translate("abc", 0, out));
    }

    private static class MyTranslator extends CharSequenceTranslator {
        @Override
        public int translate(CharSequence input, int index, Writer out) throws IOException {
            out.write("xyz");
            return input.length();
        }
    }

    private static class MyOtherTranslator extends CharSequenceTranslator {
        @Override
        public int translate(CharSequence input, int index, Writer out) throws IOException {
            out.write("def");
            return input.length();
        }
    }

    private static class MyPartialTranslator extends CharSequenceTranslator {
        @Override
        public int translate(CharSequence input, int index, Writer out) throws IOException {
            out.write(input.subSequence(index, index + 3).toString());
            return 3;
        }
    }

    private static class MyExceptionTranslator extends CharSequenceTranslator {
        @Override
        public int translate(CharSequence input, int index, Writer out) throws IOException {
            throw new IOException("Translation failed");
        }
    }
}