import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class getAndAddTest {

    @Test
    void testGetAndAddFloat() {
        MutableFloat mutableFloat = new MutableFloat(5.0f);
        float result = mutableFloat.getAndAdd(2.0f);
        Assertions.assertEquals(5.0f, result);
        Assertions.assertEquals(7.0f, mutableFloat.getValue());
    }

    @Test
    void testGetAndAddNumber() {
        MutableFloat mutableFloat = new MutableFloat(5.0f);
        float result = mutableFloat.getAndAdd(2);
        Assertions.assertEquals(5.0f, result);
        Assertions.assertEquals(7.0f, mutableFloat.getValue());
    }

    @Test
    void testGetAndAddZero() {
        MutableFloat mutableFloat = new MutableFloat(5.0f);
        float result = mutableFloat.getAndAdd(0.0f);
        Assertions.assertEquals(5.0f, result);
        Assertions.assertEquals(5.0f, mutableFloat.getValue());
    }

    @Test
    void testGetAndAddNegative() {
        MutableFloat mutableFloat = new MutableFloat(5.0f);
        float result = mutableFloat.getAndAdd(-2.0f);
        Assertions.assertEquals(5.0f, result);
        Assertions.assertEquals(3.0f, mutableFloat.getValue());
    }

    @Test
    void testGetAndAddLargeValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.MAX_VALUE);
        float result = mutableFloat.getAndAdd(1000.0f);
        Assertions.assertEquals(Float.MAX_VALUE, result);
        Assertions.assertEquals(Float.POSITIVE_INFINITY, mutableFloat.getValue());
    }
}