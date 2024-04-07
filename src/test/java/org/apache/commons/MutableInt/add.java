import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class addTest {

    private MutableInt mutableInt;

    @BeforeEach
    void setUp() {
        mutableInt = new MutableInt();
    }

    @Nested
    @DisplayName("add(int) method")
    class AddIntMethod {

        @Test
        @DisplayName("should add positive integer correctly")
        void shouldAddPositiveInt() {
            mutableInt.add(5);
            assertEquals(5, mutableInt.getValue());
        }

        @Test
        @DisplayName("should add negative integer correctly")
        void shouldAddNegativeInt() {
            mutableInt.add(-5);
            assertEquals(-5, mutableInt.getValue());
        }

        @Test
        @DisplayName("should add zero correctly")
        void shouldAddZero() {
            mutableInt.add(0);
            assertEquals(0, mutableInt.getValue());
        }
    }

    @Nested
    @DisplayName("add(Number) method")
    class AddNumberMethod {

        @Test
        @DisplayName("should add positive number correctly")
        void shouldAddPositiveNumber() {
            mutableInt.add(NumberUtils.createNumber("5"));
            assertEquals(5, mutableInt.getValue());
        }

        @Test
        @DisplayName("should add negative number correctly")
        void shouldAddNegativeNumber() {
            mutableInt.add(NumberUtils.createNumber("-5"));
            assertEquals(-5, mutableInt.getValue());
        }

        @Test
        @DisplayName("should add zero correctly")
        void shouldAddZero() {
            mutableInt.add(NumberUtils.createNumber("0"));
            assertEquals(0, mutableInt.getValue());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1.5", "2.7", "-3.8"})
        @DisplayName("should throw NumberFormatException when adding decimal number")
        void shouldThrowNumberFormatException(String number) {
            assertThrows(NumberFormatException.class, () -> mutableInt.add(NumberUtils.createNumber(number)));
        }
    }
}