import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;

class getAccessibleConstructorTest {

    @Test
    void testGetAccessibleConstructor() {
        // Test with a class that has a public constructor
        Class<?> cls1 = MyClass.class;
        Constructor<?> constructor1 = ConstructorUtils.getAccessibleConstructor(cls1);
        assertNotNull(constructor1);
        assertTrue(constructor1.isAccessible());

        // Test with a class that has a private constructor
        Class<?> cls2 = MyOtherClass.class;
        Constructor<?> constructor2 = ConstructorUtils.getAccessibleConstructor(cls2);
        assertNotNull(constructor2);
        assertTrue(constructor2.isAccessible());

        // Test with a class that has no constructor
        Class<?> cls3 = NoConstructorClass.class;
        Constructor<?> constructor3 = ConstructorUtils.getAccessibleConstructor(cls3);
        assertNull(constructor3);

        // Test with a class and parameter types
        Class<?> cls4 = MyClass.class;
        Class<?>[] parameterTypes = {int.class, String.class};
        Constructor<?> constructor4 = ConstructorUtils.getAccessibleConstructor(cls4, parameterTypes);
        assertNotNull(constructor4);
        assertTrue(constructor4.isAccessible());
        assertEquals(int.class, constructor4.getParameterTypes()[0]);
        assertEquals(String.class, constructor4.getParameterTypes()[1]);
    }

    @Test
    void testGetAccessibleConstructorWithNullClass() {
        assertThrows(NullPointerException.class, () -> {
            ConstructorUtils.getAccessibleConstructor(null);
        });
    }

    @Test
    void testGetAccessibleConstructorWithNullConstructor() {
        assertThrows(NullPointerException.class, () -> {
            ConstructorUtils.getAccessibleConstructor(null);
        });
    }

    private static class MyClass {
        public MyClass() {}
        public MyClass(int x) {}
        public MyClass(String str) {}
    }

    private static class MyOtherClass {
        private MyOtherClass() {}
    }

    private static class NoConstructorClass {
        // No constructor defined
    }
}