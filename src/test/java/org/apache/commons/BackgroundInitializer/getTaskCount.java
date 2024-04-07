import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getTaskCountTest {
  
  @Test
  void testGetTaskCount() {
    BackgroundInitializer backgroundInitializer = new BackgroundInitializer();
    int expected = 1;
    int actual = backgroundInitializer.getTaskCount();
    assertEquals(expected, actual);
  }
  
}