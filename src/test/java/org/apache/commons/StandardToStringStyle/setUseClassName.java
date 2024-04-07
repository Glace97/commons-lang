import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class setUseClassNameTest {
    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void setUseClassName_shouldSetUseClassNameFlagToTrue() {
        style.setUseClassName(true);
        assertTrue(style.isUseClassName());
    }

    @Test
    void setUseClassName_shouldSetUseClassNameFlagToFalse() {
        style.setUseClassName(false);
        assertFalse(style.isUseClassName());
    }
}