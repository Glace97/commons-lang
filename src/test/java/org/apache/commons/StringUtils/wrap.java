import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class wrapTest {

    @Nested
    @DisplayName("Testing wrap method with char parameter")
    class WrapWithChar {
        
        @ParameterizedTest
        @ValueSource(chars = {'a', 'b', 'x', '\'', '\"'})
        void shouldWrapStringWithGivenChar(char wrapWith) {
            // Given
            String str = "test";
            String expected = wrapWith + str + wrapWith;
            
            // When
            String actual = StringUtils.wrap(str, wrapWith);
            
            // Then
            assertEquals(expected, actual);
        }
        
        @Test
        void shouldReturnNullIfStringIsNull() {
            // Given
            String str = null;
            
            // When
            String actual = StringUtils.wrap(str, 'x');
            
            // Then
            assertEquals(null, actual);
        }
        
        @Test
        void shouldReturnStringIfWrapCharIsNUL() {
            // Given
            String str = "test";
            char wrapWith = '\0';
            
            // When
            String actual = StringUtils.wrap(str, wrapWith);
            
            // Then
            assertEquals(str, actual);
        }
        
    }

    @Nested
    @DisplayName("Testing wrap method with String parameter")
    class WrapWithString {
        
        @ParameterizedTest
        @ValueSource(strings = {"", "x", "'", "\""})
        void shouldWrapStringWithGivenString(String wrapWith) {
            // Given
            String str = "test";
            String expected = wrapWith + str + wrapWith;
            
            // When
            String actual = StringUtils.wrap(str, wrapWith);
            
            // Then
            assertEquals(expected, actual);
        }
        
        @Test
        void shouldReturnNullIfStringIsNull() {
            // Given
            String str = null;
            
            // When
            String actual = StringUtils.wrap(str, "'");
            
            // Then
            assertEquals(null, actual);
        }
        
        @Test
        void shouldReturnStringIfWrapStringIsNull() {
            // Given
            String str = "test";
            String wrapWith = null;
            
            // When
            String actual = StringUtils.wrap(str, wrapWith);
            
            // Then
            assertEquals(str, actual);
        }
        
    }
    
}