import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class setEqualsTest {

    private EqualsBuilder equalsBuilder;

    @BeforeEach
    void setUp() {
        equalsBuilder = new EqualsBuilder();
    }

    @Test
    void testSetEqualsTrue() {
        equalsBuilder.setEquals(true);
        assertTrue(equalsBuilder.isEquals);
    }

    @Test
    void testSetEqualsFalse() {
        equalsBuilder.setEquals(false);
        assertFalse(equalsBuilder.isEquals);
    }
}