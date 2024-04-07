import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HashCodeTest {
  
  @Test
  public void testHashCodeReturnsSameValueForEqualObjects() {
    Object obj1 = new Object();
    Object obj2 = new Object();
    IDKey key1 = new IDKey(obj1);
    IDKey key2 = new IDKey(obj1);
    IDKey key3 = new IDKey(obj2);
    
    Assertions.assertEquals(key1.hashCode(), key2.hashCode());
    Assertions.assertNotEquals(key1.hashCode(), key3.hashCode());
  }
  
  @Test
  public void testHashCodeReturnsDifferentValueForDifferentObjects() {
    Object obj1 = new Object();
    Object obj2 = new Object();
    IDKey key1 = new IDKey(obj1);
    IDKey key2 = new IDKey(obj2);
    
    Assertions.assertNotEquals(key1.hashCode(), key2.hashCode());
  }
  
  @Test
  public void testHashCodeReturnsSameValueForEqualNullObjects() {
    IDKey key1 = new IDKey(null);
    IDKey key2 = new IDKey(null);
    
    Assertions.assertEquals(key1.hashCode(), key2.hashCode());
  }
  
  @Test
  public void testHashCodeReturnsDifferentValueForNonNullAndNullObjects() {
    Object obj = new Object();
    IDKey key1 = new IDKey(obj);
    IDKey key2 = new IDKey(null);
    
    Assertions.assertNotEquals(key1.hashCode(), key2.hashCode());
  }
  
  @Test
  public void testHashCodeReturnsSameValueForEqualIdentityHashCodes() {
    Object obj1 = new Object();
    Object obj2 = new Object();
    int hashCode = System.identityHashCode(obj1);
    IDKey key1 = new IDKey(obj1);
    IDKey key2 = new IDKey(obj2);
    
    key2.id = hashCode;
    
    Assertions.assertEquals(key1.hashCode(), key2.hashCode());
  }
  
  @Test
  public void testHashCodeReturnsDifferentValueForDifferentIdentityHashCodes() {
    Object obj1 = new Object();
    Object obj2 = new Object();
    int hashCode1 = System.identityHashCode(obj1);
    int hashCode2 = System.identityHashCode(obj2);
    IDKey key1 = new IDKey(obj1);
    IDKey key2 = new IDKey(obj2);
    
    key1.id = hashCode1;
    key2.id = hashCode2;
    
    Assertions.assertNotEquals(key1.hashCode(), key2.hashCode());
  }
}