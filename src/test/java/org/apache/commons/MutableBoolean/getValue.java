import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GetValueTest {

    private MutableBoolean mutableBoolean;

    @BeforeEach
    void setup() {
        mutableBoolean = new MutableBoolean();
    }

    @Nested
    @DisplayName("getValue() method")
    class GetValueMethod {

        @Test
        @DisplayName("should return a non-null Boolean value")
        void shouldReturnNonNullValue() {
            assertNotNull(mutableBoolean.getValue());
        }

        @Test
        @DisplayName("should return the initial value when not modified")
        void shouldReturnInitialValue() {
            assertEquals(Boolean.FALSE, mutableBoolean.getValue());
        }

        @Test
        @DisplayName("should return the modified value")
        void shouldReturnModifiedValue() {
            mutableBoolean = new MutableBoolean(true);
            assertEquals(Boolean.TRUE, mutableBoolean.getValue());
        }

        @Test
        @DisplayName("should always return a new Boolean instance")
        void shouldReturnNewInstance() {
            mutableBoolean = new MutableBoolean(true);
            assertTrue(mutableBoolean.getValue() != mutableBoolean.getValue());
        }

    }
}