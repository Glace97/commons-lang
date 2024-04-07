
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutableByteTest {

    @Nested
    @DisplayName("addAndGet(byte operand)")
    class AddAndGetByteTest {
        private MutableByte mutableByte;

        @BeforeEach
        void setUp() {
            mutableByte = new MutableByte((byte) 5);
        }

        @Test
        @DisplayName("should increment value by operand and return the updated value")
        void shouldIncrementValueAndReturnUpdatedValue() {
            assertEquals((byte) 10, mutableByte.addAndGet((byte) 5));
        }
    }

    @Nested
    @DisplayName("addAndGet(Number operand)")
    class AddAndGetNumberTest {
        private MutableByte mutableByte;

        @BeforeEach
        void setUp() {
            mutableByte = new MutableByte((byte) 5);
        }

        @Test
        @DisplayName("should increment value by operand and return the updated value")
        void shouldIncrementValueAndReturnUpdatedValue() {
            assertEquals((byte) 10, mutableByte.addAndGet((byte) 5));
        }
    }
}
