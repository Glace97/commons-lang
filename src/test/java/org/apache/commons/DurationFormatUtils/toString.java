import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class toStringTest {

    private Token token;

    @BeforeEach
    void setUp() {
        token = new Token("A", false, -1);
    }

    @Test
    void testEquals() {
        Token token2 = new Token("A", false, -1);
        Token token3 = new Token("B", false, -1);

        assertTrue(token.equals(token2));
        assertFalse(token.equals(token3));
    }

    @Test
    void testGetCount() {
        assertEquals(1, token.getCount());

        token.increment();
        assertEquals(2, token.getCount());
    }

    @Test
    void testGetValue() {
        assertEquals("A", token.getValue());
    }

    @Test
    void testHashCode() {
        Token token2 = new Token("A", false, -1);
        Token token3 = new Token("B", false, -1);

        assertEquals(token.hashCode(), token2.hashCode());
        assertNotEquals(token.hashCode(), token3.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("A", token.toString());

        token.increment();
        assertEquals("AA", token.toString());
    }
}