import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getLineSeparatorTest {

    @Test
    void testGetLineSeparator() {
        // Test when line.separator property is set to \r\n
        System.setProperty("line.separator", "\r\n");
        assertEquals("\r\n", SystemProperties.getLineSeparator());

        // Test when line.separator property is set to \n
        System.setProperty("line.separator", "\n");
        assertEquals("\n", SystemProperties.getLineSeparator());

        // Test when line.separator property is set to \r
        System.setProperty("line.separator", "\r");
        assertEquals("\r", SystemProperties.getLineSeparator());

        // Test when line.separator property is set to empty string
        System.setProperty("line.separator", "");
        assertEquals("", SystemProperties.getLineSeparator());

        // Test when line.separator property is not set
        System.clearProperty("line.separator");
        assertEquals(System.lineSeparator(), SystemProperties.getLineSeparator());
    }
}