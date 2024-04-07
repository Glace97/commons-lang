import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class isNotEmptyTest {

    @Test
    void nullObject_shouldReturnFalse() {
        assertFalse(ObjectUtils.isNotEmpty(null));
    }

    @Test
    void emptyString_shouldReturnFalse() {
        assertFalse(ObjectUtils.isNotEmpty(""));
    }

    @Test
    void nonEmptyString_shouldReturnTrue() {
        assertTrue(ObjectUtils.isNotEmpty("ab"));
    }

    @Test
    void emptyArray_shouldReturnFalse() {
        assertFalse(ObjectUtils.isNotEmpty(new int[] {}));
    }

    @Test
    void nonEmptyArray_shouldReturnTrue() {
        assertTrue(ObjectUtils.isNotEmpty(new int[] {1, 2, 3}));
    }

    @Test
    void nonEmptyCollection_shouldReturnTrue() {
        assertTrue(ObjectUtils.isNotEmpty(Collections.singletonList("item")));
    }

    @Test
    void emptyMap_shouldReturnFalse() {
        assertFalse(ObjectUtils.isNotEmpty(Collections.emptyMap()));
    }

    @Test
    void nonEmptyMap_shouldReturnTrue() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        assertTrue(ObjectUtils.isNotEmpty(map));
    }

    @Test
    void emptyOptional_shouldReturnFalse() {
        assertFalse(ObjectUtils.isNotEmpty(Optional.empty()));
    }

    @Test
    void nonEmptyOptional_shouldReturnTrue() {
        assertTrue(ObjectUtils.isNotEmpty(Optional.of("value")));
    }
}