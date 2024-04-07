import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class isRegisteredTest {
  
  @Test
  void testIsRegisteredReturnsTrueForSameObject() {
    Object obj = new Object();
    assertTrue(EqualsBuilder.isRegistered(obj, obj));
  }
  
  @Test
  void testIsRegisteredReturnsTrueForRegisteredPair() {
    Object obj1 = new Object();
    Object obj2 = new Object();
    EqualsBuilder.register(obj1, obj2);
    assertTrue(EqualsBuilder.isRegistered(obj1, obj2));
  }
  
  @Test
  void testIsRegisteredReturnsTrueForSwappedRegisteredPair() {
    Object obj1 = new Object();
    Object obj2 = new Object();
    EqualsBuilder.register(obj1, obj2);
    assertTrue(EqualsBuilder.isRegistered(obj2, obj1));
  }
  
  @Test
  void testIsRegisteredReturnsFalseForUnregisteredPair() {
    Object obj1 = new Object();
    Object obj2 = new Object();
    assertFalse(EqualsBuilder.isRegistered(obj1, obj2));
  }
  
  @Test
  void testIsRegisteredReturnsFalseForSwappedUnregisteredPair() {
    Object obj1 = new Object();
    Object obj2 = new Object();
    assertFalse(EqualsBuilder.isRegistered(obj2, obj1));
  }
  
  @Test
  void testIsRegisteredReturnsFalseForNullPair() {
    assertFalse(EqualsBuilder.isRegistered(null, null));
  }
  
  @Test
  void testIsRegisteredReturnsFalseForNullAndNonNullPair() {
    Object obj = new Object();
    assertFalse(EqualsBuilder.isRegistered(null, obj));
    assertFalse(EqualsBuilder.isRegistered(obj, null));
  }
}