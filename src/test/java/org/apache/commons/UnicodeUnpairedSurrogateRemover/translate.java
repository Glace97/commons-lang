import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

class TranslateTest {

    private UnicodeUnpairedSurrogateRemover remover;
    private Writer writer;

    @BeforeEach
    void setup() {
        remover = new UnicodeUnpairedSurrogateRemover();
        writer = new StringWriter();
    }

    @Nested
    @DisplayName("When code point is a surrogate")
    class WhenCodePointIsSurrogate {

        @Test
        @DisplayName("Should return true and not write anything")
        void shouldReturnTrueAndNotWriteAnything() throws IOException {
            // Arrange
            int codePoint = Character.MIN_SURROGATE;

            // Act
            boolean result = remover.translate(codePoint, writer);

            // Assert
            Assertions.assertTrue(result);
            Assertions.assertEquals("", writer.toString());
        }

        @Test
        @DisplayName("Should return true and not write anything")
        void shouldReturnTrueAndNotWriteAnythingForMaxSurrogate() throws IOException {
            // Arrange
            int codePoint = Character.MAX_SURROGATE;

            // Act
            boolean result = remover.translate(codePoint, writer);

            // Assert
            Assertions.assertTrue(result);
            Assertions.assertEquals("", writer.toString());
        }
    }

    @Nested
    @DisplayName("When code point is not a surrogate")
    class WhenCodePointIsNotSurrogate {

        @Test
        @DisplayName("Should return false and write the code point")
        void shouldReturnFalseAndWriteCodePoint() throws IOException {
            // Arrange
            int codePoint = 'A';

            // Act
            boolean result = remover.translate(codePoint, writer);

            // Assert
            Assertions.assertFalse(result);
            Assertions.assertEquals('A', writer.toString());
        }
    }
}