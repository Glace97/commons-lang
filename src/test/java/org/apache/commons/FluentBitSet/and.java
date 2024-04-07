import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.BitSet;

class andTest {
  
  private FluentBitSet bitSet1;
  private FluentBitSet bitSet2;
  
  @BeforeEach
  void setUp() {
    bitSet1 = new FluentBitSet();
    bitSet2 = new FluentBitSet();
  }
  
  @Test
  void testAndWithEmptyBitSet() {
    FluentBitSet result = bitSet1.and(bitSet2);
    assertTrue(result.bitSet.isEmpty());
    assertSame(bitSet1, result);
  }
  
  @Test
  void testAndWithNonEmptyBitSet() {
    bitSet1.bitSet.set(0);
    bitSet2.bitSet.set(0);
    FluentBitSet result = bitSet1.and(bitSet2);
    assertTrue(result.bitSet.get(0));
    assertSame(bitSet1, result);
  }
  
  @Test
  void testAndWithDifferentSizeBitSet() {
    bitSet1.bitSet.set(0);
    bitSet2.bitSet.set(1);
    FluentBitSet result = bitSet1.and(bitSet2);
    assertFalse(result.bitSet.get(0));
    assertFalse(result.bitSet.get(1));
    assertSame(bitSet1, result);
  }
  
  @Test
  void testAndWithFluentBitSetArgument() {
    BitSet set = new BitSet();
    set.set(0);
    bitSet2.bitSet = set;
    FluentBitSet result = bitSet1.and(bitSet2);
    assertTrue(result.bitSet.get(0));
    assertSame(bitSet1, result);
  }
  
  @Test
  void testAndWithNullBitSetArgument() {
    assertThrows(NullPointerException.class, () -> {
      bitSet1.and(null);
    });
  }
  
}