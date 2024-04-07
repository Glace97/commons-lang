import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setFieldSeparatorAtEndTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void setFieldSeparatorAtEnd_true() {
        style.setFieldSeparatorAtEnd(true);
        assertTrue(style.getFieldSeparatorAtEnd());
    }

    @Test
    void setFieldSeparatorAtEnd_false() {
        style.setFieldSeparatorAtEnd(false);
        assertFalse(style.getFieldSeparatorAtEnd());
    }
}