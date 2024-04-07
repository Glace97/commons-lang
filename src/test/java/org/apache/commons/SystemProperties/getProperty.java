import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.Supplier;
import org.apache.commons.lang3.function.Suppliers;

class getPropertyTest {
  
  @Test
  void testGetPropertyWithValidProperty() {
    String property = "java.version";
    String expectedValue = System.getProperty(property);
    String actualValue = SystemProperties.getProperty(property);
    assertEquals(expectedValue, actualValue);
  }
  
  @Test
  void testGetPropertyWithEmptyProperty() {
    String property = "";
    Supplier<String> defaultValue = Suppliers.of("default");
    String expectedValue = defaultValue.get();
    String actualValue = SystemProperties.getProperty(property, defaultValue);
    assertEquals(expectedValue, actualValue);
  }
  
  @Test
  void testGetPropertyWithInvalidProperty() {
    String property = "invalid.property";
    Supplier<String> defaultValue = Suppliers.of("default");
    String expectedValue = defaultValue.get();
    String actualValue = SystemProperties.getProperty(property, defaultValue);
    assertEquals(expectedValue, actualValue);
  }
  
  @Test
  void testGetPropertyWithNullProperty() {
    String property = null;
    Supplier<String> defaultValue = Suppliers.of("default");
    String expectedValue = defaultValue.get();
    String actualValue = SystemProperties.getProperty(property, defaultValue);
    assertEquals(expectedValue, actualValue);
  }
  
  @Test
  void testGetPropertyWithSecurityException() {
    String property = "java.home";
    Supplier<String> defaultValue = Suppliers.of("default");
    String expectedValue = defaultValue.get();
    String actualValue = SystemProperties.getProperty(property, defaultValue);
    assertEquals(expectedValue, actualValue);
  }
  
  @Test
  void testGetPropertyWithSecurityExceptionAndNullDefault() {
    String property = "java.home";
    Supplier<String> defaultValue = Suppliers.nul();
    String expectedValue = null;
    String actualValue = SystemProperties.getProperty(property, defaultValue);
    assertEquals(expectedValue, actualValue);
  }
  
}