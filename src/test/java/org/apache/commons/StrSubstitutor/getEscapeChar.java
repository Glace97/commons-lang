import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getEscapeCharTest {
  
  private StrSubstitutor strSubstitutor;
  
  @BeforeEach
  void setUp() {
    strSubstitutor = new StrSubstitutor();
  }
  
  @Test
  void testGetEscapeChar_DefaultEscape_ReturnsDollarSign() {
    char escapeChar = strSubstitutor.getEscapeChar();
    assertEquals('$', escapeChar);
  }
  
  @Test
  void testGetEscapeChar_CustomEscape_ReturnsCustomEscape() {
    StrSubstitutor strSubstitutor = new StrSubstitutor(null, "${", "}", '#');
    char escapeChar = strSubstitutor.getEscapeChar();
    assertEquals('#', escapeChar);
  }
  
  @Test
  void testGetEscapeChar_PreserveEscapes_ReturnsEscapeChar() {
    StrSubstitutor strSubstitutor = new StrSubstitutor();
    strSubstitutor.setPreserveEscapes(true);
    char escapeChar = strSubstitutor.getEscapeChar();
    assertEquals('$', escapeChar);
  }
  
  @Test
  void testGetEscapeChar_NoPreserveEscapes_ReturnsEscapeChar() {
    StrSubstitutor strSubstitutor = new StrSubstitutor();
    strSubstitutor.setPreserveEscapes(false);
    char escapeChar = strSubstitutor.getEscapeChar();
    assertEquals('$', escapeChar);
  }
  
  @Test
  void testGetEscapeChar_EscapeCharWithPrefix_ReturnsEscapeChar() {
    StrSubstitutor strSubstitutor = new StrSubstitutor(null, "##", "}", '$');
    char escapeChar = strSubstitutor.getEscapeChar();
    assertEquals('$', escapeChar);
  }
  
  @Test
  void testGetEscapeChar_EscapeCharWithSuffix_ReturnsEscapeChar() {
    StrSubstitutor strSubstitutor = new StrSubstitutor(null, "${", "##", '$');
    char escapeChar = strSubstitutor.getEscapeChar();
    assertEquals('$', escapeChar);
  }
  
  @Test
  void testGetEscapeChar_EscapeCharWithPrefixAndSuffix_ReturnsEscapeChar() {
    StrSubstitutor strSubstitutor = new StrSubstitutor(null, "##", "##", '$');
    char escapeChar = strSubstitutor.getEscapeChar();
    assertEquals('$', escapeChar);
  }
}