import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class isUseFieldNamesTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void isUseFieldNames_DefaultValue_ReturnsFalse() {
        assertFalse(style.isUseFieldNames());
    }

    @Test
    void isUseFieldNames_SetToTrue_ReturnsTrue() {
        style.setUseFieldNames(true);
        assertTrue(style.isUseFieldNames());
    }

    @Test
    void isUseFieldNames_SetToFalse_ReturnsFalse() {
        style.setUseFieldNames(false);
        assertFalse(style.isUseFieldNames());
    }

}
