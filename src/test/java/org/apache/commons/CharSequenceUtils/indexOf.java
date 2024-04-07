
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class indexOfTest {

    @Test
    void testIndexOfWithStringInput() {
        String cs = "Hello World";
        String searchChar = "World";
        int start = 0;
        int expectedIndex = 6;

        int actualIndex = CharSequenceUtils.indexOf(cs, searchChar, start);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void testIndexOfWithStringBuilderInput() {
        StringBuilder cs = new StringBuilder("Hello World");
        String searchChar = "World";
        int start = 0;
        int expectedIndex = 6;

        int actualIndex = CharSequenceUtils.indexOf(cs, searchChar, start);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void testIndexOfWithStringBufferInput() {
        StringBuffer cs = new StringBuffer("Hello World");
        String searchChar = "World";
        int start = 0;
        int expectedIndex = 6;

        int actualIndex = CharSequenceUtils.indexOf(cs, searchChar, start);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void testIndexOfWithOtherCharSequenceInput() {
        CharSequence cs = new StringBuilder("Hello World");
        String searchChar = "World";
        int start = 0;
        int expectedIndex = 6;

        int actualIndex = CharSequenceUtils.indexOf(cs, searchChar, start);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void testIndexOfWithCharInput() {
        CharSequence cs = "Hello World";
        int searchChar = 'W';
        int start = 0;
        int expectedIndex = 6;

        int actualIndex = CharSequenceUtils.indexOf(cs, searchChar, start);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void testIndexOfWithSupplementaryCharInput() {
        CharSequence cs = "Hello 𝄞orld";
        int searchChar = '𝄞';
        int start = 0;
        int expectedIndex = 6;

        int actualIndex = CharSequenceUtils.indexOf(cs, searchChar, start);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void testIndexOfWithNegativeStartIndex() {
        CharSequence cs = "Hello World";
        String searchChar = "World";
        int start = -6;
        int expectedIndex = 6;

        int actualIndex = CharSequenceUtils.indexOf(cs, searchChar, start);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void testIndexOfWithStartIndexGreaterThanLength() {
        CharSequence cs = "Hello World";
        String searchChar = "World";
        int start = 20;
        int expectedIndex = -1;

        int actualIndex = CharSequenceUtils.indexOf(cs, searchChar, start);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void testIndexOfWithEmptyCharSequence() {
        CharSequence cs = "";
        String searchChar = "World";
        int start = 0;
        int expectedIndex = -1;

        int actualIndex = CharSequenceUtils.indexOf(cs, searchChar, start);

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void testIndexOfWithNullCharSequence() {
        CharSequence cs = null;
        String searchChar = "World";
        int start = 0;
        int expectedIndex = -1;

        int actualIndex = CharSequenceUtils.indexOf(cs, searchChar, start);

        assertEquals(expectedIndex, actualIndex);
    }

}
