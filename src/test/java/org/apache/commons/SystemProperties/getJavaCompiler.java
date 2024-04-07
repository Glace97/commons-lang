import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getJavaCompilerTest {

    @Test
    void testGetJavaCompiler() {
        String javaCompiler = SystemProperties.getJavaCompiler();
        assertNull(javaCompiler);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "javac", "javac.exe"})
    void testGetJavaCompilerWithDifferentValues(String value) {
        System.setProperty("java.compiler", value);
        String javaCompiler = SystemProperties.getJavaCompiler();
        assertEquals(value, javaCompiler);
    }
}