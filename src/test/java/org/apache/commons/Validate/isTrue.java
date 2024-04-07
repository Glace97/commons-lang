
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class isTrueTest {

    @Nested
    @DisplayName("Tests for isTrue(boolean expression)")
    class IsTrueWithBooleanExpression {
        
        @Test
        @DisplayName("Should not throw exception when expression is true")
        void shouldNotThrowExceptionWhenExpressionIsTrue() {
            Validate.isTrue(true);
        }
        
        @Test
        @DisplayName("Should throw exception when expression is false")
        void shouldThrowExceptionWhenExpressionIsFalse() {
            assertThrows(IllegalArgumentException.class, () -> Validate.isTrue(false));
        }
        
    }

    @Nested
    @DisplayName("Tests for isTrue(boolean expression, String message, double value)")
    class IsTrueWithDoubleValue {
        
        @Test
        @DisplayName("Should not throw exception when expression is true")
        void shouldNotThrowExceptionWhenExpressionIsTrue() {
            Validate.isTrue(true, "The value must be greater than zero: %s", 5.0);
        }
        
        @Test
        @DisplayName("Should throw exception when expression is false")
        void shouldThrowExceptionWhenExpressionIsFalse() {
            assertThrows(IllegalArgumentException.class, () -> Validate.isTrue(false, "The value must be greater than zero: %s", 0.0));
        }
        
    }

    @Nested
    @DisplayName("Tests for isTrue(boolean expression, String message, long value)")
    class IsTrueWithLongValue {
        
        @Test
        @DisplayName("Should not throw exception when expression is true")
        void shouldNotThrowExceptionWhenExpressionIsTrue() {
            Validate.isTrue(true, "The value must be greater than zero: %d", 10L);
        }
        
        @Test
        @DisplayName("Should throw exception when expression is false")
        void shouldThrowExceptionWhenExpressionIsFalse() {
            assertThrows(IllegalArgumentException.class, () -> Validate.isTrue(false, "The value must be greater than zero: %d", -5L));
        }
        
    }

    @Nested
    @DisplayName("Tests for isTrue(boolean expression, String message, Object... values)")
    class IsTrueWithObjectValues {
        
        @Test
        @DisplayName("Should not throw exception when expression is true")
        void shouldNotThrowExceptionWhenExpressionIsTrue() {
            Validate.isTrue(true, "The value must be between %d and %d", 5, 10);
        }
        
        @Test
        @DisplayName("Should throw exception when expression is false")
        void shouldThrowExceptionWhenExpressionIsFalse() {
            assertThrows(IllegalArgumentException.class, () -> Validate.isTrue(false, "The value must be between %d and %d", 10, 5));
        }
        
    }

}
