import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class getValueTest {
    private MutableObject<String> mutableObject;

    @BeforeEach
    void setUp() {
        mutableObject = new MutableObject<>();
    }

    @Test
    void testGetValueIsNull() {
        assertNull(mutableObject.getValue());
    }

    @Test
    void testGetValueIsNotNull() {
        mutableObject = new MutableObject<>("Hello");
        assertEquals("Hello", mutableObject.getValue());
    }
}