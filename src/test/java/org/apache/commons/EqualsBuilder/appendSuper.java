import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

class appendSuperTest {

    private EqualsBuilder equalsBuilder;

    @BeforeEach
    void setUp() {
        equalsBuilder = new EqualsBuilder();
    }

    @Test
    void testAppendSuper_ReturnsTrue() {
        assertTrue(equalsBuilder.appendSuper(true).isEquals);
    }

    @Test
    void testAppendSuper_ReturnsFalse() {
        assertFalse(equalsBuilder.appendSuper(false).isEquals);
    }

    @Test
    void testAppendSuper_WhenNotEqual_ReturnsFalse() {
        equalsBuilder.isEquals = false;
        assertFalse(equalsBuilder.appendSuper(true).isEquals);
    }

    @Test
    void testAppendSuper_WhenNotEqual_ReturnsTrue() {
        equalsBuilder.isEquals = false;
        assertTrue(equalsBuilder.appendSuper(false).isEquals);
    }

}