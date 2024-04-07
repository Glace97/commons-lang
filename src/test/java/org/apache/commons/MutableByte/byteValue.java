import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class byteValueTest {

  @Test
  void testByteValue() {
    MutableByte mutableByte = new MutableByte((byte) 10);
    assertEquals(10, mutableByte.byteValue());
  }

  @Test
  void testByteValueWithPositiveValue() {
    MutableByte mutableByte = new MutableByte(127);
    assertEquals(127, mutableByte.byteValue());
  }

  @Test
  void testByteValueWithNegativeValue() {
    MutableByte mutableByte = new MutableByte(-128);
    assertEquals(-128, mutableByte.byteValue());
  }

  @Test
  void testByteValueWithZero() {
    MutableByte mutableByte = new MutableByte(0);
    assertEquals(0, mutableByte.byteValue());
  }

  @Test
  void testByteValueWithMaxValue() {
    MutableByte mutableByte = new MutableByte(Byte.MAX_VALUE);
    assertEquals(Byte.MAX_VALUE, mutableByte.byteValue());
  }

  @Test
  void testByteValueWithMinValue() {
    MutableByte mutableByte = new MutableByte(Byte.MIN_VALUE);
    assertEquals(Byte.MIN_VALUE, mutableByte.byteValue());
  }

  @Test
  void testByteValueWithStringValue() {
    MutableByte mutableByte = new MutableByte("10");
    assertEquals(10, mutableByte.byteValue());
  }

  @Test
  void testByteValueWithInvalidStringValue() {
    try {
      MutableByte mutableByte = new MutableByte("abc");
      assertEquals("abc", mutableByte.byteValue());
      fail("Expected NumberFormatException to be thrown");
    } catch (NumberFormatException e) {
      // Expected
    }
  }
}