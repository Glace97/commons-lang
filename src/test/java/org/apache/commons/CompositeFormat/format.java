import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;

class FormatTest {
    private CompositeFormat compositeFormat;

    @BeforeEach
    void setUp() {
        Format parser = new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                return null;
            }

            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;
            }
        };

        Format formatter = new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                return null;
            }

            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;
            }
        };

        compositeFormat = new CompositeFormat(parser, formatter);
    }

    @Test
    void testFormat() {
        // Test case 1: obj is null
        Object obj = null;
        StringBuffer toAppendTo = new StringBuffer();
        FieldPosition pos = new FieldPosition(0);
        StringBuffer result = compositeFormat.format(obj, toAppendTo, pos);
        assertEquals(toAppendTo, result);

        // Test case 2: toAppendTo is null
        obj = "Hello";
        toAppendTo = null;
        pos = new FieldPosition(0);
        assertThrows(NullPointerException.class, () -> compositeFormat.format(obj, toAppendTo, pos));

        // Test case 3: pos is null
        obj = "Hello";
        toAppendTo = new StringBuffer();
        pos = null;
        assertThrows(NullPointerException.class, () -> compositeFormat.format(obj, toAppendTo, pos));

        // Test case 4: obj and toAppendTo are not null
        obj = "Hello";
        toAppendTo = new StringBuffer();
        pos = new FieldPosition(0);
        result = compositeFormat.format(obj, toAppendTo, pos);
        assertEquals("Hello", result.toString());
    }
}