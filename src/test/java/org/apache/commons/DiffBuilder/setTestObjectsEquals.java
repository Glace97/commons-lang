import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class setTestObjectsEqualsTest {
  
  @Test
  void testSetTestObjectsEqualsTrue() {
    DiffBuilder<String> diffBuilder = new DiffBuilder<>();
    diffBuilder.setTestObjectsEquals(true);
    
    Assertions.assertTrue(diffBuilder.testObjectsEquals);
  }
  
  @Test
  void testSetTestObjectsEqualsFalse() {
    DiffBuilder<String> diffBuilder = new DiffBuilder<>();
    diffBuilder.setTestObjectsEquals(false);
    
    Assertions.assertFalse(diffBuilder.testObjectsEquals);
  }
  
  @Test
  void testSetTestObjectsEqualsDefault() {
    DiffBuilder<String> diffBuilder = new DiffBuilder<>();
    
    Assertions.assertTrue(diffBuilder.testObjectsEquals);
  }
}