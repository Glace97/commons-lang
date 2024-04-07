import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class invertTest {

    @Test
    public void testInvert() {
        EntityArrays entityArrays = new EntityArrays();
        String[][] invertedISO8859_1_ESCAPE = entityArrays.ISO8859_1_UNESCAPE;
        String[][] invertedHTML40_EXTENDED_ESCAPE = entityArrays.HTML40_EXTENDED_UNESCAPE;
        String[][] invertedBASIC_ESCAPE = entityArrays.BASIC_UNESCAPE;
        String[][] invertedAPOS_ESCAPE = entityArrays.APOS_UNESCAPE;
        String[][] invertedJAVA_CTRL_CHARS_ESCAPE = entityArrays.JAVA_CTRL_CHARS_UNESCAPE;

        // Check if the inverted arrays have the same length as the original arrays
        assertEquals(entityArrays.ISO8859_1_ESCAPE.length, invertedISO8859_1_ESCAPE.length);
        assertEquals(entityArrays.HTML40_EXTENDED_ESCAPE.length, invertedHTML40_EXTENDED_ESCAPE.length);
        assertEquals(entityArrays.BASIC_ESCAPE.length, invertedBASIC_ESCAPE.length);
        assertEquals(entityArrays.APOS_ESCAPE.length, invertedAPOS_ESCAPE.length);
        assertEquals(entityArrays.JAVA_CTRL_CHARS_ESCAPE.length, invertedJAVA_CTRL_CHARS_ESCAPE.length);

        // Check if each pair in the inverted arrays is the inverse of the original pair
        for (int i = 0; i < entityArrays.ISO8859_1_ESCAPE.length; i++) {
            assertEquals(entityArrays.ISO8859_1_ESCAPE[i][0], invertedISO8859_1_ESCAPE[i][1]);
            assertEquals(entityArrays.ISO8859_1_ESCAPE[i][1], invertedISO8859_1_ESCAPE[i][0]);
        }

        for (int i = 0; i < entityArrays.HTML40_EXTENDED_ESCAPE.length; i++) {
            assertEquals(entityArrays.HTML40_EXTENDED_ESCAPE[i][0], invertedHTML40_EXTENDED_ESCAPE[i][1]);
            assertEquals(entityArrays.HTML40_EXTENDED_ESCAPE[i][1], invertedHTML40_EXTENDED_ESCAPE[i][0]);
        }

        for (int i = 0; i < entityArrays.BASIC_ESCAPE.length; i++) {
            assertEquals(entityArrays.BASIC_ESCAPE[i][0], invertedBASIC_ESCAPE[i][1]);
            assertEquals(entityArrays.BASIC_ESCAPE[i][1], invertedBASIC_ESCAPE[i][0]);
        }

        for (int i = 0; i < entityArrays.APOS_ESCAPE.length; i++) {
            assertEquals(entityArrays.APOS_ESCAPE[i][0], invertedAPOS_ESCAPE[i][1]);
            assertEquals(entityArrays.APOS_ESCAPE[i][1], invertedAPOS_ESCAPE[i][0]);
        }

        for (int i = 0; i < entityArrays.JAVA_CTRL_CHARS_ESCAPE.length; i++) {
            assertEquals(entityArrays.JAVA_CTRL_CHARS_ESCAPE[i][0], invertedJAVA_CTRL_CHARS_ESCAPE[i][1]);
            assertEquals(entityArrays.JAVA_CTRL_CHARS_ESCAPE[i][1], invertedJAVA_CTRL_CHARS_ESCAPE[i][0]);
        }
    }
}