import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class getAndAddTest {

    MutableInt mutableInt;

    @BeforeEach
    void setUp() {
        mutableInt = new MutableInt(5);
    }

    @Nested
    @DisplayName("Tests for getAndAdd(int operand)")
    class GetAndAddIntTests {

        @Test
        @DisplayName("Should return the correct value before the addition")
        void shouldReturnCorrectValueBeforeAddition() {
            assertEquals(5, mutableInt.getAndAdd(3));
        }

        @Test
        @DisplayName("Should increment the value by the operand")
        void shouldIncrementValueByOperand() {
            mutableInt.getAndAdd(3);
            assertEquals(8, mutableInt.getValue());
        }

    }

    @Nested
    @DisplayName("Tests for getAndAdd(Number operand)")
    class GetAndAddNumberTests {

        @Test
        @DisplayName("Should return the correct value before the addition")
        void shouldReturnCorrectValueBeforeAddition() {
            assertEquals(5, mutableInt.getAndAdd(NumberUtils.createNumber("3")));
        }

        @Test
        @DisplayName("Should increment the value by the operand")
        void shouldIncrementValueByOperand() {
            mutableInt.getAndAdd(NumberUtils.createNumber("3"));
            assertEquals(8, mutableInt.getValue());
        }

    }

}