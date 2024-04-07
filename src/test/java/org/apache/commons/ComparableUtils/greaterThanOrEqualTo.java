import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.Predicate;

class greaterThanOrEqualToTest {

    private ComparableUtils.ComparableCheckBuilder<Integer> builder;

    @BeforeEach
    void setUp() {
        builder = new ComparableUtils.ComparableCheckBuilder<>(5);
    }

    @Test
    void testGreaterThanOrEqualTo() {
        assertTrue(builder.greaterThanOrEqualTo(3));
        assertTrue(builder.greaterThanOrEqualTo(5));
        assertFalse(builder.greaterThanOrEqualTo(7));
    }
}