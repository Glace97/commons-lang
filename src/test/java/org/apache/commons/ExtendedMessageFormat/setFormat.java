import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
import java.util.HashMap;

class setFormatTest {

    private ExtendedMessageFormat messageFormat;
    private Format format;

    @BeforeEach
    void setUp() {
        messageFormat = new ExtendedMessageFormat("{0}");
        format = new MessageFormat("{0}");
    }

    @Test
    void testSetFormat() {
        assertThrows(UnsupportedOperationException.class, () -> {
            messageFormat.setFormat(0, format);
        });
    }
}