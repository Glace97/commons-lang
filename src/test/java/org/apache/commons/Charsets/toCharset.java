import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

class toCharsetTest {
  
  @Test
  void testToCharsetWithNullCharset() {
    Charset charset = Charsets.toCharset((Charset)null);
    assertEquals(Charset.defaultCharset(), charset);
  }
  
  @Test
  void testToCharsetWithNonNullCharset() {
    Charset charset = Charset.forName("UTF-8");
    Charset result = Charsets.toCharset(charset);
    assertEquals(charset, result);
  }
  
  @Test
  void testToCharsetWithNullCharsetName() {
    Charset charset = Charsets.toCharset((String)null);
    assertEquals(Charset.defaultCharset(), charset);
  }
  
  @Test
  void testToCharsetWithNonNullCharsetName() {
    Charset charset = Charsets.toCharset("UTF-8");
    Charset result = Charset.forName("UTF-8");
    assertEquals(result, charset);
  }
  
  @Test
  void testToCharsetWithUnsupportedCharsetName() {
    assertThrows(UnsupportedCharsetException.class, () -> {
      Charsets.toCharset("invalidCharset");
    });
  }
  
}