import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class setRightTest {

    private MutableTriple<String, Integer, Boolean> triple;

    @BeforeEach
    void setUp() {
        triple = new MutableTriple<>("foo", 123, true);
    }

    @Test
    void testSetRight() {
        assertNull(triple.right);

        triple.setRight("bar");
        assertEquals("bar", triple.right);

        triple.setRight(null);
        assertNull(triple.right);
    }
}