import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class getHostNameTest {
  
  @Test
  void testGetHostName() {
    SystemUtils systemUtils = new SystemUtils();
    String expectedHostName = systemUtils.IS_OS_WINDOWS ? System.getenv("COMPUTERNAME") : System.getenv("HOSTNAME");
    assertEquals(expectedHostName, systemUtils.getHostName());
  }
}