import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class subtractTest {

    @Test
    void testSubtractWithIntOperand() {
        MutableInt mutableInt = new MutableInt(10);
        mutableInt.subtract(5);
        assertEquals(5, mutableInt.getValue());
    }

    @Test
    void testSubtractWithNegativeIntOperand() {
        MutableInt mutableInt = new MutableInt(10);
        mutableInt.subtract(-5);
        assertEquals(15, mutableInt.getValue());
    }

    @Test
    void testSubtractWithZeroOperand() {
        MutableInt mutableInt = new MutableInt(10);
        mutableInt.subtract(0);
        assertEquals(10, mutableInt.getValue());
    }

    @Test
    void testSubtractWithNumberOperand() {
        MutableInt mutableInt = new MutableInt(10);
        mutableInt.subtract(NumberUtils.createNumber("5"));
        assertEquals(5, mutableInt.getValue());
    }

    @Test
    void testSubtractWithNegativeNumberOperand() {
        MutableInt mutableInt = new MutableInt(10);
        mutableInt.subtract(NumberUtils.createNumber("-5"));
        assertEquals(15, mutableInt.getValue());
    }

    @Test
    void testSubtractWithZeroNumberOperand() {
        MutableInt mutableInt = new MutableInt(10);
        mutableInt.subtract(NumberUtils.createNumber("0"));
        assertEquals(10, mutableInt.getValue());
    }
}

Note: The test class assumes that the MutableInt class has a getter method called "getValue()" to retrieve the value of the MutableInt object. If this method does not exist, please modify the test cases accordingly.