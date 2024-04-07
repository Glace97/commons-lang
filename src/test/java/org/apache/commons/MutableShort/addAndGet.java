import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class addAndGetTest {

    @Nested
    @DisplayName("addAndGet(Number operand) method")
    class AddAndGetWithNumberOperand {
        
        MutableShort mutableShort;

        @BeforeEach
        void setUp() {
            mutableShort = new MutableShort(10);
        }

        @Test
        @DisplayName("should add the number operand to the value and return the updated value")
        void shouldAddNumberOperandAndReturnUpdatedValue() {
            short result = mutableShort.addAndGet(5);
            assertEquals(15, result);
        }

        @Test
        @DisplayName("should not modify the original value when adding zero")
        void shouldNotModifyValueWhenAddingZero() {
            short result = mutableShort.addAndGet(0);
            assertEquals(10, result);
        }

        @Test
        @DisplayName("should add negative number operand to the value and return the updated value")
        void shouldAddNegativeNumberOperandAndReturnUpdatedValue() {
            short result = mutableShort.addAndGet(-5);
            assertEquals(5, result);
        }
    }

    @Nested
    @DisplayName("addAndGet(short operand) method")
    class AddAndGetWithShortOperand {
        
        MutableShort mutableShort;

        @BeforeEach
        void setUp() {
            mutableShort = new MutableShort(10);
        }

        @Test
        @DisplayName("should add the short operand to the value and return the updated value")
        void shouldAddShortOperandAndReturnUpdatedValue() {
            short result = mutableShort.addAndGet((short) 5);
            assertEquals(15, result);
        }

        @Test
        @DisplayName("should not modify the original value when adding zero")
        void shouldNotModifyValueWhenAddingZero() {
            short result = mutableShort.addAndGet((short) 0);
            assertEquals(10, result);
        }

        @Test
        @DisplayName("should add negative short operand to the value and return the updated value")
        void shouldAddNegativeShortOperandAndReturnUpdatedValue() {
            short result = mutableShort.addAndGet((short) -5);
            assertEquals(5, result);
        }
    }
}