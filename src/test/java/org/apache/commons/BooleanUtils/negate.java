import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class negateTest {

    @Test
    void testNegateTrue() {
        Boolean result = BooleanUtils.negate(Boolean.TRUE);
        Assertions.assertEquals(Boolean.FALSE, result);
    }

    @Test
    void testNegateFalse() {
        Boolean result = BooleanUtils.negate(Boolean.FALSE);
        Assertions.assertEquals(Boolean.TRUE, result);
    }

    @Test
    void testNegateNull() {
        Boolean result = BooleanUtils.negate(null);
        Assertions.assertNull(result);
    }

}