import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.EnumSet;

@TestInstance(Lifecycle.PER_CLASS)
class getEnumIgnoreCaseTest {

    @Test
    void testGetEnumIgnoreCase_WithValidEnumName_ShouldReturnEnum() {
        EnumUtilsTest.TestEnum result = EnumUtils.getEnumIgnoreCase(EnumUtilsTest.TestEnum.class, "VALUE1");
        Assertions.assertEquals(EnumUtilsTest.TestEnum.VALUE1, result);
    }

    @Test
    void testGetEnumIgnoreCase_WithInvalidEnumName_ShouldReturnNull() {
        EnumUtilsTest.TestEnum result = EnumUtils.getEnumIgnoreCase(EnumUtilsTest.TestEnum.class, "INVALID_VALUE");
        Assertions.assertNull(result);
    }

    @Test
    void testGetEnumIgnoreCase_WithNullEnumName_ShouldReturnDefaultEnum() {
        EnumUtilsTest.TestEnum result = EnumUtils.getEnumIgnoreCase(EnumUtilsTest.TestEnum.class, null, EnumUtilsTest.TestEnum.DEFAULT);
        Assertions.assertEquals(EnumUtilsTest.TestEnum.DEFAULT, result);
    }

    @Test
    void testGetEnumIgnoreCase_WithNullEnumNameAndNullDefaultEnum_ShouldReturnNull() {
        EnumUtilsTest.TestEnum result = EnumUtils.getEnumIgnoreCase(EnumUtilsTest.TestEnum.class, null, null);
        Assertions.assertNull(result);
    }

    @Test
    void testGetEnumIgnoreCase_WithEmptyEnumName_ShouldReturnNull() {
        EnumUtilsTest.TestEnum result = EnumUtils.getEnumIgnoreCase(EnumUtilsTest.TestEnum.class, "", EnumUtilsTest.TestEnum.DEFAULT);
        Assertions.assertNull(result);
    }

    @Test
    void testGetEnumIgnoreCase_WithValidMixedCaseEnumName_ShouldReturnEnum() {
        EnumUtilsTest.TestEnum result = EnumUtils.getEnumIgnoreCase(EnumUtilsTest.TestEnum.class, "ValUe1");
        Assertions.assertEquals(EnumUtilsTest.TestEnum.VALUE1, result);
    }

    @Test
    void testGetEnumIgnoreCase_WithInvalidMixedCaseEnumName_ShouldReturnNull() {
        EnumUtilsTest.TestEnum result = EnumUtils.getEnumIgnoreCase(EnumUtilsTest.TestEnum.class, "iNvAlId_vAlUe");
        Assertions.assertNull(result);
    }

    @Test
    void testGetEnumIgnoreCase_WithNullEnumClass_ShouldThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            EnumUtils.getEnumIgnoreCase(null, "VALUE1");
        });
    }

    @Test
    void testGetEnumIgnoreCase_WithNullEnumClassAndNullEnumName_ShouldThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            EnumUtils.getEnumIgnoreCase(null, null);
        });
    }

    static enum TestEnum {
        VALUE1,
        VALUE2,
        VALUE3,
        DEFAULT
    }
}