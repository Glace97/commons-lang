import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getMatchingAccessibleConstructorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetMatchingAccessibleConstructor_ExactSignature() {
        // Test with exact signature constructor
        Class<?>[] parameterTypes = {int.class, String.class};
        Constructor<TestClass> expectedConstructor = TestClass.class.getConstructor(parameterTypes);
        Constructor<TestClass> actualConstructor = ConstructorUtils.getMatchingAccessibleConstructor(TestClass.class, parameterTypes);
        assertEquals(expectedConstructor, actualConstructor);
    }

    @Test
    void testGetMatchingAccessibleConstructor_AssignmentCompatible() {
        // Test with assignment-compatible constructor
        Class<?>[] parameterTypes = {Integer.class, CharSequence.class};
        Constructor<TestClass> expectedConstructor = TestClass.class.getConstructor(parameterTypes);
        Constructor<TestClass> actualConstructor = ConstructorUtils.getMatchingAccessibleConstructor(TestClass.class, parameterTypes);
        assertEquals(expectedConstructor, actualConstructor);
    }

    @Test
    void testGetMatchingAccessibleConstructor_NoMatchingConstructor() {
        // Test with no matching constructor
        Class<?>[] parameterTypes = {long.class, double.class};
        Constructor<TestClass> actualConstructor = ConstructorUtils.getMatchingAccessibleConstructor(TestClass.class, parameterTypes);
        assertNull(actualConstructor);
    }

    @Test
    void testGetMatchingAccessibleConstructor_NullClass() {
        // Test with null class
        Class<?>[] parameterTypes = {};
        assertThrows(NullPointerException.class, () -> {
            ConstructorUtils.getMatchingAccessibleConstructor(null, parameterTypes);
        });
    }

    @Test
    void testGetMatchingAccessibleConstructor_NullParameterTypes() {
        // Test with null parameter types
        assertThrows(NullPointerException.class, () -> {
            ConstructorUtils.getMatchingAccessibleConstructor(TestClass.class, null);
        });
    }

    @Test
    void testGetMatchingAccessibleConstructor_EmptyParameterTypes() {
        // Test with empty parameter types
        Class<?>[] parameterTypes = {};
        Constructor<TestClass> actualConstructor = ConstructorUtils.getMatchingAccessibleConstructor(TestClass.class, parameterTypes);
        assertNull(actualConstructor);
    }

    @Test
    void testGetMatchingAccessibleConstructor_MultipleConstructors() {
        // Test with multiple constructors
        Class<?>[] parameterTypes = {int.class};
        Constructor<TestClass> expectedConstructor = TestClass.class.getDeclaredConstructor(parameterTypes);
        Constructor<TestClass> actualConstructor = ConstructorUtils.getMatchingAccessibleConstructor(TestClass.class, parameterTypes);
        assertEquals(expectedConstructor, actualConstructor);
    }

    @Test
    void testGetMatchingAccessibleConstructor_PrivateConstructor() {
        // Test with private constructor
        Class<?>[] parameterTypes = {String.class};
        Constructor<TestClass> expectedConstructor = TestClass.class.getDeclaredConstructor(parameterTypes);
        Constructor<TestClass> actualConstructor = ConstructorUtils.getMatchingAccessibleConstructor(TestClass.class, parameterTypes);
        assertEquals(expectedConstructor, actualConstructor);
    }
}

class TestClass {
    public TestClass(int value, String name) {}
    public TestClass(Integer value, CharSequence description) {}
    private TestClass(String text) {}
}