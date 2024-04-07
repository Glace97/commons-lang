import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ConvertRemainingAccentCharactersTest {

    private StringBuilder decomposed;

    @BeforeEach
    void setup() {
        decomposed = new StringBuilder();
    }

    @Nested
    @DisplayName("When converting remaining accent characters")
    class ConvertRemainingAccentCharacters {

        @Test
        @DisplayName("should replace 'Ł' with 'L'")
        void shouldReplaceLWithL() {
            decomposed.append("Ł");
            StringUtils.convertRemainingAccentCharacters(decomposed);
            assertEquals("L", decomposed.toString());
        }

        @Test
        @DisplayName("should replace 'ł' with 'l'")
        void shouldReplacelWithl() {
            decomposed.append("ł");
            StringUtils.convertRemainingAccentCharacters(decomposed);
            assertEquals("l", decomposed.toString());
        }

        @Test
        @DisplayName("should not modify the StringBuilder if no accent characters are present")
        void shouldNotModifyStringBuilderIfNoAccentCharactersPresent() {
            decomposed.append("A");
            StringUtils.convertRemainingAccentCharacters(decomposed);
            assertEquals("A", decomposed.toString());
        }

        @Test
        @DisplayName("should replace multiple 'Ł' with 'L'")
        void shouldReplaceMultipleLWithL() {
            decomposed.append("ŁŁŁ");
            StringUtils.convertRemainingAccentCharacters(decomposed);
            assertEquals("LLL", decomposed.toString());
        }

        @Test
        @DisplayName("should replace multiple 'ł' with 'l'")
        void shouldReplaceMultiplelWithl() {
            decomposed.append("łłł");
            StringUtils.convertRemainingAccentCharacters(decomposed);
            assertEquals("lll", decomposed.toString());
        }

        @Test
        @DisplayName("should replace 'Ł' and 'ł' with 'L' and 'l' respectively")
        void shouldReplaceLAndlWithLAndl() {
            decomposed.append("Łł");
            StringUtils.convertRemainingAccentCharacters(decomposed);
            assertEquals("Ll", decomposed.toString());
        }
    }
}