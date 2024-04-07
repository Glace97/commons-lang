import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class lexxTest {

    private DurationFormatUtils durationFormatUtils;

    @BeforeEach
    void setUp() {
        durationFormatUtils = new DurationFormatUtils();
    }

    @Nested
    @DisplayName("lexx method")
    class LexxMethod {

        @Test
        @DisplayName("should parse format into Tokens correctly")
        void shouldParseFormatIntoTokensCorrectly() {
            String format = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'";
            DurationFormatUtils.Token[] expectedTokens = {
                new DurationFormatUtils.Token("P", false, -1),
                new DurationFormatUtils.Token("y", false, -1),
                new DurationFormatUtils.Token("Y", false, -1),
                new DurationFormatUtils.Token("M", false, -1),
                new DurationFormatUtils.Token("d", false, -1),
                new DurationFormatUtils.Token("T", false, -1),
                new DurationFormatUtils.Token("H", false, -1),
                new DurationFormatUtils.Token("m", false, -1),
                new DurationFormatUtils.Token("s", false, -1),
                new DurationFormatUtils.Token(".", false, -1),
                new DurationFormatUtils.Token("S", false, -1)
            };

            DurationFormatUtils.Token[] actualTokens = durationFormatUtils.lexx(format);

            assertArrayEquals(expectedTokens, actualTokens);
        }

        @Test
        @DisplayName("should throw IllegalArgumentException for unmatched quote in format")
        void shouldThrowIllegalArgumentExceptionForUnmatchedQuoteInFormat() {
            String format = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S";

            assertThrows(IllegalArgumentException.class, () -> {
                durationFormatUtils.lexx(format);
            });
        }

        @Test
        @DisplayName("should throw IllegalArgumentException for unmatched optional in format")
        void shouldThrowIllegalArgumentExceptionForUnmatchedOptionalInFormat() {
            String format = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'[";

            assertThrows(IllegalArgumentException.class, () -> {
                durationFormatUtils.lexx(format);
            });
        }

        @Test
        @DisplayName("should throw IllegalArgumentException for nested optional block in format")
        void shouldThrowIllegalArgumentExceptionForNestedOptionalBlockInFormat() {
            String format = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.SSS'S'[[H]";

            assertThrows(IllegalArgumentException.class, () -> {
                durationFormatUtils.lexx(format);
            });
        }
    }
}