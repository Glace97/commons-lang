import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class CONST_SHORTTest {

  @Test
  void testValidShortValue() {
    short expected = 100;
    short actual = ObjectUtils.CONST_SHORT(100);
    assertEquals(expected, actual);
  }

  @Test
  void testShortValueBelowRange() {
    assertThrows(IllegalArgumentException.class, () -> ObjectUtils.CONST_SHORT(-32769));
  }

  @Test
  void testShortValueAboveRange() {
    assertThrows(IllegalArgumentException.class, () -> ObjectUtils.CONST_SHORT(32768));
  }

  @Test
  void testShortValueAtLowerRangeBoundary() {
    short expected = -32768;
    short actual = ObjectUtils.CONST_SHORT(-32768);
    assertEquals(expected, actual);
  }

  @Test
  void testShortValueAtUpperRangeBoundary() {
    short expected = 32767;
    short actual = ObjectUtils.CONST_SHORT(32767);
    assertEquals(expected, actual);
  }
}