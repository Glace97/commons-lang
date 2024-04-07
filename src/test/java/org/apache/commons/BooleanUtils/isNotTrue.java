import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class isNotTrueTest {
  
  private final BooleanUtils booleanUtils = new BooleanUtils();
  
  @Test
  void testIsNotTrueWithTrue() {
    boolean result = booleanUtils.isNotTrue(Boolean.TRUE);
    Assertions.assertFalse(result);
  }
  
  @Test
  void testIsNotTrueWithFalse() {
    boolean result = booleanUtils.isNotTrue(Boolean.FALSE);
    Assertions.assertTrue(result);
  }
  
  @Test
  void testIsNotTrueWithNull() {
    boolean result = booleanUtils.isNotTrue(null);
    Assertions.assertTrue(result);
  }
  
  @Test
  void testIsNotTrueWithCustomTrue() {
    boolean result = booleanUtils.isNotTrue(booleanUtils.TRUE);
    Assertions.assertFalse(result);
  }
  
  @Test
  void testIsNotTrueWithCustomFalse() {
    boolean result = booleanUtils.isNotTrue(booleanUtils.FALSE);
    Assertions.assertTrue(result);
  }
  
  @Test
  void testIsNotTrueWithCustomYes() {
    boolean result = booleanUtils.isNotTrue(booleanUtils.YES);
    Assertions.assertTrue(result);
  }
  
  @Test
  void testIsNotTrueWithCustomNo() {
    boolean result = booleanUtils.isNotTrue(booleanUtils.NO);
    Assertions.assertTrue(result);
  }
  
  @Test
  void testIsNotTrueWithCustomOn() {
    boolean result = booleanUtils.isNotTrue(booleanUtils.ON);
    Assertions.assertTrue(result);
  }
  
  @Test
  void testIsNotTrueWithCustomOff() {
    boolean result = booleanUtils.isNotTrue(booleanUtils.OFF);
    Assertions.assertTrue(result);
  }
  
  @Test
  void testIsNotTrueWithCustomString() {
    boolean result = booleanUtils.isNotTrue("custom");
    Assertions.assertTrue(result);
  }
  
  @Test
  void testIsNotTrueWithEmptyString() {
    boolean result = booleanUtils.isNotTrue("");
    Assertions.assertTrue(result);
  }
  
  @Test
  void testIsNotTrueWithNumericString() {
    boolean result = booleanUtils.isNotTrue("123");
    Assertions.assertFalse(result);
  }
  
  @Test
  void testIsNotTrueWithNullString() {
    boolean result = booleanUtils.isNotTrue(null);
    Assertions.assertTrue(result);
  }
}