import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrimitiveValuesTest {
    
    @Test
    void testPrimitiveValues() {
        boolean[] expected = {false, true};
        boolean[] actual = BooleanUtils.primitiveValues();
        assertArrayEquals(expected, actual);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"false", "no", "off", "on", "true", "yes"})
    void testPrimitiveValuesWithStrings(String str) {
        boolean[] expected = {false, true};
        boolean[] actual = BooleanUtils.primitiveValues();
        assertTrue(Arrays.stream(actual).anyMatch(value -> value == BooleanUtils.TRUE.equalsIgnoreCase(str)));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"FALSE", "NO", "OFF", "ON", "TRUE", "YES"})
    void testPrimitiveValuesWithUppercaseStrings(String str) {
        boolean[] expected = {false, true};
        boolean[] actual = BooleanUtils.primitiveValues();
        assertTrue(Arrays.stream(actual).anyMatch(value -> value == BooleanUtils.TRUE.equalsIgnoreCase(str.toLowerCase())));
    }
    
    @Test
    void testPrimitiveValuesLength() {
        boolean[] actual = BooleanUtils.primitiveValues();
        assertEquals(2, actual.length);
    }
}