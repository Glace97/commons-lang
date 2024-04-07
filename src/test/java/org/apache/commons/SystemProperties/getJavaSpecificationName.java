import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getJavaSpecificationNameTest {
  
  private final SystemProperties systemProperties = new SystemProperties();

  @Test
  void testGetJavaSpecificationName() {
    String javaSpecificationName = systemProperties.getJavaSpecificationName();
    assertEquals(System.getProperty("java.specification.name"), javaSpecificationName);
  }

  @Test
  void testGetJavaSpecificationName_Null() {
    SecurityManager securityManager = new SecurityManager() {
      @Override
      public void checkPropertiesAccess() throws SecurityException {
        throw new SecurityException();
      }
    };
    System.setSecurityManager(securityManager);

    String javaSpecificationName = systemProperties.getJavaSpecificationName();
    assertNull(javaSpecificationName);

    System.setSecurityManager(null);
  }
}