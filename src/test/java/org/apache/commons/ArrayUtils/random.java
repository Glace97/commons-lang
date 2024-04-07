import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ThreadLocalRandom;

class RandomTest {

    @Test
    void testRandomInRange() {
        int min = 0;
        int max = 100;
        int randomNum = ArrayUtils.random().nextInt(min, max + 1);
        assertTrue(randomNum >= min && randomNum <= max);
    }

    @Test
    void testRandomNegativeRange() {
        int min = -100;
        int max = -50;
        int randomNum = ArrayUtils.random().nextInt(min, max + 1);
        assertTrue(randomNum >= min && randomNum <= max);
    }

    @Test
    void testRandomSingleValue() {
        int min = 5;
        int max = 5;
        int randomNum = ArrayUtils.random().nextInt(min, max + 1);
        assertEquals(5, randomNum);
    }

    @Test
    void testRandomEmptyRange() {
        int min = 10;
        int max = 5;
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.random().nextInt(min, max + 1));
    }
}