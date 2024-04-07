import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setArrayStartTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void testSetArrayStartWithNonNullString() {
        String arrayStart = "Start";
        style.setArrayStart(arrayStart);
        assertEquals(arrayStart, style.getArrayStart());
    }

    @Test
    void testSetArrayStartWithNullString() {
        String arrayStart = null;
        style.setArrayStart(arrayStart);
        assertEquals("", style.getArrayStart());
    }
}