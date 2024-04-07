import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getBooleanTest {
  
  @Test
  void testGetPropertyReturnsDefaultIfKeyNotFound() {
    boolean defaultValue = true;
    boolean result = SystemProperties.getBoolean("nonexistent.key", () -> defaultValue);
    assertEquals(defaultValue, result);
  }
  
  @Test
  void testGetPropertyReturnsDefaultIfValueNotBoolean() {
    boolean defaultValue = true;
    boolean result = SystemProperties.getBoolean("key", () -> defaultValue);
    assertEquals(defaultValue, result);
  }
  
  @Test
  void testGetPropertyReturnsBooleanValue() {
    boolean defaultValue = true;
    boolean result = SystemProperties.getBoolean("key", () -> defaultValue);
    assertEquals(defaultValue, result);
  }
  
  @Test
  void testGetPropertyReturnsFalseIfValueIsFalse() {
    boolean defaultValue = true;
    boolean result = SystemProperties.getBoolean("key", () -> defaultValue);
    assertEquals(false, result);
  }
  
  @Test
  void testGetPropertyReturnsTrueIfValueIsTrue() {
    boolean defaultValue = false;
    boolean result = SystemProperties.getBoolean("key", () -> defaultValue);
    assertEquals(true, result);
  }
  
  @Test
  void testGetPropertyReturnsFalseIfValueIsNonBoolean() {
    boolean defaultValue = true;
    boolean result = SystemProperties.getBoolean("key", () -> defaultValue);
    assertEquals(false, result);
  }
  
  @Test
  void testGetPropertyReturnsDefaultValueIfKeyIsNull() {
    boolean defaultValue = true;
    boolean result = SystemProperties.getBoolean(null, () -> defaultValue);
    assertEquals(defaultValue, result);
  }
  
  @Test
  void testGetPropertyReturnsDefaultValueIfSupplierIsNull() {
    boolean defaultValue = true;
    boolean result = SystemProperties.getBoolean("key", null);
    assertEquals(defaultValue, result);
  }
  
  @Test
  void testGetPropertyReturnsDefaultValueIfKeyAndSupplierAreNull() {
    boolean defaultValue = true;
    boolean result = SystemProperties.getBoolean(null, null);
    assertEquals(defaultValue, result);
  }
  
}