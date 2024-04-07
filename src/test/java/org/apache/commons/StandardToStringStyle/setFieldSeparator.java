import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class setFieldSeparatorTest {

    private StandardToStringStyle style;

    @BeforeAll
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void testSetFieldSeparator() {
        // Test 1: Setting fieldSeparator to null
        style.setFieldSeparator(null);
        assertEquals("", style.getFieldSeparator());

        // Test 2: Setting fieldSeparator to empty string
        style.setFieldSeparator("");
        assertEquals("", style.getFieldSeparator());

        // Test 3: Setting fieldSeparator to non-null value
        style.setFieldSeparator(";");
        assertEquals(";", style.getFieldSeparator());
    }
}