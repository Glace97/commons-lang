import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SubstringsBetweenTest {
    
    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }
    
    @Test
    @DisplayName("Test substringsBetween with valid input")
    void testSubstringsBetweenValidInput() {
        String str = "[a][b][c]";
        String open = "[";
        String close = "]";
        String[] expected = {"a", "b", "c"};
        String[] actual = stringUtils.substringsBetween(str, open, close);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test substringsBetween with null input")
    void testSubstringsBetweenNullInput() {
        String str = null;
        String open = "[";
        String close = "]";
        String[] expected = null;
        String[] actual = stringUtils.substringsBetween(str, open, close);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test substringsBetween with empty input")
    void testSubstringsBetweenEmptyInput() {
        String str = "";
        String open = "[";
        String close = "]";
        String[] expected = {};
        String[] actual = stringUtils.substringsBetween(str, open, close);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test substringsBetween with empty open")
    void testSubstringsBetweenEmptyOpen() {
        String str = "[a][b][c]";
        String open = "";
        String close = "]";
        String[] expected = null;
        String[] actual = stringUtils.substringsBetween(str, open, close);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test substringsBetween with empty close")
    void testSubstringsBetweenEmptyClose() {
        String str = "[a][b][c]";
        String open = "[";
        String close = "";
        String[] expected = null;
        String[] actual = stringUtils.substringsBetween(str, open, close);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test substringsBetween with no match")
    void testSubstringsBetweenNoMatch() {
        String str = "[a][b][c]";
        String open = "{";
        String close = "}";
        String[] expected = null;
        String[] actual = stringUtils.substringsBetween(str, open, close);
        Assertions.assertArrayEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test substringsBetween with multiple matches")
    void testSubstringsBetweenMultipleMatches() {
        String str = "[a][b][c]";
        String open = "[";
        String close = "]";
        String[] expected = {"a", "b", "c"};
        String[] actual = stringUtils.substringsBetween(str, open, close);
        Assertions.assertArrayEquals(expected, actual);
    }
}