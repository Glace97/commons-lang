import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getDefaultStyleTest {

    private ToStringBuilder toStringBuilder;

    @BeforeEach
    void setUp() {
        toStringBuilder = new ToStringBuilder(null);
    }

    @Test
    void testGetDefaultStyleNotNull() {
        assertNotNull(ToStringBuilder.getDefaultStyle());
    }

    @Test
    void testGetDefaultStyleSameInstance() {
        assertSame(ToStringBuilder.getDefaultStyle(), ToStringBuilder.getDefaultStyle());
    }
}