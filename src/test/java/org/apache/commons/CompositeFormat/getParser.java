import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getParserTest {
  
  @Test
  void testGetParser() {
    Format parser = new CustomParser();
    Format formatter = new CustomFormatter();
    CompositeFormat compositeFormat = new CompositeFormat(parser, formatter);
    
    Format result = compositeFormat.getParser();
    
    assertEquals(parser, result);
  }
  
  @Test
  void testGetParser_NullParser() {
    Format formatter = new CustomFormatter();
    CompositeFormat compositeFormat = new CompositeFormat(null, formatter);
    
    Format result = compositeFormat.getParser();
    
    assertNull(result);
  }
  
  @Test
  void testGetParser_NullFormatter() {
    Format parser = new CustomParser();
    CompositeFormat compositeFormat = new CompositeFormat(parser, null);
    
    Format result = compositeFormat.getParser();
    
    assertEquals(parser, result);
  }
  
  @Test
  void testGetParser_NullParserAndFormatter() {
    CompositeFormat compositeFormat = new CompositeFormat(null, null);
    
    Format result = compositeFormat.getParser();
    
    assertNull(result);
  }
}