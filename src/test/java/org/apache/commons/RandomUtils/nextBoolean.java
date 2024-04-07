import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class nextBooleanTest {

    @Test
    void testNextBoolean() {
        boolean result = RandomUtils.nextBoolean();
        assertNotNull(result);
    }
}