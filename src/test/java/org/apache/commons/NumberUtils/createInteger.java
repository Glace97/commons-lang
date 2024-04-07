
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class createIntegerTest {
    private NumberUtils numberUtils;

    @BeforeEach
    void setUp() {
        numberUtils = new NumberUtils();
    }

    @Nested
    @DisplayName("Positive Test Cases")
    class PositiveTestCases {
        @Test
        void testCreateIntegerWithValidString() {
            String str = "123";
            Integer result = numberUtils.createInteger(str);
            assertEquals(123, result);
        }
    }

    @Nested
    @DisplayName("Negative Test Cases")
    class NegativeTestCases {
        @Test
        void testCreateIntegerWithNullString() {
            Integer result = numberUtils.createInteger(null);
            assertNull(result);
        }

        @Test
        void testCreateIntegerWithInvalidString() {
            String str = "abc";
            assertThrows(NumberFormatException.class, () -> numberUtils.createInteger(str));
        }
    }
}
