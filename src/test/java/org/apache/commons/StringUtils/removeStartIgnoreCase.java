import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class removeStartIgnoreCaseTest {
    private StringUtils stringUtils;

    @BeforeEach
    public void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testRemoveStartIgnoreCase_NullSourceString_NullResult() {
        String result = stringUtils.removeStartIgnoreCase(null, "abc");
        assertNull(result);
    }

    @Test
    void testRemoveStartIgnoreCase_EmptySourceString_EmptyResult() {
        String result = stringUtils.removeStartIgnoreCase("", "abc");
        assertEquals("", result);
    }

    @Test
    void testRemoveStartIgnoreCase_NullRemoveString_SourceStringUnchanged() {
        String source = "abcdef";
        String result = stringUtils.removeStartIgnoreCase(source, null);
        assertEquals(source, result);
    }

    @Test
    void testRemoveStartIgnoreCase_SourceStringNotStartingWithRemoveString_SourceStringUnchanged() {
        String source = "abcdef";
        String remove = "xyz";
        String result = stringUtils.removeStartIgnoreCase(source, remove);
        assertEquals(source, result);
    }

    @Test
    void testRemoveStartIgnoreCase_SourceStringStartingWithRemoveString_RemovedStringReturned() {
        String source = "abcdef";
        String remove = "abc";
        String result = stringUtils.removeStartIgnoreCase(source, remove);
        assertEquals("def", result);
    }

    @Test
    void testRemoveStartIgnoreCase_SourceStringStartingWithRemoveStringIgnoreCase_RemovedStringReturned() {
        String source = "abcdef";
        String remove = "ABC";
        String result = stringUtils.removeStartIgnoreCase(source, remove);
        assertEquals("def", result);
    }

    @Test
    void testRemoveStartIgnoreCase_SourceStringStartingWithRemoveStringIgnoreCase_SourceStringUnchanged() {
        String source = "abcdef";
        String remove = "XYZ";
        String result = stringUtils.removeStartIgnoreCase(source, remove);
        assertEquals(source, result);
    }

    @Test
    void testRemoveStartIgnoreCase_RemoveStringEmpty_SourceStringUnchanged() {
        String source = "abcdef";
        String result = stringUtils.removeStartIgnoreCase(source, "");
        assertEquals(source, result);
    }
}