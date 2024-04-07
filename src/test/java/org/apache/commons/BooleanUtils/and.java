import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class andTest {

    private BooleanUtils booleanUtils;

    @BeforeAll
    void setUp() {
        booleanUtils = new BooleanUtils();
    }

    @Test
    @DisplayName("Test 'and' method with all true values")
    void testAndAllTrue() {
        boolean result = booleanUtils.and(true, true, true);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test 'and' method with all false values")
    void testAndAllFalse() {
        boolean result = booleanUtils.and(false, false, false);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test 'and' method with a mix of true and false values")
    void testAndMixTrueAndFalse() {
        boolean result = booleanUtils.and(true, false, true);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test 'and' method with an empty array")
    void testAndEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            booleanUtils.and();
        });
    }

    @Test
    @DisplayName("Test 'and' method with an array containing null values")
    void testAndArrayWithNullValues() {
        Boolean[] array = { true, null, false };
        boolean result = booleanUtils.and(array);
        assertFalse(result);
    }
}