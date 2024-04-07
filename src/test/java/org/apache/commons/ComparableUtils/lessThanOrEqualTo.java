import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class lessThanOrEqualToTest {

    private ComparableUtils.ComparableCheckBuilder<Integer> builder;

    @BeforeEach
    void setUp() {
        builder = new ComparableUtils.ComparableCheckBuilder<>(5);
    }

    @Test
    void testLessThanOrEqualTo() {
        assertTrue(builder.lessThanOrEqualTo(10));
        assertTrue(builder.lessThanOrEqualTo(5));
    }

    @Test
    void testNotLessThanOrEqualTo() {
        assertFalse(builder.lessThanOrEqualTo(2));
        assertFalse(builder.lessThanOrEqualTo(0));
    }

    @Test
    void testLessThanOrEqualToWithEqualValues() {
        assertTrue(builder.lessThanOrEqualTo(5));
    }
}