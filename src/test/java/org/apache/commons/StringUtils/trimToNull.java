
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class trimToNullTest {

    @Test
    void testTrimToNullNullInput() {
        String str = null;
        String result = StringUtils.trimToNull(str);
        Assertions.assertNull(result);
    }

    @Test
    void testTrimToNullEmptyInput() {
        String str = "";
        String result = StringUtils.trimToNull(str);
        Assertions.assertNull(result);
    }

    @Test
    void testTrimToNullWhitespaceInput() {
        String str = "     ";
        String result = StringUtils.trimToNull(str);
        Assertions.assertNull(result);
    }

    @Test
    void testTrimToNullNoWhitespaceInput() {
        String str = "abc";
        String result = StringUtils.trimToNull(str);
        Assertions.assertEquals(str, result);
    }

    @Test
    void testTrimToNullLeadingAndTrailingWhitespaceInput() {
        String str = "    abc    ";
        String expected = "abc";
        String result = StringUtils.trimToNull(str);
        Assertions.assertEquals(expected, result);
    }

}
