import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setDefaultStyleTest {

    private ToStringBuilder toStringBuilder;

    @BeforeEach
    void setUp() {
        toStringBuilder = new ToStringBuilder(new Object());
    }

    @Test
    void setDefaultStyle_shouldSetDefaultStyle() {
        ToStringStyle style = new ToStringStyle();
        ToStringBuilder.setDefaultStyle(style);
        assertEquals(style, ToStringBuilder.defaultStyle);
    }

    @Test
    void setDefaultStyle_shouldThrowNullPointerException_whenStyleIsNull() {
        assertThrows(NullPointerException.class, () -> ToStringBuilder.setDefaultStyle(null));
    }
}