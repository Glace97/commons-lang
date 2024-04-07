import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class gtTest {

    private static final int MIN_VALUE = Integer.MIN_VALUE;
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    private ComparableUtils comparableUtils = new ComparableUtils();

    private static Predicate<Integer> createPredicate(int b) {
        return ComparableUtils.gt(b);
    }

    @ParameterizedTest
    @MethodSource("createPredicate")
    void gt_ShouldReturnTrue_WhenValueIsGreaterThanB(Predicate<Integer> predicate) {
        assertTrue(predicate.test(10));
        assertTrue(predicate.test(100));
        assertTrue(predicate.test(MAX_VALUE));
    }

    @ParameterizedTest
    @MethodSource("createPredicate")
    void gt_ShouldReturnFalse_WhenValueIsLessThanOrEqualToB(Predicate<Integer> predicate) {
        assertFalse(predicate.test(0));
        assertFalse(predicate.test(-10));
        assertFalse(predicate.test(MIN_VALUE));
    }

    @Test
    void gt_ShouldReturnFalse_WhenValueIsEqualToB() {
        Predicate<Integer> predicate = ComparableUtils.gt(10);
        assertFalse(predicate.test(10));
    }
}