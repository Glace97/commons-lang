import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setUseIdentityHashCodeTest {

    private StandardToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new StandardToStringStyle();
    }

    @Test
    void setUseIdentityHashCode_true() {
        style.setUseIdentityHashCode(true);
        assertTrue(style.isUseIdentityHashCode());
    }

    @Test
    void setUseIdentityHashCode_false() {
        style.setUseIdentityHashCode(false);
        assertFalse(style.isUseIdentityHashCode());
    }
}