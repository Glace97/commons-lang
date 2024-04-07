import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class invokeConstructorTest {

    @Test
    void testInvokeConstructor() {
        try {
            // Test when cls is null
            assertThrows(NullPointerException.class, () -> ConstructorUtils.invokeConstructor(null));

            // Test when args is null
            assertNotNull(ConstructorUtils.invokeConstructor(String.class, (Object[]) null));

            // Test when parameterTypes is null
            assertNotNull(ConstructorUtils.invokeConstructor(String.class, new Object[]{"Hello"}, null));

            // Test when cls is a class without any constructors
            assertThrows(NoSuchMethodException.class, () -> ConstructorUtils.invokeConstructor(Objects.class));

            // Test when cls is a class with private constructor
            assertThrows(IllegalAccessException.class, () -> ConstructorUtils.invokeConstructor(ConstructorUtils.class));

            // Test when cls is a class with constructor throwing exception
            assertThrows(InvocationTargetException.class, () -> ConstructorUtils.invokeConstructor(IllegalArgumentException.class));

            // Test when cls is a class with constructor throwing InstantiationException
            assertThrows(InstantiationException.class, () -> ConstructorUtils.invokeConstructor(AbstractClass.class));

            // Test when cls is a class with constructor throwing InvocationTargetException
            assertThrows(InvocationTargetException.class, () -> ConstructorUtils.invokeConstructor(ExceptionClass.class));

            // Test when cls is a class with constructor throwing IllegalAccessException
            assertThrows(IllegalAccessException.class, () -> ConstructorUtils.invokeConstructor(ClassWithoutAccess.class));

            // Test when cls is a class with constructor accepting arguments
            String result = ConstructorUtils.invokeConstructor(String.class, new Object[]{"Hello"});
            assertEquals("Hello", result);

            // Test when cls is a class with constructor accepting varargs
            result = ConstructorUtils.invokeConstructor(String.class, "H", "e", "l", "l", "o");
            assertEquals("Hello", result);

        } catch (Exception e) {
            fail("An unexpected exception occurred: " + e.getMessage());
        }
    }
}