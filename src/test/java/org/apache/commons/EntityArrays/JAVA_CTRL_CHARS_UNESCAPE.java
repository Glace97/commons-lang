import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class JAVA_CTRL_CHARS_UNESCAPETest {

    @Test
    public void testEscapeBackspace() {
        String input = "\b";
        String expectedOutput = "\\b";
        String actualOutput = EntityArrays.JAVA_CTRL_CHARS_UNESCAPE[0][1];
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEscapeNewLine() {
        String input = "\n";
        String expectedOutput = "\\n";
        String actualOutput = EntityArrays.JAVA_CTRL_CHARS_UNESCAPE[1][1];
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEscapeTab() {
        String input = "\t";
        String expectedOutput = "\\t";
        String actualOutput = EntityArrays.JAVA_CTRL_CHARS_UNESCAPE[2][1];
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEscapeFormFeed() {
        String input = "\f";
        String expectedOutput = "\\f";
        String actualOutput = EntityArrays.JAVA_CTRL_CHARS_UNESCAPE[3][1];
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEscapeCarriageReturn() {
        String input = "\r";
        String expectedOutput = "\\r";
        String actualOutput = EntityArrays.JAVA_CTRL_CHARS_UNESCAPE[4][1];
        assertEquals(expectedOutput, actualOutput);
    }
}