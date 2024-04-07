import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class notEqualTest {

    @Nested
    @DisplayName("Tests for notEqual method")
    class NotEqualTests {

        @Test
        @DisplayName("Both objects are null")
        void testNotEqual_BothNull() {
            assertTrue(ObjectUtils.notEqual(null, null));
        }

        @Test
        @DisplayName("First object is null, second object is empty string")
        void testNotEqual_FirstNullSecondEmptyString() {
            assertTrue(ObjectUtils.notEqual(null, ""));
        }

        @Test
        @DisplayName("First object is empty string, second object is null")
        void testNotEqual_FirstEmptyStringSecondNull() {
            assertTrue(ObjectUtils.notEqual("", null));
        }

        @Test
        @DisplayName("Both objects are empty strings")
        void testNotEqual_BothEmptyStrings() {
            assertFalse(ObjectUtils.notEqual("", ""));
        }

        @Test
        @DisplayName("First object is Boolean.TRUE, second object is null")
        void testNotEqual_FirstTrueSecondNull() {
            assertTrue(ObjectUtils.notEqual(Boolean.TRUE, null));
        }

        @Test
        @DisplayName("First object is Boolean.TRUE, second object is 'true'")
        void testNotEqual_FirstTrueSecondTrue() {
            assertTrue(ObjectUtils.notEqual(Boolean.TRUE, "true"));
        }

        @Test
        @DisplayName("Both objects are Boolean.TRUE")
        void testNotEqual_BothTrue() {
            assertFalse(ObjectUtils.notEqual(Boolean.TRUE, Boolean.TRUE));
        }

        @Test
        @DisplayName("First object is Boolean.TRUE, second object is Boolean.FALSE")
        void testNotEqual_FirstTrueSecondFalse() {
            assertTrue(ObjectUtils.notEqual(Boolean.TRUE, Boolean.FALSE));
        }
    }
}