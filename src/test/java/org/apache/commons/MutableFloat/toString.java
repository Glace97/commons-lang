import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class toStringTest {

    @Test
    void testToString() {
        MutableFloat mf1 = new MutableFloat(0.0f);
        assertEquals("0.0", mf1.toString());

        MutableFloat mf2 = new MutableFloat(3.14f);
        assertEquals("3.14", mf2.toString());

        MutableFloat mf3 = new MutableFloat(Float.POSITIVE_INFINITY);
        assertEquals("Infinity", mf3.toString());

        MutableFloat mf4 = new MutableFloat(Float.NEGATIVE_INFINITY);
        assertEquals("-Infinity", mf4.toString());

        MutableFloat mf5 = new MutableFloat(Float.NaN);
        assertEquals("NaN", mf5.toString());
    }
}