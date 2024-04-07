import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setDefaultFullDetailTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setup() {
        style = new StandardToStringStyle();
    }

    @Test
    void testSetDefaultFullDetail() {
        // Test when defaultFullDetail is true
        style.setDefaultFullDetail(true);
        assertTrue(style.getDefaultFullDetail());

        // Test when defaultFullDetail is false
        style.setDefaultFullDetail(false);
        assertFalse(style.getDefaultFullDetail());
    }
}