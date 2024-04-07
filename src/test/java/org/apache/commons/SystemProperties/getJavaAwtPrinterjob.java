import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.Properties;

class getJavaAwtPrinterjobTest {

  @Test
  void testGetJavaAwtPrinterjob() {
    // Initialize properties
    Properties properties = new Properties();
    properties.setProperty("java.awt.printerjob", "printerjob");

    // Set properties
    setSystemProperties(properties);

    // Test getJavaAwtPrinterjob method
    String expected = "printerjob";
    String actual = SystemProperties.getJavaAwtPrinterjob();
    assertEquals(expected, actual);
  }

  @Test
  void testGetJavaAwtPrinterjobNull() {
    // Initialize properties
    Properties properties = new Properties();

    // Set properties
    setSystemProperties(properties);

    // Test getJavaAwtPrinterjob method
    String expected = null;
    String actual = SystemProperties.getJavaAwtPrinterjob();
    assertEquals(expected, actual);
  }

  @Test
  void testGetJavaAwtPrinterjobSecurityException() {
    // Set security manager to throw security exception
    System.setSecurityManager(new SecurityManager());

    // Test getJavaAwtPrinterjob method
    String expected = null;
    String actual = SystemProperties.getJavaAwtPrinterjob();
    assertEquals(expected, actual);

    // Reset security manager
    System.setSecurityManager(null);
  }

  private void setSystemProperties(Properties properties) {
    try {
      // Get the system properties field
      Field field = System.class.getDeclaredField("props");
      field.setAccessible(true);

      // Set the properties
      field.set(null, properties);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}