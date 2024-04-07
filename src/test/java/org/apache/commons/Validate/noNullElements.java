
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class noNullElementsTest {

    private Validate validate;

    @BeforeAll
    void setUp() {
        validate = new Validate();
    }

    @Test
    void testNoNullElementsWithIterableNoNullElements() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assertEquals(list, validate.noNullElements(list));
    }

    @Test
    void testNoNullElementsWithIterableNullElements() {
        List<String> list = new ArrayList<>(Arrays.asList("a", null, "c"));
        assertThrows(IllegalArgumentException.class, () -> validate.noNullElements(list));
    }

    @Test
    void testNoNullElementsWithIterableAndMessageNoNullElements() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assertEquals(list, validate.noNullElements(list, "The collection contains null at position %d"));
    }

    @Test
    void testNoNullElementsWithIterableAndMessageNullElements() {
        List<String> list = new ArrayList<>(Arrays.asList("a", null, "c"));
        assertThrows(IllegalArgumentException.class, () -> validate.noNullElements(list, "The collection contains null at position %d"));
    }

    @Test
    void testNoNullElementsWithArrayNoNullElements() {
        String[] array = {"a", "b", "c"};
        assertArrayEquals(array, validate.noNullElements(array));
    }

    @Test
    void testNoNullElementsWithArrayNullElements() {
        String[] array = {"a", null, "c"};
        assertThrows(IllegalArgumentException.class, () -> validate.noNullElements(array));
    }

    @Test
    void testNoNullElementsWithArrayAndMessageNoNullElements() {
        String[] array = {"a", "b", "c"};
        assertArrayEquals(array, validate.noNullElements(array, "The array contain null at position %d"));
    }

    @Test
    void testNoNullElementsWithArrayAndMessageNullElements() {
        String[] array = {"a", null, "c"};
        assertThrows(IllegalArgumentException.class, () -> validate.noNullElements(array, "The array contain null at position %d"));
    }
}
