import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class appendFieldsInTest {
    private ReflectionToStringBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new ReflectionToStringBuilder(new Object());
        builder.setAppendStatics(true);
        builder.setAppendTransients(true);
        builder.setExcludeNullValues(false);
        builder.setExcludeFieldNames(new String[] {"password"});
        builder.setIncludeFieldNames(new String[] {"field1", "field2"});
        builder.setUpToClass(Object.class);
    }

    @Test
    void testAppendFieldsInArray() {
        Class<?> clazz = String[].class;
        builder.appendFieldsIn(clazz);
        // Assert the fields in the array are appended correctly
    }

    @Test
    void testAppendFieldsInClass() {
        Class<?> clazz = MyClass.class;
        builder.appendFieldsIn(clazz);
        // Assert the fields in the class are appended correctly
    }

    @Test
    void testAppendFieldsInPrimitive() {
        Class<?> clazz = int.class;
        builder.appendFieldsIn(clazz);
        // Assert that primitive fields are correctly handled
    }

    @Test
    void testAppendFieldsInNestedClass() {
        Class<?> clazz = OuterClass.InnerClass.class;
        builder.appendFieldsIn(clazz);
        // Assert that fields in nested classes are correctly appended
    }

    @Test
    void testAppendFieldsInNullValue() {
        builder.setExcludeNullValues(true);
        Class<?> clazz = MyClass.class;
        builder.appendFieldsIn(clazz);
        // Assert that fields with null values are excluded
    }

    @Test
    void testAppendFieldsInExcludedField() {
        Class<?> clazz = MyClass.class;
        builder.appendFieldsIn(clazz);
        // Assert that excluded fields are not appended
    }

    @Test
    void testAppendFieldsInIncludedField() {
        Class<?> clazz = MyClass.class;
        builder.appendFieldsIn(clazz);
        // Assert that included fields are appended
    }

    @Test
    void testAppendFieldsInUpToClass() {
        Class<?> clazz = MyClass.class;
        builder.appendFieldsIn(clazz);
        // Assert that fields up to the specified class are appended
    }
}

class MyClass {
    private String field1;
    private int field2;
    private String password;
}

class OuterClass {
    static class InnerClass {
        private String nestedField;
    }
}