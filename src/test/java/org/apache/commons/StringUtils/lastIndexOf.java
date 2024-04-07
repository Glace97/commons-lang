import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class lastIndexOfTest {

    @Test
    void testLastIndexOf_NullSequence_ReturnsNegativeOne() {
        int result = StringUtils.lastIndexOf(null, "a");
        assertEquals(-1, result);
    }

    @Test
    void testLastIndexOf_NullSearchSequence_ReturnsNegativeOne() {
        int result = StringUtils.lastIndexOf("aabaabaa", null);
        assertEquals(-1, result);
    }

    @Test
    void testLastIndexOf_EmptySequences_ReturnsZero() {
        int result = StringUtils.lastIndexOf("", "");
        assertEquals(0, result);
    }

    @Test
    void testLastIndexOf_FoundSingleCharacter_ReturnsIndex() {
        int result = StringUtils.lastIndexOf("aabaabaa", "a");
        assertEquals(7, result);
    }

    @Test
    void testLastIndexOf_FoundMultipleCharacters_ReturnsIndex() {
        int result = StringUtils.lastIndexOf("aabaabaa", "b");
        assertEquals(5, result);
    }

    @Test
    void testLastIndexOf_FoundSubstring_ReturnsIndex() {
        int result = StringUtils.lastIndexOf("aabaabaa", "ab");
        assertEquals(4, result);
    }

    @Test
    void testLastIndexOf_EmptySearchSequence_ReturnsLength() {
        int result = StringUtils.lastIndexOf("aabaabaa", "");
        assertEquals(8, result);
    }

    @Test
    void testLastIndexOf_StartPosition_ReturnsIndex() {
        int result = StringUtils.lastIndexOf("aabaabaa", "a", 2);
        assertEquals(2, result);
    }

    @Test
    void testLastIndexOf_StartPositionNotFound_ReturnsNegativeOne() {
        int result = StringUtils.lastIndexOf("aabaabaa", "b", 0);
        assertEquals(-1, result);
    }

    @Test
    void testLastIndexOf_StartPositionGreaterThanLength_ReturnsNegativeOne() {
        int result = StringUtils.lastIndexOf("aabaabaa", "b", 9);
        assertEquals(-1, result);
    }

    @Test
    void testLastIndexOf_SearchCharacter_ReturnsIndex() {
        int result = StringUtils.lastIndexOf("aabaabaa", 'a');
        assertEquals(7, result);
    }

    @Test
    void testLastIndexOf_SearchCharacterNotFound_ReturnsNegativeOne() {
        int result = StringUtils.lastIndexOf("aabaabaa", 'b');
        assertEquals(-1, result);
    }

    @Test
    void testLastIndexOf_StartPositionSearchCharacter_ReturnsIndex() {
        int result = StringUtils.lastIndexOf("aabaabaa", 'b', 8);
        assertEquals(5, result);
    }

    @Test
    void testLastIndexOf_StartPositionSearchCharacterNotFound_ReturnsNegativeOne() {
        int result = StringUtils.lastIndexOf("aabaabaa", 'b', 4);
        assertEquals(-1, result);
    }
}