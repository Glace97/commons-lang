import org.junit.jupiter.api.Test;
import java.util.function.Predicate;

class ltTest {

    @Test
    void testLt() {
        // Test case 1: a < b
        Predicate<Integer> predicate1 = ComparableUtils.lt(10);
        assert(predicate1.test(5));

        // Test case 2: a = b
        Predicate<Integer> predicate2 = ComparableUtils.lt(10);
        assert(!predicate2.test(10));

        // Test case 3: a > b
        Predicate<Integer> predicate3 = ComparableUtils.lt(10);
        assert(!predicate3.test(15));
    }
}