import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class CONST_BYTETest {

    private ObjectUtils objectUtils;

    @BeforeEach
    void setUp() {
        objectUtils = new ObjectUtils();
    }

    @Nested
    @DisplayName("Edge Cases")
    class EdgeCases {

        @Test
        @DisplayName("Test with minimum valid byte value")
        void testMinValidByteValue() {
            byte result = objectUtils.CONST_BYTE(Byte.MIN_VALUE);
            assertEquals(Byte.MIN_VALUE, result);
        }

        @Test
        @DisplayName("Test with maximum valid byte value")
        void testMaxValidByteValue() {
            byte result = objectUtils.CONST_BYTE(Byte.MAX_VALUE);
            assertEquals(Byte.MAX_VALUE, result);
        }

        @Test
        @DisplayName("Test with negative value smaller than minimum byte value")
        void testNegativeValueSmallerThanMinByteValue() {
            assertThrows(IllegalArgumentException.class, () -> objectUtils.CONST_BYTE(-129));
        }

        @Test
        @DisplayName("Test with positive value larger than maximum byte value")
        void testPositiveValueLargerThanMaxByteValue() {
            assertThrows(IllegalArgumentException.class, () -> objectUtils.CONST_BYTE(128));
        }
    }
}