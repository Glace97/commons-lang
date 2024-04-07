import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class lastOrdinalIndexOfTest {
    
    private StringUtils stringUtils;
    
    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }
    
    @Test
    void testLastOrdinalIndexOfNullString() {
        int result = stringUtils.lastOrdinalIndexOf(null, "a", 1);
        assertEquals(-1, result);
    }
    
    @Test
    void testLastOrdinalIndexOfNullSearchString() {
        int result = stringUtils.lastOrdinalIndexOf("aabaabaa", null, 1);
        assertEquals(-1, result);
    }
    
    @Test
    void testLastOrdinalIndexOfEmptyString() {
        int result = stringUtils.lastOrdinalIndexOf("", "", 1);
        assertEquals(0, result);
    }
    
    @Test
    void testLastOrdinalIndexOfNoMatch() {
        int result = stringUtils.lastOrdinalIndexOf("aabaabaa", "c", 1);
        assertEquals(-1, result);
    }
    
    @Test
    void testLastOrdinalIndexOfSingleMatch() {
        int result = stringUtils.lastOrdinalIndexOf("aabaabaa", "a", 1);
        assertEquals(7, result);
    }
    
    @Test
    void testLastOrdinalIndexOfMultipleMatches() {
        int result = stringUtils.lastOrdinalIndexOf("aabaabaa", "a", 2);
        assertEquals(6, result);
    }
    
    @Test
    void testLastOrdinalIndexOfSingleMatchWithMultipleOccurrences() {
        int result = stringUtils.lastOrdinalIndexOf("aabaabaa", "b", 1);
        assertEquals(5, result);
    }
    
    @Test
    void testLastOrdinalIndexOfMultipleMatchesWithMultipleOccurrences() {
        int result = stringUtils.lastOrdinalIndexOf("aabaabaa", "b", 2);
        assertEquals(2, result);
    }
    
    @Test
    void testLastOrdinalIndexOfSingleMatchWithSubstring() {
        int result = stringUtils.lastOrdinalIndexOf("aabaabaa", "ab", 1);
        assertEquals(4, result);
    }
    
    @Test
    void testLastOrdinalIndexOfMultipleMatchesWithSubstring() {
        int result = stringUtils.lastOrdinalIndexOf("aabaabaa", "ab", 2);
        assertEquals(1, result);
    }
    
    @Test
    void testLastOrdinalIndexOfEmptySearchString() {
        int result = stringUtils.lastOrdinalIndexOf("aabaabaa", "", 1);
        assertEquals(8, result);
    }
    
    @Test
    void testLastOrdinalIndexOfEmptySearchStringWithMultipleOccurrences() {
        int result = stringUtils.lastOrdinalIndexOf("aabaabaa", "", 2);
        assertEquals(8, result);
    }
}