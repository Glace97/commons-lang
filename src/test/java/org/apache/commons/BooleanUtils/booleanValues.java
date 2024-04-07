import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class booleanValuesTest {
    
    @Test
    void testBooleanValues() {
        Boolean[] expected = {Boolean.FALSE, Boolean.TRUE};
        Boolean[] actual = BooleanUtils.booleanValues();
        assertArrayEquals(expected, actual);
    }
}