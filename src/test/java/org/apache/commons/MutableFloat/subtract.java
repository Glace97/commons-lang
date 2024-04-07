import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Subtract Test")
class SubtractTest {

    private MutableFloat mutableFloat;

    @BeforeEach
    void setUp() {
        mutableFloat = new MutableFloat(10.0f);
    }

    @Nested
    @DisplayName("Subtract with float operand")
    class SubtractWithFloatOperand {

        @Test
        @DisplayName("Subtract positive float")
        void subtractPositiveFloat() {
            mutableFloat.subtract(5.0f);
            assertEquals(5.0f, mutableFloat.getValue());
        }

        @Test
        @DisplayName("Subtract negative float")
        void subtractNegativeFloat() {
            mutableFloat.subtract(-5.0f);
            assertEquals(15.0f, mutableFloat.getValue());
        }

        @Test
        @DisplayName("Subtract zero float")
        void subtractZeroFloat() {
            mutableFloat.subtract(0.0f);
            assertEquals(10.0f, mutableFloat.getValue());
        }
    }

    @Nested
    @DisplayName("Subtract with Number operand")
    class SubtractWithNumberOperand {

        @Test
        @DisplayName("Subtract positive Number")
        void subtractPositiveNumber() {
            mutableFloat.subtract(5);
            assertEquals(5.0f, mutableFloat.getValue());
        }

        @Test
        @DisplayName("Subtract negative Number")
        void subtractNegativeNumber() {
            mutableFloat.subtract(-5);
            assertEquals(15.0f, mutableFloat.getValue());
        }

        @Test
        @DisplayName("Subtract zero Number")
        void subtractZeroNumber() {
            mutableFloat.subtract(0);
            assertEquals(10.0f, mutableFloat.getValue());
        }

        @Test
        @DisplayName("Subtract null Number")
        void subtractNullNumber() {
            assertThrows(NullPointerException.class, () -> mutableFloat.subtract(null));
        }
    }
}