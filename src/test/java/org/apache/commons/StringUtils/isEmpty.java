
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("isEmptyTest")
class isEmptyTest {

    @Nested
    @DisplayName("When input is null")
    class WhenInputIsNull {

        @Test
        @DisplayName("Should return true")
        void shouldReturnTrue() {
            assertTrue(StringUtils.isEmpty(null));
        }
    }

    @Nested
    @DisplayName("When input is empty")
    class WhenInputIsEmpty {

        @Test
        @DisplayName("Should return true")
        void shouldReturnTrue() {
            assertTrue(StringUtils.isEmpty(""));
        }
    }

    @Nested
    @DisplayName("When input is a space character")
    class WhenInputIsSpaceCharacter {

        @Test
        @DisplayName("Should return false")
        void shouldReturnFalse() {
            assertFalse(StringUtils.isEmpty(" "));
        }
    }

    @Nested
    @DisplayName("When input is a non-empty string")
    class WhenInputIsNonEmptyString {

        @Test
        @DisplayName("Should return false")
        void shouldReturnFalse() {
            assertFalse(StringUtils.isEmpty("bob"));
        }

        @Test
        @DisplayName("Should return false")
        void shouldReturnFalseWithWhitespace() {
            assertFalse(StringUtils.isEmpty("  bob  "));
        }
    }
}
