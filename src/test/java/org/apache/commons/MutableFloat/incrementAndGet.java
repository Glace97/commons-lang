import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class incrementAndGetTest {

    @Test
    public void testIncrementAndGet() {
        MutableFloat mutableFloat = new MutableFloat(5.0f);
        assertEquals(6.0f, mutableFloat.incrementAndGet());

        mutableFloat = new MutableFloat(-5.0f);
        assertEquals(-4.0f, mutableFloat.incrementAndGet());

        mutableFloat = new MutableFloat(0.0f);
        assertEquals(1.0f, mutableFloat.incrementAndGet());

        mutableFloat = new MutableFloat(Float.POSITIVE_INFINITY);
        assertEquals(Float.POSITIVE_INFINITY, mutableFloat.incrementAndGet());

        mutableFloat = new MutableFloat(Float.NEGATIVE_INFINITY);
        assertEquals(Float.NEGATIVE_INFINITY, mutableFloat.incrementAndGet());

        mutableFloat = new MutableFloat(Float.NaN);
        assertEquals(Float.NaN, mutableFloat.incrementAndGet());
    }
}