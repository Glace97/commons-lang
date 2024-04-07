import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setFormatsTest {
    
    @Test
    void testSetFormats_UnsupportedOperationException() {
        ExtendedMessageFormat format = new ExtendedMessageFormat("");
        assertThrows(UnsupportedOperationException.class, () -> {
            format.setFormats(new Format[0]);
        });
    }
    
}