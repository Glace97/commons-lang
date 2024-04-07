import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class StringUtilsTest {

    @Test
    @DisplayName("Test toStringOrEmpty with null object")
    void testToStringOrEmptyWithNull() {
        Object obj = null;
        String result = StringUtils.toStringOrEmpty(obj);
        assertEquals("", result);
    }

    @Test
    @DisplayName("Test toStringOrEmpty with empty string")
    void testToStringOrEmptyWithEmptyString() {
        String str = "";
        String result = StringUtils.toStringOrEmpty(str);
        assertEquals("", result);
    }

    @Test
    @DisplayName("Test toStringOrEmpty with non-empty string")
    void testToStringOrEmptyWithNonEmptyString() {
        String str = "Hello World";
        String result = StringUtils.toStringOrEmpty(str);
        assertEquals("Hello World", result);
    }

    @Test
    @DisplayName("Test toStringOrEmpty with integer")
    void testToStringOrEmptyWithInteger() {
        Integer num = 10;
        String result = StringUtils.toStringOrEmpty(num);
        assertEquals("10", result);
    }

    @Test
    @DisplayName("Test toStringOrEmpty with boolean")
    void testToStringOrEmptyWithBoolean() {
        Boolean bool = true;
        String result = StringUtils.toStringOrEmpty(bool);
        assertEquals("true", result);
    }

    @Test
    @DisplayName("Test toStringOrEmpty with array")
    void testToStringOrEmptyWithArray() {
        Integer[] array = {1, 2, 3};
        String result = StringUtils.toStringOrEmpty(array);
        assertEquals("[1, 2, 3]", result);
    }

    @Test
    @DisplayName("Test toStringOrEmpty with list")
    void testToStringOrEmptyWithList() {
        List<String> list = Arrays.asList("a", "b", "c");
        String result = StringUtils.toStringOrEmpty(list);
        assertEquals("[a, b, c]", result);
    }

    @Test
    @DisplayName("Test toStringOrEmpty with set")
    void testToStringOrEmptyWithSet() {
        Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c"));
        String result = StringUtils.toStringOrEmpty(set);
        assertEquals("[a, b, c]", result);
    }

    @Test
    @DisplayName("Test toStringOrEmpty with custom object")
    void testToStringOrEmptyWithCustomObject() {
        CustomObject obj = new CustomObject("test");
        String result = StringUtils.toStringOrEmpty(obj);
        assertEquals("CustomObject[test]", result);
    }
    
    private class CustomObject {
        private String value;
        
        public CustomObject(String value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return "CustomObject[" + value + "]";
        }
    }
}