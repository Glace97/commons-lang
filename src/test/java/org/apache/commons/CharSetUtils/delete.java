import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class deleteTest {

    @Test
    void testDelete_NullString_ReturnNull() {
        String result = CharSetUtils.delete(null, "abc");
        assertEquals(null, result);
    }

    @Test
    void testDelete_EmptyString_ReturnEmptyString() {
        String result = CharSetUtils.delete("", "abc");
        assertEquals("", result);
    }

    @Test
    void testDelete_NullSet_ReturnOriginalString() {
        String result = CharSetUtils.delete("hello", null);
        assertEquals("hello", result);
    }

    @Test
    void testDelete_EmptySet_ReturnOriginalString() {
        String result = CharSetUtils.delete("hello", "");
        assertEquals("hello", result);
    }

    @Test
    void testDelete_DeleteCharactersPresentInSet() {
        String result = CharSetUtils.delete("hello", "hl");
        assertEquals("eo", result);
    }

    @Test
    void testDelete_DeleteCharactersNotPresentInSet() {
        String result = CharSetUtils.delete("hello", "le");
        assertEquals("ho", result);
    }

    @Test
    void testDelete_MultipleCharactersToDelete() {
        String result = CharSetUtils.delete("hello", "el");
        assertEquals("ho", result);
    }

    @Test
    void testDelete_MultipleOccurrencesOfCharactersToDelete() {
        String result = CharSetUtils.delete("hello", "l");
        assertEquals("heo", result);
    }
}