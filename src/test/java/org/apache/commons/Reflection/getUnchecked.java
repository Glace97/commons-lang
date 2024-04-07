
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

class getUncheckedTest {

    @Test
    void testGetUnchecked() throws IllegalAccessException {
        // Create an object and a field for testing
        TestObject obj = new TestObject();
        Field field = getField("value", TestObject.class);

        // Set the field value
        field.set(obj, 10);

        // Call the getUnchecked method and assert the result
        Object result = Reflection.getUnchecked(field, obj);
        Assertions.assertEquals(10, result);
    }

    @Test
    void testGetUnchecked_NullField() {
        // Create an object for testing
        TestObject obj = new TestObject();

        // Call the getUnchecked method with null field and assert the exception
        Assertions.assertThrows(NullPointerException.class, () -> {
            Reflection.getUnchecked(null, obj);
        });
    }

    @Test
    void testGetUnchecked_IllegalAccess() {
        // Create an object and a private field for testing
        TestObject obj = new TestObject();
        Field field = getField("privateValue", TestObject.class);

        // Call the getUnchecked method with private field and assert the exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Reflection.getUnchecked(field, obj);
        });
    }

    private Field getField(String fieldName, Class<?> clazz) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static class TestObject {
        public int value;
        private int privateValue;
    }
}
