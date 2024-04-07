import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isArrayContentDetailTest {

    private StandardToStringStyle toStringStyle;

    @BeforeEach
    void setUp() {
        toStringStyle = new StandardToStringStyle();
    }

    @Test
    @DisplayName("Test isArrayContentDetail when true")
    void testIsArrayContentDetailTrue() {
        boolean expected = true;
        boolean actual = toStringStyle.isArrayContentDetail();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test isArrayContentDetail when false")
    void testIsArrayContentDetailFalse() {
        boolean expected = false;
        boolean actual = toStringStyle.isArrayContentDetail();
        assertEquals(expected, actual);
    }
}