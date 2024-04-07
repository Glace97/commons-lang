import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getAndAddTest {

    private MutableByte mutableByte;

    @BeforeAll
    void setup() {
        mutableByte = new MutableByte((byte) 5);
    }

    @Test
    void testGetAndAdd_byteOperand_shouldReturnPreviousValue() {
        byte operand = 2;
        byte previousValue = mutableByte.getAndAdd(operand);
        Assertions.assertEquals((byte) 5, previousValue);
    }

    @Test
    void testGetAndAdd_byteOperand_shouldIncrementValue() {
        byte operand = 2;
        mutableByte.getAndAdd(operand);
        Assertions.assertEquals((byte) 7, mutableByte.getValue());
    }

    @Test
    void testGetAndAdd_numberOperand_shouldReturnPreviousValue() {
        Number operand = 2;
        byte previousValue = mutableByte.getAndAdd(operand);
        Assertions.assertEquals((byte) 7, previousValue);
    }

    @Test
    void testGetAndAdd_numberOperand_shouldIncrementValue() {
        Number operand = 2;
        mutableByte.getAndAdd(operand);
        Assertions.assertEquals((byte) 9, mutableByte.getValue());
    }

    @Test
    void testGetAndAdd_negativeOperand_shouldReturnPreviousValue() {
        byte operand = -2;
        byte previousValue = mutableByte.getAndAdd(operand);
        Assertions.assertEquals((byte) 9, previousValue);
    }

    @Test
    void testGetAndAdd_negativeOperand_shouldDecrementValue() {
        byte operand = -2;
        mutableByte.getAndAdd(operand);
        Assertions.assertEquals((byte) 7, mutableByte.getValue());
    }

    @Test
    void testGetAndAdd_zeroOperand_shouldReturnPreviousValue() {
        byte operand = 0;
        byte previousValue = mutableByte.getAndAdd(operand);
        Assertions.assertEquals((byte) 7, previousValue);
    }

    @Test
    void testGetAndAdd_zeroOperand_shouldNotChangeValue() {
        byte operand = 0;
        mutableByte.getAndAdd(operand);
        Assertions.assertEquals((byte) 7, mutableByte.getValue());
    }

}