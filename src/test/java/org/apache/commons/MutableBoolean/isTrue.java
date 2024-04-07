import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class isTrueTest {

    private MutableBoolean mutableBoolean;

    @BeforeAll
    public void setUp() {
        mutableBoolean = new MutableBoolean();
    }

    @Test
    void testIsTrueReturnsFalseByDefault() {
        assertFalse(mutableBoolean.isTrue());
    }

    @Test
    void testIsTrueReturnsTrueWhenValueIsTrue() {
        mutableBoolean = new MutableBoolean(true);
        assertTrue(mutableBoolean.isTrue());
    }

    @Test
    void testIsTrueReturnsFalseWhenValueIsFalse() {
        mutableBoolean = new MutableBoolean(false);
        assertFalse(mutableBoolean.isTrue());
    }

    @Test
    void testIsTrueReturnsTrueWhenValueIsBooleanTrue() {
        mutableBoolean = new MutableBoolean(Boolean.TRUE);
        assertTrue(mutableBoolean.isTrue());
    }

    @Test
    void testIsTrueReturnsFalseWhenValueIsBooleanFalse() {
        mutableBoolean = new MutableBoolean(Boolean.FALSE);
        assertFalse(mutableBoolean.isTrue());
    }
}