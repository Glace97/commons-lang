
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IndexOfDifferenceTest {

    @Test
    void testIndexOfDifference_nullInput() {
        int result = StringUtils.indexOfDifference((CharSequence[]) null);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testIndexOfDifference_emptyInput() {
        int result = StringUtils.indexOfDifference();
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testIndexOfDifference_singleStringInput() {
        int result = StringUtils.indexOfDifference("abc");
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testIndexOfDifference_nullStringInput() {
        int result = StringUtils.indexOfDifference(null, null);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testIndexOfDifference_emptyStringInput() {
        int result = StringUtils.indexOfDifference("", "");
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testIndexOfDifference_sameStringInput() {
        int result = StringUtils.indexOfDifference("abc", "abc");
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testIndexOfDifference_differentLengthStringInput() {
        int result = StringUtils.indexOfDifference("abc", "abxyz");
        Assertions.assertEquals(2, result);
    }

    @Test
    void testIndexOfDifference_differentStringInput() {
        int result = StringUtils.indexOfDifference("abcde", "xyz");
        Assertions.assertEquals(0, result);
    }

    @Test
    void testIndexOfDifference_mixedStringInput() {
        int result = StringUtils.indexOfDifference("i am a machine", "i am a robot");
        Assertions.assertEquals(7, result);
    }
}
