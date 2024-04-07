
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("isSameLocalTimeTest")
class isSameLocalTimeTest {

    @Nested
    @DisplayName("Positive Test Cases")
    class PositiveTests {

        @Test
        @DisplayName("Test when cal1 and cal2 have the same local time")
        void testSameLocalTime() {
            // Arrange
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            
            // Act
            boolean result = DateUtils.isSameLocalTime(cal1, cal2);
            
            // Assert
            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Negative Test Cases")
    class NegativeTests {

        @Test
        @DisplayName("Test when cal1 and cal2 have different local times")
        void testDifferentLocalTime() {
            // Arrange
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal2.add(Calendar.HOUR_OF_DAY, 1);
            
            // Act
            boolean result = DateUtils.isSameLocalTime(cal1, cal2);
            
            // Assert
            assertFalse(result);
        }
    }
}
