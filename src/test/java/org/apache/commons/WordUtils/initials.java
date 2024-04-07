import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class initialsTest {

    private static final char[] DEFAULT_DELIMITERS = null;
    private static final char[] CUSTOM_DELIMITERS = { ' ', '.' };

    @Test
    void testInitialsWithNullInput() {
        assertNull(WordUtils.initials(null));
    }

    @Test
    void testInitialsWithEmptyString() {
        assertEquals("", WordUtils.initials(""));
    }

    @Test
    void testInitialsWithNoDelimiters() {
        assertEquals("BJL", WordUtils.initials("Ben John Lee"));
    }

    @Test
    void testInitialsWithNullDelimiters() {
        assertEquals("BJ", WordUtils.initials("Ben J.Lee", DEFAULT_DELIMITERS));
    }

    @Test
    void testInitialsWithCustomDelimiters() {
        assertEquals("BJL", WordUtils.initials("Ben J.Lee", CUSTOM_DELIMITERS));
    }

    @Test
    void testInitialsWithEmptyDelimiterArray() {
        assertEquals("", WordUtils.initials("Ben J.Lee", new char[0]));
    }

}