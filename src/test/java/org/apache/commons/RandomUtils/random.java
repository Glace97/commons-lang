
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.concurrent.ThreadLocalRandom;

class RandomTest {

    @Test
    void testRandom() {
        ThreadLocalRandom random = RandomUtils.random();

        assertNotNull(random);
    }
}
