import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

class getRegisterPairTest {
  
  private final EqualsBuilder equalsBuilder = new EqualsBuilder();
  
  @Test
  void testGetRegisterPair() {
    Object lhs = new Object();
    Object rhs = new Object();
    
    Pair<IDKey, IDKey> result = equalsBuilder.getRegisterPair(lhs, rhs);
    
    Assertions.assertNotNull(result);
    Assertions.assertEquals(lhs, result.getLeft().getKey());
    Assertions.assertEquals(rhs, result.getRight().getKey());
  }
  
  @Test
  void testGetRegisterPairWithNullObjects() {
    Object lhs = null;
    Object rhs = null;
    
    Pair<IDKey, IDKey> result = equalsBuilder.getRegisterPair(lhs, rhs);
    
    Assertions.assertNotNull(result);
    Assertions.assertNull(result.getLeft().getKey());
    Assertions.assertNull(result.getRight().getKey());
  }
  
  @Test
  void testGetRegisterPairWithOneNullObject() {
    Object lhs = new Object();
    Object rhs = null;
    
    Pair<IDKey, IDKey> result = equalsBuilder.getRegisterPair(lhs, rhs);
    
    Assertions.assertNotNull(result);
    Assertions.assertEquals(lhs, result.getLeft().getKey());
    Assertions.assertNull(result.getRight().getKey());
  }
  
  @Test
  void testGetRegisterPairWithSameObject() {
    Object lhs = new Object();
    
    Pair<IDKey, IDKey> result = equalsBuilder.getRegisterPair(lhs, lhs);
    
    Assertions.assertNotNull(result);
    Assertions.assertEquals(lhs, result.getLeft().getKey());
    Assertions.assertEquals(lhs, result.getRight().getKey());
  }
  
  @Test
  void testGetRegisterPairWithDifferentObjects() {
    Object lhs = new Object();
    Object rhs = new Object();
    
    Pair<IDKey, IDKey> result = equalsBuilder.getRegisterPair(lhs, rhs);
    
    Assertions.assertNotNull(result);
    Assertions.assertEquals(lhs, result.getLeft().getKey());
    Assertions.assertEquals(rhs, result.getRight().getKey());
  }
  
  @Test
  void testGetRegisterPairWithEqualObjects() {
    Object lhs = new Integer(10);
    Object rhs = new Integer(10);
    
    Pair<IDKey, IDKey> result = equalsBuilder.getRegisterPair(lhs, rhs);
    
    Assertions.assertNotNull(result);
    Assertions.assertEquals(lhs, result.getLeft().getKey());
    Assertions.assertEquals(rhs, result.getRight().getKey());
  }
  
  @Test
  void testGetRegisterPairWithUnequalObjects() {
    Object lhs = new Integer(10);
    Object rhs = new Integer(20);
    
    Pair<IDKey, IDKey> result = equalsBuilder.getRegisterPair(lhs, rhs);
    
    Assertions.assertNotNull(result);
    Assertions.assertEquals(lhs, result.getLeft().getKey());
    Assertions.assertEquals(rhs, result.getRight().getKey());
  }
  
  @Test
  void testGetRegisterPairWithSameHashCode() {
    Object lhs = new MyClass(1);
    Object rhs = new MyClass(1);
    
    Pair<IDKey, IDKey> result = equalsBuilder.getRegisterPair(lhs, rhs);
    
    Assertions.assertNotNull(result);
    Assertions.assertEquals(lhs, result.getLeft().getKey());
    Assertions.assertEquals(rhs, result.getRight().getKey());
  }
  
  @Test
  void testGetRegisterPairWithDifferentHashCode() {
    Object lhs = new MyClass(1);
    Object rhs = new MyClass(2);
    
    Pair<IDKey, IDKey> result = equalsBuilder.getRegisterPair(lhs, rhs);
    
    Assertions.assertNotNull(result);
    Assertions.assertEquals(lhs, result.getLeft().getKey());
    Assertions.assertEquals(rhs, result.getRight().getKey());
  }
  
  static class MyClass {
    private int value;
    
    public MyClass(int value) {
      this.value = value;
    }
    
    @Override
    public int hashCode() {
      return value;
    }
    
    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      MyClass myClass = (MyClass) obj;
      return value == myClass.value;
    }
  }
  
}