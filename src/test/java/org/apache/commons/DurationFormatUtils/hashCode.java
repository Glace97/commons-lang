import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hashCodeTest {

    @Test
    void testHashCode() {
        Token token1 = new Token("value", false, -1);
        Token token2 = new Token("value", false, -1);
        Token token3 = new Token("different", false, -1);

        assertEquals(token1.hashCode(), token2.hashCode());
        assertNotEquals(token1.hashCode(), token3.hashCode());
    }
}