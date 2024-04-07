import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class simpleQuoteTest {

    @Test
    void testSimpleQuote() {
        StringBuilder sb = new StringBuilder();
        String value = "\\.^$|?*+()[]{}";
        String expected = "\\\\\\.\\^\\$\\|\\?\\*\\+\\(\\)\\[\\]\\{\\}";
        
        StringBuilder result = FastDateParser.simpleQuote(sb, value);
        
        assertEquals(expected, result.toString());
    }
}