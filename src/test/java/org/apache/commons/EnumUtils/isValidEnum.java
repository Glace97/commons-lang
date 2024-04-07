
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class isValidEnumTest {

    @Test
    @DisplayName("Valid enum names return true")
    void validEnumNamesReturnTrue() {
        Assertions.assertTrue(EnumUtils.isValidEnum(TestEnum.class, "VALUE1"));
    }

    @Test
    @DisplayName("Invalid enum names return false")
    void invalidEnumNamesReturnFalse() {
        Assertions.assertFalse(EnumUtils.isValidEnum(TestEnum.class, "INVALID"));
    }

    @Test
    @DisplayName("Null enum name returns false")
    void nullEnumNameReturnsFalse() {
        Assertions.assertFalse(EnumUtils.isValidEnum(TestEnum.class, null));
    }

    @Test
    @DisplayName("EnumClass must be defined")
    void enumClassMustBeDefined() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> EnumUtils.isValidEnum(null, "VALUE1"));
    }

    @Nested
    @DisplayName("Enum values with null elements")
    class EnumValuesWithNullElements {

        @Test
        @DisplayName("Enum values with null elements return false")
        void enumValuesWithNullElementsReturnFalse() {
            Assertions.assertFalse(EnumUtils.isValidEnum(EnumWithNullElements.class, "VALUE1"));
        }

        @Test
        @DisplayName("Enum values without null elements return true")
        void enumValuesWithoutNullElementsReturnTrue() {
            Assertions.assertTrue(EnumUtils.isValidEnum(EnumWithoutNullElements.class, "VALUE1"));
        }
    }

    @Nested
    @DisplayName("Enum values with special characters")
    class EnumValuesWithSpecialCharacters {

        @Test
        @DisplayName("Enum values with special characters return true")
        void enumValuesWithSpecialCharactersReturnTrue() {
            Assertions.assertTrue(EnumUtils.isValidEnum(EnumWithSpecialCharacters.class, "VALUE_1"));
        }

        @Test
        @DisplayName("Enum values without special characters return true")
        void enumValuesWithoutSpecialCharactersReturnTrue() {
            Assertions.assertTrue(EnumUtils.isValidEnum(EnumWithSpecialCharacters.class, "VALUE1"));
        }
    }

    enum TestEnum {
        VALUE1,
        VALUE2,
        VALUE3
    }

    enum EnumWithNullElements {
        VALUE1,
        VALUE2,
        VALUE3,
        NULL_VALUE(null)
    }

    enum EnumWithoutNullElements {
        VALUE1,
        VALUE2,
        VALUE3
    }

    enum EnumWithSpecialCharacters {
        VALUE1,
        VALUE_1,
        VALUE_2
    }
}
