import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Objects;

class toCharacterObjectTest {

    @Test
    void testToCharacterObjectWithValidChar() {
        char ch = 'A';
        Character expected = 'A';
        Character result = CharUtils.toCharacterObject(ch);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testToCharacterObjectWithNullChar() {
        char ch = '\0';
        Character expected = '\0';
        Character result = CharUtils.toCharacterObject(ch);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testToCharacterObjectWithLFChar() {
        char ch = '\n';
        Character expected = '\n';
        Character result = CharUtils.toCharacterObject(ch);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testToCharacterObjectWithCRChar() {
        char ch = '\r';
        Character expected = '\r';
        Character result = CharUtils.toCharacterObject(ch);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testToCharacterObjectWithEmptyString() {
        String str = "";
        Character expected = null;
        Character result = CharUtils.toCharacterObject(str);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testToCharacterObjectWithValidString() {
        String str = "A";
        Character expected = 'A';
        Character result = CharUtils.toCharacterObject(str);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testToCharacterObjectWithValidStringWithMultipleChars() {
        String str = "BA";
        Character expected = 'B';
        Character result = CharUtils.toCharacterObject(str);
        Assertions.assertEquals(expected, result);
    }
}