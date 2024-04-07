import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class getArraySeparatorTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void testGetArraySeparator() {
        assertEquals(",", style.getArraySeparator());
    }

    @Test
    void testSetArraySeparator() {
        style.setArraySeparator("-");
        assertEquals("-", style.getArraySeparator());
    }

    @Test
    void testSetArraySeparator_Null() {
        assertThrows(NullPointerException.class, () -> style.setArraySeparator(null));
    }
}