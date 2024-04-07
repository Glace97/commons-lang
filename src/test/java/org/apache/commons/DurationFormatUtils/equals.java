import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class equalsTest {

    @Test
    void testEquals() {
        Token token1 = new Token("value", false, -1);
        Token token2 = new Token("value", false, -1);
        Assertions.assertEquals(token1, token2);
    }
    
    @Test
    void testNotEqualsDifferentClass() {
        Token token1 = new Token("value", false, -1);
        Object token2 = new Object();
        Assertions.assertNotEquals(token1, token2);
    }
    
    @Test
    void testNotEqualsDifferentValue() {
        Token token1 = new Token("value1", false, -1);
        Token token2 = new Token("value2", false, -1);
        Assertions.assertNotEquals(token1, token2);
    }
    
    @Test
    void testNotEqualsDifferentCount() {
        Token token1 = new Token("value", false, -1);
        Token token2 = new Token("value", false, -1);
        token2.increment();
        Assertions.assertNotEquals(token1, token2);
    }
    
    @Test
    void testNotEqualsStringBuilder() {
        Token token1 = new Token(new StringBuilder("value"), false, -1);
        Token token2 = new Token(new StringBuilder("value"), false, -1);
        Assertions.assertNotEquals(token1, token2);
    }
    
    @Test
    void testNotEqualsNumber() {
        Token token1 = new Token(10, false, -1);
        Token token2 = new Token(10, false, -1);
        Assertions.assertNotEquals(token1, token2);
    }
    
    @Test
    void testNotEqualsSameObject() {
        Token token1 = new Token("value", false, -1);
        Assertions.assertEquals(token1, token1);
    }
}