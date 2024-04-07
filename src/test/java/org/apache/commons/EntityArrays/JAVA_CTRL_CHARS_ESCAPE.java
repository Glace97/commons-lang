import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JAVA_CTRL_CHARS_ESCAPETest {

    @Test
    public void testEscapeBackspace() {
        String input = "\b";
        String expected = "\\b";
        String actual = EntityArrays.JAVA_CTRL_CHARS_ESCAPE()[0][1];
        assertEquals(expected, actual);
    }

    @Test
    public void testEscapeNewLine() {
        String input = "\n";
        String expected = "\\n";
        String actual = EntityArrays.JAVA_CTRL_CHARS_ESCAPE()[1][1];
        assertEquals(expected, actual);
    }

    @Test
    public void testEscapeTab() {
        String input = "\t";
        String expected = "\\t";
        String actual = EntityArrays.JAVA_CTRL_CHARS_ESCAPE()[2][1];
        assertEquals(expected, actual);
    }

    @Test
    public void testEscapeFormFeed() {
        String input = "\f";
        String expected = "\\f";
        String actual = EntityArrays.JAVA_CTRL_CHARS_ESCAPE()[3][1];
        assertEquals(expected, actual);
    }

    @Test
    public void testEscapeCarriageReturn() {
        String input = "\r";
        String expected = "\\r";
        String actual = EntityArrays.JAVA_CTRL_CHARS_ESCAPE()[4][1];
        assertEquals(expected, actual);
    }
}