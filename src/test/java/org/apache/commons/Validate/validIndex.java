
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class ValidIndexTest {

    private List<String> collection;
    private String[] array;
    private String chars;

    @BeforeAll
    void setUp() {
        collection = new ArrayList<>(Arrays.asList("A", "B", "C"));
        array = new String[]{"A", "B", "C"};
        chars = "ABC";
    }

    @Test
    void validIndex_shouldNotThrowException_whenIndexIsValidForCollection() {
        assertDoesNotThrow(() -> Validate.validIndex(collection, 0));
        assertDoesNotThrow(() -> Validate.validIndex(collection, 2));
    }

    @Test
    void validIndex_shouldThrowException_whenIndexIsNegativeForCollection() {
        assertThrows(IndexOutOfBoundsException.class, () -> Validate.validIndex(collection, -1));
    }

    @Test
    void validIndex_shouldThrowException_whenIndexIsOutOfBoundsForCollection() {
        assertThrows(IndexOutOfBoundsException.class, () -> Validate.validIndex(collection, 3));
    }

    @Test
    void validIndex_shouldNotThrowException_whenIndexIsValidForArray() {
        assertDoesNotThrow(() -> Validate.validIndex(array, 0));
        assertDoesNotThrow(() -> Validate.validIndex(array, 2));
    }

    @Test
    void validIndex_shouldThrowException_whenIndexIsNegativeForArray() {
        assertThrows(IndexOutOfBoundsException.class, () -> Validate.validIndex(array, -1));
    }

    @Test
    void validIndex_shouldThrowException_whenIndexIsOutOfBoundsForArray() {
        assertThrows(IndexOutOfBoundsException.class, () -> Validate.validIndex(array, 3));
    }

    @Test
    void validIndex_shouldNotThrowException_whenIndexIsValidForChars() {
        assertDoesNotThrow(() -> Validate.validIndex(chars, 0));
        assertDoesNotThrow(() -> Validate.validIndex(chars, 2));
    }

    @Test
    void validIndex_shouldThrowException_whenIndexIsNegativeForChars() {
        assertThrows(IndexOutOfBoundsException.class, () -> Validate.validIndex(chars, -1));
    }

    @Test
    void validIndex_shouldThrowException_whenIndexIsOutOfBoundsForChars() {
        assertThrows(IndexOutOfBoundsException.class, () -> Validate.validIndex(chars, 3));
    }
}
