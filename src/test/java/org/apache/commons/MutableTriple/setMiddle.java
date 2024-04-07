import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setMiddleTest {

    private MutableTriple<String, Integer, Boolean> mutableTriple;

    @BeforeEach
    void setUp() {
        mutableTriple = new MutableTriple<>("left", 123, true);
    }

    @Test
    void testSetMiddle() {
        assertNull(mutableTriple.middle);

        mutableTriple.setMiddle("middle");

        assertEquals("middle", mutableTriple.middle);
    }
}