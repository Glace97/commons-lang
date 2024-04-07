import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class isStateTransitionTest {

    private EventCountCircuitBreaker breaker;

    @BeforeEach
    void setUp() {
        breaker = new EventCountCircuitBreaker(5, 10, TimeUnit.SECONDS);
    }

    @Test
    void testIsStateTransition_WhenNextDataEventCountGreaterThanOpeningThreshold_ReturnsTrue() {
        EventCountCircuitBreaker.CheckIntervalData currentData = breaker.new CheckIntervalData(3, 0);
        EventCountCircuitBreaker.CheckIntervalData nextData = breaker.new CheckIntervalData(7, 0);

        boolean result = breaker.isStateTransition(currentData, nextData);

        assertTrue(result);
    }

    @Test
    void testIsStateTransition_WhenNextDataCheckIntervalStartNotEqualCurrentDataCheckIntervalStartAndCurrentDataEventCountLessThanClosingThreshold_ReturnsTrue() {
        EventCountCircuitBreaker.CheckIntervalData currentData = breaker.new CheckIntervalData(7, 0);
        EventCountCircuitBreaker.CheckIntervalData nextData = breaker.new CheckIntervalData(0, 10);

        boolean result = breaker.isStateTransition(currentData, nextData);

        assertTrue(result);
    }

    @Test
    void testIsStateTransition_WhenNextDataCheckIntervalStartNotEqualCurrentDataCheckIntervalStartAndCurrentDataEventCountGreaterThanClosingThreshold_ReturnsFalse() {
        EventCountCircuitBreaker.CheckIntervalData currentData = breaker.new CheckIntervalData(10, 0);
        EventCountCircuitBreaker.CheckIntervalData nextData = breaker.new CheckIntervalData(0, 10);

        boolean result = breaker.isStateTransition(currentData, nextData);

        assertFalse(result);
    }

    @Test
    void testIsStateTransition_WhenNextDataCheckIntervalStartEqualCurrentDataCheckIntervalStart_ReturnsFalse() {
        EventCountCircuitBreaker.CheckIntervalData currentData = breaker.new CheckIntervalData(5, 0);
        EventCountCircuitBreaker.CheckIntervalData nextData = breaker.new CheckIntervalData(10, 0);

        boolean result = breaker.isStateTransition(currentData, nextData);

        assertFalse(result);
    }
}