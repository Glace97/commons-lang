import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

class translateTest {

    @Test
    void testTranslateInsideRange() throws IOException {
        NumericEntityEscaper escaper = new NumericEntityEscaper(10, 20, true);
        StringWriter writer = new StringWriter();
        boolean result = escaper.translate(15, writer);
        assertTrue(result);
        assertEquals("&#15;", writer.toString());
    }

    @Test
    void testTranslateOutsideRange() throws IOException {
        NumericEntityEscaper escaper = new NumericEntityEscaper(10, 20, true);
        StringWriter writer = new StringWriter();
        boolean result = escaper.translate(5, writer);
        assertFalse(result);
        assertEquals("", writer.toString());
    }

    @Test
    void testTranslateInsideRangeExclusive() throws IOException {
        NumericEntityEscaper escaper = new NumericEntityEscaper(10, 20, false);
        StringWriter writer = new StringWriter();
        boolean result = escaper.translate(15, writer);
        assertFalse(result);
        assertEquals("", writer.toString());
    }

    @Test
    void testTranslateOutsideRangeExclusive() throws IOException {
        NumericEntityEscaper escaper = new NumericEntityEscaper(10, 20, false);
        StringWriter writer = new StringWriter();
        boolean result = escaper.translate(5, writer);
        assertTrue(result);
        assertEquals("&#5;", writer.toString());
    }

    @Test
    void testTranslateAtLowerBoundary() throws IOException {
        NumericEntityEscaper escaper = new NumericEntityEscaper(10, 20, true);
        StringWriter writer = new StringWriter();
        boolean result = escaper.translate(10, writer);
        assertTrue(result);
        assertEquals("&#10;", writer.toString());
    }

    @Test
    void testTranslateAtUpperBoundary() throws IOException {
        NumericEntityEscaper escaper = new NumericEntityEscaper(10, 20, true);
        StringWriter writer = new StringWriter();
        boolean result = escaper.translate(20, writer);
        assertTrue(result);
        assertEquals("&#20;", writer.toString());
    }
}