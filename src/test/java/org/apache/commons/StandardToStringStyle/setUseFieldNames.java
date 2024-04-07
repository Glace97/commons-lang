import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setUseFieldNamesTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void setUseFieldNames_shouldSetUseFieldNamesFlagToTrue() {
        style.setUseFieldNames(true);
        assertTrue(style.isUseFieldNames());
    }

    @Test
    void setUseFieldNames_shouldSetUseFieldNamesFlagToFalse() {
        style.setUseFieldNames(false);
        assertFalse(style.isUseFieldNames());
    }

    @Test
    void setUseFieldNames_shouldNotChangeUseFieldNamesFlagIfAlreadyTrue() {
        style.setUseFieldNames(true);
        style.setUseFieldNames(true);
        assertTrue(style.isUseFieldNames());
    }

    @Test
    void setUseFieldNames_shouldNotChangeUseFieldNamesFlagIfAlreadyFalse() {
        style.setUseFieldNames(false);
        style.setUseFieldNames(false);
        assertFalse(style.isUseFieldNames());
    }
}