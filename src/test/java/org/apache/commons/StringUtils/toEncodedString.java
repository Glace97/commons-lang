
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("StringUtils.toEncodedString")
class toEncodedStringTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("When encoding bytes to string")
    class EncodingBytesToString {

        @Test
        @DisplayName("Should return empty string when bytes array is empty")
        void shouldReturnEmptyStringWhenBytesArrayIsEmpty() {
            byte[] bytes = new byte[0];
            String result = stringUtils.toEncodedString(bytes, StandardCharsets.UTF_8);
            assertEquals("", result);
        }

        @Test
        @DisplayName("Should return string representation of bytes using UTF-8 charset")
        void shouldReturnStringRepresentationOfBytesUsingUtf8Charset() {
            byte[] bytes = {72, 101, 108, 108, 111}; // "Hello"
            String result = stringUtils.toEncodedString(bytes, StandardCharsets.UTF_8);
            assertEquals("Hello", result);
        }

        @Test
        @DisplayName("Should return string representation of bytes using specified charset")
        void shouldReturnStringRepresentationOfBytesUsingSpecifiedCharset() {
            byte[] bytes = {72, 101, 108, 108, 111}; // "Hello"
            Charset charset = Charset.forName("ISO-8859-1");
            String result = stringUtils.toEncodedString(bytes, charset);
            assertEquals("Hello", result);
        }
    }
}
