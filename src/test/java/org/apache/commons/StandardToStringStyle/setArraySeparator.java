import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class setArraySeparatorTest {
  
  private StandardToStringStyle style;
  
  @BeforeEach
  void setUp() {
    style = new StandardToStringStyle();
  }
  
  @Test
  void testSetArraySeparatorWithNull() {
    style.setArraySeparator(null);
    assertEquals("", style.getArraySeparator());
  }
  
  @Test
  void testSetArraySeparatorWithEmptyString() {
    style.setArraySeparator("");
    assertEquals("", style.getArraySeparator());
  }
  
  @Test
  void testSetArraySeparatorWithNonEmptyString() {
    style.setArraySeparator(",");
    assertEquals(",", style.getArraySeparator());
  }
  
  @Test
  void testSetArraySeparatorWithSpecialCharacters() {
    style.setArraySeparator(";");
    assertEquals(";", style.getArraySeparator());
  }
  
  @Test
  void testSetArraySeparatorWithLongString() {
    String longString = "This is a very long string that exceeds the normal length limit for array separators";
    style.setArraySeparator(longString);
    assertEquals(longString, style.getArraySeparator());
  }
  
  @Test
  void testSetArraySeparatorMultipleTimes() {
    style.setArraySeparator(",");
    assertEquals(",", style.getArraySeparator());
    
    style.setArraySeparator(";");
    assertEquals(";", style.getArraySeparator());
    
    style.setArraySeparator("");
    assertEquals("", style.getArraySeparator());
  }
  
  @Test
  void testSetArraySeparatorWithWhitespace() {
    style.setArraySeparator(" ");
    assertEquals(" ", style.getArraySeparator());
  }
  
  @Test
  void testSetArraySeparatorWithNewLine() {
    style.setArraySeparator("\n");
    assertEquals("\n", style.getArraySeparator());
  }
  
  @Test
  void testSetArraySeparatorWithTab() {
    style.setArraySeparator("\t");
    assertEquals("\t", style.getArraySeparator());
  }
  
  @Test
  void testSetArraySeparatorWithUnicode() {
    style.setArraySeparator("\u2022");
    assertEquals("\u2022", style.getArraySeparator());
  }
}