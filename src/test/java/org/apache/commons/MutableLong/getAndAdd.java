import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getAndAddTest {
    private MutableLong mutableLong;

    @BeforeEach
    void setUp() {
        mutableLong = new MutableLong(5);
    }

    @Test
    void testGetAndAddLong() {
        long result = mutableLong.getAndAdd(3);
        Assertions.assertEquals(5, result);
        Assertions.assertEquals(8, mutableLong.getValue());
    }

    @Test
    void testGetAndAddLongWithNegativeOperand() {
        long result = mutableLong.getAndAdd(-3);
        Assertions.assertEquals(5, result);
        Assertions.assertEquals(2, mutableLong.getValue());
    }

    @Test
    void testGetAndAddNumber() {
        long result = mutableLong.getAndAdd(NumberUtils.createNumber("3"));
        Assertions.assertEquals(5, result);
        Assertions.assertEquals(8, mutableLong.getValue());
    }

    @Test
    void testGetAndAddNumberWithNegativeOperand() {
        long result = mutableLong.getAndAdd(NumberUtils.createNumber("-3"));
        Assertions.assertEquals(5, result);
        Assertions.assertEquals(2, mutableLong.getValue());
    }

    @Test
    void testGetAndAddLongMaxValue() {
        long result = mutableLong.getAndAdd(Long.MAX_VALUE);
        Assertions.assertEquals(5, result);
        Assertions.assertEquals(Long.MIN_VALUE, mutableLong.getValue());
    }

    @Test
    void testGetAndAddLongMinValue() {
        long result = mutableLong.getAndAdd(Long.MIN_VALUE);
        Assertions.assertEquals(5, result);
        Assertions.assertEquals(-9223372036854775803L, mutableLong.getValue());
    }

    @Test
    void testGetAndAddNumberMaxValue() {
        long result = mutableLong.getAndAdd(NumberUtils.createNumber(String.valueOf(Long.MAX_VALUE)));
        Assertions.assertEquals(5, result);
        Assertions.assertEquals(Long.MIN_VALUE, mutableLong.getValue());
    }

    @Test
    void testGetAndAddNumberMinValue() {
        long result = mutableLong.getAndAdd(NumberUtils.createNumber(String.valueOf(Long.MIN_VALUE)));
        Assertions.assertEquals(5, result);
        Assertions.assertEquals(-9223372036854775803L, mutableLong.getValue());
    }

    @Test
    void testGetAndAddZero() {
        long result = mutableLong.getAndAdd(0);
        Assertions.assertEquals(5, result);
        Assertions.assertEquals(5, mutableLong.getValue());
    }
}