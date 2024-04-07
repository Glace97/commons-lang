import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

class ReflectionToStringBuilderTest {

    private Object testObject;

    @BeforeEach
    void setUp() {
        testObject = new Object();
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("toStringInclude() tests")
    class ToStringIncludeTests {

        @Test
        void whenIncludeFieldNamesIsNull_thenReturnToStringValueWithAllFields() {
            String expected = testObject.toString();
            String actual = ReflectionToStringBuilder.toStringInclude(testObject, (String[]) null);
            assertEquals(expected, actual);
        }

        @Test
        void whenIncludeFieldNamesIsEmpty_thenReturnToStringValueWithAllFields() {
            String expected = testObject.toString();
            String actual = ReflectionToStringBuilder.toStringInclude(testObject, new String[]{});
            assertEquals(expected, actual);
        }

        @Test
        void whenIncludeFieldNamesContainsValidFields_thenReturnToStringValueWithIncludedFields() {
            String expected = "Object[field1=value1, field2=value2]";
            String actual = ReflectionToStringBuilder.toStringInclude(testObject, "field1", "field2");
            assertEquals(expected, actual);
        }

        @Test
        void whenIncludeFieldNamesContainsInvalidFields_thenReturnToStringValueWithAllFields() {
            String expected = testObject.toString();
            String actual = ReflectionToStringBuilder.toStringInclude(testObject, "invalidField1", "invalidField2");
            assertEquals(expected, actual);
        }

        @Test
        void whenIncludeFieldNamesContainsNullValueFields_thenReturnToStringValueWithAllFields() {
            String expected = testObject.toString();
            String actual = ReflectionToStringBuilder.toStringInclude(testObject, "field1", null, "field2");
            assertEquals(expected, actual);
        }

        @Test
        void whenIncludeFieldNamesContainsDuplicateFields_thenReturnToStringValueWithUniqueFields() {
            String expected = "Object[field1=value1, field2=value2]";
            String actual = ReflectionToStringBuilder.toStringInclude(testObject, "field1", "field2", "field1");
            assertEquals(expected, actual);
        }

        @Test
        void whenIncludeFieldNamesContainsFieldsWithDifferentCase_thenReturnToStringValueWithIncludedFields() {
            String expected = "Object[Field1=value1, fIeLd2=value2]";
            String actual = ReflectionToStringBuilder.toStringInclude(testObject, "Field1", "fIeLd2");
            assertEquals(expected, actual);
        }

        @Test
        void whenIncludeFieldNamesContainsFieldsWithWhitespace_thenReturnToStringValueWithIncludedFields() {
            String expected = "Object[field 1=value1, field 2=value2]";
            String actual = ReflectionToStringBuilder.toStringInclude(testObject, "field 1", "field 2");
            assertEquals(expected, actual);
        }
    }
}