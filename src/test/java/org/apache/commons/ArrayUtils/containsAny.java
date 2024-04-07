import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class containsAnyTest {

    private ArrayUtils arrayUtils;

    @BeforeEach
    void setUp() {
        arrayUtils = new ArrayUtils();
    }

    @Test
    void testContainsAny_EmptyArray_ReturnsFalse() {
        Object[] array = {};
        Object[] objectsToFind = {1, 2, 3};

        boolean result = arrayUtils.containsAny(array, objectsToFind);

        assertFalse(result);
    }

    @Test
    void testContainsAny_NullArray_ReturnsFalse() {
        Object[] array = null;
        Object[] objectsToFind = {1, 2, 3};

        boolean result = arrayUtils.containsAny(array, objectsToFind);

        assertFalse(result);
    }

    @Test
    void testContainsAny_ArrayDoesNotContainObjects_ReturnsFalse() {
        Object[] array = {4, 5, 6};
        Object[] objectsToFind = {1, 2, 3};

        boolean result = arrayUtils.containsAny(array, objectsToFind);

        assertFalse(result);
    }

    @Test
    void testContainsAny_ArrayContainsObjects_ReturnsTrue() {
        Object[] array = {1, 2, 3, 4, 5};
        Object[] objectsToFind = {4, 5, 6};

        boolean result = arrayUtils.containsAny(array, objectsToFind);

        assertTrue(result);
    }

    @Test
    void testContainsAny_ArrayContainsSomeObjects_ReturnsTrue() {
        Object[] array = {1, 2, 3, 4, 5};
        Object[] objectsToFind = {4, 6};

        boolean result = arrayUtils.containsAny(array, objectsToFind);

        assertTrue(result);
    }

    @Test
    void testContainsAny_EmptyObjectsToFind_ReturnsFalse() {
        Object[] array = {1, 2, 3, 4, 5};
        Object[] objectsToFind = {};

        boolean result = arrayUtils.containsAny(array, objectsToFind);

        assertFalse(result);
    }

    @Test
    void testContainsAny_SingleElementArray_ReturnsTrue() {
        Object[] array = {1};
        Object[] objectsToFind = {1};

        boolean result = arrayUtils.containsAny(array, objectsToFind);

        assertTrue(result);
    }

    @Test
    void testContainsAny_SingleElementArray_DoesNotContainObject_ReturnsFalse() {
        Object[] array = {1};
        Object[] objectsToFind = {2};

        boolean result = arrayUtils.containsAny(array, objectsToFind);

        assertFalse(result);
    }

    @Test
    void testContainsAny_EmptyArrayAndObjectsToFind_ReturnsFalse() {
        Object[] array = {};
        Object[] objectsToFind = {};

        boolean result = arrayUtils.containsAny(array, objectsToFind);

        assertFalse(result);
    }
}