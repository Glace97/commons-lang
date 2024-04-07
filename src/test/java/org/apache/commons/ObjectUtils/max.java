
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class maxTest {

    @Test
    void testMaxWithNullValues() {
        Integer[] values = {null, null, null};
        Integer result = ObjectUtils.max(values);
        Assertions.assertNull(result);
    }

    @Test
    void testMaxWithOneValue() {
        Integer[] values = {10};
        Integer result = ObjectUtils.max(values);
        Assertions.assertEquals(10, result);
    }

    @Test
    void testMaxWithMultipleValues() {
        Integer[] values = {5, 10, 3, 8, 2};
        Integer result = ObjectUtils.max(values);
        Assertions.assertEquals(10, result);
    }

    @Test
    void testMaxWithMixedValues() {
        Integer[] values = {5, null, 3, null, 2};
        Integer result = ObjectUtils.max(values);
        Assertions.assertEquals(5, result);
    }

    @Test
    void testMaxWithEmptyArray() {
        Integer[] values = {};
        Integer result = ObjectUtils.max(values);
        Assertions.assertNull(result);
    }
}
