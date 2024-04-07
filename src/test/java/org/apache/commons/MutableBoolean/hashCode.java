import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hashCodeTest {
  
  @Test
  void testHashCodeReturnsSameValueForEqualObjects() {
    MutableBoolean bool1 = new MutableBoolean(true);
    MutableBoolean bool2 = new MutableBoolean(true);
    
    assertEquals(bool1.hashCode(), bool2.hashCode());
  }
  
  @Test
  void testHashCodeReturnsDifferentValueForDifferentObjects() {
    MutableBoolean bool1 = new MutableBoolean(true);
    MutableBoolean bool2 = new MutableBoolean(false);
    
    assertNotEquals(bool1.hashCode(), bool2.hashCode());
  }
  
  @Test
  void testHashCodeReturnsSameValueForTrueAndBooleanTrue() {
    MutableBoolean bool = new MutableBoolean(true);
    Boolean boolObj = Boolean.TRUE;
    
    assertEquals(bool.hashCode(), boolObj.hashCode());
  }
  
  @Test
  void testHashCodeReturnsSameValueForFalseAndBooleanFalse() {
    MutableBoolean bool = new MutableBoolean(false);
    Boolean boolObj = Boolean.FALSE;
    
    assertEquals(bool.hashCode(), boolObj.hashCode());
  }
  
  @Test
  void testHashCodeReturnsSameValueForTrueAndBooleanFalse() {
    MutableBoolean bool = new MutableBoolean(true);
    Boolean boolObj = Boolean.FALSE;
    
    assertNotEquals(bool.hashCode(), boolObj.hashCode());
  }
  
  @Test
  void testHashCodeReturnsSameValueForFalseAndBooleanTrue() {
    MutableBoolean bool = new MutableBoolean(false);
    Boolean boolObj = Boolean.TRUE;
    
    assertNotEquals(bool.hashCode(), boolObj.hashCode());
  }
  
  @Test
  void testHashCodeReturnsSameValueForNullAndFalse() {
    MutableBoolean bool = new MutableBoolean(false);
    
    assertEquals(bool.hashCode(), Boolean.FALSE.hashCode());
  }
  
  @Test
  void testHashCodeReturnsSameValueForNullAndTrue() {
    MutableBoolean bool = new MutableBoolean(true);
    
    assertEquals(bool.hashCode(), Boolean.TRUE.hashCode());
  }
  
  @Test
  void testHashCodeReturnsSameValueForNullAndNull() {
    MutableBoolean bool = new MutableBoolean(null);
    
    assertEquals(bool.hashCode(), Boolean.FALSE.hashCode());
  }
  
  @Test
  void testHashCodeReturnsSameValueForTrueAndNull() {
    MutableBoolean bool = new MutableBoolean(null);
    Boolean boolObj = Boolean.TRUE;
    
    assertNotEquals(bool.hashCode(), boolObj.hashCode());
  }
  
  @Test
  void testHashCodeReturnsSameValueForFalseAndNull() {
    MutableBoolean bool = new MutableBoolean(null);
    Boolean boolObj = Boolean.FALSE;
    
    assertNotEquals(bool.hashCode(), boolObj.hashCode());
  }
}