import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class floatValueTest {

    @Test
    void testFloatValue() {
        MutableFloat mutFloat = new MutableFloat(3.14f);
        assertEquals(3.14f, mutFloat.floatValue());

        mutFloat = new MutableFloat(0f);
        assertEquals(0f, mutFloat.floatValue());

        mutFloat = new MutableFloat(Float.POSITIVE_INFINITY);
        assertEquals(Float.POSITIVE_INFINITY, mutFloat.floatValue());

        mutFloat = new MutableFloat(Float.NEGATIVE_INFINITY);
        assertEquals(Float.NEGATIVE_INFINITY, mutFloat.floatValue());

        mutFloat = new MutableFloat(Float.NaN);
        assertEquals(Float.NaN, mutFloat.floatValue());
    }
}