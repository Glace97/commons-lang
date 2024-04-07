import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class prependIfMissingTest {
    
    private StringUtils stringUtils;
    
    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }
    
    @Test
    void testPrependIfMissing_NullStringAndNullPrefix_ReturnNull() {
        String result = stringUtils.prependIfMissing(null, null);
        assertEquals(null, result);
    }
    
    @Test
    void testPrependIfMissing_StringAndNullPrefix_ReturnString() {
        String result = stringUtils.prependIfMissing("abc", null);
        assertEquals("abc", result);
    }
    
    @Test
    void testPrependIfMissing_EmptyStringAndPrefix_ReturnPrefix() {
        String result = stringUtils.prependIfMissing("", "xyz");
        assertEquals("xyz", result);
    }
    
    @Test
    void testPrependIfMissing_StringAndPrefix_ReturnPrefixedString() {
        String result = stringUtils.prependIfMissing("abc", "xyz");
        assertEquals("xyzabc", result);
    }
    
    @Test
    void testPrependIfMissing_StringAndSamePrefix_ReturnString() {
        String result = stringUtils.prependIfMissing("xyzabc", "xyz");
        assertEquals("xyzabc", result);
    }
    
    @Test
    void testPrependIfMissing_StringAndDifferentPrefix_ReturnPrefixedString() {
        String result = stringUtils.prependIfMissing("XYZabc", "xyz");
        assertEquals("xyzXYZabc", result);
    }
    
    @Test
    void testPrependIfMissing_NullStringAndNullPrefixAndNullPrefixes_ReturnNull() {
        String result = stringUtils.prependIfMissing(null, null, null);
        assertEquals(null, result);
    }
    
    @Test
    void testPrependIfMissing_StringAndNullPrefixAndNullPrefixes_ReturnString() {
        String result = stringUtils.prependIfMissing("abc", null, null);
        assertEquals("abc", result);
    }
    
    @Test
    void testPrependIfMissing_EmptyStringAndPrefixAndNullPrefixes_ReturnPrefix() {
        String result = stringUtils.prependIfMissing("", "xyz", null);
        assertEquals("xyz", result);
    }
    
    @Test
    void testPrependIfMissing_StringAndPrefixAndNullPrefixes_ReturnPrefixedString() {
        String result = stringUtils.prependIfMissing("abc", "xyz", null);
        assertEquals("xyzabc", result);
    }
    
    @Test
    void testPrependIfMissing_StringAndPrefixAndEmptyPrefixes_ReturnString() {
        String result = stringUtils.prependIfMissing("abc", "xyz", "");
        assertEquals("abc", result);
    }
    
    @Test
    void testPrependIfMissing_StringAndPrefixAndAdditionalPrefix_ReturnPrefixedString() {
        String result = stringUtils.prependIfMissing("abc", "xyz", "mno");
        assertEquals("xyzabc", result);
    }
    
    @Test
    void testPrependIfMissing_StringAndSamePrefixAndAdditionalPrefix_ReturnString() {
        String result = stringUtils.prependIfMissing("xyzabc", "xyz", "mno");
        assertEquals("xyzabc", result);
    }
    
    @Test
    void testPrependIfMissing_StringAndDifferentPrefixAndAdditionalPrefix_ReturnPrefixedString() {
        String result = stringUtils.prependIfMissing("mnoabc", "xyz", "mno");
        assertEquals("mnoabc", result);
    }
    
    @Test
    void testPrependIfMissing_StringAndDifferentCasePrefixAndAdditionalPrefix_ReturnPrefixedString() {
        String result = stringUtils.prependIfMissing("XYZabc", "xyz", "mno");
        assertEquals("xyzXYZabc", result);
    }
    
    @Test
    void testPrependIfMissing_StringAndDifferentCaseAdditionalPrefix_ReturnPrefixedString() {
        String result = stringUtils.prependIfMissing("MNOabc", "xyz", "mno");
        assertEquals("xyzMNOabc", result);
    }
}