
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SwapCaseTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    @DisplayName("Test swapCase with null input")
    void testSwapCaseWithNullInput() {
        assertNull(stringUtils.swapCase(null));
    }

    @Test
    @DisplayName("Test swapCase with empty input")
    void testSwapCaseWithEmptyInput() {
        assertEquals("", stringUtils.swapCase(""));
    }

    @Test
    @DisplayName("Test swapCase with all uppercase input")
    void testSwapCaseWithAllUppercaseInput() {
        assertEquals("the dog has a bone", stringUtils.swapCase("THE DOG HAS A BONE"));
    }

    @Test
    @DisplayName("Test swapCase with all lowercase input")
    void testSwapCaseWithAllLowercaseInput() {
        assertEquals("THE DOG HAS A BONE", stringUtils.swapCase("the dog has a bone"));
    }

    @Test
    @DisplayName("Test swapCase with mixed case input")
    void testSwapCaseWithMixedCaseInput() {
        assertEquals("tHE DOG HAS A bone", stringUtils.swapCase("The dog has a BONE"));
    }

    @Test
    @DisplayName("Test swapCase with special characters")
    void testSwapCaseWithSpecialCharacters() {
        assertEquals("!@#$%^&*()_+", stringUtils.swapCase("!@#$%^&*()_+"));
    }

    @Test
    @DisplayName("Test swapCase with Unicode characters")
    void testSwapCaseWithUnicodeCharacters() {
        assertEquals("ΣΤΥΨΩ", stringUtils.swapCase("στυψω"));
    }
}
