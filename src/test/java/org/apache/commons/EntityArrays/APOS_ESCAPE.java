import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class APOS_ESCAPETest {

    @Test
    public void testAposEscape() {
        EntityArrays entityArrays = new EntityArrays();
        String[][] aposEscape = entityArrays.APOS_ESCAPE;

        for (String[] pair : aposEscape) {
            String input = pair[0];
            String expectedOutput = pair[1];
            String actualOutput = APOS_ESCAPE.APOS_ESCAPE(input);
            assertEquals(expectedOutput, actualOutput);
        }
    }
}