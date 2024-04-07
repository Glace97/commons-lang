import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getAndAddTest {

    @Test
    void testGetAndAddWithPositiveOperand() {
        MutableShort mutableShort = new MutableShort((short) 5);
        short result = mutableShort.getAndAdd((short) 3);
        assertEquals(5, result);
        assertEquals(8, mutableShort.getValue());
    }

    @Test
    void testGetAndAddWithNegativeOperand() {
        MutableShort mutableShort = new MutableShort((short) 5);
        short result = mutableShort.getAndAdd((short) -3);
        assertEquals(5, result);
        assertEquals(2, mutableShort.getValue());
    }

    @Test
    void testGetAndAddWithZeroOperand() {
        MutableShort mutableShort = new MutableShort((short) 5);
        short result = mutableShort.getAndAdd((short) 0);
        assertEquals(5, result);
        assertEquals(5, mutableShort.getValue());
    }

    @Test
    void testGetAndAddWithMaxValueOperand() {
        MutableShort mutableShort = new MutableShort((short) 5);
        short result = mutableShort.getAndAdd(Short.MAX_VALUE);
        assertEquals(5, result);
        assertEquals((short) (5 + Short.MAX_VALUE), mutableShort.getValue());
    }

    @Test
    void testGetAndAddWithMinValueOperand() {
        MutableShort mutableShort = new MutableShort((short) 5);
        short result = mutableShort.getAndAdd(Short.MIN_VALUE);
        assertEquals(5, result);
        assertEquals((short) (5 + Short.MIN_VALUE), mutableShort.getValue());
    }
}