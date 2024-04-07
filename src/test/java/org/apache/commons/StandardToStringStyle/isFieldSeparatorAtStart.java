import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class isFieldSeparatorAtStartTest {

    private StandardToStringStyle style;

    @BeforeAll
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void testIsFieldSeparatorAtStart_Default_ReturnsFalse() {
        assertEquals(false, style.isFieldSeparatorAtStart());
    }

    @Test
    void testIsFieldSeparatorAtStart_AfterSettingToTrue_ReturnsTrue() {
        style.setFieldSeparatorAtStart(true);
        assertEquals(true, style.isFieldSeparatorAtStart());
    }

    @Test
    void testIsFieldSeparatorAtStart_AfterSettingToFalse_ReturnsFalse() {
        style.setFieldSeparatorAtStart(false);
        assertEquals(false, style.isFieldSeparatorAtStart());
    }
}