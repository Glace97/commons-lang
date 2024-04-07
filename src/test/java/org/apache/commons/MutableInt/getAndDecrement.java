import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class getAndDecrementTest {
    private MutableInt mutableInt;

    @BeforeEach
    void setUp() {
        mutableInt = new MutableInt(5);
    }

    @Nested
    @DisplayName("Tests for getAndDecrement method")
    class GetAndDecrementTests {
        @Test
        @DisplayName("Test getAndDecrement returns the correct value")
        void testGetAndDecrement() {
            int result = mutableInt.getAndDecrement();
            Assertions.assertEquals(5, result);
        }

        @Test
        @DisplayName("Test getAndDecrement decrements the value")
        void testGetAndDecrementDecrementsValue() {
            mutableInt.getAndDecrement();
            int result = mutableInt.getAndDecrement();
            Assertions.assertEquals(3, result);
        }
    }
}