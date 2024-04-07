import org.junit.jupiter.api.Test;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class nopTest {

    @Test
    void testNop() {
        Consumer<String> nop = Consumers.nop();

        // Test with null input
        nop.accept(null);
        assertNull(nop);

        // Test with empty string input
        String input = "";
        nop.accept(input);
        assertEquals("", input);

        // Test with non-empty string input
        input = "Hello World";
        nop.accept(input);
        assertEquals("Hello World", input);
    }
}