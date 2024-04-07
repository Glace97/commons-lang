
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class stripToNullTest {
    
    @Test
    void testNullString() {
        String result = StringUtils.stripToNull(null);
        Assertions.assertNull(result);
    }
    
    @Test
    void testEmptyString() {
        String result = StringUtils.stripToNull("");
        Assertions.assertNull(result);
    }
    
    @Test
    void testWhitespaceString() {
        String result = StringUtils.stripToNull("   ");
        Assertions.assertNull(result);
    }
    
    @Test
    void testNonEmptyString() {
        String result = StringUtils.stripToNull("abc");
        Assertions.assertEquals("abc", result);
    }
    
    @Test
    void testLeadingWhitespace() {
        String result = StringUtils.stripToNull("  abc");
        Assertions.assertEquals("abc", result);
    }
    
    @Test
    void testTrailingWhitespace() {
        String result = StringUtils.stripToNull("abc  ");
        Assertions.assertEquals("abc", result);
    }
    
    @Test
    void testLeadingAndTrailingWhitespace() {
        String result = StringUtils.stripToNull(" abc ");
        Assertions.assertEquals("abc", result);
    }
    
    @Test
    void testWhitespaceInMiddle() {
        String result = StringUtils.stripToNull(" ab c ");
        Assertions.assertEquals("ab c", result);
    }
    
    @Test
    void testStringWithAccents() {
        String result = StringUtils.stripToNull("éèê");
        Assertions.assertEquals("éèê", result);
    }
}
