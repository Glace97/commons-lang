import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.text.Format;
import java.util.HashMap;
import java.util.Map;

class applyPatternTest {
    private ExtendedMessageFormat emf;

    @BeforeEach
    void setUp() {
        emf = new ExtendedMessageFormat("");
    }

    @Nested
    @DisplayName("Tests for applyPattern method")
    class ApplyPatternTests {
        @Test
        @DisplayName("When pattern is null, should throw IllegalArgumentException")
        void applyPattern_NullPattern_ThrowsIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> emf.applyPattern(null));
        }

        @Test
        @DisplayName("When pattern is empty, should set toPattern as empty")
        void applyPattern_EmptyPattern_SetsToPatternAsEmpty() {
            emf.applyPattern("");
            assertEquals("", emf.toPattern);
        }

        @Test
        @DisplayName("When pattern does not contain any special characters, should set toPattern as the same pattern")
        void applyPattern_PatternWithoutSpecialCharacters_SetsToPatternAsSamePattern() {
            emf.applyPattern("Hello, world!");
            assertEquals("Hello, world!", emf.toPattern);
        }

        @Test
        @DisplayName("When pattern contains quoted strings, should strip the quoted strings and set toPattern correctly")
        void applyPattern_PatternWithQuotedStrings_SetsToPatternWithoutQuotedStrings() {
            emf.applyPattern("Hello '{0}'");
            assertEquals("Hello {0}", emf.toPattern);
        }

        @Test
        @DisplayName("When pattern contains format elements, should set toPattern correctly")
        void applyPattern_PatternWithFormatElements_SetsToPatternWithFormatElements() {
            emf.applyPattern("Hello {0,date,yyyy-MM-dd}");
            assertEquals("Hello {0,date,yyyy-MM-dd}", emf.toPattern);
        }

        @Test
        @DisplayName("When pattern contains format elements with invalid format description, should set toPattern and throw IllegalArgumentException")
        void applyPattern_PatternWithInvalidFormatDescription_ThrowsIllegalArgumentExceptionAndSetsToPattern() {
            assertThrows(IllegalArgumentException.class, () -> emf.applyPattern("Hello {0,date,invalid}"));
            assertEquals("Hello {0,date,invalid}", emf.toPattern);
        }

        @Test
        @DisplayName("When pattern contains format elements with missing closing brace, should throw IllegalArgumentException")
        void applyPattern_PatternWithMissingClosingBrace_ThrowsIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> emf.applyPattern("Hello {0,date,yyyy-MM-dd"));
        }

        @Test
        @DisplayName("When pattern contains format elements with missing starting brace, should throw IllegalArgumentException")
        void applyPattern_PatternWithMissingStartingBrace_ThrowsIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> emf.applyPattern("Hello 0,date,yyyy-MM-dd}");
        }

        @Test
        @DisplayName("When pattern contains format elements with missing format type, should throw IllegalArgumentException")
        void applyPattern_PatternWithMissingFormatType_ThrowsIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> emf.applyPattern("Hello {0,}"));
        }

        @Test
        @DisplayName("When pattern contains format elements with missing argument index, should throw IllegalArgumentException")
        void applyPattern_PatternWithMissingArgumentIndex_ThrowsIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> emf.applyPattern("Hello {,date,yyyy-MM-dd}"));
        }

        @Test
        @DisplayName("When pattern contains format elements with invalid argument index, should throw IllegalArgumentException")
        void applyPattern_PatternWithInvalidArgumentIndex_ThrowsIllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> emf.applyPattern("Hello {abc,date,yyyy-MM-dd}"));
        }

        @Test
        @DisplayName("When pattern contains format elements and registry is null, should set toPattern correctly")
        void applyPattern_PatternWithFormatElementsAndNullRegistry_SetsToPatternWithFormatElements() {
            emf.applyPattern("Hello {0,date,yyyy-MM-dd}");
            assertEquals("Hello {0,date,yyyy-MM-dd}", emf.toPattern);
        }

        @Test
        @DisplayName("When pattern contains format elements and registry is not null, should set toPattern correctly")
        void applyPattern_PatternWithFormatElementsAndNonNullRegistry_SetsToPatternWithFormatElements() {
            Map<String, FormatFactory> registry = new HashMap<>();
            registry.put("date", new DateFormatFactory());
            emf = new ExtendedMessageFormat("", registry);

            emf.applyPattern("Hello {0,date,yyyy-MM-dd}");
            assertEquals("Hello {0,date,yyyy-MM-dd}", emf.toPattern);
        }
    }
}