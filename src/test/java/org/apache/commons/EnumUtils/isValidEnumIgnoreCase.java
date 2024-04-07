import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class isValidEnumIgnoreCaseTest {

    @Nested
    @DisplayName("When checking if enum name is valid")
    class ValidEnumNameTests {

        @Test
        @DisplayName("When enum name is valid and case-insensitive match exists")
        void whenValidEnumNameAndMatchExists() {
            Assertions.assertTrue(EnumUtils.isValidEnumIgnoreCase(TestEnum.class, "VALUE1"));
        }

        @Test
        @DisplayName("When enum name is valid and no case-insensitive match exists")
        void whenValidEnumNameAndNoMatchExists() {
            Assertions.assertFalse(EnumUtils.isValidEnumIgnoreCase(TestEnum.class, "value1"));
        }
    }

    @Nested
    @DisplayName("When checking if enum name is not valid")
    class InvalidEnumNameTests {

        @Test
        @DisplayName("When enum name is null")
        void whenEnumNameIsNull() {
            Assertions.assertFalse(EnumUtils.isValidEnumIgnoreCase(TestEnum.class, null));
        }

        @Test
        @DisplayName("When enum name is empty")
        void whenEnumNameIsEmpty() {
            Assertions.assertFalse(EnumUtils.isValidEnumIgnoreCase(TestEnum.class, ""));
        }

        @Test
        @DisplayName("When enum name is whitespace")
        void whenEnumNameIsWhitespace() {
            Assertions.assertFalse(EnumUtils.isValidEnumIgnoreCase(TestEnum.class, "   "));
        }

        @Test
        @DisplayName("When enum name is not present in the enum")
        void whenEnumNameNotPresent() {
            Assertions.assertFalse(EnumUtils.isValidEnumIgnoreCase(TestEnum.class, "VALUE3"));
        }
    }

    enum TestEnum {
        VALUE1, VALUE2
    }
}