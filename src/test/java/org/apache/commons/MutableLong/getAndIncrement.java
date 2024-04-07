import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getAndIncrementTest {

    @Test
    void testGetAndIncrement() {
        MutableLong mutableLong = new MutableLong(0);

        long result1 = mutableLong.getAndIncrement();
        assertEquals(0, result1);
        assertEquals(1, mutableLong.getValue());

        long result2 = mutableLong.getAndIncrement();
        assertEquals(1, result2);
        assertEquals(2, mutableLong.getValue());

        MutableLong mutableLong2 = new MutableLong(10);

        long result3 = mutableLong2.getAndIncrement();
        assertEquals(10, result3);
        assertEquals(11, mutableLong2.getValue());

        long result4 = mutableLong2.getAndIncrement();
        assertEquals(11, result4);
        assertEquals(12, mutableLong2.getValue());
    }
}