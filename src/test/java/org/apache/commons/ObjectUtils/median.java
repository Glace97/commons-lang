import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

class medianTest {

    @Test
    void testMedianWithComparable() {
        Integer[] numbers = {1, 2, 3, 4, 5};
        Integer median = ObjectUtils.median(numbers);
        Assertions.assertEquals(3, median);
    }

    @Test
    void testMedianWithComparableEvenNumberOfItems() {
        Integer[] numbers = {1, 2, 3, 4};
        Integer median = ObjectUtils.median(numbers);
        Assertions.assertEquals(2, median);
    }

    @Test
    void testMedianWithComparableEmptyArray() {
        Integer[] numbers = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.median(numbers);
        });
    }

    @Test
    void testMedianWithComparableNullElement() {
        Integer[] numbers = {1, 2, null, 4, 5};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.median(numbers);
        });
    }

    @Test
    void testMedianWithComparator() {
        String[] strings = {"aa", "bbb", "cc", "d"};
        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);
        String median = ObjectUtils.median(lengthComparator, strings);
        Assertions.assertEquals("cc", median);
    }

    @Test
    void testMedianWithComparatorEvenNumberOfItems() {
        String[] strings = {"aa", "bbb", "cc", "d", "eee"};
        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);
        String median = ObjectUtils.median(lengthComparator, strings);
        Assertions.assertEquals("cc", median);
    }

    @Test
    void testMedianWithComparatorEmptyArray() {
        String[] strings = {};
        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.median(lengthComparator, strings);
        });
    }

    @Test
    void testMedianWithComparatorNullElement() {
        String[] strings = {"aa", "bbb", null, "d", "eee"};
        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ObjectUtils.median(lengthComparator, strings);
        });
    }
}