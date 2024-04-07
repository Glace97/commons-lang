import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class hashCodeTest {
  
  private ArrayUtils arrayUtils;
  
  @BeforeEach
  void setUp() {
    arrayUtils = new ArrayUtils();
  }
  
  @Test
  void testHashCode_NullArray_ReturnsZero() {
    int hashCode = arrayUtils.hashCode(null);
    assertEquals(0, hashCode);
  }
  
  @Test
  void testHashCode_EmptyBooleanArray_ReturnsExpectedHashCode() {
    boolean[] emptyArray = arrayUtils.EMPTY_BOOLEAN_ARRAY;
    int hashCode = arrayUtils.hashCode(emptyArray);
    
    int expectedHashCode = new HashCodeBuilder().append(emptyArray).toHashCode();
    assertEquals(expectedHashCode, hashCode);
  }
  
  @Test
  void testHashCode_EmptyBooleanObjectArray_ReturnsExpectedHashCode() {
    Boolean[] emptyArray = arrayUtils.EMPTY_BOOLEAN_OBJECT_ARRAY;
    int hashCode = arrayUtils.hashCode(emptyArray);
    
    int expectedHashCode = new HashCodeBuilder().append(emptyArray).toHashCode();
    assertEquals(expectedHashCode, hashCode);
  }
  
  // Repeat the above pattern for other arrays...
  
}