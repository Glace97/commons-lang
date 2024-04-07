import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class minTest {

    private ObjectUtils utils;

    @BeforeEach
    void setUp() {
        utils = new ObjectUtils();
    }

    @Test
    void testMinWithNullValues() {
        assertNull(utils.min((Integer) null));
        assertNull(utils.min((String) null));
        assertNull(utils.min((Double) null));
        assertNull(utils.min((Boolean) null));
    }

    @Test
    void testMinWithArray() {
        Integer[] intArray = {5, 3, 8, 2, 9};
        assertEquals(2, utils.min(intArray));
        
        String[] strArray = {"apple", "banana", "cherry"};
        assertEquals("apple", utils.min(strArray));
        
        Double[] doubleArray = {3.14, 2.71, 1.618};
        assertEquals(1.618, utils.min(doubleArray));
        
        Boolean[] boolArray = {true, false, true};
        assertEquals(false, utils.min(boolArray));
    }

    @Test
    void testMinWithComparableObjects() {
        Integer num1 = 10;
        Integer num2 = 5;
        assertEquals(5, utils.min(num1, num2));

        String str1 = "hello";
        String str2 = "world";
        assertEquals("hello", utils.min(str1, str2));

        Double decimal1 = 3.14;
        Double decimal2 = 2.71;
        assertEquals(2.71, utils.min(decimal1, decimal2));

        Boolean bool1 = true;
        Boolean bool2 = false;
        assertEquals(false, utils.min(bool1, bool2));
    }

    @Test
    void testMinWithMixedObjects() {
        Integer num = 10;
        String str = "hello";
        Double decimal = 3.14;
        Boolean bool = true;
        assertEquals(3.14, utils.min(num, str, decimal, bool));
        
        assertEquals("hello", utils.min(str, num, decimal, bool));

        assertEquals(false, utils.min(bool, str, decimal, num));
    }

    static Stream<Comparable[]> provideComparableArrays() {
        return Stream.of(
                new Comparable[]{5, 3, 8, 2, 9},
                new Comparable[]{"apple", "banana", "cherry"},
                new Comparable[]{3.14, 2.71, 1.618},
                new Comparable[]{true, false, true}
        );
    }

    @ParameterizedTest
    @MethodSource("provideComparableArrays")
    void testMinWithParameterizedArrays(Comparable[] array) {
        Comparable expected = Arrays.stream(array)
                .min(Comparator.naturalOrder())
                .orElse(null);
        assertEquals(expected, utils.min(array));
    }
}