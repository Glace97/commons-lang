
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SplitTest {

    @Test
    public void testSplit_NullInput_ReturnsNull() {
        String[] result = StringUtils.split(null);
        Assertions.assertNull(result);
    }

    @Test
    public void testSplit_EmptyInput_ReturnsEmptyArray() {
        String[] result = StringUtils.split("");
        Assertions.assertArrayEquals(new String[]{}, result);
    }

    @Test
    public void testSplit_InputWithWhitespace_ReturnsArrayOfParsedStrings() {
        String[] result = StringUtils.split("abc def");
        Assertions.assertArrayEquals(new String[]{"abc", "def"}, result);
    }

    @Test
    public void testSplit_InputWithMultipleWhitespace_ReturnsArrayOfParsedStrings() {
        String[] result = StringUtils.split("abc  def");
        Assertions.assertArrayEquals(new String[]{"abc", "def"}, result);
    }

    @Test
    public void testSplit_InputWithWhitespaceAtStartAndEnd_ReturnsArrayOfParsedStrings() {
        String[] result = StringUtils.split(" abc ");
        Assertions.assertArrayEquals(new String[]{"abc"}, result);
    }

    @Test
    public void testSplit_InputWithSeparatorChar_ReturnsArrayOfParsedStrings() {
        String[] result = StringUtils.split("a.b.c", '.');
        Assertions.assertArrayEquals(new String[]{"a", "b", "c"}, result);
    }

    @Test
    public void testSplit_InputWithMultipleSeparatorChars_ReturnsArrayOfParsedStrings() {
        String[] result = StringUtils.split("a..b.c", '.');
        Assertions.assertArrayEquals(new String[]{"a", "b", "c"}, result);
    }

    @Test
    public void testSplit_InputWithSeparatorCharsNotPresent_ReturnsArrayWithOriginalString() {
        String[] result = StringUtils.split("a:b:c", '.');
        Assertions.assertArrayEquals(new String[]{"a:b:c"}, result);
    }

    @Test
    public void testSplit_InputWithWhitespaceSeparatorChar_ReturnsArrayOfParsedStrings() {
        String[] result = StringUtils.split("a b c", ' ');
        Assertions.assertArrayEquals(new String[]{"a", "b", "c"}, result);
    }

    @Test
    public void testSplit_InputWithNullSeparatorChars_ReturnsArrayOfParsedStringsUsingWhitespace() {
        String[] result = StringUtils.split("abc def", null);
        Assertions.assertArrayEquals(new String[]{"abc", "def"}, result);
    }

    @Test
    public void testSplit_InputWithWhitespaceSeparatorChars_ReturnsArrayOfParsedStringsUsingWhitespace() {
        String[] result = StringUtils.split("abc  def", " ");
        Assertions.assertArrayEquals(new String[]{"abc", "def"}, result);
    }

    @Test
    public void testSplit_InputWithMultipleSeparatorChars_ReturnsArrayOfParsedStrings() {
        String[] result = StringUtils.split("ab:cd:ef", ":");
        Assertions.assertArrayEquals(new String[]{"ab", "cd", "ef"}, result);
    }

    @Test
    public void testSplit_InputWithNullSeparatorCharsAndMaxLimit_ReturnsArrayOfParsedStringsUsingWhitespace() {
        String[] result = StringUtils.split("ab cd ef", null, 2);
        Assertions.assertArrayEquals(new String[]{"ab", "cd:ef"}, result);
    }

    @Test
    public void testSplit_InputWithSeparatorCharsAndMaxLimit_ReturnsArrayOfParsedStrings() {
        String[] result = StringUtils.split("ab:cd:ef", ":", 2);
        Assertions.assertArrayEquals(new String[]{"ab", "cd:ef"}, result);
    }
}
