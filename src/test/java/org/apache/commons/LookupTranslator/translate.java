
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TranslateTest {

    private LookupTranslator translator;

    @BeforeEach
    void setUp() {
        // Initialize the lookup translator with test data
        CharSequence[] lookup1 = { "abc", "123" };
        CharSequence[] lookup2 = { "def", "456" };
        translator = new LookupTranslator(lookup1, lookup2);
    }

    @Test
    void testTranslate_ExistingTranslation_ReturnsCorrectLength() throws IOException {
        StringWriter writer = new StringWriter();
        int length = translator.translate("abc", 0, writer);
        assertEquals(3, length);
    }

    @Test
    void testTranslate_ExistingTranslation_WritesCorrectOutput() throws IOException {
        StringWriter writer = new StringWriter();
        translator.translate("abc", 0, writer);
        assertEquals("123", writer.toString());
    }

    @Test
    void testTranslate_NoTranslation_ReturnsZeroLength() throws IOException {
        StringWriter writer = new StringWriter();
        int length = translator.translate("xyz", 0, writer);
        assertEquals(0, length);
    }

    @Test
    void testTranslate_NoTranslation_DoesNotWriteOutput() throws IOException {
        StringWriter writer = new StringWriter();
        translator.translate("xyz", 0, writer);
        assertEquals("", writer.toString());
    }

    @Test
    void testTranslate_PartialTranslation_ReturnsCorrectLength() throws IOException {
        StringWriter writer = new StringWriter();
        int length = translator.translate("abcdef", 0, writer);
        assertEquals(3, length);
    }

    @Test
    void testTranslate_PartialTranslation_WritesCorrectOutput() throws IOException {
        StringWriter writer = new StringWriter();
        translator.translate("abcdef", 0, writer);
        assertEquals("123", writer.toString());
    }

    @Test
    void testTranslate_InputIndexGreaterThanZero_ReturnsCorrectLength() throws IOException {
        StringWriter writer = new StringWriter();
        int length = translator.translate("xabcdef", 1, writer);
        assertEquals(3, length);
    }

    @Test
    void testTranslate_InputIndexGreaterThanZero_WritesCorrectOutput() throws IOException {
        StringWriter writer = new StringWriter();
        translator.translate("xabcdef", 1, writer);
        assertEquals("123", writer.toString());
    }

    @Test
    void testTranslate_InputLengthLessThanShortestTranslation_ReturnsZeroLength() throws IOException {
        StringWriter writer = new StringWriter();
        int length = translator.translate("a", 0, writer);
        assertEquals(0, length);
    }

    @Test
    void testTranslate_InputLengthLessThanShortestTranslation_DoesNotWriteOutput() throws IOException {
        StringWriter writer = new StringWriter();
        translator.translate("a", 0, writer);
        assertEquals("", writer.toString());
    }

    @Test
    void testTranslate_InputLengthGreaterThanLongestTranslation_ReturnsZeroLength() throws IOException {
        StringWriter writer = new StringWriter();
        int length = translator.translate("abcdefg", 0, writer);
        assertEquals(0, length);
    }

    @Test
    void testTranslate_InputLengthGreaterThanLongestTranslation_DoesNotWriteOutput() throws IOException {
        StringWriter writer = new StringWriter();
        translator.translate("abcdefg", 0, writer);
        assertEquals("", writer.toString());
    }

}
