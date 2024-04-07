import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toStringExcludeTest {

    @Test
    void testToStringExclude_NullObject_ReturnsEmptyString() {
        Object obj = null;
        String result = ReflectionToStringBuilder.toStringExclude(obj, "fieldName");
        assertEquals("", result);
    }

    @Test
    void testToStringExclude_IncludeFieldNames_ReturnsToStringWithIncludedFields() {
        TestClass obj = new TestClass("John", 25, "password");
        String result = ReflectionToStringBuilder.toStringExclude(obj, "fieldName");
        assertEquals("TestClass[name=John, age=25]", result);
    }

    @Test
    void testToStringExclude_ExcludeFieldNames_ReturnsToStringWithoutExcludedFields() {
        TestClass obj = new TestClass("John", 25, "password");
        String result = ReflectionToStringBuilder.toStringExclude(obj, "password");
        assertEquals("TestClass[name=John, age=25]", result);
    }

    @Test
    void testToStringExclude_ExcludeNullValues_ReturnsToStringWithoutNullFields() {
        TestClass obj = new TestClass("John", 25, null);
        String result = ReflectionToStringBuilder.toStringExclude(obj, "fieldName");
        assertEquals("TestClass[name=John, age=25]", result);
    }

    @Test
    void testToStringExclude_ExcludeFieldNamesAndNullValues_ReturnsToStringWithoutExcludedFieldsAndNullValues() {
        TestClass obj = new TestClass("John", 25, null);
        String result = ReflectionToStringBuilder.toStringExclude(obj, "password");
        assertEquals("TestClass[name=John, age=25]", result);
    }

    @Test
    void testToStringExclude_EmptyExcludeFieldNames_ReturnsToStringWithAllFields() {
        TestClass obj = new TestClass("John", 25, "password");
        String result = ReflectionToStringBuilder.toStringExclude(obj);
        assertEquals("TestClass[name=John, age=25, password=password]", result);
    }

    @Test
    void testToStringExclude_UpToClass_ReturnsToStringUpToSpecifiedSuperClass() {
        SubTestClass obj = new SubTestClass("John", 25, "password", "secret");
        String result = ReflectionToStringBuilder.toStringExclude(obj, "fieldName", SubTestClass.class);
        assertEquals("SubTestClass[password=password, secret=secret]", result);
    }

    private static class TestClass {
        private String name;
        private int age;
        private String password;

        public TestClass(String name, int age, String password) {
            this.name = name;
            this.age = age;
            this.password = password;
        }
    }

    private static class SubTestClass extends TestClass {
        private String secret;

        public SubTestClass(String name, int age, String password, String secret) {
            super(name, age, password);
            this.secret = secret;
        }
    }
}