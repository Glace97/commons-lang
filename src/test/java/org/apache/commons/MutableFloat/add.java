import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class addTest {

    private MutableFloat mutableFloat;

    @BeforeEach
    void setUp() {
        mutableFloat = new MutableFloat();
    }

    @Test
    void add_floatOperand_shouldAddToValue() {
        mutableFloat.add(2.5f);
        assertEquals(2.5f, mutableFloat.getValue());
    }

    @Test
    void add_floatOperandWithNegativeValue_shouldSubtractFromValue() {
        mutableFloat.add(-1.5f);
        assertEquals(-1.5f, mutableFloat.getValue());
    }

    @Test
    void add_zeroOperand_shouldNotChangeValue() {
        mutableFloat.add(0f);
        assertEquals(0f, mutableFloat.getValue());
    }

    @Test
    void add_numberOperand_shouldAddToValue() {
        mutableFloat.add(3.7);
        assertEquals(3.7f, mutableFloat.getValue());
    }

    @Test
    void add_numberOperandWithNegativeValue_shouldSubtractFromValue() {
        mutableFloat.add(-2.3);
        assertEquals(-2.3f, mutableFloat.getValue());
    }
}