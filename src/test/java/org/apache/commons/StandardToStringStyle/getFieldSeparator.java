import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getFieldSeparatorTest {

    private StandardToStringStyle style;

    @BeforeAll
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void testDefaultFieldSeparator() {
        assertEquals(",", style.getFieldSeparator());
    }

    @Test
    void testCustomFieldSeparator() {
        // Set custom field separator
        style.setFieldSeparator("|");
        assertEquals("|", style.getFieldSeparator());
    }

    @Test
    void testEmptyFieldSeparator() {
        style.setFieldSeparator("");
        assertEquals("", style.getFieldSeparator());
    }

    @Test
    void testNullFieldSeparator() {
        style.setFieldSeparator(null);
        assertEquals("", style.getFieldSeparator());
    }
}