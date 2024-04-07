import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.EnumSet;

class getEnumTest {

    @Test
    void testGetEnum_withValidEnumName_shouldReturnEnum() {
        // Arrange
        Class<TestEnum> enumClass = TestEnum.class;
        String enumName = "VALUE1";

        // Act
        TestEnum result = EnumUtils.getEnum(enumClass, enumName);

        // Assert
        Assertions.assertEquals(TestEnum.VALUE1, result);
    }

    @Test
    void testGetEnum_withNullEnumName_shouldReturnNull() {
        // Arrange
        Class<TestEnum> enumClass = TestEnum.class;
        String enumName = null;

        // Act
        TestEnum result = EnumUtils.getEnum(enumClass, enumName);

        // Assert
        Assertions.assertNull(result);
    }

    @Test
    void testGetEnum_withInvalidEnumName_shouldReturnDefaultEnum() {
        // Arrange
        Class<TestEnum> enumClass = TestEnum.class;
        String enumName = "INVALID_VALUE";
        TestEnum defaultEnum = TestEnum.DEFAULT;

        // Act
        TestEnum result = EnumUtils.getEnum(enumClass, enumName, defaultEnum);

        // Assert
        Assertions.assertEquals(defaultEnum, result);
    }

    @Test
    void testGetEnum_withNullDefaultEnum_shouldReturnNull() {
        // Arrange
        Class<TestEnum> enumClass = TestEnum.class;
        String enumName = "INVALID_VALUE";
        TestEnum defaultEnum = null;

        // Act
        TestEnum result = EnumUtils.getEnum(enumClass, enumName, defaultEnum);

        // Assert
        Assertions.assertNull(result);
    }

    enum TestEnum {
        VALUE1,
        VALUE2,
        DEFAULT
    }
}