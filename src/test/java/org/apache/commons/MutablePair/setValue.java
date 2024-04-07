import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setValueTest {

    private MutablePair<String, Integer> pair;

    @BeforeEach
    void setUp() {
        pair = new MutablePair<>("left", 10);
    }

    @Test
    void setValue_shouldSetRightValueAndReturnOldValue() {
        Integer oldValue = pair.setValue(20);
        assertEquals(10, oldValue);
        assertEquals(20, pair.getRight());
    }

    @Test
    void setValue_shouldSetRightValueAndReturnNullIfPreviousValueIsNull() {
        pair = new MutablePair<>("left", null);
        Integer oldValue = pair.setValue(20);
        assertNull(oldValue);
        assertEquals(20, pair.getRight());
    }

    @Test
    void setValue_shouldNotChangeLeftValue() {
        pair.setValue(20);
        assertEquals("left", pair.getLeft());
    }

    @Test
    void setValue_shouldNotChangeOtherFields() {
        pair.setValue(20);
        assertNull(pair.EMPTY_ARRAY);
        assertEquals(4954918890077093841L, pair.serialVersionUID);
    }
}