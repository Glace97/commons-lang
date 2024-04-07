
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class withDecimalsParsingTest {

    @Nested
    @DisplayName("when input string is empty")
    class EmptyStringTest {
        
        @Test
        @DisplayName("should return true")
        void shouldReturnTrue() {
            String str = "";
            int beginIdx = 0;
            Assertions.assertTrue(NumberUtils.withDecimalsParsing(str, beginIdx));
        }
    }
    
    @Nested
    @DisplayName("when input string has valid decimal numbers")
    class ValidDecimalNumbersTest {
        
        @Test
        @DisplayName("should return true")
        void shouldReturnTrue() {
            String str = "12.34";
            int beginIdx = 0;
            Assertions.assertTrue(NumberUtils.withDecimalsParsing(str, beginIdx));
        }
    }
    
    @Nested
    @DisplayName("when input string has invalid decimal numbers")
    class InvalidDecimalNumbersTest {
        
        @Test
        @DisplayName("should return false")
        void shouldReturnFalse() {
            String str = "12..34";
            int beginIdx = 0;
            Assertions.assertFalse(NumberUtils.withDecimalsParsing(str, beginIdx));
        }
        
        @Test
        @DisplayName("should return false")
        void shouldReturnFalse_whenDecimalPointsExceedOne() {
            String str = "12.34.56";
            int beginIdx = 0;
            Assertions.assertFalse(NumberUtils.withDecimalsParsing(str, beginIdx));
        }
        
        @Test
        @DisplayName("should return false")
        void shouldReturnFalse_whenNonDigitCharacterPresent() {
            String str = "12.3a4";
            int beginIdx = 0;
            Assertions.assertFalse(NumberUtils.withDecimalsParsing(str, beginIdx));
        }
    }
    
    @Nested
    @DisplayName("when input string has no decimal numbers")
    class NoDecimalNumbersTest {
        
        @Test
        @DisplayName("should return true")
        void shouldReturnTrue() {
            String str = "1234";
            int beginIdx = 0;
            Assertions.assertTrue(NumberUtils.withDecimalsParsing(str, beginIdx));
        }
    }
    
}
