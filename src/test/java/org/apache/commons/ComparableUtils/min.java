import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Objects;

class minTest {

  @Test
  void testMinWithNonNullComparables() {
    Integer a = 5;
    Integer b = 10;
    assertEquals(a, ComparableUtils.min(a, b));
    assertEquals(a, ComparableUtils.min(b, a));
  }

  @Test
  void testMinWithOneNullComparable() {
    Integer a = 5;
    Integer b = null;
    assertEquals(a, ComparableUtils.min(a, b));
    assertEquals(a, ComparableUtils.min(b, a));
  }

  @Test
  void testMinWithBothNullComparables() {
    Integer a = null;
    Integer b = null;
    assertNull(ComparableUtils.min(a, b));
  }

  @Test
  void testMinWithEqualComparables() {
    String a = "abc";
    String b = "abc";
    assertTrue(Objects.equals(a, ComparableUtils.min(a, b)));
    assertTrue(Objects.equals(a, ComparableUtils.min(b, a)));
  }

  @Test
  void testMinWithComparablesOfDifferentTypes() {
    Integer a = 10;
    Double b = 5.5;
    assertEquals(a, ComparableUtils.min(a, b));
    assertEquals(a, ComparableUtils.min(b, a));
  }
}