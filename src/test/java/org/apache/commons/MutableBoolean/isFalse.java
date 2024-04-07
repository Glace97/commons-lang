import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isFalseTest {

    private MutableBoolean mutableBoolean;

    @BeforeEach
    void setUp() {
        mutableBoolean = new MutableBoolean();
    }

    @Test
    void testIsFalse() {
        assertTrue(mutableBoolean.isFalse());
        mutableBoolean = new MutableBoolean(true);
        assertFalse(mutableBoolean.isFalse());
    }

    @Test
    void testIsFalseWithNullValue() {
        MutableBoolean nullMutableBoolean = new MutableBoolean((Boolean) null);
        assertFalse(nullMutableBoolean.isFalse());
    }
}