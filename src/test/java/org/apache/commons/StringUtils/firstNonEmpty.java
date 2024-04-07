import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class firstNonEmptyTest {

    @Test
    void testFirstNonEmpty_NullValues_ReturnNull() {
        String result = StringUtils.firstNonEmpty(null, null, null);
        Assertions.assertNull(result);
    }

    @Test
    void testFirstNonEmpty_NullAndEmptyValues_ReturnNull() {
        String result = StringUtils.firstNonEmpty(null, null, "");
        Assertions.assertNull(result);
    }

    @Test
    void testFirstNonEmpty_NullAndWhitespaceValue_ReturnWhitespace() {
        String result = StringUtils.firstNonEmpty(null, "", " ");
        Assertions.assertEquals(" ", result);
    }

    @Test
    void testFirstNonEmpty_SingleNonEmptyValue_ReturnValue() {
        String result = StringUtils.firstNonEmpty("abc");
        Assertions.assertEquals("abc", result);
    }

    @Test
    void testFirstNonEmpty_NullAndNonEmptyValue_ReturnValue() {
        String result = StringUtils.firstNonEmpty(null, "xyz");
        Assertions.assertEquals("xyz", result);
    }

    @Test
    void testFirstNonEmpty_EmptyAndNonEmptyValue_ReturnValue() {
        String result = StringUtils.firstNonEmpty("", "xyz");
        Assertions.assertEquals("xyz", result);
    }

    @Test
    void testFirstNonEmpty_NullAndNonEmptyValues_ReturnValue() {
        String result = StringUtils.firstNonEmpty(null, "xyz", "abc");
        Assertions.assertEquals("xyz", result);
    }

    @Test
    void testFirstNonEmpty_NoValues_ReturnNull() {
        String result = StringUtils.firstNonEmpty();
        Assertions.assertNull(result);
    }
}