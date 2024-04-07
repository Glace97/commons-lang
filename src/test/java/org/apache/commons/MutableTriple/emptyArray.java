import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class emptyArrayTest {

    @Test
    void testEmptyArray() {
        MutableTriple<?, ?, ?>[] emptyArray = MutableTriple.emptyArray();
        assertNotNull(emptyArray);
        assertEquals(0, emptyArray.length);
    }
}