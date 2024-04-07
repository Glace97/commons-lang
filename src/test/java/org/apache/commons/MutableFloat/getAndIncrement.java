import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class getAndIncrementTest {

    private MutableFloat mutableFloat;

    @BeforeEach
    public void setup() {
        mutableFloat = new MutableFloat();
    }

    @Test
    public void testGetAndIncrement() {
        float initialValue = mutableFloat.getAndIncrement();
        Assertions.assertEquals(0.0f, initialValue);
        Assertions.assertEquals(1.0f, mutableFloat.getAndIncrement());
    }

    @Test
    public void testGetAndIncrementMultipleTimes() {
        float initialValue = mutableFloat.getAndIncrement();
        Assertions.assertEquals(0.0f, initialValue);
        Assertions.assertEquals(1.0f, mutableFloat.getAndIncrement());
        Assertions.assertEquals(2.0f, mutableFloat.getAndIncrement());
        Assertions.assertEquals(3.0f, mutableFloat.getAndIncrement());
    }

    @Test
    public void testGetAndIncrementWithNegativeValue() {
        mutableFloat = new MutableFloat(-5.0f);
        float initialValue = mutableFloat.getAndIncrement();
        Assertions.assertEquals(-5.0f, initialValue);
        Assertions.assertEquals(-4.0f, mutableFloat.getAndIncrement());
        Assertions.assertEquals(-3.0f, mutableFloat.getAndIncrement());
        Assertions.assertEquals(-2.0f, mutableFloat.getAndIncrement());
    }

    @Test
    public void testGetAndIncrementWithFloatValue() {
        mutableFloat = new MutableFloat(2.5f);
        float initialValue = mutableFloat.getAndIncrement();
        Assertions.assertEquals(2.5f, initialValue);
        Assertions.assertEquals(3.5f, mutableFloat.getAndIncrement());
        Assertions.assertEquals(4.5f, mutableFloat.getAndIncrement());
        Assertions.assertEquals(5.5f, mutableFloat.getAndIncrement());
    }

    @Test
    public void testGetAndIncrementWithMaxValue() {
        mutableFloat = new MutableFloat(Float.MAX_VALUE);
        float initialValue = mutableFloat.getAndIncrement();
        Assertions.assertEquals(Float.MAX_VALUE, initialValue);
        Assertions.assertEquals(Float.POSITIVE_INFINITY, mutableFloat.getAndIncrement());
        Assertions.assertEquals(Float.POSITIVE_INFINITY, mutableFloat.getAndIncrement());
        Assertions.assertEquals(Float.POSITIVE_INFINITY, mutableFloat.getAndIncrement());
    }
    
    @Test
    public void testGetAndIncrementWithMinValue() {
        mutableFloat = new MutableFloat(Float.MIN_VALUE);
        float initialValue = mutableFloat.getAndIncrement();
        Assertions.assertEquals(Float.MIN_VALUE, initialValue);
        Assertions.assertEquals(Float.MIN_VALUE + 1.0f, mutableFloat.getAndIncrement());
        Assertions.assertEquals(Float.MIN_VALUE + 2.0f, mutableFloat.getAndIncrement());
        Assertions.assertEquals(Float.MIN_VALUE + 3.0f, mutableFloat.getAndIncrement());
    }
    
    @Test
    public void testGetAndIncrementWithZeroValue() {
        mutableFloat = new MutableFloat(0.0f);
        float initialValue = mutableFloat.getAndIncrement();
        Assertions.assertEquals(0.0f, initialValue);
        Assertions.assertEquals(1.0f, mutableFloat.getAndIncrement());
        Assertions.assertEquals(2.0f, mutableFloat.getAndIncrement());
        Assertions.assertEquals(3.0f, mutableFloat.getAndIncrement());
    }
}