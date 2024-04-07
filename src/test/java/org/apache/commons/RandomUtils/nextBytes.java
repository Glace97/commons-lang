import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class nextBytesTest {

    @Test
    void testNextBytesWithZeroCount() {
        byte[] bytes = RandomUtils.nextBytes(0);
        Assertions.assertEquals(0, bytes.length);
    }

    @Test
    void testNextBytesWithPositiveCount() {
        byte[] bytes = RandomUtils.nextBytes(10);
        Assertions.assertEquals(10, bytes.length);
    }

    @Test
    void testNextBytesWithNegativeCount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            RandomUtils.nextBytes(-5);
        });
    }

    @Test
    void testNextBytesRandomness() {
        byte[] bytes1 = RandomUtils.nextBytes(10);
        byte[] bytes2 = RandomUtils.nextBytes(10);

        Assertions.assertFalse(Arrays.equals(bytes1, bytes2));
    }
}