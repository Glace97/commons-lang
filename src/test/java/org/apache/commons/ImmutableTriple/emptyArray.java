
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class emptyArrayTest {

    private ImmutableTriple<?, ?, ?>[] emptyArray;

    @BeforeEach
    void setUp() {
        emptyArray = ImmutableTriple.emptyArray();
    }

    @Test
    void testEmptyArrayNotNull() {
        assertNotNull(emptyArray);
    }

    @Test
    void testEmptyArrayEmpty() {
        assertEquals(0, emptyArray.length);
    }

    @Test
    void testEmptyArrayGenericTypes() {
        assertTrue(emptyArray instanceof ImmutableTriple<?, ?, ?>[]);
    }

    @Test
    void testEmptyArrayAssignment() {
        ImmutableTriple<?, ?, ?>[] array = emptyArray;
        assertNotNull(array);
    }

}
