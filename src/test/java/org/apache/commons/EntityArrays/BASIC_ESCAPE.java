import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BASIC_ESCAPETest {

    @Test
    public void testBasicEscape() {
        String[][] basicEscape = EntityArrays.BASIC_ESCAPE;

        for (String[] pair : basicEscape) {
            String actual = StringEscapeUtils.escapeHtml4(pair[0]);
            String expected = pair[1];
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testBasicUnescape() {
        String[][] basicUnescape = EntityArrays.BASIC_UNESCAPE;

        for (String[] pair : basicUnescape) {
            String actual = StringEscapeUtils.unescapeHtml4(pair[1]);
            String expected = pair[0];
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testAposEscape() {
        String[][] aposEscape = EntityArrays.APOS_ESCAPE;

        for (String[] pair : aposEscape) {
            String actual = StringEscapeUtils.escapeHtml4(pair[0]);
            String expected = pair[1];
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testAposUnescape() {
        String[][] aposUnescape = EntityArrays.APOS_UNESCAPE;

        for (String[] pair : aposUnescape) {
            String actual = StringEscapeUtils.unescapeHtml4(pair[1]);
            String expected = pair[0];
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testJavaCtrlCharsEscape() {
        String[][] javaCtrlCharsEscape = EntityArrays.JAVA_CTRL_CHARS_ESCAPE;

        for (String[] pair : javaCtrlCharsEscape) {
            String actual = StringEscapeUtils.escapeJava(pair[0]);
            String expected = pair[1];
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testJavaCtrlCharsUnescape() {
        String[][] javaCtrlCharsUnescape = EntityArrays.JAVA_CTRL_CHARS_UNESCAPE;

        for (String[] pair : javaCtrlCharsUnescape) {
            String actual = StringEscapeUtils.unescapeJava(pair[1]);
            String expected = pair[0];
            assertEquals(expected, actual);
        }
    }
}