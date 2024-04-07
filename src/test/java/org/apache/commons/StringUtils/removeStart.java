
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RemoveStartTest {

    @Test
    void testRemoveStartWithNullString() {
        String result = StringUtils.removeStart(null, 'a');
        Assertions.assertNull(result);
    }

    @Test
    void testRemoveStartWithEmptyString() {
        String result = StringUtils.removeStart("", 'a');
        Assertions.assertEquals("", result);
    }

    @Test
    void testRemoveStartWithNullChar() {
        String result = StringUtils.removeStart("abc", null);
        Assertions.assertEquals("abc", result);
    }

    @Test
    void testRemoveStartWithCharAtBeginning() {
        String result = StringUtils.removeStart("/path", '/');
        Assertions.assertEquals("path", result);
    }

    @Test
    void testRemoveStartWithCharNotAtBeginning() {
        String result = StringUtils.removeStart("path", '/');
        Assertions.assertEquals("path", result);
    }

    @Test
    void testRemoveStartWithZeroChar() {
        String result = StringUtils.removeStart("path", 0);
        Assertions.assertEquals("path", result);
    }

    @Test
    void testRemoveStartWithNullStringAndChar() {
        String result = StringUtils.removeStart(null, null);
        Assertions.assertNull(result);
    }

    @Test
    void testRemoveStartWithEmptyStringAndChar() {
        String result = StringUtils.removeStart("", null);
        Assertions.assertEquals("", result);
    }

    @Test
    void testRemoveStartWithStringAtBeginning() {
        String result = StringUtils.removeStart("www.domain.com", "www.");
        Assertions.assertEquals("domain.com", result);
    }

    @Test
    void testRemoveStartWithStringNotAtBeginning() {
        String result = StringUtils.removeStart("domain.com", "www.");
        Assertions.assertEquals("domain.com", result);
    }

    @Test
    void testRemoveStartWithStringAtBeginningButDifferentCase() {
        String result = StringUtils.removeStart("www.domain.com", "DOMAIN");
        Assertions.assertEquals("www.domain.com", result);
    }

    @Test
    void testRemoveStartWithStringNotPresent() {
        String result = StringUtils.removeStart("abc", "xyz");
        Assertions.assertEquals("abc", result);
    }
}
