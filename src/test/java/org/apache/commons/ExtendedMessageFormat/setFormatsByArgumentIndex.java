import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.text.Format;

class setFormatsByArgumentIndexTest {

    @Test
    void testSetFormatsByArgumentIndex() {
        ExtendedMessageFormat messageFormat = new ExtendedMessageFormat("");
        Format[] formats = new Format[2];
        formats[0] = new TestFormat();
        formats[1] = new TestFormat();

        assertThrows(UnsupportedOperationException.class, () -> {
            messageFormat.setFormatsByArgumentIndex(formats);
        });
    }

    private class TestFormat extends Format {
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