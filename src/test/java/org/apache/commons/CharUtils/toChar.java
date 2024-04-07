import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toCharTest {

    @Test
    void testToCharNotNull() {
        Character ch = 'A';
        char result = CharUtils.toChar(ch);
        assertEquals('A', result);
    }

    @Test
    void testToCharNull() {
        assertThrows(NullPointerException.class, () -> {
            CharUtils.toChar(null);
        });
    }

    @Test
    void testToCharWithDefaultValueNotNull() {
        Character ch = 'A';
        char defaultValue = 'X';
        char result = CharUtils.toChar(ch, defaultValue);
        assertEquals('A', result);
    }

    @Test
    void testToCharWithDefaultValueNull() {
        char defaultValue = 'X';
        char result = CharUtils.toChar(null, defaultValue);
        assertEquals('X', result);
    }

    @Test
    void testToCharWithStringNotNull() {
        String str = "ABC";
        char result = CharUtils.toChar(str);
        assertEquals('A', result);
    }

    @Test
    void testToCharWithStringNull() {
        assertThrows(NullPointerException.class, () -> {
            CharUtils.toChar(null);
        });
    }

    @Test
    void testToCharWithStringEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            CharUtils.toChar("");
        });
    }

    @Test
    void testToCharWithStringDefaultValueNotNull() {
        String str = "ABC";
        char defaultValue = 'X';
        char result = CharUtils.toChar(str, defaultValue);
        assertEquals('A', result);
    }

    @Test
    void testToCharWithStringDefaultValueNull() {
        char defaultValue = 'X';
        char result = CharUtils.toChar(null, defaultValue);
        assertEquals('X', result);
    }
}