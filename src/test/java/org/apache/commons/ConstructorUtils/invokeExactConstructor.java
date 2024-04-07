import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class invokeExactConstructorTest {

    @Test
    void testInvokeExactConstructor_withNullClass_shouldThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            ConstructorUtils.invokeExactConstructor(null);
        });
    }

    @Test
    void testInvokeExactConstructor_withNullArgs_shouldReturnNewInstance() {
        try {
            Object instance = ConstructorUtils.invokeExactConstructor(String.class, null);
            Assertions.assertNotNull(instance);
            Assertions.assertEquals("", instance);
        } catch (Exception e) {
            Assertions.fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    void testInvokeExactConstructor_withNoMatchingConstructor_shouldThrowNoSuchMethodException() {
        Assertions.assertThrows(NoSuchMethodException.class, () -> {
            ConstructorUtils.invokeExactConstructor(String.class, 123);
        });
    }

    @Test
    void testInvokeExactConstructor_withMatchingConstructor_shouldReturnNewInstance() {
        try {
            Object instance = ConstructorUtils.invokeExactConstructor(String.class, "Hello World");
            Assertions.assertNotNull(instance);
            Assertions.assertEquals("Hello World", instance);
        } catch (Exception e) {
            Assertions.fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    void testInvokeExactConstructor_withIllegalAccessException_shouldThrowIllegalAccessException() {
        Assertions.assertThrows(IllegalAccessException.class, () -> {
            ConstructorUtils.invokeExactConstructor(TestClass.class, 123);
        });
    }

    @Test
    void testInvokeExactConstructor_withInvocationTargetException_shouldThrowInvocationTargetException() {
        Assertions.assertThrows(InvocationTargetException.class, () -> {
            ConstructorUtils.invokeExactConstructor(TestClass.class, "Hello World");
        });
    }

    @Test
    void testInvokeExactConstructor_withInstantiationException_shouldThrowInstantiationException() {
        Assertions.assertThrows(InstantiationException.class, () -> {
            ConstructorUtils.invokeExactConstructor(TestClass.class, "Hello World");
        });
    }

    private static class TestClass {
        private TestClass(String arg) throws IllegalAccessException {
            throw new IllegalAccessException("Test Exception");
        }
    }
}