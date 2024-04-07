import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

class greaterThanTest {

    private ComparableUtils.ComparableCheckBuilder<Integer> builder;

    @BeforeEach
    void setUp() {
        builder = new ComparableUtils.ComparableCheckBuilder<>();
    }

    @Nested
    @DisplayName("Tests for greaterThan method")
    class GreaterThanTests {

        @Test
        @DisplayName("When a is greater than b, should return true")
        void greaterThan_whenAGreaterThanB_shouldReturnTrue() {
            // Arrange
            int a = 5;
            int b = 3;

            // Act
            boolean result = builder.greaterThan(b);

            // Assert
            assertTrue(result);
        }

        @Test
        @DisplayName("When a is equal to b, should return false")
        void greaterThan_whenAEqualToB_shouldReturnFalse() {
            // Arrange
            int a = 5;
            int b = 5;

            // Act
            boolean result = builder.greaterThan(b);

            // Assert
            assertFalse(result);
        }

        @Test
        @DisplayName("When a is less than b, should return false")
        void greaterThan_whenALessThanB_shouldReturnFalse() {
            // Arrange
            int a = 3;
            int b = 5;

            // Act
            boolean result = builder.greaterThan(b);

            // Assert
            assertFalse(result);
        }
    }
}