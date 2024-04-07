import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isNegatedTest {
  
  @Test
  void testNegatedRange() {
    CharRange range = new CharRange('a', 'z', true);
    assertTrue(range.isNegated());
  }
  
  @Test
  void testNonNegatedRange() {
    CharRange range = new CharRange('a', 'z', false);
    assertFalse(range.isNegated());
  }
  
  @Test
  void testEmptyRange() {
    CharRange range = new CharRange('a', 'a', false);
    assertFalse(range.isNegated());
  }
  
  @Test
  void testReversedRange() {
    CharRange range = new CharRange('z', 'a', false);
    assertFalse(range.isNegated());
  }
  
  @Test
  void testNegatedEmptySet() {
    CharRange range = new CharRange(Character.MIN_VALUE, Character.MAX_VALUE, true);
    assertFalse(range.isNegated());
  }
  
}