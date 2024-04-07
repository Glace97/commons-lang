import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class toNoNullStringArrayTest {

    @Test
    void testToNoNullStringArray_withNullCollection_returnsEmptyArray() {
        Collection<String> collection = null;
        String[] expectedArray = {};
        String[] resultArray = ReflectionToStringBuilder.toNoNullStringArray(collection);
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    void testToNoNullStringArray_withEmptyCollection_returnsEmptyArray() {
        Collection<String> collection = new ArrayList<>();
        String[] expectedArray = {};
        String[] resultArray = ReflectionToStringBuilder.toNoNullStringArray(collection);
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    void testToNoNullStringArray_withCollectionContainingNull_returnsArrayWithoutNull() {
        Collection<String> collection = new ArrayList<>(Arrays.asList("a", null, "b"));
        String[] expectedArray = {"a", "b"};
        String[] resultArray = ReflectionToStringBuilder.toNoNullStringArray(collection);
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    void testToNoNullStringArray_withNullArray_returnsEmptyArray() {
        Object[] array = null;
        String[] expectedArray = {};
        String[] resultArray = ReflectionToStringBuilder.toNoNullStringArray(array);
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    void testToNoNullStringArray_withEmptyArray_returnsEmptyArray() {
        Object[] array = {};
        String[] expectedArray = {};
        String[] resultArray = ReflectionToStringBuilder.toNoNullStringArray(array);
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    void testToNoNullStringArray_withArrayContainingNull_returnsArrayWithoutNull() {
        Object[] array = {"a", null, "b"};
        String[] expectedArray = {"a", "b"};
        String[] resultArray = ReflectionToStringBuilder.toNoNullStringArray(array);
        assertArrayEquals(expectedArray, resultArray);
    }
}