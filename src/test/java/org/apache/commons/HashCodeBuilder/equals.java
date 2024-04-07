import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class equalsTest {

    private HashCodeBuilder builder1;
    private HashCodeBuilder builder2;
    private HashCodeBuilder builder3;

    @BeforeEach
    void setUp() {
        builder1 = new HashCodeBuilder();
        builder2 = new HashCodeBuilder(17, 37);
        builder3 = new HashCodeBuilder(19, 41);
    }

    @Test
    void testEquals_SameObject_ReturnsTrue() {
        assertTrue(builder1.equals(builder1));
    }

    @Test
    void testEquals_NullObject_ReturnsFalse() {
        assertFalse(builder1.equals(null));
    }

    @Test
    void testEquals_DifferentClass_ReturnsFalse() {
        assertFalse(builder1.equals(""));
    }

    @Test
    void testEquals_EqualBuilders_ReturnsTrue() {
        assertTrue(builder1.equals(builder2));
    }

    @Test
    void testEquals_DifferentBuilders_ReturnsFalse() {
        assertFalse(builder1.equals(builder3));
    }
}