import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class addTest {

    private MutableShort mutableShort;

    @BeforeEach
    void setUp() {
        mutableShort = new MutableShort();
    }

    @Test
    void testAddWithNumberOperand() {
        mutableShort.add(NumberUtils.createNumber("10"));
        assertEquals(10, mutableShort.getValue());
    }

    @Test
    void testAddWithShortOperand() {
        mutableShort.add((short) 5);
        assertEquals(5, mutableShort.getValue());
    }

    @Test
    void testAddWithNegativeNumberOperand() {
        mutableShort.add(NumberUtils.createNumber("-10"));
        assertEquals(-10, mutableShort.getValue());
    }

    @Test
    void testAddWithNegativeShortOperand() {
        mutableShort.add((short) -5);
        assertEquals(-5, mutableShort.getValue());
    }

    @Test
    void testAddWithZeroOperand() {
        mutableShort.add(NumberUtils.createNumber("0"));
        assertEquals(0, mutableShort.getValue());
    }

}