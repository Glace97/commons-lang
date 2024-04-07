import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setFieldSeparatorAtStartTest {

    @Test
    void testSetFieldSeparatorAtStart() {
        StandardToStringStyle style = new StandardToStringStyle();

        // Test case 1: fieldSeparatorAtStart is set to true
        style.setFieldSeparatorAtStart(true);
        assertTrue(style.getFieldSeparatorAtStart());

        // Test case 2: fieldSeparatorAtStart is set to false
        style.setFieldSeparatorAtStart(false);
        assertFalse(style.getFieldSeparatorAtStart());
    }
}