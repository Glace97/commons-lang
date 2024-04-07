import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.Format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getFormatterTest {

    private CompositeFormat compositeFormat;
    private Format parser;
    private Format formatter;

    @BeforeEach
    void setUp() {
        parser = new DummyFormat();
        formatter = new DummyFormat();
        compositeFormat = new CompositeFormat(parser, formatter);
    }

    @Test
    void testGetFormatterNotNull() {
        Format result = compositeFormat.getFormatter();
        assertNotNull(result, "Formatter should not be null");
    }

    @Test
    void testGetFormatterReturnsFormatter() {
        Format result = compositeFormat.getFormatter();
        assertEquals(formatter, result, "Should return the formatter");
    }

    // Additional test cases for edge cases and high coverage

    @Test
    void testGetFormatterReturnsSameFormatterInstance() {
        Format result1 = compositeFormat.getFormatter();
        Format result2 = compositeFormat.getFormatter();
        assertTrue(result1 == result2, "Should return the same formatter instance");
    }

    private class DummyFormat extends Format {
        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
            return null;
        }

        @Override
        public Object parseObject(String source, ParsePosition pos) {
            return null;
        }
    }
}