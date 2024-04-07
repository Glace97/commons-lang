import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class swapCaseTest {

    @Test
    void testSwapCase_NullString_ReturnsNull() {
        String result = WordUtils.swapCase(null);
        assertEquals(null, result);
    }

    @Test
    void testSwapCase_EmptyString_ReturnsEmptyString() {
        String result = WordUtils.swapCase("");
        assertEquals("", result);
    }

    @Test
    void testSwapCase_UpperCaseCharacter_ReturnsLowerCaseCharacter() {
        String result = WordUtils.swapCase("A");
        assertEquals("a", result);
    }

    @Test
    void testSwapCase_TitleCaseCharacter_ReturnsLowerCaseCharacter() {
        String result = WordUtils.swapCase("Title");
        assertEquals("title", result);
    }

    @Test
    void testSwapCase_LowerCaseCharacterAfterWhitespace_ReturnsTitleCaseCharacter() {
        String result = WordUtils.swapCase("hello world");
        assertEquals("Hello World", result);
    }

    @Test
    void testSwapCase_LowerCaseCharacter_ReturnsUpperCaseCharacter() {
        String result = WordUtils.swapCase("a");
        assertEquals("A", result);
    }

    @Test
    void testSwapCase_MixedCaseString_ReturnsSwappedCaseString() {
        String result = WordUtils.swapCase("The dog has a BONE");
        assertEquals("tHE DOG HAS A bone", result);
    }
}