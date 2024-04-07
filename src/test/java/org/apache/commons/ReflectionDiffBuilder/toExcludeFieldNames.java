import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toExcludeFieldNamesTest {

    @Test
    void testToExcludeFieldNames_withNullInput_shouldReturnEmptyArray() {
        String[] excludeFieldNames = null;
        String[] result = ReflectionDiffBuilder.toExcludeFieldNames(excludeFieldNames);
        assertEquals(0, result.length);
    }

    @Test
    void testToExcludeFieldNames_withEmptyInput_shouldReturnEmptyArray() {
        String[] excludeFieldNames = new String[0];
        String[] result = ReflectionDiffBuilder.toExcludeFieldNames(excludeFieldNames);
        assertEquals(0, result.length);
    }

    @Test
    void testToExcludeFieldNames_withValidInput_shouldReturnSortedArrayWithoutNulls() {
        String[] excludeFieldNames = {"password", null, "lastModificationDate"};
        String[] result = ReflectionDiffBuilder.toExcludeFieldNames(excludeFieldNames);
        assertArrayEquals(new String[]{"lastModificationDate", "password"}, result);
    }
}