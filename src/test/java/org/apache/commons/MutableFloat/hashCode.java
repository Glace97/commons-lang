import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class hashCodeTest {

    @Test
    public void testHashCode() {
        MutableFloat mutableFloat = new MutableFloat(0);
        Assertions.assertEquals(0, mutableFloat.hashCode());

        mutableFloat = new MutableFloat(1);
        Assertions.assertEquals(Float.floatToIntBits(1), mutableFloat.hashCode());

        mutableFloat = new MutableFloat(-1);
        Assertions.assertEquals(Float.floatToIntBits(-1), mutableFloat.hashCode());

        mutableFloat = new MutableFloat(Float.NaN);
        Assertions.assertEquals(Float.floatToIntBits(Float.NaN), mutableFloat.hashCode());

        mutableFloat = new MutableFloat(Float.POSITIVE_INFINITY);
        Assertions.assertEquals(Float.floatToIntBits(Float.POSITIVE_INFINITY), mutableFloat.hashCode());

        mutableFloat = new MutableFloat(Float.NEGATIVE_INFINITY);
        Assertions.assertEquals(Float.floatToIntBits(Float.NEGATIVE_INFINITY), mutableFloat.hashCode());
    }
}