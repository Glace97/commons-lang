import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class addFirstTest {
  
  private ArrayUtils arrayUtils;
  
  @BeforeEach
  void setUp() {
    arrayUtils = new ArrayUtils();
  }
  
  @Test
  void testAddFirst_booleanArray() {
    boolean[] array = {true, false};
    boolean element = true;
    boolean[] expected = {true, true, false};
    
    boolean[] result = arrayUtils.addFirst(array, element);
    
    assertArrayEquals(expected, result);
  }
  
  @Test
  void testAddFirst_emptyBooleanArray() {
    boolean[] array = {};
    boolean element = true;
    boolean[] expected = {true};
    
    boolean[] result = arrayUtils.addFirst(array, element);
    
    assertArrayEquals(expected, result);
  }
  
  @Test
  void testAddFirst_byteArray() {
    byte[] array = {1, 2};
    byte element = 3;
    byte[] expected = {3, 1, 2};
    
    byte[] result = arrayUtils.addFirst(array, element);
    
    assertArrayEquals(expected, result);
  }
  
  @Test
  void testAddFirst_emptyByteArray() {
    byte[] array = {};
    byte element = 1;
    byte[] expected = {1};
    
    byte[] result = arrayUtils.addFirst(array, element);
    
    assertArrayEquals(expected, result);
  }
  
  // Repeat the above tests for charArray, doubleArray, floatArray, intArray, longArray, shortArray, and objectArray
  
  @Test
  void testAddFirst_nullArray() {
    boolean[] array = null;
    boolean element = true;
    boolean[] expected = {true};
    
    boolean[] result = arrayUtils.addFirst(array, element);
    
    assertArrayEquals(expected, result);
  }
  
  @Test
  void testAddFirst_nullElement() {
    boolean[] array = {true, false};
    boolean element = null;
    boolean[] expected = {null, true, false};
    
    boolean[] result = arrayUtils.addFirst(array, element);
    
    assertArrayEquals(expected, result);
  }
  
}