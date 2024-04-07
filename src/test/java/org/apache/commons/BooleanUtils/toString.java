
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("toStringTest")
class ToStringTest {

    private static BooleanUtils booleanUtils;

    @BeforeAll
    static void setUp() {
        booleanUtils = new BooleanUtils();
    }

    @Nested
    @DisplayName("toString(boolean, String, String)")
    class ToStringWithBooleanTest {

        @Test
        @DisplayName("should return trueString when bool is true")
        void shouldReturnTrueStringWhenBoolIsTrue() {
            boolean bool = true;
            String trueString = "TRUE";
            String falseString = "FALSE";
            assertEquals(trueString, booleanUtils.toString(bool, trueString, falseString));
        }

        @Test
        @DisplayName("should return falseString when bool is false")
        void shouldReturnFalseStringWhenBoolIsFalse() {
            boolean bool = false;
            String trueString = "TRUE";
            String falseString = "FALSE";
            assertEquals(falseString, booleanUtils.toString(bool, trueString, falseString));
        }
    }

    @Nested
    @DisplayName("toString(Boolean, String, String, String)")
    class ToStringWithBooleanObjectTest {

        @Test
        @DisplayName("should return trueString when bool is Boolean.TRUE")
        void shouldReturnTrueStringWhenBoolIsTrue() {
            Boolean bool = Boolean.TRUE;
            String trueString = "TRUE";
            String falseString = "FALSE";
            String nullString = "NULL";
            assertEquals(trueString, booleanUtils.toString(bool, trueString, falseString, nullString));
        }

        @Test
        @DisplayName("should return falseString when bool is Boolean.FALSE")
        void shouldReturnFalseStringWhenBoolIsFalse() {
            Boolean bool = Boolean.FALSE;
            String trueString = "TRUE";
            String falseString = "FALSE";
            String nullString = "NULL";
            assertEquals(falseString, booleanUtils.toString(bool, trueString, falseString, nullString));
        }

        @Test
        @DisplayName("should return nullString when bool is null")
        void shouldReturnNullStringWhenBoolIsNull() {
            Boolean bool = null;
            String trueString = "TRUE";
            String falseString = "FALSE";
            String nullString = "NULL";
            assertNull(booleanUtils.toString(bool, trueString, falseString, nullString));
        }
    }

}
