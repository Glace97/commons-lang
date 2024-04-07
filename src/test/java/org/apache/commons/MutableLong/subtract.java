import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SubtractTest {

    private MutableLong mutableLong;

    @BeforeEach
    void setUp() {
        mutableLong = new MutableLong(10);
    }

    @Test
    void subtract_shouldSubtractValueFromInstance() {
        mutableLong.subtract(5);
        assertEquals(5, mutableLong.getValue());
    }

    @Test
    void subtract_shouldSubtractValueFromInstanceWithNegativeOperand() {
        mutableLong.subtract(-5);
        assertEquals(15, mutableLong.getValue());
    }

    @Test
    void subtract_shouldSubtractValueFromInstanceWithZeroOperand() {
        mutableLong.subtract(0);
        assertEquals(10, mutableLong.getValue());
    }

    @Test
    void subtract_shouldSubtractValueFromInstanceWithLargeOperand() {
        mutableLong.subtract(Long.MAX_VALUE);
        assertEquals(-9223372036854775807L, mutableLong.getValue());
    }

    @Test
    void subtract_shouldSubtractValueFromInstanceWithSmallOperand() {
        mutableLong.subtract(Long.MIN_VALUE);
        assertEquals(9223372036854775806L, mutableLong.getValue());
    }

    @Test
    void subtract_shouldSubtractValueFromInstanceUsingNumberOperand() {
        mutableLong.subtract(NumberUtils.createNumber("5"));
        assertEquals(5, mutableLong.getValue());
    }

    @Test
    void subtract_shouldSubtractValueFromInstanceUsingNumberOperandWithNegativeValue() {
        mutableLong.subtract(NumberUtils.createNumber("-5"));
        assertEquals(15, mutableLong.getValue());
    }

    @Test
    void subtract_shouldSubtractValueFromInstanceUsingNumberOperandWithZeroValue() {
        mutableLong.subtract(NumberUtils.createNumber("0"));
        assertEquals(10, mutableLong.getValue());
    }

    @Test
    void subtract_shouldSubtractValueFromInstanceUsingNumberOperandWithLargeValue() {
        mutableLong.subtract(NumberUtils.createNumber(String.valueOf(Long.MAX_VALUE)));
        assertEquals(-9223372036854775807L, mutableLong.getValue());
    }

    @Test
    void subtract_shouldSubtractValueFromInstanceUsingNumberOperandWithSmallValue() {
        mutableLong.subtract(NumberUtils.createNumber(String.valueOf(Long.MIN_VALUE)));
        assertEquals(9223372036854775806L, mutableLong.getValue());
    }
}