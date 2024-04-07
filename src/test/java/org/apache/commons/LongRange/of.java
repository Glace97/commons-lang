import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ofTest {
  
  @Test
  public void testOf_Long_Long() {
    // Test with positive values
    LongRange range1 = LongRange.of(1L, 10L);
    Assertions.assertEquals(1L, range1.getMinimum());
    Assertions.assertEquals(10L, range1.getMaximum());
    
    // Test with negative values
    LongRange range2 = LongRange.of(-10L, -1L);
    Assertions.assertEquals(-10L, range2.getMinimum());
    Assertions.assertEquals(-1L, range2.getMaximum());
    
    // Test with zero values
    LongRange range3 = LongRange.of(0L, 0L);
    Assertions.assertEquals(0L, range3.getMinimum());
    Assertions.assertEquals(0L, range3.getMaximum());
  }
  
  @Test
  public void testOf_long_long() {
    // Test with positive values
    LongRange range1 = LongRange.of(1, 10);
    Assertions.assertEquals(1L, range1.getMinimum());
    Assertions.assertEquals(10L, range1.getMaximum());
    
    // Test with negative values
    LongRange range2 = LongRange.of(-10, -1);
    Assertions.assertEquals(-10L, range2.getMinimum());
    Assertions.assertEquals(-1L, range2.getMaximum());
    
    // Test with zero values
    LongRange range3 = LongRange.of(0, 0);
    Assertions.assertEquals(0L, range3.getMinimum());
    Assertions.assertEquals(0L, range3.getMaximum());
  }
  
  @Test
  public void testOf_Long_Long_ReverseOrder() {
    LongRange range1 = LongRange.of(10L, 1L);
    Assertions.assertEquals(1L, range1.getMinimum());
    Assertions.assertEquals(10L, range1.getMaximum());
    
    LongRange range2 = LongRange.of(-1L, -10L);
    Assertions.assertEquals(-10L, range2.getMinimum());
    Assertions.assertEquals(-1L, range2.getMaximum());
    
    LongRange range3 = LongRange.of(0L, -10L);
    Assertions.assertEquals(-10L, range3.getMinimum());
    Assertions.assertEquals(0L, range3.getMaximum());
  }
  
  @Test
  public void testOf_long_long_ReverseOrder() {
    LongRange range1 = LongRange.of(10, 1);
    Assertions.assertEquals(1L, range1.getMinimum());
    Assertions.assertEquals(10L, range1.getMaximum());
    
    LongRange range2 = LongRange.of(-1, -10);
    Assertions.assertEquals(-10L, range2.getMinimum());
    Assertions.assertEquals(-1L, range2.getMaximum());
    
    LongRange range3 = LongRange.of(0, -10);
    Assertions.assertEquals(-10L, range3.getMinimum());
    Assertions.assertEquals(0L, range3.getMaximum());
  }
  
  @Test
  public void testOf_Long_Long_Null() {
    Assertions.assertThrows(NullPointerException.class, () -> {
      LongRange.of(null, 10L);
    });
    
    Assertions.assertThrows(NullPointerException.class, () -> {
      LongRange.of(1L, null);
    });
    
    Assertions.assertThrows(NullPointerException.class, () -> {
      LongRange.of(null, null);
    });
  }
  
  @Test
  public void testOf_long_long_Null() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      LongRange.of(1, null);
    });
    
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      LongRange.of(null, 10);
    });
    
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      LongRange.of(null, null);
    });
  }
}