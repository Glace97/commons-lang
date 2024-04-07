
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toCharArrayTest {

    @Test
    void testEmptyCharSequence() {
        CharSequence source = "";
        char[] result = CharSequenceUtils.toCharArray(source);
        assertArrayEquals(new char[]{}, result);
    }

    @Test
    void testStringCharSequence() {
        CharSequence source = "Hello World";
        char[] result = CharSequenceUtils.toCharArray(source);
        assertArrayEquals(new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'}, result);
    }

    @Test
    void testCustomCharSequence() {
        CharSequence source = new CustomCharSequence("Custom");
        char[] result = CharSequenceUtils.toCharArray(source);
        assertArrayEquals(new char[]{'C', 'u', 's', 't', 'o', 'm'}, result);
    }

    @Test
    void testNullCharSequence() {
        assertThrows(NullPointerException.class, () -> {
            CharSequenceUtils.toCharArray(null);
        });
    }

    // Additional edge cases to consider:
    // - CharSequence with only one character
    // - CharSequence with multiple characters but with non-ASCII characters
    // - CharSequence with a large number of characters

    static class CustomCharSequence implements CharSequence {
        private final String value;

        public CustomCharSequence(String value) {
            this.value = value;
        }

        @Override
        public int length() {
            return value.length();
        }

        @Override
        public char charAt(int index) {
            return value.charAt(index);
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return value.subSequence(start, end);
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
