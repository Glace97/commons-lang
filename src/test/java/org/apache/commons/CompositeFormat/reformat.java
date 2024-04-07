import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class reformatTest {
    @Test
    void testReformat() throws ParseException {
        // Test when input is null
        CompositeFormat compositeFormat = new CompositeFormat(new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                return null;
            }

            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;
            }
        }, new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                return null;
            }

            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;
            }
        });
        assertThrows(NullPointerException.class, () -> compositeFormat.reformat(null));

        // Test when input is an empty string
        CompositeFormat compositeFormat2 = new CompositeFormat(new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                return new StringBuffer(obj.toString());
            }

            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return new Object();
            }
        }, new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                return new StringBuffer(obj.toString());
            }

            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return new Object();
            }
        });
        assertEquals("", compositeFormat2.reformat(""));

        // Test when input is a valid string
        CompositeFormat compositeFormat3 = new CompositeFormat(new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                return new StringBuffer(obj.toString());
            }

            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return new Object();
            }
        }, new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                return new StringBuffer(obj.toString());
            }

            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return new Object();
            }
        });
        assertEquals("formatted", compositeFormat3.reformat("input"));
    }
}