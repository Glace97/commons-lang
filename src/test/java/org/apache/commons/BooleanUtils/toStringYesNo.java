import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class toStringYesNoTest {
  
  @Test
  void testToStringYesNo_withTrue_returnsYes() {
    assertEquals("yes", BooleanUtils.toStringYesNo(true));
  }
  
  @Test
  void testToStringYesNo_withFalse_returnsNo() {
    assertEquals("no", BooleanUtils.toStringYesNo(false));
  }
  
  @Test
  void testToStringYesNo_withBooleanTrue_returnsYes() {
    assertEquals("yes", BooleanUtils.toStringYesNo(Boolean.TRUE));
  }
  
  @Test
  void testToStringYesNo_withBooleanFalse_returnsNo() {
    assertEquals("no", BooleanUtils.toStringYesNo(Boolean.FALSE));
  }
  
  @Test
  void testToStringYesNo_withNull_returnsNull() {
    assertEquals(null, BooleanUtils.toStringYesNo(null));
  }
  
  @Test
  void testToStringYesNo_withOtherBooleanValues_returnsNull() {
    assertEquals(null, BooleanUtils.toStringYesNo(Boolean.valueOf("other")));
  }
  
  @Test
  void testToStringYesNo_withOtherStringValues_returnsNull() {
    assertEquals(null, BooleanUtils.toStringYesNo("other"));
  }
  
  @Test
  void testToStringYesNo_withEmptyString_returnsNull() {
    assertEquals(null, BooleanUtils.toStringYesNo(""));
  }
  
  @Test
  void testToStringYesNo_withWhitespace_returnsNull() {
    assertEquals(null, BooleanUtils.toStringYesNo(" "));
  }
}