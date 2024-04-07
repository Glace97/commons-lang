
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.function.Function;

class GetFirstEnumIgnoreCaseTest {

    enum TestEnum {
        ENUM1, ENUM2, ENUM3
    }

    @Test
    void testGetFirstEnumIgnoreCase_EnumFound() {
        Function<TestEnum, String> stringFunction = TestEnum::name;
        TestEnum expected = TestEnum.ENUM2;
        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(TestEnum.class, "enum2", stringFunction, TestEnum.ENUM1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testGetFirstEnumIgnoreCase_EnumNotFound() {
        Function<TestEnum, String> stringFunction = TestEnum::name;
        TestEnum expected = TestEnum.ENUM1;
        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(TestEnum.class, "enum4", stringFunction, TestEnum.ENUM1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testGetFirstEnumIgnoreCase_NullEnumName() {
        Function<TestEnum, String> stringFunction = TestEnum::name;
        TestEnum expected = TestEnum.ENUM1;
        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(TestEnum.class, null, stringFunction, TestEnum.ENUM1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testGetFirstEnumIgnoreCase_NullEnumClass() {
        Function<TestEnum, String> stringFunction = TestEnum::name;
        TestEnum expected = TestEnum.ENUM1;
        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(null, "enum2", stringFunction, TestEnum.ENUM1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testGetFirstEnumIgnoreCase_EmptyEnumConstants() {
        Function<TestEnum, String> stringFunction = TestEnum::name;
        TestEnum expected = TestEnum.ENUM1;
        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(EmptyEnum.class, "enum2", stringFunction, TestEnum.ENUM1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testGetFirstEnumIgnoreCase_NullStringFunction() {
        TestEnum expected = TestEnum.ENUM1;
        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(TestEnum.class, "enum2", null, TestEnum.ENUM1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testGetFirstEnumIgnoreCase_DefaultEnum() {
        Function<TestEnum, String> stringFunction = TestEnum::name;
        TestEnum expected = TestEnum.ENUM1;
        TestEnum result = EnumUtils.getFirstEnumIgnoreCase(TestEnum.class, "enum4", stringFunction, null);
        Assertions.assertEquals(expected, result);
    }

    private enum EmptyEnum {}

}
