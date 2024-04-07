
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.EnumSet;

class getEnumSystemPropertyTest {

    enum TestEnum {
        VALUE1, VALUE2, VALUE3
    }

    @Test
    void shouldReturnDefaultEnumWhenEnumClassIsNull() {
        // Arrange
        Class<TestEnum> enumClass = null;
        String propName = "testProp";
        TestEnum defaultEnum = TestEnum.VALUE1;

        // Act
        TestEnum result = EnumUtils.getEnumSystemProperty(enumClass, propName, defaultEnum);

        // Assert
        Assertions.assertEquals(defaultEnum, result);
    }

    @Test
    void shouldReturnDefaultEnumWhenPropNameIsNull() {
        // Arrange
        Class<TestEnum> enumClass = TestEnum.class;
        String propName = null;
        TestEnum defaultEnum = TestEnum.VALUE1;

        // Act
        TestEnum result = EnumUtils.getEnumSystemProperty(enumClass, propName, defaultEnum);

        // Assert
        Assertions.assertEquals(defaultEnum, result);
    }

    @Test
    void shouldReturnDefaultEnumWhenPropNameNotFound() {
        // Arrange
        Class<TestEnum> enumClass = TestEnum.class;
        String propName = "nonExistingProp";
        TestEnum defaultEnum = TestEnum.VALUE1;

        // Act
        TestEnum result = EnumUtils.getEnumSystemProperty(enumClass, propName, defaultEnum);

        // Assert
        Assertions.assertEquals(defaultEnum, result);
    }

    @Test
    void shouldReturnEnumValueWhenPropNameFound() {
        // Arrange
        Class<TestEnum> enumClass = TestEnum.class;
        String propName = "testProp";
        TestEnum defaultEnum = TestEnum.VALUE1;
        System.setProperty(propName, "VALUE2");

        // Act
        TestEnum result = EnumUtils.getEnumSystemProperty(enumClass, propName, defaultEnum);

        // Assert
        Assertions.assertEquals(TestEnum.VALUE2, result);

        // Cleanup
        System.clearProperty(propName);
    }
}
