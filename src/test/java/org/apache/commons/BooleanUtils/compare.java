import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CompareTest {

    @Test
    void compareShouldReturnZeroWhenBothBooleansAreEqual() {
        boolean x = true;
        boolean y = true;

        int result = BooleanUtils.compare(x, y);

        assertEquals(0, result);
    }

    @Test
    void compareShouldReturnOneWhenFirstBooleanIsTrueAndSecondBooleanIsFalse() {
        boolean x = true;
        boolean y = false;

        int result = BooleanUtils.compare(x, y);

        assertEquals(1, result);
    }

    @Test
    void compareShouldReturnNegativeOneWhenFirstBooleanIsFalseAndSecondBooleanIsTrue() {
        boolean x = false;
        boolean y = true;

        int result = BooleanUtils.compare(x, y);

        assertEquals(-1, result);
    }

    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    void compareShouldReturnZeroWhenBothBooleansAreEqual(boolean x) {
        int result = BooleanUtils.compare(x, x);

        assertEquals(0, result);
    }

    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    void compareShouldReturnOneWhenFirstBooleanIsTrueAndSecondBooleanIsFalse(boolean x) {
        boolean y = !x;

        int result = BooleanUtils.compare(x, y);

        assertEquals(1, result);
    }

    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    void compareShouldReturnNegativeOneWhenFirstBooleanIsFalseAndSecondBooleanIsTrue(boolean x) {
        boolean y = !x;

        int result = BooleanUtils.compare(y, x);

        assertEquals(-1, result);
    }
}