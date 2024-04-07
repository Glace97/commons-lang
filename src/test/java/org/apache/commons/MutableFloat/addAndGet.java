import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class addAndGetTest {

    @Test
    public void testAddAndGet_floatOperand() {
        MutableFloat mutableFloat = new MutableFloat(10.0f);
        float result = mutableFloat.addAndGet(5.0f);
        assertEquals(15.0f, result);
        assertEquals(15.0f, mutableFloat.getValue());
    }

    @Test
    public void testAddAndGet_floatOperand_negative() {
        MutableFloat mutableFloat = new MutableFloat(-10.0f);
        float result = mutableFloat.addAndGet(5.0f);
        assertEquals(-5.0f, result);
        assertEquals(-5.0f, mutableFloat.getValue());
    }

    @Test
    public void testAddAndGet_floatOperand_zero() {
        MutableFloat mutableFloat = new MutableFloat(10.0f);
        float result = mutableFloat.addAndGet(0.0f);
        assertEquals(10.0f, result);
        assertEquals(10.0f, mutableFloat.getValue());
    }

    @Test
    public void testAddAndGet_numberOperand() {
        MutableFloat mutableFloat = new MutableFloat(10.0f);
        float result = mutableFloat.addAndGet(5);
        assertEquals(15.0f, result);
        assertEquals(15.0f, mutableFloat.getValue());
    }

    @Test
    public void testAddAndGet_numberOperand_negative() {
        MutableFloat mutableFloat = new MutableFloat(-10.0f);
        float result = mutableFloat.addAndGet(5);
        assertEquals(-5.0f, result);
        assertEquals(-5.0f, mutableFloat.getValue());
    }

    @Test
    public void testAddAndGet_numberOperand_zero() {
        MutableFloat mutableFloat = new MutableFloat(10.0f);
        float result = mutableFloat.addAndGet(0);
        assertEquals(10.0f, result);
        assertEquals(10.0f, mutableFloat.getValue());
    }

    @Test
    public void testAddAndGet_stringOperand() {
        MutableFloat mutableFloat = new MutableFloat(10.0f);
        float result = mutableFloat.addAndGet("5.0");
        assertEquals(15.0f, result);
        assertEquals(15.0f, mutableFloat.getValue());
    }

    @Test
    public void testAddAndGet_stringOperand_negative() {
        MutableFloat mutableFloat = new MutableFloat(-10.0f);
        float result = mutableFloat.addAndGet("-5.0");
        assertEquals(-15.0f, result);
        assertEquals(-15.0f, mutableFloat.getValue());
    }

    @Test
    public void testAddAndGet_stringOperand_zero() {
        MutableFloat mutableFloat = new MutableFloat(10.0f);
        float result = mutableFloat.addAndGet("0.0");
        assertEquals(10.0f, result);
        assertEquals(10.0f, mutableFloat.getValue());
    }
}