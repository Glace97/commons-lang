import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getOpeningThresholdTest {

    @Test
    void testGetOpeningThreshold() {
        int openingThreshold = 10;
        long openingInterval = 1;
        TimeUnit openingUnit = TimeUnit.SECONDS;
        int closingThreshold = 5;
        long closingInterval = 1;
        TimeUnit closingUnit = TimeUnit.SECONDS;

        EventCountCircuitBreaker circuitBreaker = new EventCountCircuitBreaker(openingThreshold, openingInterval,
                openingUnit, closingThreshold, closingInterval, closingUnit);

        int result = circuitBreaker.getOpeningThreshold();

        Assertions.assertEquals(openingThreshold, result);
    }
}