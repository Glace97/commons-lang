import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class setFormatByArgumentIndexTest {
    private ExtendedMessageFormat messageFormat;

    @BeforeEach
    void setUp() {
        messageFormat = new ExtendedMessageFormat("");
    }

    @Test
    void testSetFormatByArgumentIndex() {
        assertThrows(UnsupportedOperationException.class, () -> {
            messageFormat.setFormatByArgumentIndex(0, null);
        });
    }
}