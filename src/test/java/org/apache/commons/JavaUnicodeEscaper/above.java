import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JavaUnicodeEscaperTest {

    private JavaUnicodeEscaper unicodeEscaper;

    @BeforeAll
    void setup() {
        unicodeEscaper = new JavaUnicodeEscaper(0, 127, true);
    }

    @Nested
    @DisplayName("Constructor Test")
    class ConstructorTest {
        @Test
        @DisplayName("Constructor should set the correct boundaries")
        void constructorSetsBoundaries() {
            assertEquals(0, unicodeEscaper.getBelow());
            assertEquals(127, unicodeEscaper.getAbove());
            assertTrue(unicodeEscaper.isBetween());
        }
    }

    @Nested
    @DisplayName("Above Test")
    class AboveTest {
        @ParameterizedTest
        @ValueSource(ints = {128, 256, 512})
        @DisplayName("Escaping should occur above the specified value")
        void escapingOccursAboveSpecifiedValue(int codePoint) {
            JavaUnicodeEscaper escaper = JavaUnicodeEscaper.above(codePoint);
            assertTrue(escaper.getAbove() > codePoint);
        }
    }
}