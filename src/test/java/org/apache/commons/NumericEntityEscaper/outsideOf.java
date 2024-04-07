import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class outsideOfTest {
  
  @Test
  void testOutsideOf() {
    NumericEntityEscaper escaper = NumericEntityEscaper.outsideOf(10, 20);
    
    // Test for escaping characters outside the range
    assertEquals("&#9;", escaper.escape("&#9;")); // Test for character below the range
    assertEquals("&#21;", escaper.escape("&#21;")); // Test for character above the range
    
    // Test for not escaping characters within the range
    assertEquals("a", escaper.escape("a")); // Test for character within the range
    assertEquals("A", escaper.escape("A")); // Test for character within the range
    assertEquals("5", escaper.escape("5")); // Test for character within the range
    
    // Test for not escaping characters outside the range
    assertEquals("&lt;", escaper.escape("&lt;")); // Test for character outside the range
    assertEquals("&gt;", escaper.escape("&gt;")); // Test for character outside the range
  }
  
}