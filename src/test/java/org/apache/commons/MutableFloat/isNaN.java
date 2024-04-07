import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class isNaNTest {
  
  private MutableFloat mutableFloat;
  
  @BeforeEach
  public void setUp() {
    mutableFloat = new MutableFloat();
  }
  
  @Test
  public void testIsNaNWithNaNValue() {
    mutableFloat = new MutableFloat(Float.NaN);
    assertTrue(mutableFloat.isNaN());
  }
  
  @Test
  public void testIsNaNWithNonNaNValue() {
    mutableFloat = new MutableFloat(10.0f);
    assertFalse(mutableFloat.isNaN());
  }
  
  @Test
  public void testIsNaNWithNullValue() {
    assertThrows(NullPointerException.class, () -> {
      mutableFloat = new MutableFloat((Number) null);
      mutableFloat.isNaN();
    });
  }
  
  @Test
  public void testIsNaNWithInvalidStringValue() {
    assertThrows(NumberFormatException.class, () -> {
      mutableFloat = new MutableFloat("abc");
      mutableFloat.isNaN();
    });
  }
  
  @Test
  public void testIsNaNWithValidStringValue() {
    mutableFloat = new MutableFloat("10.0");
    assertFalse(mutableFloat.isNaN());
  }
  
  @Test
  public void testIsNaNWithZeroValue() {
    mutableFloat = new MutableFloat(0.0f);
    assertFalse(mutableFloat.isNaN());
  }
  
  @Test
  public void testIsNaNWithPositiveInfinityValue() {
    mutableFloat = new MutableFloat(Float.POSITIVE_INFINITY);
    assertFalse(mutableFloat.isNaN());
  }
  
  @Test
  public void testIsNaNWithNegativeInfinityValue() {
    mutableFloat = new MutableFloat(Float.NEGATIVE_INFINITY);
    assertFalse(mutableFloat.isNaN());
  }
  
  @Test
  public void testIsNaNWithMaxValue() {
    mutableFloat = new MutableFloat(Float.MAX_VALUE);
    assertFalse(mutableFloat.isNaN());
  }
  
  @Test
  public void testIsNaNWithMinValue() {
    mutableFloat = new MutableFloat(Float.MIN_VALUE);
    assertFalse(mutableFloat.isNaN());
  }
  
}