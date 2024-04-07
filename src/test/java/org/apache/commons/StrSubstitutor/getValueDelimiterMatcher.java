import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class getValueDelimiterMatcherTest {
    private StrSubstitutor substitutor;

    @BeforeEach
    void setUp() {
        substitutor = new StrSubstitutor();
    }

    @Nested
    @DisplayName("Default value delimiter tests")
    class DefaultValueDelimiterTests {
        @Test
        @DisplayName("Should return default value delimiter matcher")
        void shouldReturnDefaultValueDelimiterMatcher() {
            assertEquals(StrMatcher.stringMatcher(":-"), substitutor.getValueDelimiterMatcher());
        }
    }

    @Nested
    @DisplayName("Custom value delimiter tests")
    class CustomValueDelimiterTests {
        @Test
        @DisplayName("Should return custom value delimiter matcher")
        void shouldReturnCustomValueDelimiterMatcher() {
            StrMatcher valueDelimiterMatcher = StrMatcher.charMatcher(':');
            substitutor.setValueDelimiterMatcher(valueDelimiterMatcher);
            assertEquals(valueDelimiterMatcher, substitutor.getValueDelimiterMatcher());
        }
    }
}