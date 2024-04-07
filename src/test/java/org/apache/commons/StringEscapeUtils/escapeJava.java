import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class escapeJavaTest {

  @Test
  void testEscapeJava() {
    StringEscapeUtils stringEscapeUtils = new StringEscapeUtils();
    
    // Test cases for escaping special characters
    assertEquals("\\\"", stringEscapeUtils.escapeJava("\""));
    assertEquals("\\\\", stringEscapeUtils.escapeJava("\\"));
    
    // Test cases for escaping control characters
    assertEquals("\\b", stringEscapeUtils.escapeJava("\b"));
    assertEquals("\\f", stringEscapeUtils.escapeJava("\f"));
    assertEquals("\\n", stringEscapeUtils.escapeJava("\n"));
    assertEquals("\\r", stringEscapeUtils.escapeJava("\r"));
    assertEquals("\\t", stringEscapeUtils.escapeJava("\t"));
    
    // Test cases for escaping unicode characters
    assertEquals("\\u00A9", stringEscapeUtils.escapeJava("©"));
    assertEquals("\\u20AC", stringEscapeUtils.escapeJava("€"));
    
    // Test cases for escaping combinations of special, control, and unicode characters
    assertEquals("\\\"\\\\\\b\\f\\n\\r\\t\\u00A9\\u20AC", stringEscapeUtils.escapeJava("\"\\\b\f\n\r\t©€"));
    
    // Test case for empty input
    assertEquals("", stringEscapeUtils.escapeJava(""));
  }
}