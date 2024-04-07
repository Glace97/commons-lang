import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class addTest {
    private MutableLong mutableLong;

    @BeforeEach
    void setUp() {
        mutableLong = new MutableLong();
    }

    @Test
    void testAddWithLongOperand() {
        mutableLong.add(5L);
        assertEquals(5L, mutableLong.getValue());
    }

    @Test
    void testAddWithNegativeLongOperand() {
        mutableLong.add(-10L);
        assertEquals(-10L, mutableLong.getValue());
    }

    @Test
    void testAddWithZeroOperand() {
        mutableLong.add(0L);
        assertEquals(0L, mutableLong.getValue());
    }

    @Test
    void testAddWithNumberOperand() {
        mutableLong.add(NumberUtils.createNumber("15"));
        assertEquals(15L, mutableLong.getValue());
    }

    @Test
    void testAddWithNegativeNumberOperand() {
        mutableLong.add(NumberUtils.createNumber("-20"));
        assertEquals(-20L, mutableLong.getValue());
    }

    @Test
    void testAddWithZeroNumberOperand() {
        mutableLong.add(NumberUtils.createNumber("0"));
        assertEquals(0L, mutableLong.getValue());
    }
}